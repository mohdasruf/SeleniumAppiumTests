import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class Excelread {
	
	public static String filepath = "";
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFCell cell = null;
	public XSSFRow row = null;
	
	
	public Excelread(String path) throws IOException
	{
		this.filepath = path;
		FileInputStream fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		
	}
	
	public String getcelldata(String Sheetname, int colnum,int rownum){
		
		int index = workbook.getSheetIndex(Sheetname);
		
		System.out.println("Index :" + index);
		
	
		sheet = workbook.getSheetAt(index);
		
		 		 
		 row = sheet.getRow( rownum-1);
		 
		 cell = row.getCell(colnum);
		
		 
		 String data = cell.getStringCellValue();
		 
		return data;
		
	}





public static void main(String[] args) throws IOException{
	
	String path = "/Users/mohamedasruf/git/SeleniumAppium/SeleniumAppium/src/test/java/com/demo/data/Test Cases.xlsx";
	
	Excelread exl = new Excelread(path);
	
	String data1 = exl.getcelldata("Test Data", 6, 8);
	
	System.out.println("data  :" + data1);
	
}
}