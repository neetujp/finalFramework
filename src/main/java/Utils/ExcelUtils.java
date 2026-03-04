package Utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static FileInputStream fi;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;

    // Get row count
    public static int getRowCount(String xFile, String sheetName) throws Exception {

        fi = new FileInputStream(xFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);

        int rowCount = ws.getLastRowNum();

        wb.close();
        fi.close();

        return rowCount;
    }

    // Get column count
    public static int getColCount(String xFile, String sheetName, int rowNo) throws Exception {

        fi = new FileInputStream(xFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNo);

        int colCount = row.getLastCellNum();

        wb.close();
        fi.close();

        return colCount;
    }

    // Get cell data
    public static String getCellData(String xFile, String sheetName, int rowNo, int colNo) throws Exception {

        fi = new FileInputStream(xFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rowNo);
        cell = row.getCell(colNo);

        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);

        wb.close();
        fi.close();

        return data;
    }
}