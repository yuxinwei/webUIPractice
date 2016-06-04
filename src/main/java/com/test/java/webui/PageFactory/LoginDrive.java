package com.test.java.webui.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/5/22.
 * 改进点：数据驱动是通过读取csv文件方式，load数据
 */
public class LoginDrive extends InvokeData {
    private LoginPage loginPage;
    private WebDriver driver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        System.out.println("before");
    }


    @Test(dataProvider = "csv")
    public void drive(String username, String password) {
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.login();
        Assert.assertTrue(loginPage.getTitle().contains("Suning"));
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("after");
        driver.quit();
    }
}
