package com.test.java.unit.junit;

import com.test.java.unit.service.AddFunctionService;
import org.junit.Test;

/**
 * Created by beigui on 2016/5/10.
 */
public class AddFunctionServiceTest {
    private AddFunctionService addFunctionService;
    @Test
    public void addTest() {
        addFunctionService = new AddFunctionService();
        System.out.println(addFunctionService.add(1, 1));
    }
}
