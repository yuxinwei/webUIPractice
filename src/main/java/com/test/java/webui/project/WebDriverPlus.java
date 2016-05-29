package com.test.java.webui.project;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by beigui on 2016/5/19.
 */
public class WebDriverPlus {
    private WebDriver driver;
    private JavascriptExecutor jse;
    private WebDriverWait wait;
    private static final String FIREFOX = "firefox";

    public WebDriverPlus() {
        this(FIREFOX);
    }

    public WebDriverPlus(String browser) {
        if (browser.equals("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + File.separator + "driver" + File.separator + "IEDriverServer2.48.exe");
            driver = new InternetExplorerDriver();
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver2.20.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver();
        }

        jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, 10);
        System.out.println("driver setted up");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverPlus get(String url) {
        driver.get(url);
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public JavascriptExecutor getJse() {
        return jse;
    }

    public void randomAction() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public void quit() {
        driver.quit();
    }



    /*public WebElement findElement(By locator) {
        if (isElementPresent(locator)) {
            return driver.findElement(locator);
        }
        return null;
    }

    public WebElement findElement(By locator, String text) {
        if (isElementMatch(locator, text)) {
            return driver.findElement(locator);
        }
        return null;
    }

    public boolean isElementPresent(By locator) {
        try {
            WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (null != result) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean isElementMatch(By locator, String text) {
        return wait.until((ExpectedConditions.textToBePresentInElementLocated(locator, text)));
    }*/
}
