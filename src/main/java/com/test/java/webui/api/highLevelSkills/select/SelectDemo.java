package com.test.java.webui.api.highLevelSkills.select;

import com.test.java.webui.api.base.AbstractLocalHtml;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/3/21.
 */
public class SelectDemo extends AbstractLocalHtml {
    @Test
    public void dropDownTest() {
        launchLocalHtml("Droplist.html");
        //得到下拉列表框
        Select make = new Select(driver.findElement(By.name("make")));
        //验证下拉列表的数量
        Assert.assertEquals(4, make.getOptions().size());
        //通过value属性来选择选项
//        make.selectByValue("Audi");
        //通过索引来选择选项
        make.selectByIndex(3);
    }
}
