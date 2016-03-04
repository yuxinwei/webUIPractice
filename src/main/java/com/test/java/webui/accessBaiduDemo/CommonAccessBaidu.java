package com.test.java.webui.accessBaiduDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by beigui on 2016/3/4.
 */
public class CommonAccessBaidu {
    public static void main(String[] args) {
        WebDriver driver = null;
        String browser = "firefox";
        String browserLocation = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";
        String url = "http://www.baidu.com";
        if (browser.equals("firefox")) {
            if (!browserLocation.equals("")) {
                System.setProperty("webdriver.firefox.bin", browserLocation);
            }
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver","d:\\Software\\SeleniumDriver\\chromedriver2.20.exe");
            if (!browserLocation.equals("")) {
                System.setProperty("webdriver.chrome.bin", browserLocation);
            }
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.ie.driver", "d:\\Software\\SeleniumDriver\\IEDriverServer2.48.exe");
            driver = new InternetExplorerDriver();
        }
        driver.get(url);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
