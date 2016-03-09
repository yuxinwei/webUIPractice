package com.test.java.webui.api.driver;

import com.test.java.webui.api.base.AbstractAccessBaidu;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/3/9.
 */
public class MaximumBrowser extends AbstractAccessBaidu{
    @Test
    public void maxBrowser() {
        driver.manage().window().maximize();
    }
}
