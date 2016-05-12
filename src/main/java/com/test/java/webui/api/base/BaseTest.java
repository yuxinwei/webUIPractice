package com.test.java.webui.api.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by beigui on 2016/3/8.
 */
public abstract class BaseTest {
    protected WebDriver driver;
    protected JavascriptExecutor jse;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        jse = (JavascriptExecutor) driver;
        System.out.println("driver setted up");
    }

    @AfterClass
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

    protected void injectjQueryIfNeeded() {
        while (!jQueryLoaded()) {
            injectjQuery();
            System.out.println("inject jquery once.");
        }
    }

    private void injectjQuery() {
        jse.executeScript(" var headId = " +
                "document.getElementsByTagName(\"head\")[0];" +
                "var newScript = document.createElement('script');" +
                "newScript.type = 'text/javascript';" +
                "newScript.src = " +
                "'https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js';" +
                "headId.appendChild(newScript);");

    }

    private boolean jQueryLoaded() {
        Boolean loaded = false;
        try {
            loaded = (Boolean) jse.executeScript("return jQuery() != null");
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return loaded;
    }

}
