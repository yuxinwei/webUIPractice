package com.test.java.webui.api.highLevelSkills.actions;

import com.test.java.webui.api.base.AbstractLocalHtml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/3/11.
 * 功能：当鼠标双击的时候触发了字体变化的事件， doubleClick模拟了真实的双击动作，验证了字体属性
 *
 * Actions可以是鼠标键盘组合的一系列行为，通过build组成一个链条，perform进行执行
 *
 * Refer: https://www.ibm.com/developerworks/cn/java/j-lo-keyboard/
 * 在使用 Selenium WebDriver 做自动化测试的时候，会经常模拟鼠标和键盘的一些行为。
 * 比如使用鼠标单击、双击、右击、拖拽等动作；或者键盘输入、快捷键使用、组合键使用等模拟键盘的操作。
 * 在 WebDeriver 中，有一个专门的类来负责实现这些测试场景，
 * 那就是 Actions 类，在使用该类的过程中会配合使用到 Keys 枚举
 * 以及 Mouse、 Keyboard、CompositeAction 等类。
 */
public class ActionsDemo extends AbstractLocalHtml{
    @Test
    public void doubleClickTest() {
        launchLocalHtml("DoubleClickDemo.html");
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals("14px", message.getCssValue("font-size"));
        Actions builder = new Actions(driver);
        builder.doubleClick(message).doubleClick().build().perform();
        Assert.assertEquals("20px", message.getCssValue("font-size"));
    }
}
