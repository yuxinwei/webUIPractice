package com.test.java.unit.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/5/17.
 * DataProvider的返回值为Object[][]，固定格式
 * Test用例中，直接指定参数类型和数量，testng会自动匹配个数
 */
public class DataProviderDemo {
    @DataProvider(name = "loginData")
    public Object[][] data() {
        return new Object[][]{{"user1", "pass1"}, {"user2", "pass2"}};
    }

    @Test(dataProvider = "loginData")
    public void test(String username, String password) {
        System.out.println(username + " " + password);
    }

    @Test(dataProvider = "loginData")
    public void testWrongParamNumber(String username, String password, String test) {
        System.out.println(username + " " + password + " " + test);
    }
}
