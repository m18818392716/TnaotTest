package com.tnaot.utils.entity;

import lombok.Data;

@Data
public class GlobalStep {

    private String touchElementPath; // 触发条件的元素
    private String targetElementPath; // 目标要操作的元素
    private String targetAction; // 目标执行的操作
    private String description; // 描述
    private String type; // 类型：只出现一次，或者每次都可能会出现
    private Integer dataNum; // 数据位置
    private String data; // 对应的数据

    private int executeNum; // 已经执行过的次数,每次resetApp归零

}
