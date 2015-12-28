

import java.util.ArrayList;
import java.util.Scanner;

public class BrassDigits {
	int digitzero = 0;
	int digitone = 0;
	int digittwo = 0;
	int digitthree = 0;
	int digitfour = 0;
	int digitfive = 0;
	int digitsix = 0;
	int digitseven = 0;
	int digiteight = 0;
	int digitnine = 0;

	public void newFunction(String a){
		
		long i = Integer.parseInt(a);
		
		System.out.println("value of string is " + i);
		
		ArrayList al = new ArrayList();
		
		while (!(i==0)){
			al.add(i);
			i=i-1;
		}
		 
		for(int j = 0; j<al.size();j++){
			
		   
			String str = "" +al.get(j);  
			
			char[] digit = str.toCharArray(); 
			
			for(int k = 0; k < digit.length; k++){
			 
			char temp=digit[k];
				 
			
				if (temp=='0'){
				digitzero = digitzero + 1;}
				
				if (temp=='1'){
					digitone = digitone + 1;				
				}
				
				if (temp=='2'){
					digittwo = digittwo + 1;}
				
				if (temp=='3'){
					digitthree = digitthree + 1;}
				
				if (temp=='4'){
					digitfour = digitfour + 1;}
				
				if (temp=='5'){
					digitfive = digitfive + 1;}
				
				if (temp=='6'){
					digitsix = digitsix + 1;}
				
				if (temp=='7'){
					digitseven = digitseven + 1;}
				
				if (temp=='8'){
					digiteight = digiteight + 1;}
				
				if (temp=='9'){
					digitnine = digitnine + 1;}
				
			
			}
			
		}
		System.out.println("number of zero brass digits :" + digitzero);
		System.out.println("number of one brass digits :" + digitone);
		System.out.println("number of two brass digits :" + digittwo);
		System.out.println("number of three brass digits :" + digitthree);
		System.out.println("number of four brass digits :" + digitfour);
		System.out.println("number of five brass digits :" + digitfive);
		System.out.println("number of six brass digits :" + digitsix);
		System.out.println("number of seven brass digits :" + digitseven);
		System.out.println("number of eight brass digits  :" + digiteight);
		System.out.println("number of nine brass digits :" + digitnine);
			}
	

	public static void main(String args[])
	   {
	      //long i;
	      
			String a;
		
	        Scanner in = new Scanner(System.in);
	  
	        System.out.println("Enter a value");
	        
	        a=in.nextLine();
	      
	        //i = in.nextInt();
	        System.out.println("You entered "+a);
	 
	        BrassDigits b= new BrassDigits();
	        
	        b.newFunction(a);
	   }

}
