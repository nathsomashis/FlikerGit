package com.fliker.Connection;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.fliker.SpringMongoConfig;
import com.fliker.User;

public class MongoConnection {
	
	
	
	
	/*public HashMap ConnectionListMongo(){
		
		HashMap connectionlist = new HashMap();
		connectionlist.put(System.currentTimeMillis(), getDBConnection());
		
		return connectionlist;
		
	}*/

	public MongoOperations getDBConnection(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		User user = new User("mkyong", "password123");

		// save
		return mongoOperation;
	}
	
}
