package com.sbms.test.pages;

import com.sbms.test.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver() {
        return DriverFactory.getInstance().getDriver();
    }
}
