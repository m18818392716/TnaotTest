package com.tnaot.utils.entity;

import lombok.Data;

@Data
public class ConstantStep {

    private String constantId;
    private String stepNum;
    private String description; // 描述
    private String elementPath; // 控件路径  对应page包下的 [类名].[属性名]
    private String action; // 对控件的操作

    private Integer dataNum; // 数据位置
    private String data; // 对应的数据

}
