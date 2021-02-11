package utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {
    XSSFWorkbook wb;
    //Creating a constructor of the same class that would load excel file using the File I/O stream
    public ReadExcelFile(){
        File src = new File(System.getProperty("user.dir") + "/src/test/java/testdata/TestData.xlsx");
        try {
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        }
        catch (Exception e) {
            System.out.println("The exception is: " +e.getMessage());
        }
    }
    //This method would fetch the data from the corresponding cell of the excel sheet and return as a String.
    public String getData(int sheetIndex, int row, int column){
        String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
        return data;
    }
}