package com.fliker.Modal;

import java.util.ArrayList;
import java.util.HashMap;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Courses;
import com.fliker.Repository.Jobs;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class CoursePreview {

	public ArrayList getCourseList(String lastid){
		
		ArrayList courselist = new ArrayList();
		/*MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection().getCollection("Course");
		DBCursor cursor;
		if(lastid.isEmpty()){
			cursor = collection.find().limit(50).sort(new BasicDBObject("courseReview",-1));
		}else{
			cursor = collection.find(new BasicDBObject("courseid", lastid)).limit(50).sort(new BasicDBObject("courseReview",-1));
		}
		
		
		
		while(cursor.hasNext()){
			courselist.add(cursor.next());
		}*/
		
		return courselist;
	}
	
	
	
	public void createCourse(){
		
	}
	
	public void publishCourse(){
		
	}
	
	public void uploadCourseContent(){
		
	}
	
	public void spreadCourse(){
		
	}
	
	public void shareCourse(){
		
	}
	
	public void likeCourse(){
		
	}
	
	public void modifyCourse(){
		
	}
	
	public ArrayList getSponsorslist(){
		
		ArrayList sponsorslist = new ArrayList();
		
		
		return sponsorslist;
	}
	
	public ArrayList getpartnerList(){
		
		ArrayList partnerlist = new ArrayList();
		
		
		
		return partnerlist;
	}
	
	
	
}
