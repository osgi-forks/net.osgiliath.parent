package conf;

/*
 * #%L
 * net.osgiliath.features.karaf-features.itests.jaxrs.web
 * %%
 * Copyright (C) 2013 - 2014 Osgiliath corp
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

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import net.osgiliath.features.karaf.jaxrs.web.cdi.HelloServiceJaxRS;

/**
 * 
 * @author charliemordant Web CDI REST application registering
 */
@ApplicationPath("helloService")
public class JaxRSCDIApplication extends Application {
  /**
   * Injection of the service
   */
  @Inject
  private HelloServiceJaxRS helloServiceJaxRS;

  /**
   * Returns service implems
   */
  @Override
  public Set<Object> getSingletons() {
    final Set<Object> ret = new HashSet<Object>();
    ret.add(this.helloServiceJaxRS);
    return ret;

  }

}
