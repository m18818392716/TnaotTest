package com.tnaot.utils;

import com.tnaot.utils.entity.CaseStep;
import com.tnaot.utils.entity.Result;
import com.tnaot.utils.entity.TestCase;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelUtil {

    private final static String EXCEL_PATH = "UILibrary.xls";
    // 可配置多个sheet，以“,”分隔
    private final static String TEST_CASE_SHEET_INDEX = "5";
    private final static String CASE_STEP_SHEET_INDEX = "1";

    private final static String DATA_NUM_NAME = "dataNum";
    private final static String DATA_PREFIX = "data_";
    private final static String RESULT_NAME = "result";

    private static Workbook workbook;
    private static ThreadLocal<Map<String, TestCase>> testCases = new ThreadLocal<>();
    private static ThreadLocal<Map<String, List<CaseStep>>> caseSteps = new ThreadLocal<>();
    private static ThreadLocal<Map<String, Result>> results = new ThreadLocal<>();
    private final static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static void readCaseExcel(){
        logger.info("Read Case Excel Start!");
        try {
            Workbook wb = ExcelUtil.getWorkbook();
            String[] sheet_array = TEST_CASE_SHEET_INDEX.split(",");
            for (String sheetIndex : sheet_array){
                Sheet sheet = wb.getSheetAt(Integer.parseInt(sheetIndex));
                Row row0 = sheet.getRow(0);

                // get table header
                List<String> fieldNames = new ArrayList<>();
                Integer resutlIndex = null;
                for (int i = 0; i < row0.getLastCellNum(); i++){
                    String fieldName = row0.getCell(i).getStringCellValue();
                    fieldNames.add(fieldName);
                    if(RESULT_NAME.equalsIgnoreCase(fieldName)){
                        resutlIndex = i;
                    }
                }

                for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                    Row row = sheet.getRow(i);

                    // 获取当前result单元格的地址
                    Result result = new Result();
                    result.setSheetIndex(Integer.parseInt(sheetIndex));
                    result.setRowIndex(i);
                    result.setCellIndex(resutlIndex);

                    TestCase testCase = new TestCase();
                    testCase.setSheetIndex(Integer.parseInt(sheetIndex));
//                System.out.println("Preset Excel Row:"+row.getRowNum()+" CellTotalNum:"+row.getPhysicalNumberOfCells());
                    for(Cell cell : row){
                        if(cell != null){
                            Field field = TestCase.class.getDeclaredField(fieldNames.get(cell.getColumnIndex()));
                            field.setAccessible(true);
                            if(cell.getCellType() == 0){
                                field.set(testCase, (int)cell.getNumericCellValue());
//                            System.out.println("number value:"+cell.getNumericCellValue()+" index:"+cell.getColumnIndex());
                            } else if (cell.getCellType() == 1){
                                field.set(testCase, cell.getStringCellValue());
//                            System.out.println("string value:"+cell.getStringCellValue()+" index:"+cell.getColumnIndex());
                            } else {
                                logger.error("type not preset:"+cell.getCellType()+"  row num:"+ (row.getRowNum() + 1) +"  cell num:"+(cell.getColumnIndex() + 1));
                            }

                        }
                    }

                    // 将ID作为Key对应结果地址保存
                    result.setCaseId(testCase.getId());
                    ExcelUtil.getResults().put(testCase.getId(), result);
                    // 将ID作为Key，整行数据作为value保存
                    ExcelUtil.getTestCases().put(testCase.getId(), testCase);
                }
            }

            System.out.println("Case excel数据：");
            for (String key : ExcelUtil.getTestCases().keySet()){
                System.out.println(key + " : "+ ExcelUtil.getTestCases().get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Read Case Excel Fail!");
        }
        logger.info("Read Case Excel End!");
    }

    @Test
    public static void readStepExcel(){

        logger.info("Read Step Excel Start!");
        try {
            Workbook wb = ExcelUtil.getWorkbook();
            String[] sheet_array = CASE_STEP_SHEET_INDEX.split(",");
            for (String sheetIndex : sheet_array){
                Sheet sheet = wb.getSheetAt(Integer.parseInt(sheetIndex));
                Row row0 = sheet.getRow(0);

                // 将表头保存至数组
                List<String> fieldNames = new ArrayList<>();
                // 将 数据位置 (“data_”后面的数字） 与 列的索引 对应的关系保存到Map
                Map<Integer, Integer> dataNumForCellIndex = new HashMap<>();
                for (int i = 0; i < row0.getLastCellNum(); i++){
                    String fieldName = row0.getCell(i).getStringCellValue();
                    fieldNames.add(fieldName);
                    if(fieldName.startsWith(DATA_PREFIX)){
                        int dataNum = Integer.parseInt(fieldName.split("_")[1]);
                        dataNumForCellIndex.put(dataNum, i);
                    }
                }

                for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                    Row row = sheet.getRow(i);
                    CaseStep caseStep = new CaseStep();
                    caseStep.setSheetIndex(Integer.parseInt(sheetIndex));
//                System.out.println("Preset Excel Row:"+row.getRowNum()+" CellTotalNum:"+row.getPhysicalNumberOfCells());

                    for(Cell cell : row){
                        // 如果dataNum列不为空，则把将对应要使用的数据取出来，存放在data变量里面
                        if(DATA_NUM_NAME.equalsIgnoreCase(fieldNames.get(cell.getColumnIndex()))){
                            if(StringUtils.isNotBlank(getCellValue(cell))){
                                Integer dataNum = Integer.parseInt(getCellValue(cell));
                                Cell targetDataCell = row.getCell(dataNumForCellIndex.get(dataNum));
                                String data = getCellValue(targetDataCell);
                                caseStep.setData(data);
                            }
                        }
                        // "data_" 开头的数据不进行赋值
                        if(!fieldNames.get(cell.getColumnIndex()).startsWith(DATA_PREFIX)){
                            setCellToObject(cell, fieldNames, caseStep);
                        }
                    }

                    // caseID为key，保存step集合
                    if(ExcelUtil.getCaseSteps().get(caseStep.getCaseId()) == null){
                        List<CaseStep> stepList = new ArrayList<>();
                        ExcelUtil.getCaseSteps().put(caseStep.getCaseId(), stepList);
                    }
                    ExcelUtil.getCaseSteps().get(caseStep.getCaseId()).add(caseStep);
                }
            }
            System.out.println("Step excel数据：");
            for (String key : ExcelUtil.getCaseSteps().keySet()){
                System.out.println(key + " : "+ ExcelUtil.getCaseSteps().get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Read Step Excel Fail!");
        }
        logger.info("Read Step Excel End!");
    }

    public static void setCellToObject(Cell cell, List<String> fieldNames, Object object) throws Exception {
        if(cell != null){
            Field field = object.getClass().getDeclaredField(fieldNames.get(cell.getColumnIndex()));
            field.setAccessible(true);
            if(cell.getCellType() == 0){
                field.set(object, (int)cell.getNumericCellValue());
//                            System.out.println("number value:"+cell.getNumericCellValue()+" index:"+cell.getColumnIndex());
            } else if (cell.getCellType() == 1){
                field.set(object, cell.getStringCellValue());
//                            System.out.println("string value:"+cell.getStringCellValue()+" index:"+cell.getColumnIndex());
            } else {
//                logger.error("type not preset:"+cell.getCellType()+"  row num:"+ (row.getRowNum() + 1) +"  cell num:"+(cell.getColumnIndex() + 1));
                logger.error("type not preset:"+cell.getCellType() +"  cell num:"+(cell.getColumnIndex() + 1));
            }
        }
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

    public static Map<String, TestCase> getTestCases(){
        if(testCases.get() == null){
            testCases.set(new HashMap<>());
        }
        return testCases.get();
    }

    public static Map<String, List<CaseStep>> getCaseSteps(){
        if(caseSteps.get() == null){
            caseSteps.set(new HashMap<>());
        }
        return caseSteps.get();
    }

    public static Map<String, Result> getResults(){
        if(results.get() == null){
            results.set(new HashMap<>());
        }
        return results.get();
    }

    public static Workbook getWorkbook(){
        try {
            if(workbook == null){
                InputStream in = ExcelUtil.class.getClassLoader().getResourceAsStream(EXCEL_PATH);
                workbook = WorkbookFactory.create(in);
                in.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return workbook;
    }

    public static void writeResult(){
        try{
            InputStream in = ExcelUtil.class.getClassLoader().getResourceAsStream(EXCEL_PATH);
            Workbook workbook = null;
            if(EXCEL_PATH.endsWith("xls")){
                workbook = new HSSFWorkbook(in);
            } else {
                workbook = new XSSFWorkbook(in);
            }
            in.close();

            for (String key : getResults().keySet()){
                Result result = getResults().get(key);
                Cell resultCell = workbook.getSheetAt(result.getSheetIndex()).getRow(result.getRowIndex()).getCell(result.getCellIndex());
                if(result.getIsRun()){
                    if(result.isResult()){
                        resultCell.setCellValue("PASS");
                    } else {
                        resultCell.setCellValue("FAIL");
                    }
                } else {
                    resultCell.setCellValue("");
                }
            }

            FileOutputStream excelFileOutPutStream = new FileOutputStream("src/main/resources/" + EXCEL_PATH);//写数据到这个路径上
            workbook.write(excelFileOutPutStream);
            excelFileOutPutStream.flush();
            excelFileOutPutStream.close();
            System.out.println("done");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
