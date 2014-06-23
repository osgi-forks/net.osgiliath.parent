package net.osgiliath.helper.camel.configadmin.internal;

/*
 * #%L
 * net.osgiliath.helper.camel.cdi.configadmin
 * %%
 * Copyright (C) 2013 - 2014 Osgiliath
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

import java.io.IOException;
import java.util.Properties;

import net.osgiliath.helper.camel.configadmin.ConfigAdminTracker;

import org.apache.camel.component.properties.DefaultPropertiesParser;
import org.apache.deltaspike.core.api.config.ConfigResolver;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author charliemordant
 * Camel property parser for config admin
 */
public class ConfigAdminPropertiesParser extends DefaultPropertiesParser {
    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory
	    .getLogger(ConfigAdminPropertiesParser.class);
    /**
     * Camel config override to resolve config admin properties
     */
    @Override
    public String parseProperty(String key, String value, Properties properties) {
	String answer = null;
	try {
	    answer = ConfigAdminTracker.getInstance(null).getProperty(key);
	} catch (IOException | InvalidSyntaxException e) {
	    LOG.error("Exception while parsing config admin properties", e);
	}
	if (answer != null) {
	    return answer;
	}
	answer = ConfigResolver.getPropertyValue(key);
	if (answer != null) {
	    return answer;
	}
	return super.parseProperty(key, value, properties);
    }
}