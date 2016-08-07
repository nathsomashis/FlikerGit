package com.fliker.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunctionality {

	public String getDateDiffference(String startdate, String enddate){
		
		String difference = "";
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(startdate);
			d2 = format.parse(enddate);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			String day=" ";
			String hours = " ";
			String minutes = " ";
			String second = " ";

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
			
			if(diffDays > 0){
				day = String.valueOf(diffDays) + " days, ";
			}
			if(diffHours > 0){
				hours = String.valueOf(diffHours) + " hours, ";
			}
			if(diffMinutes > 0){
				minutes = String.valueOf(diffMinutes) + " minutes, ";
			}
			second = String.valueOf(diffSeconds);
			
			
			difference = day + hours + minutes + second+" seconds.";

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return difference;
		
	}
	
}
