package com.test.java.webui.PageFactory;

import com.test.java.util.CSVOperator;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by beigui on 2016/5/23.
 */
public class InvokeData {
    @DataProvider(name = "csv")
    public Object[][] loadCSVData(Method m) {
        String folderName = m.getDeclaringClass().getSimpleName();
        String fileName = m.getName();
        Object[][] result = null;
        try {
            result = CSVOperator.read(folderName + File.separator + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
