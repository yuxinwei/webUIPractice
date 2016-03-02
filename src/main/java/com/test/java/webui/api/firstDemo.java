package com.test.java.webui.api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by beigui on 2016/3/2.
 */
public class firstDemo {
    public static void main(String[] args) {
        //Firefox如果不在默认的位置 %PROGRAMFILES%\Mozilla Firefox\firefox.exe
//        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
