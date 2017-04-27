package com.fliker.Connection;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.fliker.SpringMongoConfig;
import com.fliker.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoConnection {
	
	
	
	
	/*public HashMap ConnectionListMongo(){
		
		HashMap connectionlist = new HashMap();
		connectionlist.put(System.currentTimeMillis(), getDBConnection());
		
		return connectionlist;
		
	}*/

	public static DBCollection getDBConnection(String collectionname){
		MongoClientURI uri  = new MongoClientURI("mongodb://admin:admin@ds021663.mlab.com:21663/fliker");
        MongoClient client = new MongoClient(uri);
        DB db = client.getDB(uri.getDatabase());

        DBCollection collection = db.getCollection(collectionname);

		// save
		return collection;
	}
	
	
	public DBCursor getDBObject(String columnname, String comparision, String collectionname){
		
		DBCollection collection = getDBConnection(collectionname);
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put(columnname, comparision);
		
		DBCursor cursor = collection.find(basicdbobj);
		/*while(cursor.hasNext()) {
		    System.out.println(cursor.next());
		}*/
		
		return cursor;
	}
	
	public DBCursor getDBObjectSorted(String columnname, String comparision, String collectionname, String sortingcolumn, int limit){
		
		DBCollection collection = getDBConnection(collectionname);
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put(columnname, comparision);
		
		DBCursor cursor = collection.find(basicdbobj).sort(new BasicDBObject(sortingcolumn,-1)).limit(limit);
		/*while(cursor.hasNext()) {
		    System.out.println(cursor.next());
		}*/
		
		return cursor;
	}
	
	
	public void saveObject(BasicDBObject basicreqobj, String collectionname){
		
		DBCollection collection = getDBConnection(collectionname);
		collection.save(basicreqobj);
		
	}
	
	public void updateObject(BasicDBObject searchbasicreqobj,BasicDBObject updatebasicreqobj, String collectionname){
		
		DBCollection collection = getDBConnection(collectionname);
		collection.update(searchbasicreqobj, updatebasicreqobj);
		
	}
	
	
}
