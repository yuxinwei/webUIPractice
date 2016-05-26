package com.test.java.webui.project.Page;

import com.test.java.webui.project.WebDriverPlus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/**
 * Created by beigui on 2016/5/24.
 */
public class CartPage extends AbstractBasePage {

    public CartPage(WebDriverPlus webDriverPlus) {
        super(webDriverPlus);
    }

    @FindBy(how = How.ID, using = "sh_receive_name")
    WebElement receiveName;

    @FindBy(how = How.ID, using = "sh_receive_mobile")
    WebElement receiveMobile;

    @FindBy(how = How.XPATH, using = "//div[@id='city']/a")
    WebElement areaLink;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'北京')]")
    WebElement province;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'北京市')]")
    WebElement city;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'东城区')]")
    WebElement range;

    @FindBy(how = How.ID, using = "sh_receive_address")
    WebElement address;

    @FindBy(how = How.ID, using = "submit-btn")
    WebElement submit;

    public void typeReceiveName(String name) {
        receiveName.sendKeys(name);
    }

    public void typeReceiveMobile(String mobileNumber) {
        receiveMobile.sendKeys(mobileNumber);
    }

    public void selectArea() {
        Assert.assertTrue(areaLink.getText().contains("请选择"));
        areaLink.click();
        province.click();
        city.click();
        range.click();
    }

    public void typeAddress(String addr) {
        address.sendKeys(addr);
    }

    public void submitOrder() {
        submit.click();
    }
}
