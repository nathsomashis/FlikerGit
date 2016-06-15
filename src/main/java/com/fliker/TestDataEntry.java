package com.fliker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fliker.Modal.FilePreview;
import com.fliker.Repository.Comment;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.Like;
import com.fliker.Repository.Post;
import com.fliker.Repository.Share;
import com.fliker.Repository.User;

public class TestDataEntry {

	
	
	public static void main(String args[]){
		
		TestDataEntry testentry = new TestDataEntry();
		testentry.addUser();
		
	}
	
	public void addEntry(){
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Post postentry = new Post();
		Share[] shaedentry = new Share[3];
		Like[] likeentry = new Like[3];
		Comment[] commententry = new Comment[3];
		
		FileUpload fileupload = new FileUpload();
		
		
		
		//User userentry = new User();
		
		Query searchUserQuery = new Query(Criteria.where("username").is("Somashis"));
		User userentry = mongoOperation.findOne(searchUserQuery, User.class);
		
		postentry.setPostowner(userentry);
		
		postentry.setPostcomments(commententry);
		postentry.setPostliked(likeentry);
		postentry.setPostshared(shaedentry);
		postentry.setPostType("Post");
		//postentry.setPostContent(postContent);
		
		
		
		
	}
	
	public void addUser(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		User user1 = new User("Somashis", "lamborgini@5");
		User user2 = new User("Reetesh", "century@5");
		
		mongoOperation.save(user1);
		mongoOperation.save(user2);
		
	}
	
	
	
}
