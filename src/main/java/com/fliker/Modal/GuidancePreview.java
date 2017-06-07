package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Assignment;
import com.fliker.Repository.Blog;
import com.fliker.Repository.DashBoardData;
import com.fliker.Repository.Guidance;
import com.fliker.Repository.GuidanceContent;
import com.fliker.Repository.GuidanceContentDashboard;
import com.fliker.Repository.GuidanceContentFiles;
import com.fliker.Repository.GuidanceContentShared;
import com.fliker.Repository.GuidanceEntry;
import com.fliker.Repository.Post;
import com.fliker.Repository.Profile;
import com.fliker.Repository.SearchContent;
import com.fliker.Repository.Share;
import com.fliker.Repository.Timetable;
import com.fliker.Utility.DateFunctionality;
import com.fliker.Utility.ServicesUtil;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class GuidancePreview {

  public ArrayList getGuidance(String lastid){
		
		ArrayList postlist = new ArrayList();
		
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("GuidanceSelection");
		DBCursor cursor;
		if(lastid.isEmpty()){
			cursor = collection.find().limit(50).sort(new BasicDBObject("profileid",-1));
		}else{
			cursor = collection.find(new BasicDBObject("profileid", lastid)).limit(50).sort(new BasicDBObject("profileid",-1));
		}
		
		while(cursor.hasNext()){
			postlist.add(cursor.next());
		}
		
		
		return postlist;
	}
  
  
  public ArrayList onGoingResources( String userid){
		
	  ArrayList guidancelist = new ArrayList<Post>();

	  	MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("provideruserid", userid, "GuidanceContent");
		/*if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();*/

		while (resultcursor.hasNext()) {

			DBObject dbj = resultcursor.next();
			HashMap totalSet = new HashMap();
			GuidancePreview guidprev = new GuidancePreview();
			
				totalSet.put("sharetokenid", (String)dbj.get("sharetokenid"));
				totalSet.put("dashboardid", (String)dbj.get("dashboardid"));
				totalSet.put("averageVelocity", (String)dbj.get("averageVelocity"));
				totalSet.put("blogid", (String)dbj.get("blogid"));
				
				BasicDBList likedlist = (BasicDBList)dbj.get("likeid");
				BasicDBList sharedlist = (BasicDBList)dbj.get("sharedid");
				
				totalSet.put("likeid", likedlist.size());
				totalSet.put("shareid", sharedlist.size());
				
				Guidance guidance = guidprev.getGuidanceSection((String)dbj.get("guidanceid"));
				
				totalSet.put("guidanceduration", guidance.getGuidanceduration());
				totalSet.put("guidancelocation", guidance.getGuidancelocation());
				totalSet.put("guidancereason", guidance.getGuidancereason());
				totalSet.put("guidancesubject", guidance.getGuidanceSubject());
				totalSet.put("guidancetype", guidance.getGuidencetype());
				
				
				ProfilePreview profprev = new ProfilePreview();
				BasicDBList consumeridslist = (BasicDBList)dbj.get("consumeruserid");
				/*for(int i=0;i<fileids.size();i++){ 
					String fileid = (String);
					fileids.get(i); System.out.println("fileid ++"+fileid); }*/
				LinkedList consumerlist = new LinkedList();
				
				for(int n=0;n<consumeridslist.size();n++){
					
					ArrayList profileinfo = profprev.getProfileInfo((String)consumeridslist.get(n));
					
					
					for(int m=0;m<profileinfo.size();m++){
						
						if(profileinfo.get(m) instanceof Profile){
							Profile profileinfos = (Profile)profileinfo.get(m);
							
							HashMap profileset = new HashMap();
							
							profileset.put("profileid", profileinfos.getProfileid());
							profileset.put("profileImage", profileinfos.getProfileImageid());
							profileset.put("profileName", profileinfos.getName());
							profileset.put("userid", profileinfos.getUserid());
							
							consumerlist.add(profileset);
							
						}
						
						
					}
				
				}
				
				String nextmeeting = guidprev.getnextMeeting((String)dbj.get("timetableid"));
				
				totalSet.put("nextmeeting", nextmeeting);
				String topiccount = guidprev.getNumberOfBlogsTopics((String)dbj.get("blogid"), userid);
				totalSet.put("topiccount", topiccount);
				totalSet.put("consumerids",consumerlist);
				
				totalSet.put("guidanceid", (String)dbj.get("guidanceid"));
				totalSet.put("timetableid", (String)dbj.get("timetableid"));
				
				ArrayList providerprofileinfo = profprev.getProfileInfo((String)dbj.get("provideruserid"));
				
				
				for(int m=0;m<providerprofileinfo.size();m++){
					
					if(providerprofileinfo.get(m) instanceof Profile){
						Profile profileinfos = (Profile)providerprofileinfo.get(m);
						
						totalSet.put("providerprofileid", profileinfos.getProfileid());
						totalSet.put("providerprofileimage", profileinfos.getProfileImageid());
						totalSet.put("providername", profileinfos.getName());
						totalSet.put("provideruserid", profileinfos.getUserid());
						
						//consumerlist.add(profileset);
						
					}
					
					
				}
				
				//totalSet.put("provideruserid", (String)dbj.get("provideruserid"));
				
			
			guidancelist.add(totalSet);
		}
		
		
		MongoConnection mongoconnew = new MongoConnection();
		DBCursor resultcursornew = mongoconnew.getDBObject("consumeruserid", userid, "GuidanceContent");
		
		while (resultcursornew.hasNext()) {

			DBObject dbj = resultcursornew.next();
			HashMap totalSet = new HashMap();
			GuidancePreview guidprev = new GuidancePreview();
			
			totalSet.put("sharetokenid", (String)dbj.get("sharetokenid"));
			totalSet.put("dashboardid", (String)dbj.get("dashboardid"));
			totalSet.put("averageVelocity", (String)dbj.get("averageVelocity"));
			totalSet.put("blogid", (String)dbj.get("blogid"));
			
			Guidance guidance = guidprev.getGuidanceSection((String)dbj.get("guidanceid"));
			
			totalSet.put("guidanceduration", guidance.getGuidanceduration());
			totalSet.put("guidancelocation", guidance.getGuidancelocation());
			totalSet.put("guidancereason", guidance.getGuidancereason());
			totalSet.put("guidancesubject", guidance.getGuidanceSubject());
			totalSet.put("guidancetype", guidance.getGuidencetype());
			
			
			ProfilePreview profprev = new ProfilePreview();
			BasicDBList consumeridslist = (BasicDBList)dbj.get("consumeruserid");
			LinkedList consumerlist = new LinkedList();
			
			for(int n=0;n<consumeridslist.size();n++){
				
				ArrayList profileinfo = profprev.getProfileInfo((String)consumeridslist.get(n));
				
				
				for(int m=0;m<profileinfo.size();m++){
					
					if(profileinfo.get(m) instanceof Profile){
						Profile profileinfos = (Profile)profileinfo.get(m);
						
						HashMap profileset = new HashMap();
						
						profileset.put("profileid", profileinfos.getProfileid());
						profileset.put("profileImage", profileinfos.getProfileImageid());
						profileset.put("profileName", profileinfos.getName());
						profileset.put("userid", profileinfos.getUserid());
						
						consumerlist.add(profileset);
						
					}
					
					
				}
			
			}
			
			String nextmeeting = guidprev.getnextMeeting((String)dbj.get("timetableid"));
			
			totalSet.put("nextmeeting", nextmeeting);
			String topiccount = guidprev.getNumberOfBlogsTopics((String)dbj.get("blogid"), userid);
			totalSet.put("topiccount", topiccount);
			totalSet.put("consumerids",consumerlist);
			
			totalSet.put("guidanceid", (String)dbj.get("guidanceid"));
			totalSet.put("timetableid", (String)dbj.get("timetableid"));
			
			ArrayList providerprofileinfo = profprev.getProfileInfo((String)dbj.get("provideruserid"));
			
			
			for(int m=0;m<providerprofileinfo.size();m++){
				
				if(providerprofileinfo.get(m) instanceof Profile){
					Profile profileinfos = (Profile)providerprofileinfo.get(m);
					
					HashMap profileset = new HashMap();
					
					totalSet.put("providerprofileid", profileinfos.getProfileid());
					totalSet.put("providerprofileimage", profileinfos.getProfileImageid());
					totalSet.put("providername", profileinfos.getName());
					totalSet.put("provideruserid", profileinfos.getUserid());
					
					consumerlist.add(profileset);
					
				}
				
				
			}
			
			//totalSet.put("provideruserid", (String)dbj.get("provideruserid"));
				
			
			guidancelist.add(totalSet);
		}
		
		return guidancelist;
	  
	}
  
  
  
  private Guidance getGuidanceSection(String guidanceid) {
	// TODO Auto-generated method stub
	
	  
	  Guidance guidance = new Guidance();
	  MongoConnection mongoconnew = new MongoConnection();
		DBCursor resultcursornew = mongoconnew.getDBObject("guidanceid", guidanceid, "GuidanceSelection");
		
		if (resultcursornew.hasNext()) {

			DBObject dbj = resultcursornew.next();
			
			guidance.setGuidanceduration((String)dbj.get("guidanceduration"));
			guidance.setGuidanceflag((String)dbj.get("guidanceflag"));
			guidance.setGuidancelocation((String)dbj.get("guidancelocation"));
			guidance.setGuidancereason((String)dbj.get("guidancereason"));
			guidance.setGuidanceSubject((String)dbj.get("guidanceSubject"));
			guidance.setGuidencetype((String)dbj.get("guidencetype"));
			
		}
	  return guidance;
	  
  }


public ArrayList getGuidanceResources( String subject, String guidancetype){
		
		/*ArrayList postlist = new ArrayList();
		
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("GuidanceSelection");
		DBCursor cursor;
		if(lastid.isEmpty()){
			cursor = collection.find().limit(50).sort(new BasicDBObject("guidanceid",-1));
		}else{
			cursor = collection.find(new BasicDBObject("guidanceid", lastid)).limit(50).sort(new BasicDBObject("guidanceid",-1));
		}
		
		while(cursor.hasNext()){
			postlist.add(cursor.next());
		}
		
		ArrayList guidancelist =  new ArrayList();
		
		for (int i = 0; i < postlist.size(); i++) {
			System.out.println("postlist.size() ><><" + postlist.size());
			HashMap perPostSet = (HashMap) postlist.get(i);
			Set perset = perPostSet.entrySet();
			Iterator perit = perset.iterator();
			while (perit.hasNext()) {
				
				Map.Entry perme = (Map.Entry) perit.next();

				String keyvalue = (String) perme.getKey();
				
				System.out.println(perme.getValue());

				if (keyvalue.equalsIgnoreCase("guidanceSubject")) {
					
					BasicDBList basicdb = (BasicDBList)perme.getValue();
					
					for(int m = 0;m< basicdb.size(); m++){
						String guidencesub = (String)basicdb.get(m);
						if(guidencesub.equalsIgnoreCase(subject)){
							guidancelist.add(postlist.get(i));
						}
						//System.out.println(imageid);
					}
					
				}
			}
			
		}
		
		
		return guidancelist;*/
	  
	  
	  ArrayList guidancelist = new ArrayList<Post>();

		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("GuidanceSelection");
		DBCursor cursor;
		cursor = collection.find().limit(20).sort(new BasicDBObject("guidanceid", -1));

		while (cursor.hasNext()) {

			DBObject dbj = cursor.next();
			HashMap totalSet = new HashMap();
			
			
			if(((dbj.get("guidanceSubject").toString()).equalsIgnoreCase(subject))&& ((dbj.get("guidencetype").toString()).equalsIgnoreCase(guidancetype))){
				totalSet.put("guidanceid", (String)dbj.get("guidanceid"));
				totalSet.put("guidanceSubject", (String)dbj.get("guidanceSubject"));
				totalSet.put("guidanceflag", (String)dbj.get("guidanceflag"));
				totalSet.put("guidencetype", (String)dbj.get("guidencetype"));
				ProfilePreview profprev = new ProfilePreview();
				ArrayList profileinfo = profprev.getProfileInfo((String)dbj.get("userid"));
				for(int m=0;m<profileinfo.size();m++){
					
					if(profileinfo.get(m) instanceof Profile){
						Profile profileinfos = (Profile)profileinfo.get(m);
						
						totalSet.put("profileid", (String)dbj.get("profileid"));
						totalSet.put("profileImage", (String)dbj.get("profileImageid"));
						totalSet.put("profileName", (String)dbj.get("name"));
						
					}
					
					
				}
				
				totalSet.put("userid", (String)dbj.get("userid"));
				
			}
			
			
			
			guidancelist.add(totalSet);
		}

		
		
		return guidancelist;
	  
	  
	}
  
  
  public ArrayList getNextSetGuidanceResources(String pageno, String subject){
		
	  ArrayList guidancelist = new ArrayList<Post>();

		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("GuidanceSelection");
		DBCursor cursor;
		int pagenos = Integer.parseInt(pageno);
		cursor = collection.find().skip(20*pagenos).limit(20).sort(new BasicDBObject("guidanceid", -1));

		while (cursor.hasNext()) {

			DBObject dbj = cursor.next();
			HashMap totalSet = new HashMap();
			
			
			if((dbj.get("guidanceflag").toString()).equalsIgnoreCase(subject)){
				totalSet.put("guidanceid", dbj.get("guidanceid"));
				totalSet.put("guidanceSubject", dbj.get("guidanceSubject"));
				totalSet.put("guidanceflag", dbj.get("guidanceflag"));
				totalSet.put("guidencetype", dbj.get("guidencetype"));
			}
			
			
			
			guidancelist.add(totalSet);
		}

		
		
		return guidancelist;
	  
	  
	}

	
  public String saveGidance(String userid, String guidancesubjects,String guidancereason, HttpServletRequest request, String guidanceflag, String guidenctype, String location, String published, String duration){
		
	  ArrayList profileinfo = new ArrayList();
	  
	  System.out.println("in dashboard social controller"+guidancesubjects+guidancereason+location+published+guidanceflag+duration);
		Guidance guidance = new Guidance();
		
		guidance.setGuidanceSubject(guidancesubjects);
		guidance.setUserid(userid);
		guidance.setGuidanceflag(guidanceflag);
		guidance.setGuidencetype(guidenctype);
		guidance.setGuidanceduration(duration);
		guidance.setGuidancelocation(location);
		guidance.setGuidancereason(guidancereason);
		
		GuidancePreview guidanceprev = new GuidancePreview();
		
		
		String uniqueid = "";
		
		try {
			uniqueid = guidanceprev.makeSHA1Hash(guidancesubjects+userid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		guidance.setGuidanceid(uniqueid);
		
		String guidanceid = guidance.getGuidanceid();
		
		MongoConnection mongocon = new MongoConnection();
		
		BasicDBObject basicreqobj =  guidanceprev.formDBObject(guidance);
		
		mongocon.saveObject(basicreqobj, "GuidanceSelection");
		//lots of operation needed to do here
		
		
		guidanceprev.searchContent(userid, uniqueid, guidancesubjects);
		
		//mongoOperation.save(postentry);
		
		System.out.println("Published ::"+published);
		guidanceprev.publishContent(userid, uniqueid, guidancesubjects,location);
		
		return uniqueid;
		
	}
	
  


  public String makeSHA1Hash(String input)
          throws NoSuchAlgorithmException, UnsupportedEncodingException
      {
          MessageDigest md = MessageDigest.getInstance("SHA1");
          md.reset();
          byte[] buffer = input.getBytes("UTF-8");
          md.update(buffer);
          byte[] digest = md.digest();

          String hexStr = "";
          for (int i = 0; i < digest.length; i++) {
              hexStr +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
          }
          return hexStr;
      }

  public BasicDBObject formDBObject(Guidance guidance){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("guidanceid", guidance.getGuidanceid());
		basicdbobj.put("userid", guidance.getUserid());
		basicdbobj.put("guidanceSubject", guidance.getGuidanceSubject());
		basicdbobj.put("guidanceduration", guidance.getGuidanceduration());
		basicdbobj.put("guidanceflag", guidance.getGuidanceflag());
		basicdbobj.put("guidancelocation", guidance.getGuidancelocation());
		basicdbobj.put("guidencetype", guidance.getGuidencetype());
		basicdbobj.put("guidancereason", guidance.getGuidancereason());
		
		
		return basicdbobj;
		
	}
  
  public BasicDBObject formGuidanceContentDBObject(GuidanceContent guidancecontent){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("guidanceid", guidancecontent.getGuidanceid());
		basicdbobj.put("provideruserid", guidancecontent.getProvideruserid());
		basicdbobj.put("consumeruserid", guidancecontent.getConsumeruserid());
		basicdbobj.put("sharetokenid", guidancecontent.getSharetokenid());
		basicdbobj.put("dashboardid", guidancecontent.getDashboardid());
		basicdbobj.put("averageVelocity", guidancecontent.getAverageVelocity());
		basicdbobj.put("blogid", guidancecontent.getBlogid());
		basicdbobj.put("timetableid", guidancecontent.getTimetableid());
		basicdbobj.put("likeid", guidancecontent.getLikeid());
		basicdbobj.put("sharedid", guidancecontent.getSharedid());
		basicdbobj.put("price", guidancecontent.getPrice());
		
		return basicdbobj;
		
	}
  
  public BasicDBObject formGuidanceContentDashDBObject(GuidanceContentDashboard guidancecontentdash){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("guidancecontentDashid", guidancecontentdash.getGuidancecontentDashid());
		
		return basicdbobj;
	}
  
  public BasicDBObject formGuidanceContentShareDBObject(GuidanceContentShared guidancecontentshare){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("guidancesharedid", guidancecontentshare.getGuidancesharedid());
		return basicdbobj;
	}
  
  public BasicDBObject formBlogDBObject(Blog blog){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("blogid", blog.getBlogid());
		return basicdbobj;
		
	}
  
  public BasicDBObject formTimetableDBObject(Timetable timetable){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("timeableid", timetable.getTimeableid());
		return basicdbobj;
		
	}
  
  public String formLink(String url, String context, String linkadd, String ideaworkid)throws NullPointerException{
		
		URI uri;
		String domain=null;
		try {
			uri = new URI(url);
			domain = uri.getHost();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		String link = domain+"/"+context+"/"+linkadd+"?"+ideaworkid;
		
		return link;
		
	}


  public void applyForGuidance(String guidanceSubject, String userid, String guidencetype, String guidanceuserid, String guidanceid, String guidanceprice) {
	// TODO Auto-generated method stub
	  
	  String[] consumers = new String[0];
	  System.out.println("guidanceSubject >>"+guidanceSubject+" guidencetype >>"+guidencetype+" guidanceuserid >>"+guidanceuserid);
	  
	  PublishPreview pubprev = new PublishPreview();
	  String[] likeid = new String[0];
	  String[] sharedid = new String[0];
	  GuidanceContent guidancecontent = new GuidanceContent();
	  GuidancePreview guidanceprev = new GuidancePreview();
	  GuidanceContentDashboard guidancecondash = new GuidanceContentDashboard();
	  GuidanceContentShared guidanceshare = new GuidanceContentShared();
	  //GuidanceContentFiles guidancecontfile = new GuidanceContentFiles();
	  
		guidancecontent.setConsumeruserid(consumers);
		guidancecontent.setDashboardid(guidanceid);
		guidancecontent.setGuidanceid(guidanceid);
		guidancecontent.setProvideruserid(guidanceuserid);
		guidancecontent.setSharetokenid(guidanceid);
		guidancecontent.setTimetableid(guidanceid);
		guidancecontent.setAverageVelocity("0");
		guidancecontent.setBlogid(guidanceid);
		guidancecontent.setLikeid(likeid);
		guidancecontent.setSharedid(sharedid);
		guidancecontent.setPrice(guidanceprice);
		
		MongoConnection mongocon = new MongoConnection();
		
		BasicDBObject basicreqobj =  guidanceprev.formGuidanceContentDBObject(guidancecontent);
		
		mongocon.saveObject(basicreqobj, "GuidanceContent");
		
		guidancecondash.setGuidancecontentDashid(guidancecontent.getDashboardid());
		
		guidanceshare.setGuidancesharedid(guidancecontent.getSharetokenid());
		
		//guidanceprev.searchContent(userid, uniqueid, guidanceSubject);
		
		//pubprev.publishtopublisher(guidanceSubject, userid, guidencetype, guidanceuserid, uniqueid);
		
	
  }


	public void applicationGuide(String guidanceSubject, String userid, String guidencetype, String guidanceuserid) {
		// TODO Auto-generated method stub
		
		GuidancePreview guidanceprev = new GuidancePreview();
		PublishPreview pubprev = new PublishPreview();
		
		String uniqueid = "";
		
		try {
			uniqueid = guidanceprev.makeSHA1Hash(guidanceSubject+userid+guidencetype);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		guidanceprev.searchContent(userid, uniqueid, guidanceSubject);
		
		pubprev.publishtopublisher(guidanceSubject, userid, guidencetype, guidanceuserid, uniqueid);
		
	}
	
	
	

  	public void searchContent(String userid,String uniqueid, String guidanceSubject){
  		
  		ArrayList profilelist = new ArrayList();
		ProfilePreview profprev = new ProfilePreview();
		profilelist = profprev.getProfileInfo(userid);
		
		String imageid = "";
		String profileid = "";
		String skypeid = "";
		String name = "";
		String emailid = "";
		String currentStatus="";
		String experience = "";
		String hangoverid = "";
		String salary = "";
		String tellaboutme = "";
		String contact = "";
		int articlecount = 0;
		int connectioncount = 0;
		int followercount = 0;
		
		
		for(int m=0;m<profilelist.size();m++){
			
			
			if(profilelist.get(m) instanceof Profile){
				Profile profileinform = (Profile)profilelist.get(m);
				imageid = profileinform.getProfileImageid();
				skypeid = profileinform.getSkypeid();
				name = profileinform.getName();
				emailid = profileinform.getEmailid();
				currentStatus = profileinform.getCurrentStatus();
				experience = profileinform.getExperience();
				hangoverid = profileinform.getHangoverid();
				contact = profileinform.getContact();
				
			}/*else{
				HashMap collectionlist = (HashMap)profilelist.get(m);
				Set collectionset = collectionlist.entrySet();
				Iterator collit = collectionset.iterator();
				while(collit.hasNext()){
					
					Map.Entry mecoll = (Map.Entry)collit.next();
					String collectionresul = (String)mecoll.getKey();
					
					if(collectionresul.equalsIgnoreCase("articles")){
						ArrayList articlelist = (ArrayList)mecoll.getValue();
						if(articlelist!= null){
							articlecount = articlelist.size();
						}
						
					}
				}
			}*/
			
		}
		
		SearchContent searchcontent = new SearchContent();
		searchcontent.setSearchid(uniqueid);
		searchcontent.setContentDescription("Guidance Subject ::"+guidanceSubject+",Profile Image ::"+imageid+",Profile SkypeID ::"+skypeid+",Profile Name ::"+name+",Profile Email ::"+emailid+",Profile CurrenStatus ::"+currentStatus
				+",Profile Experience ::"+experience+",Profile HangOver ID ::"+hangoverid+",Profile Contact ::"+contact);
		searchcontent.setContentLink("");
		searchcontent.setContentType("Apply For Guidance");
		
		MongoConnection mongoconsearch = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch =  searchprev.formDBObject(searchcontent);
		
		mongoconsearch.saveObject(basicreqobjsearch, "SearchContent");
  		
  		
  	}
  
  	
  	 private void publishContent(String userid, String uniqueid, String guidancesubject, String location) {
 		// TODO Auto-generated method stub
 		
 		  
  		ArrayList profilelist = new ArrayList();
		ProfilePreview profprev = new ProfilePreview();
		profilelist = profprev.getProfileInfo(userid);
		
		String imageid = "";
		String profileid = "";
		String skypeid = "";
		String name = "";
		String emailid = "";
		String currentStatus="";
		String experience = "";
		String hangoverid = "";
		String salary = "";
		String tellaboutme = "";
		String contact = "";
		int articlecount = 0;
		int connectioncount = 0;
		int followercount = 0;
		
		
		for(int m=0;m<profilelist.size();m++){
			
			
			if(profilelist.get(m) instanceof Profile){
				Profile profileinform = (Profile)profilelist.get(m);
				imageid = profileinform.getProfileImageid();
				skypeid = profileinform.getSkypeid();
				name = profileinform.getName();
				emailid = profileinform.getEmailid();
				currentStatus = profileinform.getCurrentStatus();
				experience = profileinform.getExperience();
				hangoverid = profileinform.getHangoverid();
				contact = profileinform.getContact();
				
			}else{
				HashMap collectionlist = (HashMap)profilelist.get(m);
				Set collectionset = collectionlist.entrySet();
				Iterator collit = collectionset.iterator();
				while(collit.hasNext()){
					
					Map.Entry mecoll = (Map.Entry)collit.next();
					String collectionresul = (String)mecoll.getKey();
					
					if(collectionresul.equalsIgnoreCase("articles")){
						ArrayList articlelist = (ArrayList)mecoll.getValue();
						if(articlelist!= null){
							articlecount = articlelist.size();
						}
						
					}
				}
			}
			
		}
		
		String PostComment = name+"is providing Guidance for the subject "+guidancesubject;
		
		PostPreview postprev = new PostPreview();
		postprev.publishGuidance(userid, PostComment, location);
 		  
 		  
 	  }


	public HashMap getDashBoardData(String guidanceid) {
		
		HashMap dashboarddata = new HashMap();
		HashMap assignmentdata = new HashMap();
		HashMap actualdata = new HashMap();
		HashMap truedata = new HashMap();
		HashMap assignmentperprogress = new HashMap();
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			String dashboardid = (String)theObj.get("dashboardid");
			
			MongoConnection mongoconint = new MongoConnection();
			DBCursor guidcursor = mongoconint.getDBObject("guidancecontentDashid", guidanceid, "GuidanceContentDash");
			
			if(guidcursor.hasNext()){
				
				DBObject theObjgrid = guidcursor.next();
				
				String[] dashboardids = (String[])theObjgrid.get("guidancedashdataid");
				
				for(int m=0;m<dashboardids.length;m++){
					
					MongoConnection mongocondash = new MongoConnection();
					DBCursor dashcursor = mongocondash.getDBObject("dashdataid", dashboardids[m], "DashBoardData");
					
					if(dashcursor.hasNext()){
						
						DBObject theObjdash = dashcursor.next();
						if(((String)theObjdash.get("dashdatatype")).equalsIgnoreCase("assignment")){
							assignmentdata.put((String)theObjdash.get("dashXdata"), (String)theObjdash.get("dashYdata"));
						}else if(((String)theObjdash.get("dashdatatype")).equalsIgnoreCase("truedata")){
							truedata.put((String)theObjdash.get("dashXdata"), (String)theObjdash.get("dashYdata"));
						}else if(((String)theObjdash.get("dashdatatype")).equalsIgnoreCase("actualdata")){
							actualdata.put((String)theObjdash.get("dashXdata"), (String)theObjdash.get("dashYdata"));
						}
						
					}
					
				}
				
				
			}
			if(!assignmentdata.isEmpty()){
				dashboarddata.put("assignment", assignmentdata);
			}
			if(!truedata.isEmpty()){
				dashboarddata.put("truedata", truedata);
			}
			if(!actualdata.isEmpty()){
				dashboarddata.put("actualdata", actualdata);
			}
		}
		return dashboarddata;
	}


	public ArrayList getGuidanceTimeTable(String timetableid) {
		// TODO Auto-generated method stub
		
		ArrayList timetablelist = new ArrayList();
		
		
		return timetablelist;
	}


	public Timetable getTimeTableInfo(String guidanceid) {
		// TODO Auto-generated method stub
		String timelineids = "";
		Timetable timetable = new Timetable();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			timelineids = (String)theObj.get("timetableid");
			
			MongoConnection mongotimecon = new MongoConnection();
			DBCursor timecursor = mongotimecon.getDBObject("timeableid", timelineids, "Timetable");
			if(timecursor.hasNext()){
				DBObject theObjtime = timecursor.next();
				
				timetable.setTimeableid((String)theObjtime.get("timetableid"));
				timetable.setEventid((String[])theObjtime.get("eventid"));
				
			}
			
		}
		return timetable;
	}


	public ArrayList getGuidanceData(String guidanceid) {
		// TODO Auto-generated method stub
		return null;
	}


	public GuidanceContentShared getSharedInfo(String guidanceid) {
		// TODO Auto-generated method stub
		String shareids = "";
		GuidanceContentShared guidshared = new GuidanceContentShared();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			shareids = (String)theObj.get("sharetokenid");
			
			MongoConnection mongotimecon = new MongoConnection();
			DBCursor timecursor = mongotimecon.getDBObject("guidancesharedid", shareids, "GuidanceContentShare");
			if(timecursor.hasNext()){
				DBObject theObjtime = timecursor.next();
				
				guidshared.setGuidancesharedid((String)theObjtime.get("guidancesharedid"));
				guidshared.setGuidancefilelistid((String[])theObjtime.get("guidancefilelistid"));
				
			}
			
		}
		return guidshared;
	}


	public GuidanceContentDashboard getDashBoardGuidance(String guidanceid) {
		// TODO Auto-generated method stub
		
		String dashboardid = "";
		GuidanceContentDashboard guidancedash = new GuidanceContentDashboard();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		
			dashboardid = (String)theObj.get("dashboardid");
			MongoConnection mongotimecon = new MongoConnection();
			DBCursor timecursor = mongotimecon.getDBObject("guidancecontentDashid", dashboardid, "GuidanceContentDash");
			if(timecursor.hasNext()){
				DBObject theObjtime = timecursor.next();
			
				guidancedash.setGuidancecontentDashid((String)theObjtime.get("guidancecontentDashid"));
				guidancedash.setGuidancedashdataid((String[])theObjtime.get("guidancedashdataid"));
				guidancedash.setGuidancefilelistid((String[])theObjtime.get("guidancefilelistid"));
				
				
				
			}
			
		}
		
		
		return guidancedash;
		
	}


	public Blog getGuidanceBlogs(String guidanceid) {
		// TODO Auto-generated method stub
		
		String guidblogid ="";
		Blog guidblog	= new Blog();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		
			guidblogid = (String)theObj.get("blogid");
			MongoConnection mongotimecon = new MongoConnection();
			DBCursor timecursor = mongotimecon.getDBObject("blogid", guidblogid, "Blog");
			if(timecursor.hasNext()){
				DBObject theObjtime = timecursor.next();
				
				guidblog.setBlogid((String)theObjtime.get("blogid"));
				guidblog.setTopicid((String[])theObjtime.get("topicid"));
				guidblog.setBlogaccessuserids((String[])theObjtime.get("blogaccessuserids"));
				guidblog.setBlogactive((String)theObjtime.get("blogactive"));
				guidblog.setBlogname((String)theObjtime.get("blogname"));
				
			}
			
			
		}
		
		return guidblog;
	}


	public HashMap getTimeTable(String guidanceid, String month) {
		// TODO Auto-generated method stub
		
		String available = "False";
		HashMap eventmap = new HashMap();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		
			String timetableid = (String)theObj.get("timetableid");
			MongoConnection mongotimecon = new MongoConnection();
			DBCursor timecursor = mongotimecon.getDBObject("timeableid", timetableid, "Timetable");
			if(timecursor.hasNext()){
				DBObject theObjtime = timecursor.next();
				
				String[] events = (String[])theObjtime.get("eventid");
				
				for(int s=0;s<events.length;s++){
					
					MongoConnection mongoevencon = new MongoConnection();
					DBCursor eventcursor = mongoevencon.getDBObjectSorted("eventid", events[s], "Event", "eventstarttime", 200);
					if(eventcursor.hasNext()){
						
						DBObject theevent = timecursor.next();
						HashMap eventHandle = new HashMap();
						
						
						
						SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
				        String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";
				        String dateInStart = (String)theevent.get("eventstarttime");
				        String dateInEnd = (String)theevent.get("eventendtime");
				        String dateformstart = "";
				        String dateformend = "";
				        

				        try {

				            Date date1 = formatter.parse(dateInStart);
				            Date date2 = formatter.parse(dateInEnd);
				            
				            Calendar cal = Calendar.getInstance();
				            cal.setTime(date1);
				            
				            int year1 = cal.get(Calendar.YEAR);
				            int months1 = cal.get(Calendar.MONTH);
				            int day1 = cal.get(Calendar.DAY_OF_MONTH);
				            int hour1 = cal.get(Calendar.HOUR_OF_DAY);
				            int minutes1  = cal.get(Calendar.MINUTE);
				            
				            dateformstart = "Year::"+year1+" ,Month ::"+months1+ " ,Day::"+day1+" ,Hour::"+hour1+" ,Minutes::"+minutes1;
				            
				            cal.setTime(date2);
				            int year2 = cal.get(Calendar.YEAR);
				            int months2 = cal.get(Calendar.MONTH);
				            int day2 = cal.get(Calendar.DAY_OF_MONTH);
				            int hour2 = cal.get(Calendar.HOUR_OF_DAY);
				            int minutes2  = cal.get(Calendar.MINUTE);
				            
				            dateformend = "Year::"+year2+" ,Month ::"+months2+ " ,Day::"+day2+" ,Hour::"+hour2+" ,Minutes::"+minutes2;
				            

				        } catch (ParseException e) {
				            e.printStackTrace();
				        }

				        
				        
						
						eventHandle.put("Start Time", dateformstart);
						eventHandle.put("End Time", dateformend);
						eventHandle.put("Event Occurance",(String)theevent.get("eventoccurance"));
						eventHandle.put("Event Title", (String)theevent.get("eventtitle"));
						eventHandle.put("Event Description", (String)theevent.get("eventDescription"));
						eventHandle.put("Event Priority", (String)theevent.get("eventpriority"));
						eventHandle.put("Shared By", (String)theevent.get("evensharedbyuserid"));
						eventHandle.put("Event Shared To", (String[])theevent.get("eventsharedtouserids"));
						
						eventmap.put((String)theevent.get("eventid"), eventHandle);


						
					}
					
					
				}
				
				
			}
			
			
		}
		
		
		return eventmap;
	}
	
	
	
	public void saveEvent(String time, String eventtitle, String evendescription, String eventstarttime, String eventendtime, String eventoccurance, String eventpriority, String sharedby, String sharedwith){
		
		
		
		
		
		
		
		
	}


	public String nextMeeting(String guidanceid, String participantid) {
		// TODO Auto-generated method stub
		
		DateFormat dateFormat = new SimpleDateFormat("YYYY-mm-ddTHH:MM:ss");
		Date date = new Date();
		String currentdate = dateFormat.format(date);
		System.out.println(dateFormat.format(date));
		
		
		String meetingtime = "";
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			String timetableid = (String)theObj.get("timetableid");
			
			MongoConnection mongoconint = new MongoConnection();
			DBCursor guidcursor = mongoconint.getDBObject("timeableid", timetableid, "Timetable");
			
			if(guidcursor.hasNext()){
				
				DBObject theObjgrid = guidcursor.next();
				
				String[] events = (String[])theObj.get("eventid");
				
				MongoConnection mongocoevent = new MongoConnection();
				DBCursor eventcursor = mongocoevent.getNextMeetingDBObject("eventstarttime", currentdate, "Event");
				
				if(eventcursor.hasNext()){
					
					DBObject eventObj = eventcursor.next();
					
					meetingtime = (String)eventObj.get("eventstarttime");
					
				}
				
			}
		}
		
		
		
		return meetingtime;
		
	}
	
	
	public String getnextMeeting(String timetableid) {
		// TODO Auto-generated method stub
		
		DateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd HH:MM:ss");
		Date date = new Date();
		String currentdate = dateFormat.format(date);
		System.out.println(dateFormat.format(date));
		String meetingtime="";
		
			MongoConnection mongoconint = new MongoConnection();
			DBCursor guidcursor = mongoconint.getDBObject("timeableid", timetableid, "Timetable");
			
			if(guidcursor.hasNext()){
				
				DBObject theObjgrid = guidcursor.next();
				
				String[] events = (String[])theObjgrid.get("eventid");
				
				MongoConnection mongocoevent = new MongoConnection();
				DBCursor eventcursor = mongocoevent.getNextMeetingDBObject("eventstarttime", currentdate, "Event");
				
				if(eventcursor.hasNext()){
					
					DBObject eventObj = eventcursor.next();
					
					meetingtime = (String)eventObj.get("eventstarttime");
					
				}
				
			}
		
		
		return meetingtime;
		
	}
	
	
	public String getNumberOfBlogsTopics(String blogid, String userid){
		
		
		String topicnumber = "";
		int topiccount = 0;
		
		MongoConnection mongoconint = new MongoConnection();
		DBCursor blogcursor = mongoconint.getDBObject("blogid", blogid, "Blog");
		
		if(blogcursor.hasNext()){
			
			DBObject eventObj = blogcursor.next();
			String[] topics = (String[])eventObj.get("topicid");
			
			for(int s=0;s<topics.length;s++){
				
				MongoConnection mongocontop = new MongoConnection();
				DBCursor topiccursor = mongoconint.getDBObject("topicid", topics[s], "Topic");
				
				if(topiccursor.hasNext()){
					DBObject topicObj = blogcursor.next();
					
					if(((String)topicObj.get("topiccreateduserid")).equalsIgnoreCase(userid)){
						topiccount++;
					}
					
				}
				
			}
			
			
		}
		
		
		topicnumber = Integer.toString(topiccount);
		
		return topicnumber;
		
	}


	public void endorseSubject(String guidanceSubject, String provider, String student) {
		// TODO Auto-generated method stub
		
		
		
	}


	public String getGuidanceCosumeruserid(String guidanceid) {
		// TODO Auto-generated method stub
		
		String userid = "";
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			userid = (String)theObj.get("consumeruserid");
		}
		
		
		return userid;
	}
	
	
	public String getGuidanceProvideruserid(String guidanceid) {
		// TODO Auto-generated method stub
		
		String userid = "";
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			userid = (String)theObj.get("provideruserid");
		}
		
		
		return userid;
	}


	public String getGuidanceType(String guidanceid, String accessuserid) {
		// TODO Auto-generated method stub
		String guidancetype = "";
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			if(((String)theObj.get("consumeruserid")).equalsIgnoreCase(accessuserid)){
				guidancetype = "consumer";
			}else if(((String)theObj.get("provideruserid")).equalsIgnoreCase(accessuserid)){
				guidancetype = "provider";
			}
		}
		return guidancetype;
	}


	public String formAssignmentList(String guidanceid, String userid, String contenttype) {
		// TODO Auto-generated method stub
		
		ArrayList assignmentlist = new ArrayList();
		
		StringBuffer contentbuff = new StringBuffer();
		contentbuff.append("[");
		
		MongoConnection mongocon = new MongoConnection();
		Assignment assignment = new Assignment();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceAssignment");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			String[] assignments = (String[])theObj.get("assignmentids");
			
			
			for(int d=0;d<assignments.length;d++){
				
				MongoConnection mongoconassign = new MongoConnection();
				DBCursor asigncursor = mongoconassign.getDBObject("assignmentid", assignments[d], "Assignment");
				if(asigncursor.hasNext()){
					DBObject assignObj = asigncursor.next();
					
					String[] sharedids = (String[])assignObj.get("assignmentshareids");
					boolean contains = Arrays.asList(sharedids).contains(userid);
					
					if(contains == true){
						
						assignment.setAssignmentanswersheet((String[])assignObj.get("assignmentanswersheet"));
						assignment.setAssignmentenddatetime((String)assignObj.get("assignmentenddatetime"));
						assignment.setAssignmentid((String)assignObj.get("assignmentid"));
						assignment.setAssignmentquestionsets((String[])assignObj.get("assignmentquestionsets"));
						assignment.setAssignmentstartdatetime((String)assignObj.get("assignmentstartdatetime"));
						assignment.setAverageVelocity((String)assignObj.get("averageVelocity"));
						assignment.setNoOfQuestions((String)assignObj.get("noOfQuestions"));
						assignment.setPercentagescore((String)assignObj.get("percentagescore"));
						assignment.setAssignmentdescription((String)assignObj.get("assignmentdescription"));
						assignment.setAssignmentname((String)assignObj.get("assignmentname"));
						assignment.setAssignmentsubject((String)assignObj.get("assignmentsubject"));
						assignment.setAssignmentcreatedby((String)assignObj.get("assignmentcreatedby"));
						
						DateFunctionality datefunc = new DateFunctionality();
						String assignmentstatus = "";
						String datediff = datefunc.getDateDiffference((String)assignObj.get("assignmentstartdatetime"), (String)assignObj.get("assignmentenddatetime"));
						if(Integer.valueOf(datediff)<1){
							assignmentstatus = "<span class='label label-default'>INACTIVE</span>";
						}else{
							assignmentstatus = "<span class='label label-success'>ACTIVE</span>";
						}
						
						String content = "{"+"\""+"name"+"\""+":"+"\""+"\""+(String)assignObj.get("assignmentname")+"<br><small class='text-muted'><i>"+(String)assignObj.get("assignmentsubject")+"<i></small>"+"\""+","+
								"\""+"est"+"\""+":"+"\""+"<td><div class='progress progress-xs' data-progressbar-value='"+(String)assignObj.get("percentagescore")+"'><div class='progress-bar'></div></div></td>"+"\""+","+
								"\""+"contacts"+"\""+":"+"\""+"<div class='project-members'><a href='javascript:void(0)'><img src='/Fliker/imageFromUserid/"+(String)assignObj.get("assignmentcreatedby")+"' class='offline' alt='user'></a> </div> "+"\""+","+
								"\""+"status"+"\""+":"+"\""+assignmentstatus+"\""+","+
								"\""+"target-actual"+"\""+":"+"\""+"<span style='margin-top:5px' class='sparkline display-inline' data-sparkline-type='compositebar' data-sparkline-height='18px' data-sparkline-barcolor='#aafaaf' data-sparkline-line-width='2.5' data-sparkline-line-val='[6,4,7,8,47,9,9,8,3,2,2,5,6,7,4,1,5,7,6]' data-sparkline-bar-val='[6,4,7,8,47,9,9,8,3,2,2,5,6,7,9,9,5,7,6]'></span>"+"\""+","+
								"\""+"actual"+"\""+":"+"\""+"<span class='sparkline text-align-center' data-sparkline-type='line' data-sparkline-width='100%' data-sparkline-height='25px'>20,-35,70</span>"+"\""+","+
								"\""+"tracker"+"\""+":"+"\""+"<span class='onoffswitch'><input type='checkbox' name='start_interval' class='onoffswitch-checkbox' id='track' name='"+(String)assignObj.get("assignmentid")+"' checked='checked'><label class='onoffswitch-label' for='st1'><span class='onoffswitch-inner' data-swchon-text='ON' data-swchoff-text='OFF'></span><span class='onoffswitch-switch'></span></label></span>"+"\""+","+
								"\""+"starts"+"\""+":"+"\""+(String)assignObj.get("assignmentstartdatetime")+"\""+","+
								"\""+"ends"+"\""+":"+"\""+"<strong>"+(String)assignObj.get("assignmentstartdatetime")+"</strong>"+"\""+","+
								"\""+"comments"+"\""+":"+"\""+(String)assignObj.get("assignmentdescription")+"\""+","+
								"\""+"action"+"\""+":"+"\""+"<button class='btn btn-xs btn-success' id='"+(String)assignObj.get("assignmentid")+" onclick='openAssignment("+(String)assignObj.get("assignmentid")+")''>Open Assignment</button>"+"\""+"}";
								
						
						contentbuff.append(content);
					}
					
					
					
					
					
					
				}
			}
			
		}
		contentbuff.append("]");
		
		return contentbuff.toString();
	}


	public String formQuestionList(String guidanceid, String userid, String contenttype) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}


	public ArrayList getGuidanceProjectData(String guidanceid) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}


	public void createNewGuidance(String guidancesubject, String guidancereason, String location, String published) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}


	public ArrayList getGuidanceUnPublishDetails(String userids) {
		// TODO Auto-generated method stub
		
		ArrayList guidancelist = new ArrayList<Post>();

		MongoConnection mongocon = new MongoConnection();
		Assignment assignment = new Assignment();
		DBCursor resultcursor = mongocon.getDBObject("userid", userids, "GuidanceSelection");
		while(resultcursor.hasNext()){
			DBObject dbj = resultcursor.next();
			HashMap totalSet = new HashMap();
			
			totalSet.put("guidanceid", (String)dbj.get("guidanceid"));
			totalSet.put("guidanceSubject", (String)dbj.get("guidanceSubject"));
			totalSet.put("guidancelocation", (String)dbj.get("guidancelocation"));
			totalSet.put("guidanceduration", (String)dbj.get("guidanceduration"));
			totalSet.put("guidancereason", (String)dbj.get("guidancereason"));
			
			ProfilePreview profprev = new ProfilePreview();
			ArrayList profileinfo = profprev.getProfileInfo((String)dbj.get("userid"));
			for(int m=0;m<profileinfo.size();m++){
				
				if(profileinfo.get(m) instanceof Profile){
					Profile profileinfos = (Profile)profileinfo.get(m);
					
					totalSet.put("profileid", profileinfos.getProfileid());
					totalSet.put("profileImage", profileinfos.getProfileImageid());
					totalSet.put("profileName", profileinfos.getName());
					
				}
				
				
			}
			
			totalSet.put("userid", (String)dbj.get("userid"));
			
			guidancelist.add(totalSet);
			
		}
		
		return guidancelist;
		
	}
	
	public HashMap getAllGuidanceProvidingSubjectList(String userid) {
		// TODO Auto-generated method stub
		
		
		GuidancePreview guidprev = new GuidancePreview();
		HashMap guidanceidset = new HashMap();

		MongoConnection mongocon = new MongoConnection();
		Assignment assignment = new Assignment();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "GuidanceSelection");
		while(resultcursor.hasNext() ){
			
			DBObject dbj = resultcursor.next();
			String provideid = (String)dbj.get("guidanceflag");
			
			if(provideid.equalsIgnoreCase("provide")){
				
				String guidancesubject = (String)dbj.get("guidanceSubject");
				/*MongoConnection mongoconguid = new MongoConnection();
				DBCursor resultguid = mongoconguid.getDBObject("guidanceid", guidanceid, "GuidanceSelection");
				if(resultguid.hasNext()){*/
					
					/*DBObject thedbj = resultguid.next();
					String guidsubject = (String)dbj.get("guidanceSubject");*/
					
					MongoConnection mongoconsub = new MongoConnection();
					DBCursor resultsubject = mongoconsub.getDBObject("guidanceSubject", guidancesubject, "GuidanceSelection");
					while(resultsubject.hasNext()){
						DBObject thesubdbj = resultsubject.next();
						String guidanceflag = (String)thesubdbj.get("guidanceflag");
						if(guidanceflag.equalsIgnoreCase("consume")){
							
							ArrayList guidanceproviderlist = guidprev.checkGuidanceTake((String)thesubdbj.get("userid"), guidancesubject);
							HashMap guidanceinfo = new HashMap();
							guidanceinfo.put("guidancepresent", guidanceproviderlist);
							guidanceinfo.put("guidancereason", (String)thesubdbj.get("guidancereason"));
							guidanceinfo.put("guidancelocation", (String)thesubdbj.get("guidancelocation"));
							guidanceinfo.put("guidanceduration", (String)thesubdbj.get("guidanceduration"));
							guidanceinfo.put("guidanceuserid", (String)thesubdbj.get("userid"));
							
							
							guidanceidset.put((String)thesubdbj.get("guidanceid"), guidanceinfo);
							
							
						
					}
					
				}
				
			}
		}
		
		return guidanceidset;
	}
	
	
	
	public ArrayList checkGuidanceTake(String userid, String guidancesubject){
		
		//String guidanceids = "";
		ArrayList guidanceidlist = new ArrayList();
		ProfilePreview profprev = new ProfilePreview();
		ArrayList profilelist = profprev.getProfileInfo(userid);
		
		
		//String[] guidancelist = new String[0];
		
		
		for(int m=0;m<profilelist.size();m++){
			
			
			if(profilelist.get(m) instanceof Profile){
				Profile profileinform = (Profile)profilelist.get(m);
				String[] guidancelist = profileinform.getGuidanceids();
				
				for(int n=0;n<guidancelist.length;n++){
					
					MongoConnection mongoconsub = new MongoConnection();
					DBCursor resultsubject = mongoconsub.getDBObject("guidanceid", guidancelist[n], "GuidanceSelection");
					if(resultsubject.hasNext()){
						DBObject thesubdbj = resultsubject.next();
						String guidancesubj = (String)thesubdbj.get("guidanceSubject");
						
						if(guidancesubj.equalsIgnoreCase(guidancesubject)){
							guidanceidlist.add((String)thesubdbj.get("userid"));
						}
						
					}
					
				}
				
				
			}
			
		}
		
		return guidanceidlist;
		
	}


	public HashMap getAllGuidanceConsumingSubjectList(String userid) {
		// TODO Auto-generated method stub
		
		GuidancePreview guidprev = new GuidancePreview();
		HashMap guidanceidset = new HashMap();

		MongoConnection mongocon = new MongoConnection();
		Assignment assignment = new Assignment();
		DBCursor resultcursor = mongocon.getDBObject("userid", userid, "GuidanceSelection");
		while(resultcursor.hasNext() ){
			
			DBObject dbj = resultcursor.next();
			String provideid = (String)dbj.get("guidanceflag");
			
			if(provideid.equalsIgnoreCase("consume")){
				
				String guidancesubject = (String)dbj.get("guidanceSubject");
				/*MongoConnection mongoconguid = new MongoConnection();
				DBCursor resultguid = mongoconguid.getDBObject("guidanceid", guidanceid, "GuidanceSelection");
				if(resultguid.hasNext()){*/
					
					/*DBObject thedbj = resultguid.next();
					String guidsubject = (String)dbj.get("guidanceSubject");*/
					
					MongoConnection mongoconsub = new MongoConnection();
					DBCursor resultsubject = mongoconsub.getDBObject("guidanceSubject", guidancesubject, "GuidanceSelection");
					while(resultsubject.hasNext()){
						DBObject thesubdbj = resultsubject.next();
						String guidanceflag = (String)thesubdbj.get("guidanceflag");
						if(guidanceflag.equalsIgnoreCase("provide")){
							
							HashMap guidanceinfo = new HashMap();
							guidanceinfo.put("guidancereason", (String)thesubdbj.get("guidancereason"));
							guidanceinfo.put("guidancelocation", (String)thesubdbj.get("guidancelocation"));
							guidanceinfo.put("guidanceduration", (String)thesubdbj.get("guidanceduration"));
							guidanceinfo.put("guidanceuserid", (String)thesubdbj.get("userid"));
							
							ProfilePreview profprev = new ProfilePreview();
							ArrayList profileinfolist = profprev.getProfileInfo((String)thesubdbj.get("userid"));
							
							String profileid="";
							
							
							for(int m=0;m<profileinfolist.size();m++){
								
								
								if(profileinfolist.get(m) instanceof Profile){
									Profile profileinform = (Profile)profileinfolist.get(m);
									profileid = profileinform.getProfileid();
									
								}
								
							}
							guidanceinfo.put("guidanceprofileid", profileid);
							
							guidanceidset.put((String)thesubdbj.get("guidanceid"), guidanceinfo);
							
							
						}
						
					}
			}
			
		}
		
		
		return null;
	}
	
	
	
	}




