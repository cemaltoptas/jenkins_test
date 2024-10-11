package com.oop.utilties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Objects;
import java.util.logging.Logger;

public enum BrowserType {

    CHROME("chrome") {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    FIREFOX("firefox") {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    },
    EDGE("edge") {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    },
    SAFARI("safari") {
        @Override
        public WebDriver createDriver() {
            if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                throw new WebDriverException("Safari is only supported on macOS");
            }
            WebDriverManager.getInstance(SafariDriver.class).setup();
            return new SafariDriver();
        }
    },
    EXPLORER("ie") {
        @Override
        public WebDriver createDriver() {
            if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                throw new WebDriverException("Internet Explorer is only supported on Windows");
            }
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }
    },
    CHROME_HEADLESS("chrome-headless") {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            return new ChromeDriver(options);
        }
    };

    private static final Logger LOGGER = Logger.getLogger(BrowserType.class.getName());
    private final String name;

    BrowserType(String name) {
        this.name = name;
    }

    public static BrowserType fromString(String browserName) {
        for (BrowserType type : values()) {
            if (type.name.equalsIgnoreCase(browserName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unsupported browser: " + browserName);
    }

    public static String getClassReference() {
        String path = Objects.requireNonNull(BrowserType.class.getResource("/")).toString();
        return "Root path: " + path;
    }

    public abstract WebDriver createDriver();

    @Override
    public String toString() {
        return this.name;
    }
}