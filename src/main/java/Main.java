import java.util.*;
import java.io.*;

import Pro.Level;
import Pro.Operators;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
public class Main {
    public static void main(String[] args) {
        try {
//            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("ruler/ruler.xlsx"));
//            int sheetCount = wb.getNumberOfSheets();//获取sheet的个数
//            System.out.println(sheetCount);
//            for (int i = 0; i <sheetCount; i++) {
//                System.out.println("读取第"+(i+1)+"个sheet");
//                XSSFSheet sheet = wb.getSheetAt(i);
//                int rowCount = sheet.getLastRowNum();
//                for (int j = 0; j <=rowCount; j++) {
//                    int colCount = sheet.getRow(j).getLastCellNum();
//                    System.out.println("第"+(j+1)+"行数据如下");
//                    for (int k = 0; k < colCount; k++) {
//                        System.out.println(sheet.getRow(j).getCell(k)+"  ");
//                    }
//                }
//            }
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("ruler/ruler.xlsx"));
//            int sheetCount = workbook.getNumberOfSheets();//获取sheet 的个数
            //遍历sheet1，获取干员数据
            XSSFSheet sheet = workbook.getSheetAt(0);//第0个sheet 干员sheet
            int rowNum = sheet.getLastRowNum();//获取总行数
            ArrayList<Operators> operatorsList=new ArrayList<>();
            for(int i=1;i<=rowNum;i++) {
                XSSFRow row = sheet.getRow(i);//获取每一行
                Operators operators =new Operators();
                int columns=0;
                if(1==i){
                    columns=row.getLastCellNum()-1;
                }else {
                    columns=row.getLastCellNum();
                }
                for(int j=0;j<=columns;j++) {
                    Cell cell = row.getCell(j);
                    switch (j) {
                        case 0:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue=cell.getStringCellValue();
                            operators.setOperatorName(cellValue);
                            break;
                        case 1:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue2=cell.getStringCellValue();
                            operators.setLevel(cellValue2);
                            break;
                        case 2:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue3=cell.getStringCellValue();
                            operators.setLimit(cellValue3);
                            break;
                        case 3:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue4=cell.getStringCellValue();
                            operators.setOperatorCount(cellValue4);
                            break;
                    }
                }operatorsList.add(operators);
            }

            System.out.println(operatorsList.get(0).getOperatorName().contains("维什"));
//            for (int i = 0; i < operatorsList.size(); i++) {
//                System.out.println(operatorsList.get(i).getOperatorName());
//                System.out.println(operatorsList.get(i).getLevel());
//                System.out.println(operatorsList.get(i).getLimit());
//                System.out.println(operatorsList.get(i).getOperatorCount());
//            }
            //遍历sheet2，获取关卡相关数据
            XSSFSheet sheet1=workbook.getSheetAt(1);
            int rowNum1=sheet1.getLastRowNum();
            ArrayList<Level> levelsList=new ArrayList<>();
            for(int i=1;i<=rowNum1;i++) {
                XSSFRow row1 = sheet1.getRow(i);
                Level level= new Level();
                int columns=0;
                if(1==i){
                    columns=row1.getLastCellNum()-1;
                }else {
                    columns=row1.getLastCellNum();
                }
                for (int j=0;j<=columns;j++) {
                    Cell cell1 = row1.getCell(j);
                    switch (j) {
                        case 0:
                            cell1.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue1=cell1.getStringCellValue();
                            level.setLevelName(cellValue1);
                            break;
                        case 1:
                            cell1.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue2=cell1.getStringCellValue();
                            level.setCount(cellValue2);
                    }
                }
                levelsList.add(level);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}