package net.osgiliath.helpers.camel;

/*
 * #%L
 * helpers.cxf.exception.handling
 * %%
 * Copyright (C) 2013 Osgiliath corp
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

import helpers.cxf.exception.handling.ExceptionMappingConstants;

import java.io.StringReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.http.HttpOperationFailedException;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Camel processor which copy the message of an exception to the message body
 * 
 * @author Charlie
 * 
 */

public class ThrownExceptionMessageToInBodyProcessor implements Processor {
  /**
   * The Logger.
   */
  private static Logger LOG = LoggerFactory
      .getLogger(ThrownExceptionMessageToInBodyProcessor.class);

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
   */
  @Override
  public void process(Exchange exchange) throws Exception {
    final HttpOperationFailedException exception = exchange.getProperty(
        Exchange.EXCEPTION_CAUGHT, HttpOperationFailedException.class);
    if (null != exception
        && null != exception.getResponseHeaders().get(
            ExceptionMappingConstants.EXCEPTION_BODY_HEADER)) {
      final String body = exception.getResponseHeaders().get(
          ExceptionMappingConstants.EXCEPTION_BODY_HEADER);
      LOG.info("Catched error in route: " + body);
      final SAXBuilder sxb = new SAXBuilder();
      final Document doc = sxb.build(new StringReader(body));
      exchange.getIn().setBody(
          doc.getRootElement()
              .getChild(ExceptionMappingConstants.EXCEPTION_MESSAGE).getText());
    }
  }

}
