package net.osgiliath.messaging.cdi.repository;

/*
 * #%L
 * net.osgiliath.hello.model.jpa
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

import net.osgiliath.messaging.cdi.HelloEntity;

/**
 * 
 * @author charliemordant JPA accessible interface by business or route module
 *         (see business module for JMS or REST export, don't forget the
 *         template.mf cxf package export)
 */
public interface HelloCDIRepository {
  /**
   * Saves the entity
   * 
   * @param entity
   *          to save
   */
  <S extends HelloEntity> void directSave(S entity);
}
