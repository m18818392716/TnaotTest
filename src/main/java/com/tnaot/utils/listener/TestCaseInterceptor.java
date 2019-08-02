package com.tnaot.utils.listener;

import com.tnaot.demo.RunTestCase;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestCaseInterceptor implements IMethodInterceptor {

    // 控制case执行顺序
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {

        Map<String, IMethodInstance> orders = new TreeMap <> () ; // 有序map
        for (IMethodInstance instance : list) {
            RunTestCase runTestCase = (RunTestCase) instance.getInstance();
            orders.put(String.valueOf(runTestCase.getTestCase().getId()), instance);
        }

        List<IMethodInstance> orderList = new ArrayList<>();
        for (String order : orders.keySet()) { // 重新排序
//            System.out.println("TestCase: "+((RunTestCase)orders.get(order).getInstance()).getTestCase().getId());
            IMethodInstance test = orders.get(order);
            orderList.add(test);
        }
        return orderList; // TestNG会按这个返回的List内实例的顺序来执行
    }
}
