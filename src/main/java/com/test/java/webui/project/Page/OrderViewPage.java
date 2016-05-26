package com.test.java.webui.project.Page;

import com.test.java.webui.project.WebDriverPlus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by beigui on 2016/5/26.
 */
public class OrderViewPage extends AbstractBasePage {

    public OrderViewPage(WebDriverPlus webDriverPlus) {
        super(webDriverPlus);
    }

    @FindBy(how = How.XPATH, using = "//table/tbody/tr[2]/td/h3")
    List<WebElement> cells;

    public boolean checkOrder(String text) {
        for (WebElement item : cells) {
            System.out.println(item.getText());
            if (item.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }
}
