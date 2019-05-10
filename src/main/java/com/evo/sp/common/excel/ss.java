package com.evo.sp.common.excel;

import com.evo.sp.common.ex.SpAssert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-05-10 14:12
 */
public class ss {


    public void aa() throws IOException, InvalidFormatException {
        String path = this.getClass().getResource("/").getPath();
        System.out.println(path);
        File file = new File(path + "11111.xls");
        Workbook workbook = createWorkBook(file);
        for (Sheet sheet : getSheets(workbook)) {
            for (Row row : sheet) {
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
    public static Workbook createWorkBook(File file) throws IOException {
        Workbook workbook = WorkbookFactory.create(file);
        return workbook;
    }

    /**
     * 使用流创建workbook（使用内存相对较多）
     */
    public static Workbook createWorkBook(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        Workbook workbook = WorkbookFactory.create(inputStream);
        return workbook;
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
     *
     *  返回指定的工作表（Sheet）
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
     *
     * 返回指定工作表（Sheet）中的行
     */
    public static List<Row> getRows(Sheet... sheets){
        
        return null;
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
