package com.test.java.webui.api.element;

import com.test.java.webui.api.base.AbstractAccessBaidu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by beigui on 2016/3/8.
 * 功能：百度一下Test，并记录下第一个div的文本
 */
public class SearchTestOnBaidu extends AbstractAccessBaidu {
    @Test
    public void searchTest() {
        WebElement searchInput = driver.findElement(By.id("kw"));
        searchInput.sendKeys("Test");
        WebElement submitButton = driver.findElement(By.id("su"));
        submitButton.click();

        List<WebElement> results = driver.findElements(By.xpath("//div[@class='result c-container ']"));
        System.out.println(results.get(0).getText());
    }
}
