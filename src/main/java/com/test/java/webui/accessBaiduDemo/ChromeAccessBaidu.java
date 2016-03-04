package com.test.java.webui.accessBaiduDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by beigui on 2016/3/4.
 */
public class ChromeAccessBaidu {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","d:\\Software\\SeleniumDriver\\chromedriver2.20.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
