package net.osgiliath.hello.routes;

/*
 * #%L
 * net.osgiliath.hello.routes
 * %%
 * Copyright (C) 2013 Osgiliath
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;

import lombok.Setter;
import net.osgiliath.hello.business.model.Hellos;
import net.osgiliath.hello.model.jpa.model.HelloObject;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;
import org.apache.commons.io.IOUtils;


//TODO sample route, see apache camel and EIP keyword on the net ;)
public class HelloRoute extends RouteBuilder {
	private DataFormat helloObjectJSonFormat = new JacksonDataFormat(
			HelloObject.class, Hellos.class);
	@Setter
	private Processor thrownExceptionMessageToInBodyProcessor;
	@Setter
	private DataFormat xmljson;
	
	private Processor octetsStreamToStringProcessor =new Processor() {
		
		@Override
		public void process(Exchange exchange) throws Exception {
			InputStream bodyObject = exchange.getIn().getBody(InputStream.class);
			StringWriter writer = new StringWriter();
			IOUtils.copy(bodyObject, writer);
			String theString = writer.toString();
			exchange.getIn().setBody(theString);
			
		}
	};
	
	@Override
	public void configure() throws Exception {
		// initialize a jaxb context to xml marshall
		JAXBContext ctx = JAXBContext
				.newInstance(new Class[] { HelloObject.class, Hellos.class });
		DataFormat jaxBDataFormat = new JaxbDataFormat(ctx);
		
		from("{{hello.helloJMSEntryPoint}}").log(LoggingLevel.INFO, "Received message on hello.helloJMSEntryPoint")
				.filter(header("webSocketMsgType").isNotEqualTo("heartBeat"))
				.choice()
				.when(header("httpRequestType").isEqualTo("POST"))
				.to("direct:helloObjectPOST")
				.endChoice()
				.when(header("httpRequestType").isEqualTo("GET"))
				.to("direct:helloObjectGET")
				.endChoice()
				.otherwise()
				.setBody(
						simple("{error:  'Command not supported for the JaxRS queue'}"))
				.to("direct:toError");

		from("direct:helloObjectGET").log(LoggingLevel.INFO, "Received message on direct:helloObjectGET")
				.doTry()
				.setHeader(Exchange.HTTP_METHOD, constant("GET"))
				.setHeader(Exchange.CONTENT_TYPE, constant("application/xml"))
				.inOut("{{net.osgiliath.hello.business.url.helloservice}}/hello")
				.inOut("direct:marshall")
				.to("{{hello.helloJaxRSEndPoint}}")
				.doCatch(Exception.class).log("Catching exception on GET")
				.to("direct:helloValidationError");

		from("direct:helloObjectPOST").doTry().log("registering hello ${body}")
				.setHeader(Exchange.HTTP_METHOD, constant("POST"))
				.setHeader(Exchange.CONTENT_TYPE, constant("application/xml"))
				.unmarshal(helloObjectJSonFormat)
				.marshal(jaxBDataFormat)
				.to("{{net.osgiliath.hello.business.url.helloservice}}/hello").doCatch(Exception.class)
				.to("direct:helloValidationError");
		
		from("direct:marshall").log("Received data on direct:marshall")
		.process(octetsStreamToStringProcessor).log("hello data retrieved from JaxRS : ${in.body}")
		.marshal(xmljson).log("After XMLJSON : ${body}");
		
		
		
		from("direct:helloValidationError")
		.process(thrownExceptionMessageToInBodyProcessor)
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				exchange.getIn().setBody(exchange.getIn().getBody(String.class)
						.replaceAll("\"", "'").replaceAll("\n", ""));
			}
		})
		.setBody(simple("{\"error\": \"${in.body}\"}"))
		.log("Subscription error: ${in.body}").to("{{hello.errors}}");

	}
}
