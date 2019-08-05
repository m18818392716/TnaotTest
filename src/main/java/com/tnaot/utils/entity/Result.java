package com.tnaot.utils.entity;

import lombok.Data;

@Data
public class Result {
    private String caseId;
    private Boolean isRun; // 是否运行

    private Integer sheetIndex; // 目标sheet索引
    private Integer rowIndex; // 目标行索引
    private Integer cellIndex; // 目标列索引

    private String result; // 结果 PASS | FAIL | 空 (当isRun为false的时候，会赋值为空字符串)
}
