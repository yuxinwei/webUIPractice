package com.test.java.webui.project.Page;

import com.test.java.webui.project.WebDriverPlus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by beigui on 2016/5/24.
 */
public class WarePage extends AbstractBasePage {

    public WarePage(WebDriverPlus webDriverPlus) {
        super(webDriverPlus);
    }

    @FindBy(how = How.ID, using = "addCart")
    WebElement addToCart;

    public void toCart() {
        addToCart.click();
    }


    @FindBy(how = How.ID, using = "buyNum")
    WebElement buyNum;

    @FindBy(how = How.ID, using = "buyNowAddCart")
    WebElement buyButton;

    private void addNum(String num) {
        buyNum.sendKeys(num);
    }

    public void addCart() {
        moveToElement(buyButton).click();
    }
}
