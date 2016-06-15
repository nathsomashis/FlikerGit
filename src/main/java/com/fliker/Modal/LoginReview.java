package com.fliker.Modal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fliker.SpringMongoConfig;
import com.fliker.User;
import com.fliker.Repository.LoginUser;

public class LoginReview {

	public String validateUser(String username,String password){
		
		String message;
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Query searchUserQuery = new Query(Criteria.where("username").is(username));

		// find the saved user again.
		LoginUser savedUser = mongoOperation.findOne(searchUserQuery, LoginUser.class);
		
		if(savedUser.getPassword().equals(password)){
			message = "validUser";
		}else{
			message = "InvalidUser";
		}
		
		return message;
		
	}
	
}
