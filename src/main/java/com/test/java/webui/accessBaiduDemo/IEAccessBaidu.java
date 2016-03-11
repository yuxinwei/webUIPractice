package com.test.java.webui.accessBaiduDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by beigui on 2016/3/4.
 * 功能：IE访问百度，需要Ie driver
 */
public class IEAccessBaidu {
    public static void main(String[] args) {
//        System.setProperty("webdriver.ie.driver", "d:\\Software\\SeleniumDriver\\IEDriverServer2.48.exe");
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\IEDriverServer2.48.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://www.baidu.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
