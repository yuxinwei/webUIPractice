package com.test.java.webui.api.highLevelSkills.testFlowControl;

import com.test.java.webui.api.base.AbstractLocalHtml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by beigui on 2016/4/5.
 * 功能：检查元素状态的方法：
 * 方法           目的
 * isEnabled()  检查元素是否启用
 * isSelected() 检查元素是否被选中(单选，多选，下拉框)
 * isDisplayed()检查元素是否可见
 */
public class ElementStatusCheckDemo extends AbstractLocalHtml {
    @Test
    public void radioButtonTest() {
        launchLocalHtml("RadioButton.html");
        //使用value值来定位单选按钮
        WebElement apple = driver.findElement(By.cssSelector("input[value='Apple']"));
        //检查是否已选择，如果没有则点击选择
        if (!apple.isSelected()) {
            apple.click();
        }
        //验证apple选项已经选中
        Assert.assertTrue(apple.isSelected());
        //也可以得到所有的单选按钮
        List<WebElement> fruit = driver.findElements(By.name("fruit"));
        //查询Orange选项是否存在，如果存在则选择
        for (WebElement item : fruit) {
            if (item.getAttribute("value").equals("Orange")) {
                if (!item.isSelected()) {
                    item.click();
                    Assert.assertTrue(item.isSelected());
                    break;
                }
            }
        }
    }
}
