package com.test.java.webui.project.Page;

import com.test.java.webui.project.WebDriverPlus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by beigui on 2016/5/24.
 */
public class LoginPage extends AbstractBasePage {
    public LoginPage(WebDriverPlus webDriverPlus) {
        super(webDriverPlus);
    }

    @FindBy(how = How.ID, using = "userName")
    WebElement username;

    @FindBy(how = How.ID, using = "password")
    WebElement password;

    @FindBy(how = How.ID, using = "submit")
    WebElement submit;

    @FindBy(how = How.ID, using = "usernameHtml02")
    WebElement usernameCheckpoint;

    public void typeUsername(String _username) {
        username.clear();
        username.sendKeys(_username);
    }

    public void typePassword(String _password) {
        password.clear();
        password.sendKeys(_password);
    }

    public boolean isLoginedIn(String text) {
        return textToBePresent(usernameCheckpoint, text);
    }

    public void login() {
        System.out.println("开始登录");
        submit.click();
    }
}
