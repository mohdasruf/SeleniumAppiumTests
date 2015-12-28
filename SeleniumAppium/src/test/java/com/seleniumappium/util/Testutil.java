package com.seleniumappium.util;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.seleniumappium.testcases.TestBase;

public class Testutil {
		public static boolean isExecutable(String testName, ExcelReader xls){
		
		for(int rowNum=2;rowNum<=xls.getRowCount("Test Cases");rowNum++){
			
			if(xls.getCellData("Test Cases", "TCID", rowNum).equals(testName)){
			
				if(xls.getCellData("Test Cases", "Runmode", rowNum).equals("Y"))
					return true;
				else 
					return false;
			}
			
		}
		
		return false;
	}
	
	public static void takeScreenShot(String fileName) {
		File srcFile = ((TakesScreenshot)(TestBase.driver)).getScreenshotAs(OutputType.FILE);
		System.out.println("Step 1 completed");
		System.out.println("driver value:" + TestBase.driver);
	    try {
	    	FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName+".jpg"));
	    	System.out.println("Step 2 completed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static Object[][] getData(String testName,ExcelReader xls){
		// find the row number from which test starts
		// find the number of columns in the test
		// find the number of rows in the test
		// put the data in hastable and put hastable in array
		
		int testStartRowNum=0;
		// find the row num from which test starts
		for(int rNum=1;rNum<=xls.getRowCount("Test Data");rNum++){
			if(xls.getCellData("Test Data", 0, rNum).equals(testName)){
				testStartRowNum=rNum;
				break;
			}
		}
		System.out.println("Test "+ testName +" starts from "+ testStartRowNum);
		
		int colStartRowNum=testStartRowNum+1;
		int totalCols=0;
		while(!xls.getCellData("Test Data", totalCols, colStartRowNum).equals("")){
			totalCols++;
		}
		System.out.println("Total Cols in test "+ testName + " are "+ totalCols);
		
		//rows
		int dataStartRowNum=testStartRowNum+2;
		int totalRows=0;
		while(!xls.getCellData("Test Data", 0, dataStartRowNum+totalRows).equals("")){
			totalRows++;
		}
		System.out.println("Total Rows in test "+ testName + " are "+ totalRows);

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		// extract data
		Object[][] data = new Object[totalRows][1];
		int index=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+totalRows);rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<totalCols;cNum++){
				table.put(xls.getCellData("Test Data", cNum, colStartRowNum), xls.getCellData("Test Data", cNum, rNum));
				System.out.print(xls.getCellData("Test Data", cNum, rNum) +" -- ");
			}
			data[index][0]= table;
			index++;
			System.out.println();
		}
		
		System.out.println("done");
		
		return data;
	}
	
	
	
	
	

}
