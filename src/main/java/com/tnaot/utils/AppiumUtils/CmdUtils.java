package com.tnaot.utils.AppiumUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CmdUtils {

    public static final String PROJECT_PATH = "D:/software/githubRespository/TnaotTest/";

//    protected static Logger logger = Logger.getLogger(CmdUtils.class);

//    public static void main(String[] args)
//    {
//        // get the current runtime assosiated with this process
//        Runtime runtime = Runtime.getRuntime();
//        // print the current free memory for this runtime
//        System.out.println("" + runtime.freeMemory());
//
//        String xmlFileName = "testng.xml";
//        String path = "D:/software/idea-workspace";
//        try {
//            System.out.println("开始执行..");
//            //runtime.exec("cmd /k cd D:/software/idea-workspace && mvn test -DxmlFileName=" + xmlFileName);
//            runtime.exec("cmd /k cd " + path + " && mvn test -DxmlFileName=" + xmlFileName);
//            System.out.println("结束执行..");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


    /**
     * 通过java启动cmd命令模式来执行maven命令
     * @param xmlFileName 需要执行的testNG文件XML
     */
    public static void generateReport(String xmlFileName,String excelPath)
    {
        // get the current runtime assosiated with this process
        Runtime runtime = Runtime.getRuntime();
        // print the current free memory for this runtime
        System.out.println("" + runtime.freeMemory());

        //String xmlFileName = "testng.xml";
        String path = "D:/software/githubRespository/TnaotTest";
        try {
            System.out.println("开始执行..");
            //runtime.exec("cmd /k cd D:/software/idea-workspace && mvn test -DxmlFileName=" + xmlFileName);
            runtime.exec("cmd /k cd " + path + " && mvn test -DxmlFileName=" + xmlFileName + " -DexcelPath=" + excelPath);
            System.out.println("结束执行..");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        String srcPath = PROJECT_PATH + "target/surefire-reports";
        generateReport("testng.xml","UILibrary.xls");
        try {
            TimeUnit.SECONDS.sleep(10);//秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //SendEmail.send(srcPath);
    }
}
