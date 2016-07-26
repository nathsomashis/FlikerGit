package com.fliker.Modal;

import java.util.ArrayList;
import java.util.HashMap;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Profile;
import com.fliker.Repository.User;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ProfilePreview {

	
	public ArrayList getProfileInfo(String userid){
		
		ArrayList profileArr = new ArrayList();
		
		Profile profileinfo = new Profile();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Profile");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		    //How to get the DBObject value to ArrayList of Java Object?

		    /*BasicDBList passwordlist = (BasicDBList) theObj.get("password");
		    for (int i = 0; i < passwordlist.size(); i++) {
		        BasicDBObject passwordobj = (BasicDBObject) passwordlist.get(i);
		        String passwordword = passwordobj.getString("password");
		        

		        students.add(student);
		    } */
			
			/*BasicDBObject passwordobj = (BasicDBObject)theObj.get("password");*/
			
			profileinfo.setUserid(userid);
			profileinfo.setProfileid((String)theObj.get("profileid"));
			profileinfo.setCurrentStatus((String)theObj.get("skypeid"));
			profileinfo.setName((String)theObj.get("name"));
			profileinfo.setEmailid((String)theObj.get("emailid"));
			profileinfo.setExperience((String)theObj.get("experience"));
			profileinfo.setCurrentStatus((String)theObj.get("currentStatus"));
			profileinfo.setContact((String)theObj.get("contact"));
			profileinfo.setHangoverid((String)theObj.get("hangoverid"));
			profileinfo.setProfiledataid((String)theObj.get("profiledataid"));
			profileinfo.setProfileImageid((String)theObj.get("profileImageid"));
			profileinfo.setSalary((String)theObj.get("salary"));
			profileinfo.setTellmeaboutme((String)theObj.get("tellmeaboutme"));
			
			ProfilePreview profprev = new ProfilePreview();
			
			profileArr.add(profileinfo);
			
			//articleids
			HashMap articlemap = new HashMap();
			ArrayList articles = new ArrayList();
			String[] articlelist = (String[])theObj.get("articleids");
			if(articlelist != null){
				for(int i=0;i<articlelist.length;i++){
					articles.add(profprev.getArticlelist(articlelist[i]));
				}
			}
			articlemap.put("articles", articles);
			profileArr.add(articlemap);
			
			//connectionids
			HashMap connectionmap = new HashMap();
			ArrayList connections = new ArrayList();
			String[] connectionlist = (String[])theObj.get("connectids");
			if(connectionlist != null){
				
				for(int j=0;j<connectionlist.length;j++){
					connections.add(profprev.getProfileInfo(connectionlist[j]));
				}
				
			}
			connectionmap.put("connections",connections);
			profileArr.add(connectionmap);
			
			//followerids
			HashMap followmap = new HashMap();
			ArrayList followerslist = new ArrayList();
			String[] followerarr = (String[])theObj.get("follwerids");
			if(followerarr != null){
				
				for(int k=0;k<followerarr.length;k++){
					followerslist.add(profprev.getFollowerslist(followerarr[k]));
				}
			}
			followmap.put("followers", followerslist);
			profileArr.add(followmap);
			
		}
		
		
		return profileArr;
	}
	
	
	public String getArticlelist(String articleid){
		
		String articledesc = "";
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("articleid", articleid, "Articles");
		
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			articledesc = (String)theObj.get("articledescription");
			
		}
		
		
		return articledesc;
	}
	
	public Profile getConnectionlist(String coonectionid){
		
		Profile profileinfo = new Profile();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("connectionid", coonectionid, "Connections");
		
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			String userid = (String)theObj.get("userid");
			
			DBCursor profilecursor = mongocon.getDBObject("userid", userid, "Profile");
			
			if(profilecursor.hasNext()){
				DBObject profileObj = profilecursor.next();
				profileinfo.setUserid(userid);
				profileinfo.setProfileImageid((String)profileObj.get("profileImageid"));
				profileinfo.setName((String)profileObj.get("name"));
				
			}
			
		}
		
		
		return profileinfo;
	}
	
	
	public Profile getFollowerslist(String followerid){
		
		Profile profileinfo = new Profile();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("followerid", followerid, "Followers");
		
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			String userid = (String)theObj.get("userid");
			
			DBCursor profilecursor = mongocon.getDBObject("userid", userid, "Profile");
			
			if(profilecursor.hasNext()){
				DBObject profileObj = profilecursor.next();
				profileinfo.setUserid(userid);
				profileinfo.setProfileImageid((String)profileObj.get("profileImageid"));
				profileinfo.setName((String)profileObj.get("name"));
				
			}
			
		}
		
		
		return profileinfo;
	}


	public DBObject getUser(String shareOwner) {
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor profcursor = mongocon.getDBObject("profileid", shareOwner, "Profile");
		DBObject dbj = null;
		
		while(profcursor.hasNext()){
			
			dbj = profcursor.next();
			
		}
		
		
		return dbj;
	}


	public Profile getProfile(String shareOwner) {
		
		
		
		
		return null;
	}
	
	
	
}
