package com.fliker.Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
			
			String day="";
			String hours = "";
			String minutes = "";
			String second = "";

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

	public String getCurrentdate(){
		String currentDate = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date today = Calendar.getInstance().getTime();  
		System.out.println(dateFormat.format(today)); //2016/11/16 12:08:43
		currentDate = dateFormat.format(today);
		return currentDate;
	}
	
	public String getFuturedate(int nofdays){
		String currentDate = "";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, nofdays);
		Date today = c.getTime();  
		System.out.println(dateFormat.format(today)); //2016/11/16 12:08:43
		currentDate = dateFormat.format(today);
		return currentDate;
	}
	
	
	public String getUniformDates(String date){
		
		
			DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a", Locale.US);

	        String text = date;
	        LocalDateTime localDateTime = LocalDateTime.parse(text, formatter);
	        LocalTime localTime = localDateTime.toLocalTime();
	        String localtimezone = localTime.toString();
		
	        return localtimezone;
	}
	
	
	public Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {

	    Map<String, String> result = new HashMap<>();

	    Enumeration headerNames = request.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	        String key = (String) headerNames.nextElement();
	        String value = request.getHeader(key);
	        result.put(key, value);
	    }

	    return result;
	}
	
	
	public String getDateSystems(){
		
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
        //String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";//example
        
		
		
        Date datepack = new Date();
        DateFunctionality datefunc = new DateFunctionality();
        
        String localdate = datefunc.getUniformDates(formatter.format(datepack));
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(datepack);
        
        String yearpack = Integer.toString(cal.get(Calendar.YEAR));
        String monthspack = Integer.toString(cal.get(Calendar.MONTH));
        String daypack = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hourpack = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minutespack  = Integer.toString(cal.get(Calendar.MINUTE));
		
		return localdate;
		
	}
	
	
}
