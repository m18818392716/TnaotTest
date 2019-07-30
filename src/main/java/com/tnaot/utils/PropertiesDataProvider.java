package com.tnaot.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


public class PropertiesDataProvider {

    public static String getTestData(String configFilePath, String key) {
        Configuration config = null;
        try {
            config = new PropertiesConfiguration(configFilePath);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return String.valueOf(config.getProperty(key));
    }
}
