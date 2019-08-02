import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class RunSuite {

    public static void main(String[] args) {

        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();

        List<String> testFieldList = new ArrayList<>();
//        方法一：
        //testFieldList.add("testng_main.xml");

//        方法二：
        testFieldList.add("testng.xml");
//        testFieldList.add("testng1.xml");
//        testFieldList.add("testng2.xml");

        testng.setTestSuites(testFieldList);

        testng.addListener(tla);
//        设置多线程
        testng.setSuiteThreadPoolSize(1);

        testng.run();
        System.out.println("ConfigurationFailures: "+tla.getConfigurationFailures());
        System.out.println("FailedTests: " + tla.getFailedTests());
    }
}
