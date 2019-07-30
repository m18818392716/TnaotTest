package com.tnaot.utils.entity;

import lombok.Data;

@Data
public class CaseStep {

    private String caseId;
    private String stepNum;
    private String elementPath; // 控件路径  对应page包下的 [类名].[属性名]
    private String action; // 对控件的操作

    private String dataNum; // 数据位置
    private String data; // 对应的数据

    private Integer sheetIndex; // sheet索引
}
