package com.fliker.Modal;

import java.util.ArrayList;

import org.springframework.data.mongodb.MongoCollectionUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.fliker.User;
import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Jobs;
import com.mongodb.DBCursor;

public class JobsPreview {

	public ArrayList getJobsList(){
		
		ArrayList joblist = new ArrayList<Jobs>();
		
		MongoConnection mongoconn = new MongoConnection();
		DBCursor dbcurson = (DBCursor) mongoconn.getDBConnection("Jobs").find();
		
		while(dbcurson.hasNext()){
			joblist.add(dbcurson.next());
		}
		
		return joblist;
		
	}
	
	public Jobs searchId(String id){
		
		MongoConnection mongoconn = new MongoConnection();
		// query to search user
				Query searchUserQuery = new Query(Criteria.where("Jobid").is(id));

				// find the saved user again.
				Jobs savedJobs = new Jobs();
						
				DBCursor dbcursor = mongoconn.getDBObject("Jobid", id, "Jobs");
				
				while(dbcursor.hasNext()){
					savedJobs = (Jobs) dbcursor.next();
				}
				System.out.println("2. find - savedUser : " + savedJobs);
				
		return savedJobs;	
	}
	
	/*public String setTracker(String id, boolean newTrack){
		
		MongoConnection mongoconn = new MongoConnection();
		Query searchUserQuery = new Query(Criteria.where("Jobid").is(id));
		
		//System.out.println("2. find - savedUser : " + savedUser);

		// update password
		mongoconn.getDBConnection().updateFirst(searchUserQuery, Update.update("JobTrack", newTrack),
				User.class);
		
		// find the updated user object
				Jobs updatedjobs = mongoconn.getDBConnection().findOne(
						new Query(Criteria.where("Jobid").is(id)), Jobs.class);

				System.out.println("3. updatedUser : " + updatedjobs);
				
			return "done";	
	}*/
	
	
	
}
