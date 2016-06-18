package com.fliker.Modal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.fliker.SpringMongoConfig;
import com.fliker.Repository.User;

public class RegisterPreview {
	
	
	
	public void registerUser(String email, String username, String password,String firstname, String lastname, String gender, String request, String subscription, String terms){
		
		//username='+emailid+'&password='+passwordid+'&firstname'+firstname+'&gender'+gender+'&request'+request+'&subscription'+subscription+'&terms'+terms
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		User newuser = new User(email, username, password, firstname, lastname, gender, request, subscription, terms);
		
		mongoOperation.save(newuser);
		
	}

}
