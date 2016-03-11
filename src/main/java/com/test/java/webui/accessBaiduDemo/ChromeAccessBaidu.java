package com.test.java.webui.accessBaiduDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by beigui on 2016/3/4.
 */
public class ChromeAccessBaidu {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","D:\\Software\\SeleniumDriver\\chromedriver2.20.exe");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\driver\\chromedriver2.20.exe");
        //如果chrome没有安装在默认位置
//        System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
