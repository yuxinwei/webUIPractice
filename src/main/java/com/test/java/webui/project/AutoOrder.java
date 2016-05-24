package com.test.java.webui.project;

import com.test.java.webui.PageFactory.InvokeData;
import com.test.java.webui.project.Page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/5/19.
 */
public class AutoOrder extends InvokeData {
    private WebDriverPlus driverPlus;

    @BeforeClass
    public void before() {
        driverPlus = new WebDriverPlus();
        driverPlus.get("https://passport.suning.com/ids/login");
    }

    @Test(dataProvider = "csv")
    public void order(String username, String password) {
        LoginPage loginPage = new LoginPage(driverPlus);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.login();
        Assert.assertTrue(loginPage.getTitle().contains("Suning"));
    }

    @AfterClass
    public void tearDown() {
        driverPlus.quit();
    }
}
