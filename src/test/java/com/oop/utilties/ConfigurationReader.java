package com.oop.utilties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigurationReader {
    private static final Logger LOGGER = Logger.getLogger(ConfigurationReader.class.getName());

    private static
    Properties properties;

    static {
        try (FileInputStream input = new FileInputStream("configuration.properties")) {
            properties = new Properties();
            properties.load(input);

            LOGGER.info("Configuration file loaded successfully.");
        } catch (IOException e) {
            LOGGER.severe("Error loading configuration file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }
}
