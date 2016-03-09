package com.test.java.webui.api.base;

import org.testng.annotations.BeforeClass;

/**
 * Created by beigui on 2016/3/8.
 */
public abstract class AbstractAccessBaidu extends BaseTest{
    private String url = "http://www.baidu.com";

    @BeforeClass
    public void accessBaidu() throws InterruptedException {
        driver.get(url);
        System.out.println("访问百度，title为" + driver.getTitle());
    }
}
