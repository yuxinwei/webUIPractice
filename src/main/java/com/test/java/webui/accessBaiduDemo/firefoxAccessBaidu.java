package com.test.java.webui.accessBaiduDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by beigui on 2016/3/2.
 * 功能：firefox访问百度
 */
public class FirefoxAccessBaidu {
    public static void main(String[] args) {
        //Firefox如果不在默认的位置 %PROGRAMFILES%\Mozilla Firefox\firefox.exe
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
