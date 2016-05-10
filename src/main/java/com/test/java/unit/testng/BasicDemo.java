package com.test.java.unit.testng;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by beigui on 2016/3/8.
 */
public class BasicDemo {
    @BeforeClass
    public void before() {
        System.out.println("before");
    }

    @Test
    public void test() {
        System.out.println("testing");
    }

    @Test
    public void assertTest() {
        Assert.assertTrue("not true", true);
        Assert.assertTrue("wrong", false);
    }

    @AfterClass
    public void after() {
        System.out.println("after");
    }
}
