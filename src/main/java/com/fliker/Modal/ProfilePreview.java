package com.fliker.Modal;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Profile;
import com.fliker.Repository.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ProfilePreview {

	
	public ArrayList getProfileInfo(String userid){
		
		ArrayList profileArr = new ArrayList();
		
		
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Profile");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		    //How to get the DBObject value to ArrayList of Java Object?
			Profile profileinfo = new Profile();
		    /*BasicDBList passwordlist = (BasicDBList) theObj.get("password");
		    for (int i = 0; i < passwordlist.size(); i++) {
		        BasicDBObject passwordobj = (BasicDBObject) passwordlist.get(i);
		        String passwordword = passwordobj.getString("password");
		        

		        students.add(student);
		    } */
			
			/*BasicDBObject passwordobj = (BasicDBObject)theObj.get("password");*/
			
			profileinfo.setUserid(userid);
			profileinfo.setProfileid((String)theObj.get("profileid"));
			profileinfo.setSkypeid((String)theObj.get("skypeid"));
			profileinfo.setName((String)theObj.get("name"));
			profileinfo.setEmailid((String)theObj.get("emailid"));
			profileinfo.setExperience((String)theObj.get("experience"));
			profileinfo.setCurrentStatus((String)theObj.get("currentStatus"));
			profileinfo.setContact((String)theObj.get("contact"));
			profileinfo.setHangoverid((String)theObj.get("hangoverid"));
			profileinfo.setProfiledataid((String)theObj.get("profiledataid"));
			profileinfo.setProfileImageid((String)theObj.get("profileImageid"));
			profileinfo.setSalary((String)theObj.get("salary"));
			profileinfo.setSalaryhike((String)theObj.get("salaryhike"));
			profileinfo.setTellmeaboutme((String)theObj.get("tellmeaboutme"));
			String[] courseids = null;
			if((String)theObj.get("courseids")!=null){
				courseids = ((String)theObj.get("courseids")).split(",");
			}
			profileinfo.setCourseids(courseids);
			
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
	
	
	public ArrayList getProfileInformation(String userid){
		
		ArrayList profileArr = new ArrayList();
		
		
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Profile");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		    //How to get the DBObject value to ArrayList of Java Object?
			Profile profileinfo = new Profile();
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
			profileinfo.setSalaryhike((String)theObj.get("salaryhike"));
			profileinfo.setTellmeaboutme((String)theObj.get("tellmeaboutme"));
			String[] courseids = null;
			if((String)theObj.get("courseids")!=null){
				courseids = ((String)theObj.get("courseids")).split(",");
			}
			profileinfo.setCourseids(courseids);
			
			ProfilePreview profprev = new ProfilePreview();
			
			profileArr.add(profileinfo);
			
			//articleids
			HashMap articlemap = new HashMap();
			ArrayList articles = new ArrayList();
			String[] articlelist = (String[])theObj.get("articleids");
			if(articlelist != null){
				articles.add(articlelist.length);
			}
			articlemap.put("articles", articles);
			profileArr.add(articlemap);
			
			//connectionids
			HashMap connectionmap = new HashMap();
			ArrayList connections = new ArrayList();
			String[] connectionlist = (String[])theObj.get("connectids");
			if(connectionlist != null){
				
				connections.add(connectionlist.length);
				
			}
			connectionmap.put("connections",connections);
			profileArr.add(connectionmap);
			
			//followerids
			HashMap followmap = new HashMap();
			ArrayList followerslist = new ArrayList();
			String[] followerarr = (String[])theObj.get("follwerids");
			if(followerarr != null){
				
				followerslist.add(followerarr.length);
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
	
	
	public Profile getProfileData(String userid) {
		
		MongoConnection mongocon = new MongoConnection();
		Profile profileinfo = new Profile();
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
			profileinfo.setSkypeid((String)theObj.get("skypeid"));
			profileinfo.setName((String)theObj.get("name"));
			profileinfo.setEmailid((String)theObj.get("emailid"));
			profileinfo.setExperience((String)theObj.get("experience"));
			profileinfo.setCurrentStatus((String)theObj.get("currentStatus"));
			profileinfo.setContact((String)theObj.get("contact"));
			profileinfo.setHangoverid((String)theObj.get("hangoverid"));
			profileinfo.setProfiledataid((String)theObj.get("profiledataid"));
			profileinfo.setProfileImageid((String)theObj.get("profileImageid"));
			profileinfo.setSalary((String)theObj.get("salary"));
			profileinfo.setSalaryhike((String)theObj.get("salaryhike"));
			profileinfo.setTellmeaboutme((String)theObj.get("tellmeaboutme"));
			String[] courseids = null;
			if((String)theObj.get("courseids")!=null){
				courseids = ((String)theObj.get("courseids")).split(",");
			}
			profileinfo.setCourseids(courseids);
			
			ProfilePreview profprev = new ProfilePreview();
			
		}
		
		
		return profileinfo;
	}
	
	public String profileimage(String userid){
		
		String imageiddoc = "";
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Profile");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			String imageid = (String)theObj.get("profileImageid");
			if(imageid != null){
				imageiddoc = imageid;
			}else{
				imageiddoc = "";
			}
			
		}
		
		return imageiddoc;
	}


	public void saveCurrentStatus(String userid, String currentstatus) {
		// TODO Auto-generated method stub\
		
		ProfilePreview prof = new ProfilePreview();
		prof.saveElements(userid, currentstatus, "currentStatus");
		
	}
	
	
	public void saveElements(String userid, String content, String column){
		
		MongoConnection mongocon = new MongoConnection();
		//Query searchUserQuery = new Query(Criteria.where("userid").is(userid));
		
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append(column, content));

		BasicDBObject searchQuery = new BasicDBObject().append("userid", userid);

		
		mongocon.updateObject(searchQuery, newDocument, "Profile");
		
		
		
	}


	public void saveContactNo(String userid, String contact) {
		// TODO Auto-generated method stub
		
		ProfilePreview prof = new ProfilePreview();
		prof.saveElements(userid, contact, "contact");
		
	}


	public void saveEmailModify(String userid, String emailid) {
		// TODO Auto-generated method stub
		
		ProfilePreview prof = new ProfilePreview();
		prof.saveElements(userid, emailid, "emailid");
		
	}


	public void saveSkypeModify(String userid, String skypeid) {
		// TODO Auto-generated method stub
		
		ProfilePreview prof = new ProfilePreview();
		prof.saveElements(userid, skypeid, "skypeid");
		
	}


	public void saveTellMeAbout(String userid, String aboutme) {
		// TODO Auto-generated method stub
		
		ProfilePreview prof = new ProfilePreview();
		prof.saveElements(userid, aboutme, "tellmeaboutme");
		
	}


	public void saveExperience(String userid, String experience) {
		// TODO Auto-generated method stub
		
		ProfilePreview prof = new ProfilePreview();
		prof.saveElements(userid, experience, "experience");
	}


	public void saveSalaryRange(String userid, String salarystart, String salaryhike) {
		// TODO Auto-generated method stub
		
		ProfilePreview prof = new ProfilePreview();
		prof.saveElements(userid, salarystart, "salary");
		prof.saveElements(userid, salaryhike, "salaryhike");
	}


	public void saveNewProfileData(String userid, String email, String username, String password, String firstname, String lastname,
			String gender, String request, String subscription, String terms,String contact,String currentStatus) {
		// TODO Auto-generated method stub
		
		ProfilePreview profprev = new ProfilePreview();
		
		
		String[] articles = new String[0];
		String[] connections = new String[0];
		String[] courses = new String[0];
		String[] followers = new String[0];
		String[] guidance = new String[0];
		String[] projects = new String[0];
		String[] skillset = new String[0];
		
		
		Profile profile = new Profile();
		profile.setArticleids(articles);
		profile.setConnectids(connections);
		profile.setContact(contact);
		profile.setCourseids(courses);
		profile.setCurrentStatus(currentStatus);
		profile.setEmailid(email);
		profile.setExperience("");
		profile.setFollwerids(followers);
		profile.setGuidanceids(guidance);
		profile.setHangoverid(email);
		profile.setName(firstname+" "+lastname);
		profile.setProfiledataid("");
		profile.setProfileImageid("");
		profile.setProjects(projects);
		profile.setSalary("");
		profile.setSalaryhike("");
		profile.setSkilliset(skillset);
		profile.setSkypeid(email);
		profile.setTellmeaboutme("");
		profile.setUserid(userid);
		
		
		
		MongoConnection mongocon = new MongoConnection();
		
		BasicDBObject basicreqobj =  profprev.formProfileDBObject(profile);
		
		mongocon.saveObject(basicreqobj, "Profile");
		
	}


	private BasicDBObject formProfileDBObject(Profile profile) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("articleids", profile.getArticleids());
		basicdbobj.put("connectids", profile.getConnectids());
		basicdbobj.put("contact", profile.getContact());
		basicdbobj.put("courseids", profile.getCourseids());
		basicdbobj.put("currentStatus", profile.getCurrentStatus());
		basicdbobj.put("emailid", profile.getEmailid());
		basicdbobj.put("experience", profile.getExperience());
		basicdbobj.put("follwerids", profile.getFollwerids());
		basicdbobj.put("guidanceids", profile.getGuidanceids());
		basicdbobj.put("hangoverid", profile.getHangoverid());
		basicdbobj.put("name", profile.getName());
		basicdbobj.put("profiledataid", profile.getProfiledataid());
		basicdbobj.put("profileid", profile.getProfileid());
		basicdbobj.put("profileImageid", profile.getProfileImageid());
		basicdbobj.put("projects", profile.getProjects());
		basicdbobj.put("salary", profile.getSalary());
		basicdbobj.put("salaryhike", profile.getSalaryhike());
		basicdbobj.put("skilliset", profile.getSkilliset());
		basicdbobj.put("skypeid", profile.getSkypeid());
		basicdbobj.put("tellmeaboutme", profile.getTellmeaboutme());
		basicdbobj.put("userid", profile.getUserid());
		
		return basicdbobj;
	}


	/*public ArrayList getRecommendedList(String userid) {
		
		ArrayList recommendlist = new ArrayList();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Profile");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		    //How to get the DBObject value to ArrayList of Java Object?
			Profile profileinfo = new Profile();
			String[] profilefoconn = profileinfo.getConnectids();
			String[] profilefofoll = profileinfo.getFollwerids();
			
			if(profilefoconn.length <0){
				for(int m=0;m<profilefoconn.length;m++){
					
					MongoConnection mongoconn = new MongoConnection();
					DBCursor resultconn = mongoconn.getDBObject("userid", profilefoconn[m], "Profile");
					if(resultconn.hasNext()){
						
						DBObject theObjconn = resultconn.next();
					    //How to get the DBObject value to ArrayList of Java Object?
						Profile profileprof = new Profile();
						profileprof.
						
					}
					
					
				}
				
				
			}
			
			
		
		}
		// TODO Auto-generated method stub
		return recommendlist;
	}*/
	
	
}
