package com.test.java.webui.api.highLevelSkills.testFlowControl;

import com.test.java.webui.api.base.AbstractLocalHtml;
import junit.framework.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/4/5.
 */
public class AlertDemo extends AbstractLocalHtml {
    @Test
    public void alertTest() {
        launchLocalHtml("alert.html");
        //点击按钮弹出alert框
        WebElement button = driver.findElement(By.id("alert"));
        button.click();

        //获取alert窗口
        Alert alertBox = driver.switchTo().alert();

        //验证alert窗口里的文字
        Assert.assertTrue(alertBox.getText().equals("Hello World"));
        alertBox.accept();
    }

    @Test
    public void confirmTest() {
        launchLocalHtml("alert.html");
        //点击确定按钮
        getConfirmBox().accept();
        //验证点击后的文字
        Assert.assertEquals("你点击了确定按钮！",
                        driver.findElement(By.cssSelector("span")).getText());

        //再次点击取消按钮
        getConfirmBox().dismiss();
        Assert.assertEquals("你点击了取消按钮！",
                        driver.findElement(By.cssSelector("span")).getText());
    }

    //封装得到确认窗口的方法
    private Alert getConfirmBox() {
        //点击按钮弹出确认提示框
        WebElement button = driver.findElement(By.id("confirm"));
        button.click();

        //获取确认提示框
        Alert confirmBox = driver.switchTo().alert();
        Assert.assertTrue(confirmBox.getText().contains("我是确认提示框"));
        return confirmBox;
    }
}
