package com.fliker.Utility;

public class TestRegular {

	
	public static void main(String args[]){
		
		boolean retval = false;
		if (args[0].length() == 7 ) {
		java.util.regex.Pattern p = java.util.regex.Pattern.compile("[0-9][/][0-9][/][0-9]");
		java.util.regex.Matcher m= p.matcher(args[0]);
		retval = m.matches();
		}
		
	}
}
