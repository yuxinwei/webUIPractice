package com.test.java.webui.api.screenshot;

import com.test.java.webui.api.base.AbstractAccessBaidu;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by beigui on 2016/3/15.
 * 功能： TakesScreenshot接口提供了getScreenshotAs()方法来捕捉屏幕。
 *       OutputType.FILE是指定了输出文件的格式，即截取的屏幕以文件形式返回。
 */
public class TakesScreenshotTest extends AbstractAccessBaidu {
    @Test
    public void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("d:\\sreenshot.jpg");
        try {
            FileUtils.copyFile(srcFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
