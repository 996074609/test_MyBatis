package com.ch;


import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Properties;

public class test02 {
    public static void main(String[] args) throws IOException {
        Properties p = Resources.getResourceAsProperties("db.properties");
        String name = p.getProperty("name");
        System.out.println(name);
    }
}
