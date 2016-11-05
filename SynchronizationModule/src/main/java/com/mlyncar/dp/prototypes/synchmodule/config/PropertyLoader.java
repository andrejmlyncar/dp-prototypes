package com.mlyncar.dp.prototypes.synchmodule.config;

import com.mlyncar.dp.prototypes.synchmodule.exception.ConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Andrej Mlyncar <a.mlyncar@gmail.com>
 */
public class PropertyLoader {

    private Properties properties;
    private final static String CONFIG_PATH_PROPERTY_NAME = "synchronization.properties";

    public PropertyLoader() throws ConfigurationException {
        this.properties = new Properties();
        InputStream configFileStream = PropertyLoader.class.getClassLoader().getResourceAsStream(CONFIG_PATH_PROPERTY_NAME);
        try {
            properties.load(configFileStream);
        } catch (IOException ex) {
            throw new ConfigurationException("Unable to load configuration file: " + ex.getMessage(), ex);
        }
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }
}
