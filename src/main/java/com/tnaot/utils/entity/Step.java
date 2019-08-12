package com.tnaot.utils.entity;

import lombok.Data;

@Data
public class Step {

    String stepNum; // 步骤编号
    String description; // 描述
    String elementPath; // 控件路径  对应page包下的 [类名].[属性名]
    String action; // 对控件的操作

    Integer dataNum; // 数据位置
    String data; // 对应的数据

}
