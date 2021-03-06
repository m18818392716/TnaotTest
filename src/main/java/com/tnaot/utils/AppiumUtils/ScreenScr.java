package com.tnaot.utils.AppiumUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenScr {

    public static void getScreen(TakesScreenshot driver,String filename){

        String cyrPatn=System.getProperty("user.dir");

        File scrfile=driver.getScreenshotAs(OutputType.FILE);

        try {
            //((ITakesScreenshot)driver).GetScreenshot().SaveAsFile(cyrPatn+"\\img\\"+filename+".png");
            //FileUtils.copyFile(scrfile, new File(cyrPatn+"\\img\\"+filename+".png"));
            //FileUtils.copyFile(scrfile, new File(cyrPatn+"\\target\\surefire-reports\\img\\"+filename+".png"));
            //FileUtils.copyFile(scrfile, new File(cyrPatn+"\\test-output\\surefire-reports\\img\\"+filename+".png"));
            FileUtils.copyFile(scrfile, new File(cyrPatn+"\\test-output\\surefire-reports\\img\\"+filename+".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("GetScreenshot Fail");
        }finally{
            System.out.println("GetScreenshot Successful"+cyrPatn+"\\img\\"+filename+".png");
            //System.out.println("GetScreenshot Successful"+cyrPatn+"\\target\\img\\"+filename+".png");
        }

    }
}
