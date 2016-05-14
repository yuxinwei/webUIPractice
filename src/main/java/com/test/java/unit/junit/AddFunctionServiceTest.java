package com.test.java.unit.junit;

import com.test.java.unit.service.AddFunctionService;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by beigui on 2016/5/10.
 * 单元测试是一个测试思想，比方例子中的对AddFunctionService的add方法进行测试，就是一个单元测试，是最小单元的测试
 * 而Junit或者说unitX，是框架，为了让单元测试更简单且复用性高而建立的
 * 在这个例子中，现阶段无法体现出来。
 * 让我们扩展AddFunctionService，添加更多的方法，展示框架的强大之处
 */
public class AddFunctionServiceTest {
    private static AddFunctionService addFunctionService;

    @BeforeClass
    public static void before() {
        System.out.println("before");
        addFunctionService = new AddFunctionService();
    }

    @Test
    public void addTest() {
        System.out.println(addFunctionService.add(1, 1));
    }

    @Test
    public void plusTest() {
        System.out.println(addFunctionService.plus(1,1));
    }
}
