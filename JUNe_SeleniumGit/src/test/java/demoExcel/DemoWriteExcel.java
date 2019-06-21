package demoExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DemoWriteExcel {
  @Test
  public void f() throws IOException {
	  File src = new File("src/test/java/demoWebdriver/MyFiles/Login.xlsx");
		FileInputStream fis= new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1= wb.getSheetAt(0);
		int rowCount= sheet1.getLastRowNum();
		System.out.println("total rows is:" +rowCount);

		for(int i=0;i<=rowCount;i++) {
			String Data1= sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("coulumn 1 is:" +Data1);
			String Data2=sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("column 2 is:" +Data2);
		}
		
		sheet1.getRow(0).createCell(2).setCellValue("Result");
		sheet1.getRow(1).createCell(2).setCellValue("Pass");
		sheet1.getRow(2).createCell(2).setCellValue("Pass");
		sheet1.getRow(3).createCell(2).setCellValue("Fail");
		
		FileOutputStream fout = new FileOutputStream("src/test/java/demoWebdriver/MyFiles/Login.xlsx");
		wb.write(fout);
		fout.close();
  }
}
