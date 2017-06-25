package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Profile;
import com.fliker.Repository.ProfileProjects;
import com.fliker.Repository.SkillAssesment;
import com.fliker.Repository.SkillSet;
import com.fliker.Repository.User;
import com.fliker.Utility.DateFunctionality;
import com.fliker.Utility.UploadFileService;
import com.mongodb.BasicDBList;
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
			BasicDBList consumeridslist = (BasicDBList)theObj.get("courseids");
			if(!consumeridslist.isEmpty()){
				courseids = (String[]) consumeridslist.toArray();
			}
			/*if((String)theObj.get("courseids")!=null){
				courseids = ((String)theObj.get("courseids")).split(",");
			}*/
			profileinfo.setCourseids(courseids);
			
			ProfilePreview profprev = new ProfilePreview();
			
			profileArr.add(profileinfo);
			
			//articleids
			HashMap articlemap = new HashMap();
			ArrayList articles = new ArrayList();
			BasicDBList articlelist = (BasicDBList)theObj.get("articleids");
			if(!articlelist.isEmpty()){
				for(int m=0;m<articlelist.size();m++){
					articles.add(profprev.getArticlelist((String)articlelist.get(m)));
				}
			}
			/*String[] articlelist = (String[])theObj.get("articleids");
			if(articlelist != null){
				for(int i=0;i<articlelist.length;i++){
					articles.add(profprev.getArticlelist(articlelist[i]));
				}
			}*/
			articlemap.put("articles", articles);
			profileArr.add(articlemap);
			
			//connectionids
			HashMap connectionmap = new HashMap();
			ArrayList connections = new ArrayList();
			BasicDBList connectionlist = (BasicDBList)theObj.get("connectids");
			if(!connectionlist.isEmpty()){
				for(int m=0;m<connectionlist.size();m++){
					connections.add(profprev.getProfileInfo((String)connectionlist.get(m)));
				}
			}
			
			/*String[] connectionlist = (String[])theObj.get("connectids");
			if(connectionlist != null){
				
				for(int j=0;j<connectionlist.length;j++){
					connections.add(profprev.getProfileInfo(connectionlist[j]));
				}
				
			}*/
			connectionmap.put("connections",connections);
			profileArr.add(connectionmap);
			
			//followerids
			HashMap followmap = new HashMap();
			ArrayList followerslist = new ArrayList();
			BasicDBList followerarr = (BasicDBList)theObj.get("follwerids");
			if(!followerarr.isEmpty()){
				for(int m=0;m<followerarr.size();m++){
					followerslist.add(profprev.getFollowerslist((String)followerarr.get(m)));
				}
			}
			
			followmap.put("followers", followerslist);
			profileArr.add(followmap);
			
			HashMap guidancemap = new HashMap();
			ArrayList guidancelist = new ArrayList();
			BasicDBList guidancearr = (BasicDBList)theObj.get("guidanceids");
			if(!guidancearr.isEmpty()){
				for(int m=0;m<guidancearr.size();m++){
					guidancelist.add((String)guidancearr.get(m));
				}
			}
			
			guidancemap.put("guidance", guidancelist);
			profileArr.add(guidancemap);
			
			/*String[] followerarr = (String[])theObj.get("follwerids");
			if(followerarr != null){
				
				for(int k=0;k<followerarr.length;k++){
					followerslist.add(profprev.getFollowerslist(followerarr[k]));
				}
			}*/
			
			HashMap eventmap = new HashMap();
			ArrayList eventlist = new ArrayList();
			BasicDBList eventarr = (BasicDBList)theObj.get("eventids");
			if(!eventarr.isEmpty()){
				for(int m=0;m<eventarr.size();m++){
					eventlist.add((String)eventarr.get(m));
				}
			}
			
			eventmap.put("events", eventlist);
			profileArr.add(eventmap);
			
			
			HashMap skillmap = new HashMap();
			ArrayList skilllist = new ArrayList();
			BasicDBList skillarr = (BasicDBList)theObj.get("skilliset");
			if(!skillarr.isEmpty()){
				for(int m=0;m<skillarr.size();m++){
					skilllist.add(profprev.getSkilllist((String)skillarr.get(m)));
				}
			}
			
			skillmap.put("skills", skilllist);
			profileArr.add(skillmap);
			
			HashMap projectmap = new HashMap();
			ArrayList projectlist = new ArrayList();
			BasicDBList projectarr = (BasicDBList)theObj.get("projects");
			if(!projectarr.isEmpty()){
				for(int m=0;m<projectarr.size();m++){
					projectlist.add((String)projectarr.get(m));
				}
			}
			
			projectmap.put("projects", projectlist);
			profileArr.add(projectmap);
			
			HashMap coursemap = new HashMap();
			ArrayList courselist = new ArrayList();
			BasicDBList coursearr = (BasicDBList)theObj.get("courseids");
			if(!coursearr.isEmpty()){
				for(int m=0;m<coursearr.size();m++){
					courselist.add((String)coursearr.get(m));
				}
			}
			
			coursemap.put("courses", courselist);
			profileArr.add(coursemap);
			
			
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
			BasicDBList articlelist = (BasicDBList)theObj.get("articleids");
			if(!articlelist.isEmpty()){
				for(int m=0;m<articlelist.size();m++){
					articles.add(profprev.getArticlelist((String)articlelist.get(m)));
				}
			}
			/*String[] articlelist = (String[])theObj.get("articleids");
			if(articlelist != null){
				for(int i=0;i<articlelist.length;i++){
					articles.add(profprev.getArticlelist(articlelist[i]));
				}
			}*/
			articlemap.put("articles", articles);
			profileArr.add(articlemap);
			
			//connectionids
			HashMap connectionmap = new HashMap();
			ArrayList connections = new ArrayList();
			BasicDBList connectionlist = (BasicDBList)theObj.get("connectids");
			if(!connectionlist.isEmpty()){
				for(int m=0;m<connectionlist.size();m++){
					connections.add(profprev.getProfileInfo((String)connectionlist.get(m)));
				}
			}
			
			/*String[] connectionlist = (String[])theObj.get("connectids");
			if(connectionlist != null){
				
				for(int j=0;j<connectionlist.length;j++){
					connections.add(profprev.getProfileInfo(connectionlist[j]));
				}
				
			}*/
			connectionmap.put("connections",connections);
			profileArr.add(connectionmap);
			
			//followerids
			HashMap followmap = new HashMap();
			ArrayList followerslist = new ArrayList();
			BasicDBList followerarr = (BasicDBList)theObj.get("follwerids");
			if(!followerarr.isEmpty()){
				for(int m=0;m<followerarr.size();m++){
					followerslist.add(profprev.getFollowerslist((String)followerarr.get(m)));
				}
			}
			
			followmap.put("followers", followerslist);
			profileArr.add(followmap);
			
			
			
			/*String[] followerarr = (String[])theObj.get("follwerids");
			if(followerarr != null){
				
				for(int k=0;k<followerarr.length;k++){
					followerslist.add(profprev.getFollowerslist(followerarr[k]));
				}
			}*/
			
			HashMap eventmap = new HashMap();
			ArrayList eventlist = new ArrayList();
			BasicDBList eventarr = (BasicDBList)theObj.get("eventids");
			if(!eventarr.isEmpty()){
				for(int m=0;m<eventarr.size();m++){
					eventlist.add(profprev.getFollowerslist((String)eventarr.get(m)));
				}
			}
			
			eventmap.put("events", eventlist);
			profileArr.add(eventmap);
			
			
			HashMap guidancemap = new HashMap();
			ArrayList guidancelist = new ArrayList();
			BasicDBList guidancearr = (BasicDBList)theObj.get("guidanceids");
			if(!guidancearr.isEmpty()){
				for(int m=0;m<guidancearr.size();m++){
					guidancelist.add((String)guidancearr.get(m));
				}
			}
			
			guidancemap.put("guidance", guidancelist);
			profileArr.add(guidancemap);
			
			/*String[] followerarr = (String[])theObj.get("follwerids");
			if(followerarr != null){
				
				for(int k=0;k<followerarr.length;k++){
					followerslist.add(profprev.getFollowerslist(followerarr[k]));
				}
			}*/
			
			HashMap skillmap = new HashMap();
			ArrayList skilllist = new ArrayList();
			BasicDBList skillarr = (BasicDBList)theObj.get("skilliset");
			if(!skillarr.isEmpty()){
				for(int m=0;m<skillarr.size();m++){
					skilllist.add((String)skillarr.get(m));
				}
			}
			
			skillmap.put("skills", skilllist);
			profileArr.add(skillmap);
			
			HashMap projectmap = new HashMap();
			ArrayList projectlist = new ArrayList();
			BasicDBList projectarr = (BasicDBList)theObj.get("projects");
			if(!projectarr.isEmpty()){
				for(int m=0;m<projectarr.size();m++){
					projectlist.add((String)projectarr.get(m));
				}
			}
			
			projectmap.put("projects", projectlist);
			profileArr.add(projectmap);
			
			HashMap coursemap = new HashMap();
			ArrayList courselist = new ArrayList();
			BasicDBList coursearr = (BasicDBList)theObj.get("courseids");
			if(!coursearr.isEmpty()){
				for(int m=0;m<coursearr.size();m++){
					courselist.add((String)coursearr.get(m));
				}
			}
			
			coursemap.put("courses", courselist);
			profileArr.add(coursemap);
		}
		
		
		return profileArr;
	}
	
	private HashMap getSkilllist(String skillid) {
		// TODO Auto-generated method stub
		HashMap skillmap = new HashMap();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("skillid", skillid, "SkillSet");
		while(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			skillmap.put("skillname", (String)theObj.get("skillname"));
			ArrayList skillassesreslist = new ArrayList();
			BasicDBList skillasseslist = (BasicDBList)theObj.get("skillAssesment");
			for(int x=0;x<skillasseslist.size();x++){
				DBCursor skillcursor = mongocon.getDBObject("skillassesmentid", (String)skillasseslist.get(x), "SkillAssesment");
				if(skillcursor.hasNext()){
					DBObject skillObj = skillcursor.next();
					skillassesreslist.add((String)skillObj.get("skilldescription")+":"+(String)skillObj.get("skillfileid"));
				}
			}
			skillmap.put("skillasses", skillassesreslist);
			skillmap.put("skillid", skillid);
			
		}
		
		return skillmap;
	}
	
	private HashMap getProjectlist(String projectid) {
		// TODO Auto-generated method stub
		HashMap projmap = new HashMap();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("projectid", projectid, "ProfileProject");
		while(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			projmap.put("projectname", (String)theObj.get("projectname"));
			ArrayList projectasseslist = new ArrayList();
			BasicDBList projectlist = (BasicDBList)theObj.get("projectassesments");
			for(int x=0;x<projectlist.size();x++){
				DBCursor projcursor = mongocon.getDBObject("projectassesmentid", (String)projectlist.get(x), "ProfileProjectAssesment");
				if(projcursor.hasNext()){
					DBObject projObj = projcursor.next();
					projectasseslist.add((String)projObj.get("projectrole")+":"+(String)projObj.get("projectdescription")+":"+(String)projObj.get("projectfiles"));
				}
			}
			projmap.put("projectasses", projectasseslist);
			projmap.put("projectid", projectid);
		}
		
		return projmap;
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
		UploadFileService uploadser = new UploadFileService();
		
		String uniqueid = "";
		
		try {
			uniqueid = uploadser.makeSHA1Hash(username+password+userid+email);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		profile.setProfileid(uniqueid);
		
		
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
		basicdbobj.put("eventids", profile.getEventids());
		
		return basicdbobj;
	}


	public String getProfileEventList(String userid, String entrydatetime, String entryendtime) {
		// TODO Auto-generated method stub
		
		String eventlst = "";
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "Profile");
		
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			BasicDBList eventlist = (BasicDBList)theObj.get("eventids");
			if(!eventlist.isEmpty()){
				for(int m=0;m<eventlist.size();m++){
					DBCursor eventcursor = mongocon.getDBObject("eventid", (String)eventlist.get(m), "Event");
					
					if(eventcursor.hasNext()){
						DBObject eventObj = eventcursor.next();
						
						String starttime = (String)eventObj.get("eventstarttime");
						String endtime = (String)eventObj.get("eventendtime");
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:ss");
				        try
				        {
				            Date startdate = simpleDateFormat.parse(starttime);
				            Date givenstartdate = simpleDateFormat.parse(entrydatetime);
				            Date givenendtime = simpleDateFormat.parse(entryendtime);
				            Date enddate = simpleDateFormat.parse(endtime);

				            if(givenstartdate.after(startdate) || givenendtime.before(enddate)|| givenendtime.after(startdate)|| givenstartdate.before(enddate)){
				            	
				            	eventlst = "true";
				            	
				            }
				            
				        }
				        catch (ParseException ex)
				        {
				            System.out.println("Exception "+ex);
				        }
						
					}
					
					
				}
			}
			
		}
		
		
		return eventlst;
	}


	public void saveSkillToProfileInfo(String skillname, String skilldesc, String skilltoken, String userid, String skilllocation) {
		// TODO Auto-generated method stub
		ProfilePreview profprev = new ProfilePreview();
		
		String fileid = "";
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("tempid", skilltoken, "FileUnionTimeFrame");
		while(resultcursor.hasNext() ){
			
			DBObject dbj = resultcursor.next();
			
			String userids = (String)dbj.get("userid");
			if(userids.equalsIgnoreCase(userid)){
				
				fileid = (String)dbj.get("fileid");
			}
			
		}
		UploadFileService uploadser = new UploadFileService();
		String uniqueid = "";
		
		try {
			uniqueid = uploadser.makeSHA1Hash(skillname+userid+skilltoken);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SkillAssesment skillasses = new SkillAssesment();
		skillasses.setSkillassesmentid(uniqueid);
		skillasses.setSkilldescription(skilldesc);
		skillasses.setSkillfileid(fileid);
		
		String[] skillAssesment = {uniqueid};
		
		
		DateFunctionality datefunc = new DateFunctionality();
		//datefunc.getDateSystems();
		
		SkillSet skillset = new SkillSet();
		skillset.setSkillid(uniqueid);
		skillset.setSkillAssesment(skillAssesment);
		skillset.setSkilldatetime(datefunc.getDateSystems());
		skillset.setSkilllocation(skilllocation);
		skillset.setSkillname(skillname);
		
		
		BasicDBObject basicsksetskobj =  profprev.formProfileSkillDBObject(skillset);
		mongocon.saveObject(basicsksetskobj, "SkillSet");
		
		BasicDBObject basicskassobj =  profprev.formProfileSkillAssesDBObject(skillasses);
		mongocon.saveObject(basicskassobj, "SkillAssesment");
		
		mongocon.updateObject(new BasicDBObject("userid", userid),new BasicDBObject("$push", new BasicDBObject("skilliset", uniqueid)), "Profile");
		
	}
	
	
	public void saveAchievToSkill(String skilldata,String token,String userids,String skillid) {
		// TODO Auto-generated method stub
		ProfilePreview profprev = new ProfilePreview();
		
		String fileid = "";
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("tempid", token, "FileUnionTimeFrame");
		while(resultcursor.hasNext() ){
			
			DBObject dbj = resultcursor.next();
			
			String userid = (String)dbj.get("userid");
			if(userids.equalsIgnoreCase(userid)){
				
				fileid = (String)dbj.get("fileid");
			}
			
		}
		UploadFileService uploadser = new UploadFileService();
		String uniqueid = "";
		
		try {
			uniqueid = uploadser.makeSHA1Hash(skilldata+token);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SkillAssesment skillasses = new SkillAssesment();
		skillasses.setSkillassesmentid(uniqueid);
		skillasses.setSkilldescription(skilldata);
		skillasses.setSkillfileid(fileid);
		
		DateFunctionality datefunc = new DateFunctionality();
		//datefunc.getDateSystems();
		
				
		BasicDBObject basicskassobj =  profprev.formProfileSkillAssesDBObject(skillasses);
		mongocon.saveObject(basicskassobj, "SkillAssesment");
		
		mongocon.updateObject(new BasicDBObject("skillid", skillid),new BasicDBObject("$push", new BasicDBObject("skillAssesment", uniqueid)), "SkillSet");
		
	}


	private BasicDBObject formProfileSkillAssesDBObject(SkillAssesment skillasses) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("skillassesmentid", skillasses.getSkillassesmentid());
		basicdbobj.put("skilldescription", skillasses.getSkilldescription());
		basicdbobj.put("skillfileid", skillasses.getSkillfileid());
				
		return basicdbobj;
	}


	private BasicDBObject formProfileSkillDBObject(SkillSet skillset) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("skillAssesment", skillset.getSkillAssesment());
		basicdbobj.put("skilldatetime", skillset.getSkilldatetime());
		basicdbobj.put("skillid", skillset.getSkillid());
		basicdbobj.put("skilllocation", skillset.getSkilllocation());
		basicdbobj.put("skillname", skillset.getSkillname());
		
		return basicdbobj;
	}


	public void saveProjectToProfileInfo(String projectname, String projectskill, String projectrole,
			String projectdata, String location, String userid) {
		// TODO Auto-generated method stub
		ProfilePreview profprev = new ProfilePreview();
		//String[] projectskills = projectskill.split(",");
		
		UploadFileService uploadser = new UploadFileService();
		String uniqueid = "";
		
		try {
			uniqueid = uploadser.makeSHA1Hash(projectname+projectrole);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DateFunctionality datefunc = new DateFunctionality();
		
		ProfileProjects profproj = new ProfileProjects();
		profproj.setProjectid(uniqueid);
		profproj.setProjectdescription(projectdata);
		profproj.setProjectlocation(location);
		profproj.setProjectname(projectname);
		profproj.setProjectrole(projectrole);
		profproj.setProjectdate(datefunc.getDateSystems());
		profproj.setProjectskill(projectskill.split(","));
		
		MongoConnection mongocon = new MongoConnection();
		BasicDBObject basicprojkobj =  profprev.formProfileProjDBObject(profproj);
		mongocon.saveObject(basicprojkobj, "ProfileProject");
		
		mongocon.updateObject(new BasicDBObject("userid", userid),new BasicDBObject("$push", new BasicDBObject("projects", uniqueid)), "Profile");
		
	}


	private BasicDBObject formProfileProjDBObject(ProfileProjects profproj) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("projectdate", profproj.getProjectdate());
		basicdbobj.put("projectdescription", profproj.getProjectdescription());
		basicdbobj.put("projectid", profproj.getProjectid());
		basicdbobj.put("projectlocation", profproj.getProjectlocation());
		basicdbobj.put("projectname", profproj.getProjectname());
		basicdbobj.put("projectrole", profproj.getProjectrole());
		basicdbobj.put("projectskill", profproj.getProjectskill());
		
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
