package com.tnaot.utils.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {

    //如果注解为空，则动态设置注解，以确保用例失败后重跑。
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer retryAnalyzer = iTestAnnotation.getRetryAnalyzer();//获取到retryAnalyzer的注解
        if (retryAnalyzer == null) {
            iTestAnnotation.setRetryAnalyzer(TestNGRetry.class);
        }
    }
}
