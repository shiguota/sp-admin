package com.evo.sp.common.excel;

import com.evo.sp.common.ex.SpAssert;
import com.evo.sp.util.SpStringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-05-10 14:12
 */
@SuppressWarnings("all")
public class ss {

    private static Workbook workbook;


    public void aa() throws IOException, InvalidFormatException {
        String path = this.getClass().getResource("/").getPath();
        System.out.println(path);
        File file = new File(path + "11111.xls");
        createWorkBook(file);
        List<Sheet> sheets = getSheets(workbook);
        Sheet sheet = sheets.get(4);
        //sheet.removeRow(sheet.getRow(1));
        for (int i = 0; i < sheets.size(); i++) {
            System.out.println("SHEET:"+i);
            for (Row row : sheets.get(i)) {
                for (Cell cell : row) {
                    // Alternatively, get the value and format it yourself
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.println(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.println(cell.getDateCellValue());
                            } else {
                                System.out.println(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            System.out.println(cell.getCellFormula());
                            break;
                        case BLANK:
                            System.out.println();
                            break;
                        default:
                            System.out.println();
                    }
                }
            }
        }
    }


    /**
     * 使用file创建workbook对象
     */
    public static void createWorkBook(File file) throws IOException {
        workbook = WorkbookFactory.create(file);
    }

    /**
     * 使用流创建workbook（使用内存相对较多）
     */
    public static void createWorkBook(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        workbook = WorkbookFactory.create(inputStream);
    }

    /**
     * 工作表（Sheet）集合
     */
    public static List<Sheet> getSheets(Workbook workbook) {
        List<Sheet> sheets = new ArrayList<>();
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        while (sheetIterator.hasNext()) {
            sheets.add(sheetIterator.next());
        }
        return sheets;
    }

    /**
     * 返回指定的工作表（Sheet）
     */
    public static List<Sheet> getSheets(Workbook workbook, Integer... index) {
        SpAssert.isNull(index);
        List<Sheet> sheets = getSheets(workbook);
        if (index.length > 1) {
            return sheets.subList(index[0], index.length - 1);
        }
        Sheet sheet = sheets.get(index[0]);
        sheets.clear();
        sheets.add(sheet);
        return sheets;
    }

    /**
     * 返回指定工作表（Sheet）中的行
     */
    public static List<Row> getRows(Map<Integer, String> integerMap) {
        //参数校验
        SpAssert.isNull(integerMap);
        //获取sheet集合
        List<Sheet> sheets = getSheets(workbook);
        //遍历map
        Iterator entries = integerMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Integer key = (Integer) entry.getKey();
            Sheet sheet = sheets.get(key);
            String[] strings = SpStringUtils.splitStr((String) entry.getValue(), "/");
            //读取数据
            getSheelInRows(sheet, strings);
        }
        return null;
    }

    /**
     * 读取指定key中指定范围的行
     */
    public static void getSheelInRows(Sheet sheet, String[] rows) {
        //校验参数
        SpAssert.isNull(sheet);
        //判断行数数组是否为null
        if (SpAssert.isNotNull(rows)) {
            //判断当前sheet中是否制定了，读取的行数范围
            if (SpAssert.isNotNull(rows) && rows.length == 2) {
                sheet.removeRowBreak(Integer.valueOf(rows[1]));
                Row row = sheet.getRow(Integer.valueOf(rows[1]));
            }
        }
        for (Row row : sheet) {
            getRowContent(row);
        }
    }


    /**
     * 读取行中的数据
     */
    public static void getRowContent(Row row) {
        SpAssert.isNull(row);
        for (Cell cell : row) {
            switch (cell.getCellType()) {
                case STRING:
                    System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        System.out.println(cell.getDateCellValue());
                    } else {
                        System.out.println(cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    System.out.println(cell.getCellFormula());
                    break;
                case BLANK:
                    System.out.println();
                    break;
                default:
                    System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        try {
            ss s = new ss();
            s.aa();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

}
