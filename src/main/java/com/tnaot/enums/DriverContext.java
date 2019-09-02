package com.tnaot.enums;

/**
 * @author Susanna
 * @date 2019/9/1 14:44
 */
public enum DriverContext {

    NATIVE_APP("NATIVE_APP"), WEBVIEW("WEBVIEW");

    private String driverContext;

    DriverContext(String driverContext){
        this.driverContext = driverContext;
    }

    public String getDriverContext(){ return driverContext; }
}
