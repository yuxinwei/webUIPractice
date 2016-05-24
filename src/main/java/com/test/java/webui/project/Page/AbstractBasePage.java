package com.test.java.webui.project.Page;

import com.test.java.webui.project.WebDriverPlus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by beigui on 2016/5/24.
 */
public abstract class AbstractBasePage {
    protected WebDriverPlus webDriverPlus;
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jse;

    public AbstractBasePage(WebDriverPlus webDriverPlus) {
        this.webDriverPlus = webDriverPlus;
        driver = webDriverPlus.getDriver();
        wait = webDriverPlus.getWait();
        jse = webDriverPlus.getJse();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        //下一步非常重要，是POM编程方式起作用的关键，自动把注解数据加载到属性中
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    /*
    public WebElement findElement(By locator) {
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
    }
    */
}
