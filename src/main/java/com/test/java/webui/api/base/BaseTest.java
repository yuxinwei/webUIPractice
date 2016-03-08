package com.test.java.webui.api.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by beigui on 2016/3/8.
 */
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        System.out.println("driver setted up");
    }

    @AfterClass
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
