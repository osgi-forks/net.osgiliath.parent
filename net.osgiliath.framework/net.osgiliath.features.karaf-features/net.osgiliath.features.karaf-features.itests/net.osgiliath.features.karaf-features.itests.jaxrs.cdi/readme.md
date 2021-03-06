# JaxRS CDI integration test
To integrate JaxRS (Restful web services) with CDI, you've to look at these files:

* [Required capabilities](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.jaxrs.cdi/osgi.bnd)
* [Annotations to map service on the service interface](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.jaxrs.cdi/src/main/java/net/osgiliath/features/karaf/jaxrs/cdi/HelloServiceJaxRS.java)
* [Service implementation and service registration via cdi](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.jaxrs.cdi/src/main/java/net/osgiliath/features/karaf/jaxrs/cdi/impl/HelloServiceImpl.java)
* [JaxB annotated model element to be able to convert it in xml](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.jaxrs.cdi/src/main/java/net/osgiliath/features/karaf/jaxrs/cdi/model/HelloObject.java)
* [Index file referencing jaxb annotated classes](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.jaxrs.cdi/src/main/java/net/osgiliath/features/karaf/jaxrs/cdi/model/jaxb.index)

Relevant doc: https://ops4j1.jira.com/wiki/display/PAXCDI/Pax+CDI
Relevant doc: http://cxf.apache.org/docs/jax-rs.html