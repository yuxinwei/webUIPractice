package com.test.java.webui.project.Page;

import com.test.java.webui.project.WebDriverPlus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by beigui on 2016/5/27.
 */
public class CartPage extends AbstractBasePage {
    public CartPage(WebDriverPlus webDriverPlus) {
        super(webDriverPlus);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'去结算')]")
    WebElement toOrder;

    public void goToOrder() {
        toOrder.click();
    }
}
