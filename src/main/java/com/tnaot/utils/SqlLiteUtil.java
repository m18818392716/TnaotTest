package com.tnaot.utils;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlLiteUtil {

    public static final String DB_PATH = "test-output\\extents.db";
    protected static Connection connect = null;
    protected static Statement stmt = null;

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

    @Test
    public void printAllTest() {
//        System.out.println("SQLLITE START!!!!!!");
//        try {
//            Class.forName("org.sqlite.JDBC");
//            String db = "test-output\\extents.db";
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db);
//            Statement state = conn.createStatement();
//            ResultSet rs = state.executeQuery("select * from Test;"); //查询数据
////            ResultSet rs = state.executeQuery("select distinct TestName from Test where Status = 'fail';"); //查询数据
//            while (rs.next()) { //将查询到的数据打印出来
//                System.out.print("name = " + rs.getString("TestName") + " "); //列属性一
//                System.out.println("age = " + rs.getString("ReportIDExtent")); //列属性二
//            }
//            rs.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        createTable();
//        startCase("第二个case");
//        endCaseByName("第二个case","PASS");
        getAllLastCaseByStatus("PASS");
        closeConnection();
    }

    public static void createTable() {
        try {
            connect.setAutoCommit(false);

            stmt = connect.createStatement();

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

            stmt.executeUpdate(sql);
            System.out.println("create data success");

            // 提交
            connect.commit();

            // 关闭Statement
            stmt.close();
//            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 保存case
    public static void startCase(String caseName) {
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            String sql = "insert into test_case(test_name,status,start_time,create_time) " +
                    "values ('"+ caseName +"','RUNNING',datetime('now', 'localtime'),datetime('now', 'localtime'))";
            // 执行
            int count = stmt.executeUpdate(sql);
            if (count > 0) {
                System.out.println("insert data success");
            } else {
                System.out.println("insert data fail");
            }

            // 提交
            connect.commit();
            // 关闭Statement
            stmt.close();
//            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> getAllLastCaseByStatus(String status) {
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();

            String sql = "select * from (select * from test_case group by test_name having max(start_time) order by test_name) where status = '" + status + "'";

            ResultSet result = stmt.executeQuery(sql);
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
            stmt.close();
            return caseList;
//            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static List<Map<String, Object>> getAllLastCase() {
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();

            String sql = "select * from test_case group by test_name having max(start_time) order by test_name";

            ResultSet result = stmt.executeQuery(sql);
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
            stmt.close();
            return caseList;
//            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void endCaseByName(String caseName, String throwableMessage, String status) {
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();

            String sql = "update test_case set status = '" + status + "'";
            if(throwableMessage != null){
                sql += ",throwable_message = '" + throwableMessage + "'";
            }
            sql += ",end_time = datetime('now', 'localtime'),last_update_time = datetime('now', 'localtime')" +
                    " where start_time = (select max(start_time) from test_case where test_name = '" + caseName + "')";
            int count = stmt.executeUpdate(sql);

            if (count > 0) {
                System.out.println("update data success");
            } else {
                System.out.println("update data fail");
            }
            connect.commit();
            stmt.close();
//            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void delById(int id) {
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();

            String sql = "delete from test_case where id = " + id;
            int count = stmt.executeUpdate(sql);

            if (count > 0) {
                System.out.println("delete data success");
            } else {
                System.out.println("delete data fail");
            }

            connect.commit();
            stmt.close();
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
