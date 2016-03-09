package com.test.java.webui.api.element;

import com.test.java.webui.api.base.AbstractAccessBaidu;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by beigui on 2016/3/9.
 */
public class SelectElement extends AbstractAccessBaidu {
    @Test
    public void selectElementByJQuery() {
        injectjQueryIfNeeded();
        List<WebElement> links = (List<WebElement>) jse.executeScript("return jQuery.find('.mnav')");
        for (WebElement item : links) {
            System.out.println(item.getText());
        }
    }
}
