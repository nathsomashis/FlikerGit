package com.fliker.Modal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.fliker.SpringMongoConfig;
import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class RegisterPreview {
	
	private String useridSave;
	
	private static String newuserid;
	
	public String registerUser(String email, String username, String password,String firstname, String lastname, String gender, String request, String subscription, String terms){
		
		//username='+emailid+'&password='+passwordid+'&firstname'+firstname+'&gender'+gender+'&request'+request+'&subscription'+subscription+'&terms'+terms
		
		User newuser = new User(email, username, password, firstname, lastname, gender, request, subscription, terms);
		
		MongoConnection mongoconn = new MongoConnection();
		RegisterPreview regprev = new RegisterPreview();
		
		mongoconn.saveObject(regprev.formDBObject(newuser), "User");
		
		
		mongoconn.saveObject(regprev.postToProfile(newuser), "Profile");
		
		System.out.println("userinfo saved"+getUseridSave()+" same as variable "+newuserid);
		
		return newuserid;
	}
	
	public BasicDBObject formDBObject(User userinfo){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		userinfo.setUserid(userinfo.getEmailid()+userinfo.getUsername()+System.currentTimeMillis());
		basicdbobj.put("userid", userinfo.getUserid());
		basicdbobj.put("emailid", userinfo.getEmailid());
		basicdbobj.put("username", userinfo.getUsername());
		basicdbobj.put("firstname", userinfo.getFirstname());
		basicdbobj.put("lastname", userinfo.getLastname());
		basicdbobj.put("gender", userinfo.getGender());
		basicdbobj.put("request", userinfo.getRequest());
		basicdbobj.put("subscription", userinfo.getSubscription());
		basicdbobj.put("terms", userinfo.getTerms());
		basicdbobj.put("password", userinfo.getPassword());
		basicdbobj.put("enabled", false);
		
		setUseridSave(userinfo.getUserid());
		System.out.println("userinfo saved"+getUseridSave()+" same as variable "+useridSave);
		newuserid = useridSave;
		
		return basicdbobj;
		
	}
	
	
	public BasicDBObject postToProfile(User userinfo){
		
		BasicDBObject profileobj = new BasicDBObject();
		profileobj.put("userid", userinfo.getUserid());
		profileobj.put("profileid", userinfo.getUserid());
		profileobj.put("name", userinfo.getFirstname()+userinfo.getLastname());
		profileobj.put("emailid", userinfo.getEmailid());
		
		return profileobj;
	}
	
	public String validateUser(String emailid){
		
		String message = "";
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("emailid", emailid, "User");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			message = "Email id already exist";
		}
		
		return message;
		
	}

	public String getUseridSave() {
		return useridSave;
	}

	public void setUseridSave(String useridSave) {
		this.useridSave = useridSave;
	}
	
	

}
