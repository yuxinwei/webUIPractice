package com.test.java.webui.flash;

import org.openqa.selenium.firefox.FirefoxDriver;

public class permadi_INTERACTION_WITH_JAVASCRIPT {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("http://www.permadi.com/tutorial/flashjscommand/");
        driver.manage().window().maximize();
        FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
        flashApp.callFlashObject("Play"); // first number
        Thread.sleep(3000L);
        flashApp.callFlashObject("StopPlay"); // operation

        Thread.sleep(3000L);
        flashApp.callFlashObject("Rewind");
        System.out.println(flashApp.callFlashObject("GetVariable", "/:message"));
        flashApp.callFlashObject("SetVariable", "/:message", "Learn Flash testing with Webdriver");
        System.out.println(flashApp.callFlashObject("GetVariable", "/:message"));

    }

}