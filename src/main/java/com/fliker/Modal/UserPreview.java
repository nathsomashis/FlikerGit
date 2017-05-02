package com.fliker.Modal;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.User;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class UserPreview {
	
	public User setUserName(String username){
		User user  = new User();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("emailid", username, "User");
		
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			String gender = "";
		
			user.setEmailid((String)theObj.get("emailid"));
			user.setEnabled((Boolean)theObj.get("enabled"));
			user.setFirstname((String)theObj.get("firstname"));
			if(((String)theObj.get("gender")).equalsIgnoreCase("2")){
				gender = "female";
			}else{
				gender = "male";
			}
			user.setGender(gender);
			user.setLastname((String)theObj.get("lastname"));
			user.setUserid((String)theObj.get("userid"));
			
		}
		return user;
	}
	
	public String getGender(String userid){
		
		String gender = "";
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "User");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			if(((String)theObj.get("gender")).equalsIgnoreCase("2")){
				gender = "female";
			}else{
				gender = "male";
			}
		}
		
		return gender;
	}

}
