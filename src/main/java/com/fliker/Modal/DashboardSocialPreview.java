package com.fliker.Modal;

import java.util.ArrayList;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Post;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class DashboardSocialPreview {

	
	public ArrayList postlist(String lastid){
		
		ArrayList postlist = new ArrayList<Post>();
		
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection().getCollection("Post");
		DBCursor cursor;
		if(lastid.isEmpty()){
			cursor = collection.find().limit(50).sort(new BasicDBObject("postid",-1));
		}else{
			cursor = collection.find(new BasicDBObject("postid", lastid)).limit(50).sort(new BasicDBObject("postid",-1));
		}
		
		while(cursor.hasNext()){
			postlist.add(cursor.next());
		}
		
		return postlist;
	}
	
}
