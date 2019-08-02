package com.tnaot.demo;

import com.tnaot.utils.entity.TestParameters;
import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SampleTest implements ITest {
    // Has to be set to prevent NullPointerException from reporters
    protected String mTestCaseName = "";

    @DataProvider(name="BasicDataProvider")
    public Object[][] getTestData() {
        Object[][] data = new Object[][] {
                { new TestParameters("TestCase1", "Sample test 1")},
                { new TestParameters("TestCase2", "Sample test 2")},
                { new TestParameters("TestCase3", "Sample test 3")},
                { new TestParameters("TestCase4", "Sample test 4")},
                { new TestParameters("TestCase5", "Sample test 5") }
        };
        return data;
    }

    @BeforeMethod(alwaysRun = true)
    public void testData(Method method, Object[] testData) {
        String testCase = "";
        String des = "";
        if (testData != null && testData.length > 0) {
            TestParameters testParams = null;
            //Check if test method has actually received required parameters
            for (Object testParameter : testData) {
                if (testParameter instanceof TestParameters) {
                    testParams = (TestParameters)testParameter;
                    break;
                }
            }
            if (testParams != null) {
                testCase = testParams.getTestName();
                des = testParams.getTestDescription();
            }
        }
        //this.mTestCaseName = String.format("%s(%s)", method.getName(), testCase);
        this.mTestCaseName = String.format("%s(%s)", testCase, des);
    }

    @Override
    public String getTestName() {
        return this.mTestCaseName;
    }

    @Test(dataProvider="BasicDataProvider")
    public void testSample1(TestParameters testParams){
        //test code here
        System.out.println("This is testSample1!");
    }

    @Test(dataProvider="BasicDataProvider")
    public void testSample2(TestParameters testParams){
        //test code here
        System.out.println("This is testSample2!");
    }

    @Test
    public void testSample3(){
        //test code here
        System.out.println("This is testSample3!");
    }


}
