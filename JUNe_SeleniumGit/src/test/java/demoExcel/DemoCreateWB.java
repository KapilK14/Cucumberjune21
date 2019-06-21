package demoExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DemoCreateWB {
	@Test
	public void f() throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File("DemoWb.xlsx"));
		wb.write(out);
		out.close();
		System.out.println("file is created");
	}
}
