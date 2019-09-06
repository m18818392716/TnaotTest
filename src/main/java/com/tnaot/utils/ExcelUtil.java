package com.tnaot.utils;

import com.tnaot.demo.RunTestCase;
import com.tnaot.utils.entity.*;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.testng.Assert;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelUtil {

    public static String excelPath;
    // 可配置多个sheet，以“,”分隔
    //public final static String TEST_CASE_SHEET_INDEX = "5";
    //public final static String CASE_STEP_SHEET_INDEX = "1";
    public final static String TEST_CASE_SHEET_INDEX = "0,2,4,6,8,10";
    public final static String CASE_STEP_SHEET_INDEX = "1,3,5,7,9,11";
    public final static String ASSET_STEP_SHEET_INDEX = "12";
    public final static String CONSTANT_STEP_SHEET_INDEX = "13";
    // 全局sheet
    public final static int GLOBAL_STEP_SHEET_INDEX = 14;
    public final static int USER_SHEET_INDEX = 15;

    public final static String DATA_NUM_NAME = "dataNum";
    public final static String DATA_PREFIX = "data_";
    public final static String RESULT_NAME = "result";

    public final static String RESULT_PASS = "PASS";
    public final static String RESULT_FAIL = "FAIL";
    public final static String RESULT_SKIP = "SKIP";

    private static Workbook workbook;
    private static ThreadLocal<Map<String, TestCase>> testCases = new ThreadLocal<>(); // caseId为key，保存对应TestCase
    private static ThreadLocal<Map<String, User>> users = new ThreadLocal<>(); // userId为key，保存对应User
    private static ThreadLocal<Map<String, List<CaseStep>>> caseSteps = new ThreadLocal<>(); // caseId为key，保存对应的CaseStep集合
    private static ThreadLocal<Map<String, List<AssertStep>>> assertSteps = new ThreadLocal<>(); // caseId为key，保存对应的AssertStep集合
    private static ThreadLocal<Map<String, List<GlobalStep>>> globalSteps = new ThreadLocal<>(); // elementPath为key，保存对应的GlobalStep集合
    private static ThreadLocal<Map<String, List<ConstantStep>>> constantSteps = new ThreadLocal<>(); // constantId为key，保存对应的ConstantStep集合
    private static ThreadLocal<Map<String, Result>> results = new ThreadLocal<>(); // caseId为key，保存对应Result
    private final static LogUtils logger = new LogUtils(ExcelUtil.class);

    @Test
    public void test(){
        readAllExcel();
    }

    public static void readAllExcel() {
        readCaseExcel();
        readCaseStepExcel();
        readAssertStepExcel();
        readGlobalStepExcel();
        readUserExcel();
        readConstantStepExcel();
    }

    public static void readCaseExcel() {
        logger.info("Read Case Excel Start!");
        try {
            Workbook wb = ExcelUtil.getWorkbook();
            String[] sheet_array = TEST_CASE_SHEET_INDEX.split(",");
            for (String sheetIndex : sheet_array) {
                Sheet sheet = wb.getSheetAt(Integer.parseInt(sheetIndex));
                Row row0 = sheet.getRow(0);

                // get table header
                List<String> fieldNames = new ArrayList<>();
                Integer resutlIndex = null;
                for (int i = 0; i < row0.getLastCellNum(); i++) {
                    String fieldName = row0.getCell(i).getStringCellValue();
                    fieldNames.add(fieldName);
                    if (RESULT_NAME.equalsIgnoreCase(fieldName)) {
                        resutlIndex = i;
                    }
                }

                for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                    Row row = sheet.getRow(i);
                    if (row != null && row.getCell(0) != null && row.getCell(0).getCellType() != Cell.CELL_TYPE_BLANK) {
                        // 获取当前result单元格的地址
                        Result result = new Result();
                        result.setSheetIndex(Integer.parseInt(sheetIndex));
                        result.setRowIndex(i);
                        result.setCellIndex(resutlIndex);

                        TestCase testCase = new TestCase();
//                        System.out.println("Preset Excel Row:"+row.getRowNum()+" CellTotalNum:"+row.getPhysicalNumberOfCells());
                        for (Cell cell : row) {
                            setCellToObject(cell, fieldNames, testCase);
                        }

                        // 将ID作为Key对应结果地址保存
                        result.setCaseId(testCase.getId());
                        ExcelUtil.getResults().put(testCase.getId(), result);
                        // 将ID作为Key，整行数据作为value保存
                        ExcelUtil.getTestCases().put(testCase.getId(), testCase);
                    }
                }
            }

            System.out.println("Case excel数据：");
            for (String key : ExcelUtil.getTestCases().keySet()) {
                System.out.println(key + " : " + ExcelUtil.getTestCases().get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Read Case Excel Fail!");
        }
        logger.info("Read Case Excel End!");
    }

    public static void readCaseStepExcel() {

        logger.info("Read Step Excel Start!");
        try {
            Workbook wb = ExcelUtil.getWorkbook();
            String[] sheet_array = CASE_STEP_SHEET_INDEX.split(",");
            for (String sheetIndex : sheet_array) {
                Sheet sheet = wb.getSheetAt(Integer.parseInt(sheetIndex));
                Row row0 = sheet.getRow(0);

                // 将表头保存至集合
                List<String> fieldNames = new ArrayList<>();
                // 将 数据位置 (“data_”后面的数字） 与 列的索引 对应的关系保存到Map
                Map<Integer, Integer> dataNumForCellIndex = new HashMap<>();
                // 为集合赋值
                setHeaderForHasData(row0, fieldNames, dataNumForCellIndex);

                for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                    Row row = sheet.getRow(i);
                    if (row != null && row.getCell(0) != null && row.getCell(0).getCellType() != Cell.CELL_TYPE_BLANK) {
                        CaseStep caseStep = new CaseStep();
//                        System.out.println("Preset Excel Sheet:" + sheetIndex +" Row:"+row.getRowNum()+" CellTotalNum:"+row.getPhysicalNumberOfCells());

                        for (Cell cell : row) {
                            // 如果dataNum列不为空，则把将对应要使用的数据取出来，存放在data变量里面
                            if (DATA_NUM_NAME.equalsIgnoreCase(fieldNames.get(cell.getColumnIndex()))) {
                                if (StringUtils.isNotBlank(getCellValue(cell))) {
                                    Integer dataNum = Integer.parseInt(getCellValue(cell));
                                    Cell targetDataCell = row.getCell(dataNumForCellIndex.get(dataNum));
                                    String data = getCellValue(targetDataCell);
                                    caseStep.setData(data);
                                }
                            }
                            // "data_" 开头的数据不进行赋值
                            if (!fieldNames.get(cell.getColumnIndex()).startsWith(DATA_PREFIX)) {
                                setCellToObject(cell, fieldNames, caseStep);
                            }
                        }

                        // caseID为key，保存step集合
                        List<CaseStep> caseStepList = ExcelUtil.getCaseSteps().get(caseStep.getCaseId());
                        if (caseStepList == null) {
                            caseStepList = new ArrayList<>();
                            ExcelUtil.getCaseSteps().put(caseStep.getCaseId(), caseStepList);
                        }
                        caseStepList.add(caseStep);
                    }
                }
            }
//            System.out.println("Step excel数据：");
//            for (String key : ExcelUtil.getCaseSteps().keySet()) {
//                System.out.println(key + " : " + ExcelUtil.getCaseSteps().get(key));
//            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Read Step Excel Fail!");
        }
        logger.info("Read Step Excel End!");
    }

    public static void readAssertStepExcel() {
        logger.info("Read Case Assert Step Excel Start!");
        try {
            Workbook wb = ExcelUtil.getWorkbook();
            String[] sheet_array = ASSET_STEP_SHEET_INDEX.split(",");
            for (String sheetIndex : sheet_array) {
                Sheet sheet = wb.getSheetAt(Integer.parseInt(sheetIndex));
                Row row0 = sheet.getRow(0);

                // 将表头保存至集合
                List<String> fieldNames = new ArrayList<>();
                // 将 数据位置 (“data_”后面的数字） 与 列的索引 对应的关系保存到Map
                Map<Integer, Integer> dataNumForCellIndex = new HashMap<>();
                // 为集合赋值
                setHeaderForHasData(row0, fieldNames, dataNumForCellIndex);

                for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                    Row row = sheet.getRow(i);
                    if (row != null && row.getCell(0) != null && row.getCell(0).getCellType() != Cell.CELL_TYPE_BLANK) {
                        AssertStep assertStep = new AssertStep();
//                        System.out.println("Preset Excel Row:"+row.getRowNum()+" CellTotalNum:"+row.getPhysicalNumberOfCells());

                        for (Cell cell : row) {
                            // 如果dataNum列不为空，则把将对应要使用的数据取出来，存放在data变量里面
                            if (DATA_NUM_NAME.equalsIgnoreCase(fieldNames.get(cell.getColumnIndex()))) {
                                if (StringUtils.isNotBlank(getCellValue(cell))) {
                                    Integer dataNum = Integer.parseInt(getCellValue(cell));
                                    Cell targetDataCell = row.getCell(dataNumForCellIndex.get(dataNum));
                                    String data = getCellValue(targetDataCell);
                                    assertStep.setData(data);
                                }
                            }
                            // "data_" 开头的数据不进行赋值
                            if (!fieldNames.get(cell.getColumnIndex()).startsWith(DATA_PREFIX)) {
                                setCellToObject(cell, fieldNames, assertStep);
                            }
                        }

                        // caseID为key，保存step集合
                        List<AssertStep> assertStepList = ExcelUtil.getAssertSteps().get(assertStep.getCaseId());
                        if (assertStepList == null) {
                            assertStepList = new ArrayList<>();
                            ExcelUtil.getAssertSteps().put(assertStep.getCaseId(), assertStepList);
                        }
                        assertStepList.add(assertStep);
                    }
                }
            }
//            System.out.println("Case Assert Step excel数据：");
//            for (String key : ExcelUtil.getAssertSteps().keySet()) {
//                System.out.println(key + " : " + ExcelUtil.getAssertSteps().get(key));
//            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Read Case Assert Step Excel Fail!");
        }
        logger.info("Read Case Assert Step Excel End!");
    }

    public static void readGlobalStepExcel() {
        logger.info("Read Global Step Excel Start!");
        try {
            Workbook wb = ExcelUtil.getWorkbook();
            Sheet sheet = wb.getSheetAt(GLOBAL_STEP_SHEET_INDEX);
            Row row0 = sheet.getRow(0);

            // 将表头保存至集合
            List<String> fieldNames = new ArrayList<>();
            // 将 数据位置 (“data_”后面的数字） 与 列的索引 对应的关系保存到Map
            Map<Integer, Integer> dataNumForCellIndex = new HashMap<>();
            // 为集合赋值
            setHeaderForHasData(row0, fieldNames, dataNumForCellIndex);

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                if (row != null && row.getCell(0) != null && row.getCell(0).getCellType() != Cell.CELL_TYPE_BLANK) {
                    GlobalStep globalStep = new GlobalStep();
//                    System.out.println("Preset Excel Row:"+row.getRowNum()+" CellTotalNum:"+row.getPhysicalNumberOfCells());
                    for (Cell cell : row) {
                        // 如果dataNum列不为空，则把将对应要使用的数据取出来，存放在data变量里面
                        if (DATA_NUM_NAME.equalsIgnoreCase(fieldNames.get(cell.getColumnIndex()))) {
                            if (StringUtils.isNotBlank(getCellValue(cell))) {
                                Integer dataNum = Integer.parseInt(getCellValue(cell));
                                Cell targetDataCell = row.getCell(dataNumForCellIndex.get(dataNum));
                                String data = getCellValue(targetDataCell);
                                globalStep.setData(data);
                            }
                        }
                        // "data_" 开头的数据不进行赋值
                        if (!fieldNames.get(cell.getColumnIndex()).startsWith(DATA_PREFIX)) {
                            setCellToObject(cell, fieldNames, globalStep);
                        }
                    }

                    // 触发的控件的path为key，step集合为value，保存map
                    List<GlobalStep> globalStepList = ExcelUtil.getGlobalSteps().get(globalStep.getTouchElementPath());
                    if (globalStepList == null) {
                        globalStepList = new ArrayList<>();
                        ExcelUtil.getGlobalSteps().put(globalStep.getTouchElementPath(), globalStepList);
                    }
                    globalStepList.add(globalStep);
                }
            }

//            System.out.println("Global Step excel数据：");
//            for (String key : ExcelUtil.getGlobalSteps().keySet()) {
//                System.out.println(key + " : " + ExcelUtil.getGlobalSteps().get(key));
//            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Read Global Step Excel Fail!");
        }
        logger.info("Read Global Step Excel End!");
    }

    public static void readConstantStepExcel() {

        logger.info("Read Constant Step Excel Start!");
        try {
            Workbook wb = ExcelUtil.getWorkbook();
            String[] sheet_array = CONSTANT_STEP_SHEET_INDEX.split(",");
            for (String sheetIndex : sheet_array) {
                Sheet sheet = wb.getSheetAt(Integer.parseInt(sheetIndex));
                Row row0 = sheet.getRow(0);

                // 将表头保存至集合
                List<String> fieldNames = new ArrayList<>();
                // 将 数据位置 (“data_”后面的数字） 与 列的索引 对应的关系保存到Map
                Map<Integer, Integer> dataNumForCellIndex = new HashMap<>();
                // 为集合赋值
                setHeaderForHasData(row0, fieldNames, dataNumForCellIndex);

                for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                    Row row = sheet.getRow(i);
                    if (row != null && row.getCell(0) != null && row.getCell(0).getCellType() != Cell.CELL_TYPE_BLANK) {
                        ConstantStep constantStep = new ConstantStep();
//                        System.out.println("Preset Excel Row:"+row.getRowNum()+" CellTotalNum:"+row.getPhysicalNumberOfCells());

                        for (Cell cell : row) {
                            // 如果dataNum列不为空，则把将对应要使用的数据取出来，存放在data变量里面
                            if (DATA_NUM_NAME.equalsIgnoreCase(fieldNames.get(cell.getColumnIndex()))) {
                                if (StringUtils.isNotBlank(getCellValue(cell))) {
                                    Integer dataNum = Integer.parseInt(getCellValue(cell));
                                    Cell targetDataCell = row.getCell(dataNumForCellIndex.get(dataNum));
                                    String data = getCellValue(targetDataCell);
                                    constantStep.setData(data);
                                }
                            }
                            // "data_" 开头的数据不进行赋值
                            if (!fieldNames.get(cell.getColumnIndex()).startsWith(DATA_PREFIX)) {
                                setCellToObject(cell, fieldNames, constantStep);
                            }
                        }

                        // caseID为key，保存step集合
                        List<ConstantStep> constantStepList = ExcelUtil.getConstantSteps().get(constantStep.getConstantId());
                        if (constantStepList == null) {
                            constantStepList = new ArrayList<>();
                            ExcelUtil.getConstantSteps().put(constantStep.getConstantId(), constantStepList);
                        }
                        constantStepList.add(constantStep);
                    }
                }
            }
//            System.out.println("Constant Step excel数据：");
//            for (String key : ExcelUtil.getConstantSteps().keySet()) {
//                System.out.println(key + " : " + ExcelUtil.getConstantSteps().get(key));
//            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Read Constant Step Excel Fail!");
        }
        logger.info("Read Constant Step Excel End!");
    }

    public static void readUserExcel() {
        logger.info("Read User Excel Start!");
        try {
            Workbook wb = ExcelUtil.getWorkbook();
            Sheet sheet = wb.getSheetAt(USER_SHEET_INDEX);
            Row row0 = sheet.getRow(0);

            // get table header
            List<String> fieldNames = new ArrayList<>();
            for (int i = 0; i < row0.getLastCellNum(); i++) {
                String fieldName = row0.getCell(i).getStringCellValue();
                fieldNames.add(fieldName);
            }

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                if (row != null && row.getCell(0) != null && row.getCell(0).getCellType() != Cell.CELL_TYPE_BLANK) {
                    User user = new User();
//                        System.out.println("Preset Excel Row:"+row.getRowNum()+" CellTotalNum:"+row.getPhysicalNumberOfCells());
                    for (Cell cell : row) {
                        setCellToObject(cell, fieldNames, user);
                    }
                    // 将ID作为Key，整行数据作为value保存
                    ExcelUtil.getUsers().put(user.getId(), user);
                }
            }

//            System.out.println("User excel数据：");
//            for (String key : ExcelUtil.getUsers().keySet()) {
//                System.out.println(key + " : " + ExcelUtil.getUsers().get(key));
//            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Read User Excel Fail!");
        }
        logger.info("Read User Excel End!");
    }


    // 为含有“dataNum”的数据表头集合赋值，
    private static void setHeaderForHasData(Row row, List<String> fieldNames, Map<Integer, Integer> dataNumForCellIndex) {
        for (int i = 0; i < row.getLastCellNum(); i++) {
            String fieldName = row.getCell(i).getStringCellValue();
            fieldNames.add(fieldName);
            if (fieldName.startsWith(DATA_PREFIX)) {
                int dataNum = Integer.parseInt(fieldName.split("_")[1]);
                dataNumForCellIndex.put(dataNum, i);
            }
        }
    }

    // 将单元格内容赋值到对象里面
    public static void setCellToObject(Cell cell, List<String> fieldNames, Object object) throws Exception {
        if (cell != null) {
            Field cellField = object.getClass().getDeclaredField(fieldNames.get(cell.getColumnIndex()));
            // 子类无该属性，则试着去父类查找
            if (cellField == null) {
                Field[] fields = object.getClass().getSuperclass().getDeclaredFields();
                for (Field field : fields) {
                    System.out.println("field: " + field.getName());
                }

                cellField = object.getClass().getSuperclass().getDeclaredField(fieldNames.get(cell.getColumnIndex()));
            }
            Method setMethod = getFieldSetMethod(object, cellField);
            // 获取单元格内容，String形式
            String cellValue = getCellValue(cell);
            // 将单元格内容的类型转为目标属性的类型
            Object result = ConvertUtils.convert(cellValue, cellField.getType());
            setMethod.invoke(object, result);
//            cellField.set(object, result);
        }
    }

    public static Method getFieldSetMethod(Object object, Field cellField) throws Exception {
        String setMethodName = "set" + cellField.getName().substring(0, 1).toUpperCase() + cellField.getName().substring(1);
        Method setMethod = object.getClass().getMethod(setMethodName, cellField.getType());
        return setMethod;
    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        // 判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: // 数字
                //short s = cell.getCellStyle().getDataFormat();
                if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                    SimpleDateFormat sdf = null;
                    // 验证short值
                    if (cell.getCellStyle().getDataFormat() == 14) {
                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                    } else if (cell.getCellStyle().getDataFormat() == 21) {
                        sdf = new SimpleDateFormat("HH:mm:ss");
                    } else if (cell.getCellStyle().getDataFormat() == 22) {
                        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    } else {
                        throw new RuntimeException("日期格式错误!!!");
                    }
                    Date date = cell.getDateCellValue();
                    cellValue = sdf.format(date);
                } else if (cell.getCellStyle().getDataFormat() == 0) {//处理数值格式
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cellValue = String.valueOf(cell.getRichStringCellValue().getString());
                }
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                cellValue = null;
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    public static void writeResult() {
        logger.info("Write Excel Result Start!");
        try {
            InputStream in = ExcelUtil.class.getClassLoader().getResourceAsStream(excelPath);
            Workbook workbook;
            if (excelPath.endsWith("xls")) {
                workbook = new HSSFWorkbook(in);
            } else {
                workbook = new XSSFWorkbook(in);
            }
            in.close();

            // 遍历获取目标结果单元格，进行写入值
            for (String key : getResults().keySet()) {
                Result result = getResults().get(key);
                Row resultRow = workbook.getSheetAt(result.getSheetIndex()).getRow(result.getRowIndex());
                Cell resultCell = resultRow.getCell(result.getCellIndex());
                // 单元格为空时，需要创建再赋值
                if (resultCell == null) {
                    resultCell = resultRow.createCell(result.getCellIndex());
                }
                CellStyle cellStyle = workbook.createCellStyle();
                Font font = workbook.createFont();
                cellStyle.setFont(font);
                resultCell.setCellStyle(cellStyle);
                if (!result.getIsRun()) {
                    font.setColor((short) 19); // SKIP为浅黄色
                    resultCell.setCellValue(RESULT_SKIP);
                } else {
                    if (RESULT_PASS.equals(result.getResult())) {
                        font.setColor((short) 17); // PASS为绿色
                    } else {
                        font.setColor(Font.COLOR_RED); // FAIL为红色
                    }
                    resultCell.setCellValue(result.getResult());
                }
            }

            FileOutputStream excelFileOutPutStream = new FileOutputStream("src/main/resources/" + excelPath);//写数据到这个路径上
            workbook.write(excelFileOutPutStream);
            excelFileOutPutStream.flush();
            excelFileOutPutStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Write Excel Result Fail!");
        }
        logger.info("Write Excel Result End!");
    }

    public static Map<String, TestCase> getTestCases() {
        if (testCases.get() == null) {
            testCases.set(new HashMap<>());
        }
        return testCases.get();
    }

    public static Map<String, User> getUsers() {
        if (users.get() == null) {
            users.set(new HashMap<>());
        }
        return users.get();
    }

    public static Map<String, List<CaseStep>> getCaseSteps() {
        if (caseSteps.get() == null) {
            caseSteps.set(new HashMap<>());
        }
        return caseSteps.get();
    }

    public static Map<String, List<AssertStep>> getAssertSteps() {
        if (assertSteps.get() == null) {
            assertSteps.set(new HashMap<>());
        }
        return assertSteps.get();
    }

    public static Map<String, Result> getResults() {
        if (results.get() == null) {
            results.set(new HashMap<>());
        }
        return results.get();
    }

    public static Map<String, List<GlobalStep>> getGlobalSteps() {
        if (globalSteps.get() == null) {
            globalSteps.set(new HashMap<>());
        }
        return globalSteps.get();
    }

    public static Map<String, List<ConstantStep>> getConstantSteps() {
        if (constantSteps.get() == null) {
            constantSteps.set(new HashMap<>());
        }
        return constantSteps.get();
    }

    public static Workbook getWorkbook() {
        if(excelPath == null){
            excelPath = "TestTnaot_1.xls"; // 默认值
        }
        try {
            if (workbook == null) {
                InputStream in = ExcelUtil.class.getClassLoader().getResourceAsStream(excelPath);//这种获取的方式就是获取当前项目resource下的文件，所以直接写那个xls，就可以读到它
                workbook = WorkbookFactory.create(in);
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }
}
