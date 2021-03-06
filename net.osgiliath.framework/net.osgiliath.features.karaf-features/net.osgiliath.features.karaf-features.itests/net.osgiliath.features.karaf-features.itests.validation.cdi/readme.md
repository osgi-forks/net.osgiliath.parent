# JSR-303 (bean validation) CDI integration tests

Bean validation tests with osgiliath

## Relevant files
Manifest requirements:

* [Beans.xml mandatory file](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.validation.cdi/src/main/resources/META-INF/beans.xml)
* [osgi.bnd CDI extension requirement](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.validation.cdi/osgi.bnd)
* [Validator factory declaration](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.validation.cdi/src/main/java/conf/CDIValidator.java)
* [Validation annotated bean](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.validation.cdi/src/main/java/net/osgiliath/validation/HelloObject.java)
* [Validated service](https://github.com/OsgiliathEnterprise/net.osgiliath.parent/blob/master/net.osgiliath.framework/net.osgiliath.features.karaf-features/net.osgiliath.features.karaf-features.itests/net.osgiliath.features.karaf-features.itests.validation.cdi/src/main/java/net/osgiliath/validation/impl/ValidatorFactorySample.java)

## Relevant doc

* Pax-CDI : https://ops4j1.jira.com/wiki/display/PAXCDI/Pax+CDI
* Hibernate validator: http://hibernate.org/validator/
