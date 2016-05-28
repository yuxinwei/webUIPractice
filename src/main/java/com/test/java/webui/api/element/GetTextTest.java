package com.test.java.webui.api.element;

import com.test.java.webui.api.base.AbstractAccessBaidu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/3/8.
 */
public class GetTextTest extends AbstractAccessBaidu{
    @Test
    public void assertGetText() {
        WebElement loginElement = driver.findElement(By.xpath("(//a[contains(text(),'登录')])[2]"));
        Assert.assertTrue(loginElement.getText().equals("登录"), loginElement.getText());
    }

    @Test
    public void test() {
        System.out.println("ss");
    }
}
