package com.fliker.Modal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fliker.SpringMongoConfig;
import com.fliker.User;
import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.LoginUser;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class LoginReview {

	public String validateUser(String username,String password){
		
		String message="";
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("username", username, "User");
		 
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		    //How to get the DBObject value to ArrayList of Java Object?

		    /*BasicDBList passwordlist = (BasicDBList) theObj.get("password");
		    for (int i = 0; i < passwordlist.size(); i++) {
		        BasicDBObject passwordobj = (BasicDBObject) passwordlist.get(i);
		        String passwordword = passwordobj.getString("password");
		        

		        students.add(student);
		    } */
			
			/*BasicDBObject passwordobj = (BasicDBObject)theObj.get("password");*/
			if(password.equalsIgnoreCase(theObj.get("password").toString())){
				message = theObj.get("userid").toString();
			}else{
				message = "The password doesn't match";
			}
			
			
		}else if(mongocon.getDBObject("emailid", username, "User").hasNext()){
			
			DBObject theObj = mongocon.getDBObject("emailid", username, "User").next();
			/*BasicDBObject passwordobj = (BasicDBObject)theObj.get("password");*/
			System.out.println(theObj.get("password").toString());
			
			if(password.equalsIgnoreCase(theObj.get("password").toString())){
				message = theObj.get("userid").toString();
			}else{
				message = "The password doesn't match";
			}
			
			
		}else{
			message = "The username is not valid";
		}
		
		
		/*if(savedUser.getPassword().equals(password)){
			message = "validUser";
		}else{
			message = "InvalidUser";
		}*/
		
		return message;
		
	}
	
}
