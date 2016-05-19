package com.test.java.webui.api.highLevelSkills.testFlowControl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by beigui on 2016/3/22.
 * 隐式等待：用来同步测试。当使用了隐式等待执行测试的时候，如果WebDriver没有在DOM中找到元素，将继续等待
 *          超出设定时间后则抛出找不到元素的异常。
 *          换句话说，当查找元素或元素并没有立即出现的时候，隐式等待将等待一段时间再查找DOM.默认时间为0。
 *          一旦设置了隐式等待，则它存在于整个WebDriver对象实例的生命周期中，
 *          但是，隐式等待会让一个正常响应的应用的测试变慢，它将会在寻找每个元素的时候都进行等待，
 *          这样就增加了整个测试执行的时间。
 */
public class ImplicitlyWaitDemo {
    @Test
    public void implicitWaitTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.tutorialzine.com/2009/09/simple-ajax-website-jquery/demo.html");
        //等待10秒
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement page4Button = driver.findElement(By.linkText("Page 4"));
        page4Button.click();

        WebElement message = driver.findElement(By.id("pageContent"));
        //等待ajax的内容出现
        //为什么这边用的线程等待，而不用隐式等待？
//        Thread.sleep(4000)意思是等待4秒钟，如果没有这句加上pageContent本身就存在，
//        所以它的内容就是最初没有点击时候的文本，不是我们所期望的。可见这样的方法本不是很
//        好。所以尽量去使用显示的等待，提供了更多的方法来精确的控制同步。
//        Thread.sleep(4000);
        Assert.assertTrue(message.getText().contains("Nunc nibh tortor"));
        driver.close();
    }
}
