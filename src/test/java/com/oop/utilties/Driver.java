package com.oop.utilties;

import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class Driver {
    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {
        throw new IllegalStateException("Utility class");
    }

    // Get driver instance
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browser = ConfigurationReader.getProperty("browser");  // Get browser name from config
            driverPool.set(BrowserType.fromString(browser).createDriver());  // Use BrowserType enum to create the WebDriver
        }
        return driverPool.get();
    }

    // Close and clean up the driver
    public static void closeDriver() {
        if (driverPool.get() != null) {
            try {
                driverPool.get().quit();
            } catch (Exception e) {
                LOGGER.warning("Error while closing driver: " + e.getMessage());
            } finally {
                driverPool.remove();
            }
        }
    }

}
