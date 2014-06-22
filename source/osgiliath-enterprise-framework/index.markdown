---
layout: page
title: "Osgiliath enterprise framework"
date: 2014-06-22 16:59
comments: true
sharing: true
footer: true
---
Osgiliath entreprise framework is a flexible OpenSourced Java stack.

If you're searching for the other Osgiliath project "Osgiliath evolutionary framework" from Pablo Garcia you're on the wrong site (<a href="http://osgiliath.org/">it's here</a>)

It aims to fulfill common enterprise dilemmas and requirements at lesser effort.

To summarize, Osgiliath allows you to code from the ui to the database in a clean modular and service oriented way.

<H2>SOA everywhere</H2>

Osgiliath framework supports many servicing protocol, at all level of granularity:
<ul>
	<li><a href="http://en.wikipedia.org/wiki/Java_API_for_RESTful_Web_Services" title="REST" target="_blank">REST</a> and <a href="http://en.wikipedia.org/wiki/Java_Message_Service" title="JMS" target="_blank"></a> at a high granularity</li>
	<li>Websocket for real time web communication between the browser and your servers</li>
	<li>OSGI services for intra-JVM component communication for fine grained servicing</li>
</ul>
{% img center /images/osgiliath-enterprise-framework/Osgiliath-communication.jpg 350 350 'Osgiliath Architecture' 'Osgiliath Architecture'%}


<H2>Uses of Enterprise integration patterns</H2>

With the help of <a href="http://camel.apache.org/eip.html" title="Apache Camel" target="_blank">Apache Camel</a> Osgiliath leveraged to a complete <a href="http://en.wikipedia.org/wiki/Enterprise_service_bus" title="Enterprise Service Bus" target="_blank">Enterprise Service Bus</a>
{% img center /images/osgiliath-enterprise-framework/Osgiliath-SOA-architecture.jpg 800 600 'Osgiliath Modules' 'Osgiliath module'%}


With the helper OSGI bundle precept, you'll be able to deploy multiple versions of a product on a same JVM so ensuring the non-regression of your entire system.
You'll also be able to hot deploy or undeploy every piece of software, or an entire application in a click, leading to a no outage, always on the wire system.

<H1>Testable at each levels, CI ready</H1>

Test driven development and continuous deployment ready, each parts of the framework are testable with unit or end to end tests.
As an addition, each kind of tests outputs metrics that are interpretable by quality tools like Sonarqube.

<H1>Based on standards and cutting edge technologies</H1>


<H2>Standard based</H2>
When possible, capabilities are provided by Java standards (JSRs or OSGIRS...) or de-facto ones: Bean Validation 1.1, JMS 2, JaxRS 2, JPA 2, JTA 1.1, JMX, JaxB, JsonP, Blueprint services, DI, CDI 1.1, Servlet 3, AngularJS

<H2>On the cutting edge</H2>
Developers will gain in productivity and be happy to work with Osgiliath framework with the help of fashionable frameworks they love:
Functional programing with Guava.
Boilerplate code reduction with Lombok
AngularJS and Twitter Bootstrap (Yeoman) framework for UI programming

<H1>You already know it</H1>
By this subtle combination of well-known frameworks developers are already familiar to Osgiliath.

<H2>Easy to use</h2>
Finally, a fully featured (Maven) build chain and project skeletton generation will considerably reduce the amount of work needed to make these things alive (for example OSGI is sometimes considered as an over engineering stuff, but the use of multiple simplifications will helps you to drastically reduce this overhead).   

<H2>Opened</H2>
Osgiliath framework is mainly an aggregation of existing well known open source libraries, and is also Apache licensed: if something does not fit to your needs, one can always clone the project on Github and make your customization.



