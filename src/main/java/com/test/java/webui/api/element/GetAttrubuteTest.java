package com.test.java.webui.api.element;

import com.test.java.webui.api.base.AbstractAccessBaidu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/3/8.
 */
public class GetAttrubuteTest extends AbstractAccessBaidu {
    @Test
    public void checkHrefNuoMi() {
        WebElement linkElement = driver.findElement(By.xpath("//a[contains(text(),'糯米')]"));
        String link = linkElement.getAttribute("href");
        Assert.assertTrue(link.contains("www.nuomi.com1"), "href实际为：" + link);
    }
}
