package com.tnaot.utils.entity;

import lombok.Data;

@Data
public class GlobalStep{

    private String touchElementPath; // 触发条件的元素
    private String type; // 类型：只出现一次，或者每次都可能会出现

    private int executeNum; // 已经执行过的次数,每次resetApp归零

    String stepNum; // 步骤编号
    String description; // 描述
    String elementPath; // 控件路径  对应page包下的 [类名].[属性名]
    String action; // 对控件的操作

    Integer dataNum; // 数据位置
    String data; // 对应的数据

}
