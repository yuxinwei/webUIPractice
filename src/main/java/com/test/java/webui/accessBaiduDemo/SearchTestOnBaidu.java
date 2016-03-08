package com.test.java.webui.accessBaiduDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by beigui on 2016/3/8.
 * 功能：百度一下Test，并记录下第一个div的文本
 */
public class SearchTestOnBaidu {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");
        WebElement searchInput = driver.findElement(By.id("kw"));
        searchInput.sendKeys("Test");
        WebElement submitButton = driver.findElement(By.id("su"));
        submitButton.click();

        List<WebElement> results = driver.findElements(By.xpath("//div[@class='result c-container ']"));
        System.out.println(results.get(0).getText());
        driver.quit();
    }
}
