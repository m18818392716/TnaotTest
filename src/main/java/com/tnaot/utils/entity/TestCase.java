package com.tnaot.utils.entity;

import lombok.Data;

@Data
public class TestCase {

    private String id;
    private String description; // 用例描述
    private String isRun; // 用例是否运行
    private String result; // 运行结果 PASS/FAIL/空
    private String dependId; // 依赖的caseID
}
