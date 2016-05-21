package com.test.java.webui.api.base;

import java.io.File;

/**
 * Created by beigui on 2016/3/11.
 */
public class AbstractLocalHtml extends BaseTest {
    protected void launchLocalHtml(String html) {
        html = System.getProperty("user.dir") + File.separator + "demo" + File.separator + html;
        System.out.println("html 路径：" + html);
        driver.get(html);
        System.out.println("访问网页：" + driver.getTitle());
    }
}
