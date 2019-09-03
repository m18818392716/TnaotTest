package com.tnaot.utils;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlLiteUtil {

    public static final String DB_PATH = "test-output\\extents.db";
    protected static Connection connect = null;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH + "?date_string_format=yyyy-MM-dd HH:mm:ss");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Opened database successfully");
    }

//    @Test
//    public void printAllTest() {
//        createTable();
//        startCase("第二个case");
//        endCaseByName("news_003(资讯转发并评论（转发toast消息提示框显示时间过短导致无法捕捉元素 测试失败）)","哈哈哈","PASS");
//        getAllLastCaseByStatus("PASS");
//        closeConnection();
//    }

    public static void createTable() {
        try {
            connect.setAutoCommit(false);

//            String sql = "create table user(id int,name text,sex text)";
            String sql = "CREATE TABLE IF NOT EXISTS test_case" +
                    "(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "test_name NVARCHAR(100) NOT NULL," +
                        "description NVARCHAR(256)," +
                        "status NVARCHAR(100)," +
                        "start_time DATETIME," +
                        "end_time DATETIME," +
                        "throwable_message text," +
                        "create_time DATETIME," +
                        "last_update_time DATETIME" +
                    ")";

            PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.executeUpdate();
            System.out.println("create data success");

            // 提交
            connect.commit();

            // 关闭Statement
            pstm.close();
//            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 保存case
    public static void startCase(String caseName) {
        try {
            connect.setAutoCommit(false);
            String sql = "insert into test_case(test_name,status,start_time,create_time) " +
                    "values (?,'RUNNING',datetime('now', 'localtime'),datetime('now', 'localtime'))";
            PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.setString(1, caseName);
            // 执行
            int count = pstm.executeUpdate();
            if (count > 0) {
                System.out.println("insert data success");
            } else {
                System.out.println("insert data fail");
            }

            // 提交
            connect.commit();
            // 关闭Statement
            pstm.close();
//            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> getAllLastCaseByStatus(String status) {
        try {
            connect.setAutoCommit(false);

            String sql = "select * from (select * from test_case group by test_name having max(start_time) order by test_name) where status = ?";
            PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.setString(1, status);
            ResultSet result = pstm.executeQuery();

            List<Map<String, Object>> caseList = new ArrayList<>();
            while (result.next()) {
                Map<String, Object> testCase = new HashMap<>();
                testCase.put("id", result.getInt("id"));
                testCase.put("testName", result.getString("test_name"));
                testCase.put("description", result.getString("description"));
                testCase.put("status", result.getString("status"));
                testCase.put("startTime", result.getDate("start_time").getTime());
                testCase.put("endTime", result.getDate("end_time").getTime());
                testCase.put("throwableMessage", result.getString("throwable_message"));
                testCase.put("createTime", result.getDate("create_time").getTime());
                testCase.put("lastUpdateTime", result.getDate("last_update_time").getTime());
                caseList.add(testCase);
//                System.out.println(result.getInt("id"));
//                System.out.println(result.getString("test_name"));
            }

            result.close();
            pstm.close();
//            connect.close();
            return caseList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static List<Map<String, Object>> getAllLastCase() {
        try {
            connect.setAutoCommit(false);

            String sql = "select * from test_case group by test_name having max(start_time) order by test_name";
            PreparedStatement pstm = connect.prepareStatement(sql);
            ResultSet result = pstm.executeQuery();

            List<Map<String, Object>> caseList = new ArrayList<>();
            while (result.next()) {
                Map<String, Object> testCase = new HashMap<>();
                testCase.put("id", result.getInt("id"));
                testCase.put("testName", result.getString("test_name"));
                testCase.put("description", result.getString("description"));
                testCase.put("status", result.getString("status"));
                testCase.put("startTime", result.getDate("start_time").getTime());
                testCase.put("endTime", result.getDate("end_time").getTime());
                testCase.put("throwableMessage", result.getString("throwable_message"));
                testCase.put("createTime", result.getDate("create_time").getTime());
                testCase.put("lastUpdateTime", result.getDate("last_update_time").getTime());
                caseList.add(testCase);
//                System.out.println(result.getInt("id"));
//                System.out.println(result.getString("test_name"));
            }

            result.close();
            pstm.close();
//            connect.close();
            return caseList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void endCaseByName(String caseName, String throwableMessage, String status) {
        try {
            connect.setAutoCommit(false);

            String sql = "update test_case set status = ?";
            if(throwableMessage != null){
                sql += ",throwable_message = ?";
            }
            sql += ",end_time = datetime('now', 'localtime'),last_update_time = datetime('now', 'localtime')" +
                    " where start_time = (select max(start_time) from test_case where test_name = ?)";
//            System.out.println("excute sql: " + sql);
            PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.setString(1, status);
            if(throwableMessage != null){
                pstm.setString(2, throwableMessage);
                pstm.setString(3, caseName);
            } else {
                pstm.setString(2, caseName);
            }
            int count = pstm.executeUpdate();

            if (count > 0) {
                System.out.println("update data success");
            } else {
                System.out.println("update data fail");
            }
            connect.commit();
            pstm.close();
//            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteById(int id) {
        try {
            connect.setAutoCommit(false);

            String sql = "delete from test_case where id = ?";
            PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.setInt(1, id);
            int count = pstm.executeUpdate();

            if (count > 0) {
                System.out.println("delete data success");
            } else {
                System.out.println("delete data fail");
            }

            connect.commit();
            pstm.close();
//            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
