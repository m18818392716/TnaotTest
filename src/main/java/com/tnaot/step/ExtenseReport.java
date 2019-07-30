package com.tnaot.step;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtenseReport {

    static ExtentReports extent;
    static String reportLocation = "../test-output/ExtentReport.html";
    static String imageLocation = "../src/main/java/resources/imag/test.png";


    private ExtentReports createReport() {
        return extent;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        extent = new ExtentReports(reportLocation, NetworkMode.OFFLINE);

        ExtentTest test = extent.startTest("My First Test1", "Sample description");

        String img = test.addScreenCapture(imageLocation);
        test.log(LogStatus.INFO, "Image", "Image example: " + img);

        extent.endTest(test);

        ExtentTest test2 = extent.startTest("My First Test2", "Sample descrsiption");
        String aimg = test2.addScreenCapture(imageLocation);
        System.out.println(img);
        test2.log(LogStatus.INFO, "Image", "Image example: " + aimg);

        extent.endTest(test2);

        extent.flush();
    }
}
