package com.seleniumappium.testcases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumappium.util.hashtabarray;

public class testdatap {
	
	
	@Test(dataProvider = "getdata")
	public void logintest1(Hashtable<String,String> data){
		
		System.out.println("data" + data.get("mummy"));
		
	}
	
	@DataProvider
	public  Object[][] getdata(){
		return hashtabarray.datap();
		
	}

}
