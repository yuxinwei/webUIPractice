package com.test.java.webui.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by beigui on 2016/5/22.
 * Refer: http://www.cnblogs.com/tobecrazy/p/5008432.html
 */
public class LoginPage {
    public String base_url = "https://passport.suning.com/ids/login";
    public WebDriver driver;

    @FindBy(how = How.ID, using = "userName")
    WebElement username;

    @FindBy(how = How.ID, using = "password")
    WebElement password;

    @FindBy(how = How.ID, using = "submit")
    WebElement submit;

    public void typeUsername(String _username) {
        username.clear();
        username.sendKeys(_username);
    }

    public void typePassword(String _password) {
        password.clear();
        password.sendKeys(_password);
    }

    public void login() {
        submit.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(base_url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
}
