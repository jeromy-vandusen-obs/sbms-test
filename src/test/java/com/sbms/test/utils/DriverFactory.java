package com.sbms.test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static final DriverFactory INSTANCE = new DriverFactory();

    private final ThreadLocal<WebDriver> driver;

    private DriverFactory() {
        driver = ThreadLocal.withInitial(ChromeDriver::new);
    }

    public static DriverFactory getInstance() {
        return INSTANCE;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
