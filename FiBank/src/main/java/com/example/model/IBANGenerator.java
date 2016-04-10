package com.example.model;

public class IBANGenerator {
	private static int id=1;
	private static final String COUNTRY="BG";
	private static final String BANK="00";
	private static final String BIC="FIBK";
	private static final String DEPARTMENT="1234";
	
	public static String generateIBAN(String typeOfAnAccount){
		if(typeOfAnAccount==null){
			return null;
		}
		String str=(new Integer(id)).toString();
		int x=8-str.length();
		String str1=null;
		while(x>0){
			str1=str1+"0";
		}
		String iban=COUNTRY+BANK+BIC+DEPARTMENT+typeOfAnAccount+str1+str;
		return iban;
		
	}
	
	

}
