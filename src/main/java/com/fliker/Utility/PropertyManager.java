package com.fliker.Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

public class PropertyManager {

	public void createFileProperty(){
		Properties prop = new Properties();
		OutputStream output = null;
		
		try {

			output = new FileOutputStream("Course.properties");

			// set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "mkyong");
			prop.setProperty("dbpassword", "password");

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		
	}
	
	
	public ArrayList readPropertySection(String property, String propertyfile){
		
		Properties prop = new Properties();
		InputStream input = null;
		ArrayList propertlist = new ArrayList();

		try {

			input = new FileInputStream(propertyfile);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			/*System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("dbuser"));*/
			System.out.println(prop.getProperty("CourseCategory"));
			
			
			String[] propertyset = (prop.getProperty(property)).split(","); 
			for(int i=0;i<propertyset.length;i++){
				
				propertlist.add(propertyset[i]);
				
			}
			

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return propertlist;
		
	}
	
	
}
