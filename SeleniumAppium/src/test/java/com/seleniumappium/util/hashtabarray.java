package com.seleniumappium.util;

import java.util.Hashtable;

public class hashtabarray {

	public static Object[][]  datap() {
		// TODO Auto-generated method stub
		
		Hashtable<String,String> table = null;
				
				table = new Hashtable<String,String>();
		
		table.put("mummy", "Dhana");
		table.put("daddy", "Asruf");
		table.put("daughter", "Roshnie");
		table.put("son", "Roshan");
		
		
		Object[][] data = new Object[2][1];
		
		data[0][0] = table;
		
		table = new Hashtable<String,String>();
		
		table.put("mummy", "sdkl");
		table.put("daddy", "sdsd");
		table.put("daughter", "sds");
		table.put("son", "sds");
		
	
			data[1][0] = table;
		
			return data;
		
		
		
		

	}

}
