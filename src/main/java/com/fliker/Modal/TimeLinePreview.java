package com.fliker.Modal;

import java.util.ArrayList;
import java.util.HashMap;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Post;
import com.fliker.Repository.Profile;
import com.fliker.Repository.Timeline;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class TimeLinePreview {

	public ArrayList getTimeLineData(String userid) {
		// TODO Auto-generated method stub
		
		ArrayList timelinelatest = new ArrayList();
		
		ProfilePreview profprev = new ProfilePreview();
		Profile prof = profprev.getProfileData(userid);
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("profileid", prof.getProfileid(), "Timeline");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			Timeline timeline = new Timeline();
			
			timeline.setTimelineid((String)theObj.get("timelineid"));
			timeline.setProfileid((String)theObj.get("profileid"));
			timeline.setLogEntry((String)theObj.get("logEntry"));
			timeline.setEvent((String)theObj.get("event"));
			timeline.setTimelinedescription((String)theObj.get("timelinedescription"));
			timeline.setTimelineentrytype((String)theObj.get("timelineentrytype"));
			timeline.setTimelineimageid((String)theObj.get("timelineimageid"));
			timeline.setTimelinelink((String)theObj.get("timelinelink")); 
			
			
			timelinelatest.add(timeline);
		}
		
		
		return timelinelatest;
	}
	
	
	public ArrayList getTimelinePost(){
		
		
		ArrayList timelinelist = new ArrayList<Post>();

		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("Timeline");
		DBCursor cursor;
		cursor = collection.find().limit(10).sort(new BasicDBObject("timelinedate", -1));

		while (cursor.hasNext()) {
			DBObject dbj = cursor.next();
			HashMap totalSet = new HashMap();
			totalSet.put("timelineid", dbj.get("timelineid"));
			totalSet.put("profileid", dbj.get("profileid"));
			totalSet.put("logEntry", dbj.get("logEntry"));
			totalSet.put("event", dbj.get("event"));
			totalSet.put("timelineentrytype", dbj.get("timelineentrytype"));
			totalSet.put("timelinedescription", dbj.get("timelinedescription"));
			totalSet.put("timelineimageid", dbj.get("timelineimageid"));
			totalSet.put("timelinelink", dbj.get("timelinelink"));
			totalSet.put("timelinedate", dbj.get("timelinedate"));
			totalSet.put("timelinelocation", dbj.get("timelinelocation"));
			// User Details
			
			timelinelist.add(totalSet);
		}

		return timelinelist;
		
	}


	public ArrayList getTimelineLaterPost(String lastid) {
		// TODO Auto-generated method stub
		ArrayList timelinelist = new ArrayList<Post>();

		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("Timeline");
		int lastnumber = Integer.parseInt(lastid);
		DBCursor cursor;
		cursor = collection.find().skip(lastnumber).limit(10).sort(new BasicDBObject("timelinedate", -1));

		while (cursor.hasNext()) {
			DBObject dbj = cursor.next();
			HashMap totalSet = new HashMap();
			totalSet.put("timelineid", dbj.get("timelineid"));
			totalSet.put("profileid", dbj.get("profileid"));
			totalSet.put("logEntry", dbj.get("logEntry"));
			totalSet.put("event", dbj.get("event"));
			totalSet.put("timelineentrytype", dbj.get("timelineentrytype"));
			totalSet.put("timelinedescription", dbj.get("timelinedescription"));
			totalSet.put("timelineimageid", dbj.get("timelineimageid"));
			totalSet.put("timelinelink", dbj.get("timelinelink"));
			totalSet.put("timelinedate", dbj.get("timelinedate"));
			totalSet.put("timelinelocation", dbj.get("timelinelocation"));
			// User Details
			
			timelinelist.add(totalSet);
		}

		return timelinelist;
	}

}
