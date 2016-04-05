package com.test.java.webui.api.highLevelSkills.testFlowControl;

import com.test.java.webui.api.base.AbstractLocalHtml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by beigui on 2016/4/5.
 */
public class FrameDemo extends AbstractLocalHtml {
    @Test
    public void frameByIdOrNameTest() {
        launchLocalHtml("frame\\frame.html");
        //通过id定位到左边的框架
        driver.switchTo().frame("left");
        String leftMsg = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals("i am left page", leftMsg);

        //回到初始的焦点
        driver.switchTo().defaultContent();

        //通过name定位到右边的框架
        driver.switchTo().frame("right");
        String rightMsg = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals("i am right page", rightMsg);
    }

    @Test
    public void frameByContentTest() {
        launchLocalHtml("frame\\frame.html");
        //得到所有的frame元素
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        //通过页面的内容得到中间框架
        for (WebElement item : frames) {
            driver.switchTo().frame(item);
            if (driver.getPageSource().contains("middle")) {
                break;
            } else {
                //***没有匹配的时候需要回到最初的页面
                driver.switchTo().defaultContent();
            }
        }

        String actualText = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals("i am middle page", actualText);
    }
}
