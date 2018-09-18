package com.sbms.test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static final DriverFactory INSTANCE = new DriverFactory();

    private final ThreadLocal<WebDriver> driver;

    private DriverFactory() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("os.name").toLowerCase().startsWith("windows") ?
                        "src/test/drivers/chromedriver_win32.exe" :
                        "src/test/drivers/chromedriver_linux64");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1200x600");
        options.addArguments("--lang=en");
        driver = ThreadLocal.withInitial(() -> new ChromeDriver(options));
    }

    public static DriverFactory getInstance() {
        return INSTANCE;
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
