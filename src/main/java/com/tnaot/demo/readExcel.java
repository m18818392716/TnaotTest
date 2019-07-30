package com.tnaot.demo;

import com.tnaot.utils.XMLUtils;

public class readExcel {

    public static void main(String[] args) {
        String path = "D:\\software\\idea-workspace\\src\\main\\java\\com\\tnaot\\page\\LoginPage.xml";
        String pageName = "LoginPage";
        try {
            XMLUtils.readXMLDocument(path,pageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
