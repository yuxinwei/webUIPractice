package com.test.java.util;


import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by beigui on 2016/5/22.
 */
public class CSVOperator {
    /**
     *这个是用supercsv写的，api不简洁，放弃
     */
//    public static Object[][] csvReader(String filePath) throws IOException {
//        Object[][] result =  new Object[1024][];
//        filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + filePath + ".csv";
//        CsvListReader reader = new CsvListReader(new FileReader(filePath), CsvPreference.STANDARD_PREFERENCE);
//        List<String> item = null;
//        int i = 0;
//        while ((item = reader.read()) != null) {
//            if (!item.isEmpty()) {
//                result[i++] = item.toArray();
//            }
//        }
//        return result;
//    }

    public static Object[][] read(String filePath) throws IOException {
        filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + filePath + ".csv";
        CSVReader reader = new CSVReader(new FileReader(filePath), ',');
        List<String[]> lines = reader.readAll();
        Object[][] result = null;
        if (null != lines && lines.size() > 0) {
            int count = lines.size() - 1;
            result = new Object[count][];
            for (int i = 1; i < lines.size(); i++) {
                result[i - 1] = lines.get(i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        read("LoginDrive" + File.separator + "drive");
    }
}
