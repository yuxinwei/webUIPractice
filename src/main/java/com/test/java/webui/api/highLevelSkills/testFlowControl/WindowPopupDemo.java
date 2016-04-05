package com.test.java.webui.api.highLevelSkills.testFlowControl;

import com.test.java.webui.api.base.AbstractLocalHtml;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by beigui on 2016/4/5.
 */
public class WindowPopupDemo extends AbstractLocalHtml {
    //通过名称识别一个弹出窗口
    @Test
    public void windowsNameTest() {
        launchLocalHtml("window.html");
        //保存父窗口
        String parentWindowId = driver.getWindowHandle();
        //点击按钮弹出窗口
        WebElement helpButton = driver.findElement(By.id("helpbutton1"));
        helpButton.click();

        try {
            //转到HelpWindow
            driver.switchTo().window("HelpWindow");
        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }

        //验证新窗口里的文本
        Assert.assertEquals("PopUpWindow", driver.findElement(By.tagName("p")).getText());
        //关闭子窗口
        driver.close();
        //回到父窗口
        driver.switchTo().window(parentWindowId);
        //验证父窗口的title
        Assert.assertTrue(driver.getTitle().equals("help"));
    }

    //通过窗口标题一个弹出窗口
    @Test
    public void windowsTitleTest() {
        launchLocalHtml("window.html");
        //保存父窗口
        String parentWindowId = driver.getWindowHandle();
        //点击按钮弹出窗口
        WebElement helpButton = driver.findElement(By.id("helpbutton1"));
        helpButton.click();

        Set<String> allWindowsId = driver.getWindowHandles();
        //通过title得到新的窗口
        for (String item : allWindowsId) {
            if (driver.switchTo().window(item).getTitle().equals("PopUpWindow")) {
                break;
            }
        }

        //验证新窗口里的文本
        Assert.assertEquals("PopUpWindow", driver.findElement(By.tagName("p")).getText());
        //关闭子窗口
        driver.close();
        //回到父窗口
        driver.switchTo().window(parentWindowId);
    }

    //通过窗口里面的内容一个弹出窗口
    @Test
    public void windowsContentTest() {
        launchLocalHtml("window.html");
        //保存父窗口
        String parentWindowId = driver.getWindowHandle();
        //点击按钮弹出窗口
        WebElement helpButton = driver.findElement(By.id("helpbutton1"));
        helpButton.click();

        Set<String> allWindowsId = driver.getWindowHandles();
        //通过title得到新的窗口
        for (String item : allWindowsId) {
            driver.switchTo().window(item);
            if (driver.getPageSource().contains("Welcome")) {
                break;
            }
        }

        //验证新窗口里的文本
        Assert.assertEquals("PopUpWindow", driver.findElement(By.tagName("p")).getText());
        //关闭子窗口
        driver.close();
        //回到父窗口
        driver.switchTo().window(parentWindowId);
    }
}
