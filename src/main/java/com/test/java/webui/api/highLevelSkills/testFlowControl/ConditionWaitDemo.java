package com.test.java.webui.api.highLevelSkills.testFlowControl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/3/22.
 * 显式等待：只需要执行在需要同步的地方而不影响脚本其他的地方。
 *         WebDriverWait和ExpectedCondition类执行显式等待。
 *         ExpectedCondition类提供了一系列预定义好的条件来等待。
 *         下面列出了常用条件
 *      预定义条件           方法名
 *  -----------------|-------------------
 *     元素可见可点击  |   elementToBeClickable(By locator)
 *     元素被选中      |  elementToBeSelected(WebElement element)
 *     存在一个元素    |   presenceOfElementLocated(By locator)
 *  元素中出现指定的文本 |   textToBePresentInElementLocated(By locator, String text)
 *     元素的值        |   textToBePresentInElementValue(By locator, String text)
 *        标题        |    titleContains(String title)
 *
 *  更多信息访问：http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
 *
 */
public class ConditionWaitDemo {
    @Test
    public void conditionWaitTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.tutorialzine.com/2009/09/simple-ajax-website-jquery/demo.html");

        WebElement page4Button = driver.findElement(By.linkText("Page 4"));
        page4Button.click();

        //设置等待时间为10秒
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //等待直到符合元素文本内容出现
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("pageContent"),
                "Nunc nibh tortor"
                ));
        driver.close();
    }
}
