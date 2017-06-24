package com.fliker.Modal;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Assignment;
import com.fliker.Repository.Bill;
import com.fliker.Repository.Blog;
import com.fliker.Repository.DashBoardData;
import com.fliker.Repository.Dashboard;
import com.fliker.Repository.Events;
import com.fliker.Repository.FileUnionTimeFrame;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.Guidance;
import com.fliker.Repository.GuidanceContent;
import com.fliker.Repository.GuidanceContentCalendar;
import com.fliker.Repository.GuidanceContentDashBoardSet;
import com.fliker.Repository.GuidanceContentDashboard;
import com.fliker.Repository.GuidanceContentFiles;
import com.fliker.Repository.GuidanceContentShared;
import com.fliker.Repository.GuidanceEntry;
import com.fliker.Repository.GuidanceEntryCalendar;
import com.fliker.Repository.GuidanceEntryShare;
import com.fliker.Repository.GuidanceFileShare;
import com.fliker.Repository.GuidanceInfo;
import com.fliker.Repository.GuidanceProject;
import com.fliker.Repository.Invoice;
import com.fliker.Repository.Post;
import com.fliker.Repository.Profile;
import com.fliker.Repository.SearchContent;
import com.fliker.Repository.Share;
import com.fliker.Repository.TempFileHistory;
import com.fliker.Repository.Timetable;
import com.fliker.Repository.Vote;
import com.fliker.Utility.DateFunctionality;
import com.fliker.Utility.ServicesUtil;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class GuidancePreview {

	public IdentityHashMap< String, HashMap<String,LinkedList<String>>> requestobjectmap = new IdentityHashMap<String,HashMap<String,LinkedList<String>>>();	
	
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
		String[] guidancepaging = new String[0];
		String[] guidanceinterest = new String[0];
		
		guidance.setGuidanceSubject(guidancesubjects);
		guidance.setUserid(userid);
		guidance.setGuidanceflag(guidanceflag);
		guidance.setGuidencetype(guidenctype);
		guidance.setGuidanceduration(duration);
		guidance.setGuidancelocation(location);
		guidance.setGuidancereason(guidancereason);
		guidance.setGuidancepaging(guidancepaging);
		guidance.setGuidanceinterest(guidanceinterest);
		
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
		basicdbobj.put("guidancepaging", guidance.getGuidancepaging());
		basicdbobj.put("guidanceinterest", guidance.getGuidanceinterest());
		
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
		basicdbobj.put("quizids", guidancecontent.getQuizids());
		basicdbobj.put("assignmentids", guidancecontent.getAssignmentids());
		basicdbobj.put("infoid", guidancecontent.getInfoid());
		
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
	  String[] quizids = new String[0];
	  String[] assignmentids = new String[0];
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
		guidancecontent.setAssignmentids(assignmentids);
		guidancecontent.setQuizids(quizids);
		guidancecontent.setInfoid(guidanceid);
		guidancecontent.setProjectid(guidanceid);
		
		String[] eventid = new String[0];
		Timetable timetable = new Timetable(); 
		timetable.setTimeableid(guidanceid);
		timetable.setEventid(eventid);
		
		String[] blogaccessuserids = new String[0];
		String[] topicid = new String[0];
		Blog blogs = new Blog();
		blogs.setBlogaccessuserids(blogaccessuserids);
		blogs.setBlogactive("true");
		blogs.setBlogid(guidanceid);
		blogs.setBlogname(guidanceSubject+guidencetype);
		blogs.setTopicid(topicid);
		
		
		MongoConnection mongocon = new MongoConnection();
		
		BasicDBObject basicreqobj =  guidanceprev.formGuidanceContentDBObject(guidancecontent);
		
		mongocon.saveObject(basicreqobj, "GuidanceContent");
		
		BasicDBObject timeqobj =  guidanceprev.formGuidanceTimetableDBObject(timetable);
		mongocon.saveObject(timeqobj, "Timetable");
		
		BasicDBObject blogqobj =  guidanceprev.formGuidanceBlogDBObject(blogs);
		mongocon.saveObject(blogqobj, "Blog");
		
		//guidancecondash.setGuidancecontentDashid(guidancecontent.getDashboardid());
		
		//guidanceshare.setGuidancesharedid(guidancecontent.getSharetokenid());
		
		//guidanceprev.searchContent(userid, uniqueid, guidanceSubject);
		
		//pubprev.publishtopublisher(guidanceSubject, userid, guidencetype, guidanceuserid, uniqueid);
		
	
  }


	private BasicDBObject formGuidanceBlogDBObject(Blog blogs) {
	// TODO Auto-generated method stub
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("blogaccessuserids", blogs.getBlogaccessuserids());
		basicdbobj.put("blogactive", blogs.getBlogactive());
		basicdbobj.put("blogid", blogs.getBlogid());
		basicdbobj.put("blogname", blogs.getBlogname());
		basicdbobj.put("topicid", blogs.getTopicid());
		
		return basicdbobj;
}


	private BasicDBObject formGuidanceTimetableDBObject(Timetable timetable) {
	// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("eventid", timetable.getEventid());
		basicdbobj.put("timeableid", timetable.getTimeableid());
		
		return basicdbobj;
	}


	public void applicationGuide(String pageruserid, String guidanceid) {
		// TODO Auto-generated method stub
		
		GuidancePreview guidanceprev = new GuidancePreview();
		PublishPreview pubprev = new PublishPreview();
		
		String uniqueid = "";
		
		/*try {
			//uniqueid = guidanceprev.makeSHA1Hash(guidanceSubject+userid+guidencetype);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//guidanceprev.searchContent(userid, uniqueid, guidanceSubject);
		
		//pubprev.publishtopublisher(guidanceSubject, userid, guidencetype, guidanceuserid, uniqueid);
		
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


	public HashMap getGuidanceData(String guidanceid) {
		// TODO Auto-generated method stub
		HashMap guidanceinfomap = new HashMap();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceinfoid", guidanceid, "GuidanceInfo");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			String guidancedescription = (String)theObj.get("guidancedescription");
			String guidanceprice = (String)theObj.get("guidanceprice");
			String guidancesubjectexperience = (String)theObj.get("guidancesubjectexperience");
			BasicDBList guidanceendorebylist = (BasicDBList)theObj.get("guidanceendorseby");
			BasicDBList guidanceachevements = (BasicDBList)theObj.get("guidanceachievements");
			
			LinkedList companylist = new LinkedList();
			
			if(guidanceendorebylist.size() > 0){
				for(int m=0;m<guidanceendorebylist.size();m++){
					
					DBCursor companycursor = mongocon.getDBObject("companyid", (String)guidanceendorebylist.get(m), "Company");
					if(companycursor.hasNext()){
						DBObject companyObj = companycursor.next();
						HashMap companyinfo = new HashMap();
						companyinfo.put("companyname", companyObj.get("companyname"));
						companyinfo.put("companylogo", companyObj.get("companylogoid"));
						
						companylist.add(companyinfo);
					}
					
				}
			}
			LinkedList achievements = new LinkedList();
			
			if(guidanceachevements.size()>0){
				
				for(int n=0;n<guidanceachevements.size();n++){
					
					achievements.add((String)guidanceachevements.get(n));
				}
				
				
			}
			
			guidanceinfomap.put("guidancedescription", guidancedescription);
			guidanceinfomap.put("guidanceprice", guidanceprice);
			guidanceinfomap.put("guidancesubjectexperience", guidancesubjectexperience);
			guidanceinfomap.put("guidanceendorebylist", companylist);
			guidanceinfomap.put("guidanceachevements", achievements);
			
			
			
		}
		
		
		return guidanceinfomap;
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
				//guidancedash.setGuidancefilelistid((String[])theObjtime.get("guidancefilelistid"));
				
				
				
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


	public BasicDBList getGuidanceCosumeruserid(String guidanceid) {
		// TODO Auto-generated method stub
		
		BasicDBList useridlist = new BasicDBList();
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
			
			useridlist = (BasicDBList)theObj.get("consumeruserid");
		}
		
		
		return useridlist;
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
				if(guidancelist!= null){
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
							guidanceinfo.put("guidancesubject", (String)thesubdbj.get("guidanceSubject"));
							
							ProfilePreview profprev = new ProfilePreview();
							ArrayList profileinfolist = profprev.getProfileInfo((String)thesubdbj.get("userid"));
							
							String profileid="";
							String profilename="";
							String profileimage="";
							
							
							for(int m=0;m<profileinfolist.size();m++){
								
								
								if(profileinfolist.get(m) instanceof Profile){
									Profile profileinform = (Profile)profileinfolist.get(m);
									profileid = profileinform.getProfileid();
									profilename = profileinform.getName();
									profileimage = profileinform.getProfileImageid();
								}
								
							}
							guidanceinfo.put("guidanceprofileid", profileid);
							guidanceinfo.put("guidanceprofilename", profilename);
							guidanceinfo.put("guidanceprofileimage", profileimage);
							
							guidanceidset.put((String)thesubdbj.get("guidanceid"), guidanceinfo);
							
							
						}
						
					}
			}
			
		}
		
		
		return guidanceidset;
	}


	public ArrayList getGuidanceViewData(String guidanceid) {
		// TODO Auto-generated method stub
		
		ArrayList guidancedata = new ArrayList();
		
		return guidancedata;
	}


	public void pagingGuide(String guidanceid, String userid) {
		// TODO Auto-generated method stub
		
		ArrayList subjectlist = new ArrayList();
		MongoConnection mongoconsub = new MongoConnection();
		DBCursor resultcursorsub = mongoconsub.getDBObject("userid", userid, "GuidanceSelection");
		while(resultcursorsub.hasNext() ){
			DBObject subdbj = resultcursorsub.next();
			String subject = (String)subdbj.get("guidanceSubject");
			String guidancetoid = (String)subdbj.get("guidanceid");
			subjectlist.add(subject+"::"+guidancetoid);
		}
		
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceSelection");
		while(resultcursor.hasNext() ){
			
			DBObject dbj = resultcursor.next();
			String currentsubject = (String)dbj.get("guidanceSubject");
			for(int i=0;i<subjectlist.size();i++){
				String subjecttocheck = ((String)subjectlist.get(i)).split("::")[0];
				String guidancetocheck = ((String)subjectlist.get(i)).split("::")[1];
				if(currentsubject.equalsIgnoreCase(subjecttocheck)){
					MongoConnection mongoconnpage = new MongoConnection();
					mongoconnpage.updateObject(new BasicDBObject("guidanceid", guidanceid),
							new BasicDBObject("$push", new BasicDBObject("guidancepaging", guidancetocheck)), "GuidanceSelection");
				}
			}
			
			
		}
		
	}


	public void createGuidanceContentData(String guidanceid, String guidanceprice, String guidancereason) {
		// TODO Auto-generated method stub
		
		
		String[] guidancedashdataid = new String[0];
		String[] guidancelocationids = new String[0];
		GuidanceContentDashboard guidancecontentdash = new GuidanceContentDashboard();
		guidancecontentdash.setGuidancecontentDashid(guidanceid);
		guidancecontentdash.setGuidancedashdataid(guidancedashdataid);
		guidancecontentdash.setGuidancelocationids(guidancelocationids);
		
		MongoConnection mongoconsearch = new MongoConnection();
		GuidancePreview guidprev = new GuidancePreview();
		BasicDBObject basicreqobjsearch =  guidprev.formGuideContDashDBObject(guidancecontentdash);
		mongoconsearch.saveObject(basicreqobjsearch, "GuidanceContentDash");
		
		
		String[] guidancefilelistid = new String[0];
		GuidanceContentShared guidancecontentshare = new GuidanceContentShared();
		guidancecontentshare.setGuidancefilelistid(guidancefilelistid);
		guidancecontentshare.setGuidancesharedid(guidanceid);
		
		BasicDBObject guidcontshare =  guidprev.formGuideContShareDBObject(guidancecontentshare);
		mongoconsearch.saveObject(guidcontshare, "GuidanceContentShare");
		
		String[] guidanceendorseby = new String[0];
		String[] guidanceachievements = new String[0];
		GuidanceInfo guideinfo = new GuidanceInfo();
		guideinfo.setGuidancesubjectexperience("");
		guideinfo.setGuidanceprice(guidanceprice);
		guideinfo.setGuidanceinfoid(guidanceid);
		guideinfo.setGuidanceendorseby(guidanceendorseby);
		guideinfo.setGuidancedescription(guidancereason);
		guideinfo.setGuidanceachievements(guidanceachievements);
		
		BasicDBObject guidcontinfo =  guidprev.formGuideContInfoDBObject(guideinfo);
		mongoconsearch.saveObject(guidcontinfo, "GuidanceInfo");
		
	}


	private BasicDBObject formGuideContInfoDBObject(GuidanceInfo guideinfo) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("guidanceachievements", guideinfo.getGuidanceachievements());
		basicdbobj.put("guidancedescription", guideinfo.getGuidancedescription());
		basicdbobj.put("guidanceendorseby", guideinfo.getGuidanceendorseby());
		basicdbobj.put("guidanceinfoid", guideinfo.getGuidanceinfoid());
		basicdbobj.put("guidanceprice", guideinfo.getGuidanceprice());
		basicdbobj.put("guidancesubjectexperience", guideinfo.getGuidancesubjectexperience());
		
		return basicdbobj;
	}


	private BasicDBObject formGuideContShareDBObject(GuidanceContentShared guidancecontentshare) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("guidancefilelistid", guidancecontentshare.getGuidancefilelistid());
		basicdbobj.put("guidancesharedid", guidancecontentshare.getGuidancesharedid());
		
		return basicdbobj;
	}


	private BasicDBObject formGuideContDashDBObject(GuidanceContentDashboard guidancecontentdash) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("guidancecontentDashid", guidancecontentdash.getGuidancecontentDashid());
		basicdbobj.put("guidancedashdataid", guidancecontentdash.getGuidancedashdataid());
		basicdbobj.put("guidancelocationids", guidancecontentdash.getGuidancelocationids());
		
		return basicdbobj;
	}


	public void saveTempFilesAchieve(String fileuploadid, String token, String userid) {
		
		
		// TODO Auto-generated method stub
		
		AssignmentFilePreview assignprev = new AssignmentFilePreview();
		
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
        //String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";//example
        
		
		
        Date datepack = new Date();
        DateFunctionality datefunc = new DateFunctionality();
        
        String localdate = datefunc.getUniformDates(formatter.format(datepack));
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(datepack);
        
        String yearpack = Integer.toString(cal.get(Calendar.YEAR));
        String monthspack = Integer.toString(cal.get(Calendar.MONTH));
        String daypack = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String hourpack = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
        String minutespack  = Integer.toString(cal.get(Calendar.MINUTE));
		
		String context = "Achievement ::"+token+" ,FileID ::"+fileuploadid+" ,User ::"+userid;
		
		FileUnionTimeFrame fileuntimeframe = new FileUnionTimeFrame();
		fileuntimeframe.setContext(context);
		fileuntimeframe.setDate(localdate);
		fileuntimeframe.setDay(daypack);
		fileuntimeframe.setFileid(fileuploadid);
		fileuntimeframe.setHour(hourpack);
		fileuntimeframe.setMonth(monthspack);
		fileuntimeframe.setTempid(token);
		fileuntimeframe.setUserid(userid);
		
		MongoConnection mongoconsearch = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch =  assignprev.formDBObject(fileuntimeframe);
		
		mongoconsearch.saveObject(basicreqobjsearch, "FileUnionTimeFrame");
		
		
	}


	public void saveGuidanceAchievementInfo(String achievementdesc, String achievementname, String token,
			String userid, String guidanceid) {
		// TODO Auto-generated method stub
		String fileid = "";
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("tempid", token, "FileUnionTimeFrame");
		while(resultcursor.hasNext() ){
			
			DBObject dbj = resultcursor.next();
			
			String userids = (String)dbj.get("userid");
			if(userids.equalsIgnoreCase(userid)){
				
				fileid = (String)dbj.get("fileid");
			}
			
		}
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("achievement", achievementname);
		jsonobj.put("achievementdescription", achievementdesc);
		jsonobj.put("achievementtoken", token);
		jsonobj.put("achievementfile", fileid);
		
		String jsonstr = jsonobj.toJSONString();
		System.out.println("jsonstr >>"+jsonstr);
		
		mongocon.updateObject(new BasicDBObject("guidanceinfoid", guidanceid),new BasicDBObject("$push", new BasicDBObject("guidanceachievements", jsonstr)), "GuidanceInfo");
		
	}
	
	
	 public Set<Currency> getAllCurrencies()
	    {
	        Set<Currency> toret = new HashSet<Currency>();
	        Locale[] locs = Locale.getAvailableLocales();

	        for(Locale loc : locs) {
	            try {
	                Currency currency = Currency.getInstance( loc );

	                if ( currency != null ) {
	                	System.out.println(currency.getCurrencyCode());
	                    toret.add( currency );
	                }
	            } catch(Exception exc)
	            {
	                // Locale not found
	            }
	        }

	        return toret;
	    }


	public void saveGuidanceInfo(String guidancedesc, String guidanceexperience, String guidancecost,
			String guidancecostcurrency, String guidancecostper, String guidanceid) {
		// TODO Auto-generated method stub
		String guidprice = guidancecost+" "+guidancecostcurrency;
		MongoConnection mongocon = new MongoConnection();
		mongocon.updateObject(new BasicDBObject("guidanceinfoid", guidanceid),new BasicDBObject("$set", new BasicDBObject("guidancedescription", guidancedesc)), "GuidanceInfo");
		mongocon.updateObject(new BasicDBObject("guidanceinfoid", guidanceid),new BasicDBObject("$set", new BasicDBObject("guidanceprice", guidprice)), "GuidanceInfo");
		mongocon.updateObject(new BasicDBObject("guidanceinfoid", guidanceid),new BasicDBObject("$set", new BasicDBObject("guidancesubjectexperience", guidanceexperience)), "GuidanceInfo");
		
		
	}
	
	public void saveFileToLocalDisk(MultipartFile multipartFile) throws IOException, FileNotFoundException {

		String outputFileName = getOutputFilename(multipartFile);
		byte[] imagebytes = multipartFile.getBytes();
		// FileCopyUtils.copy(multipartFile.getBytes(), new
		// FileOutputStream(outputFileName));
		System.out.println(outputFileName);
		System.out.println(imagebytes);

	}
	
	public String getOutputFilename(MultipartFile multipartFile) {

		return getDestinationLocation() + multipartFile.getOriginalFilename();
	}

	public String getDestinationLocation() {
		return "F:/uploaded-files/";
	}
	
	public FileUpload getUploadedFileInfo(MultipartFile multipartFile) throws IOException {

		AssignmentFilePreview assignprev = new AssignmentFilePreview();
		String uniqueid = "";
		try {
			uniqueid = assignprev.makeSHA1Hash(multipartFile.getOriginalFilename());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileUpload fileInfo = new FileUpload();
		fileInfo.setFileid(uniqueid + System.currentTimeMillis());
		fileInfo.setName(multipartFile.getOriginalFilename());
		fileInfo.setSize(multipartFile.getSize());
		fileInfo.setType(multipartFile.getContentType());
		fileInfo.setLocation(getDestinationLocation());
		fileInfo.setFileblob(multipartFile.getBytes());
		
		

		return fileInfo;
	}
	
	
	public String saveFile(Map<String, MultipartFile> fileMap, String userid, String guidancedata,String token, String tokenui){
		String fileids = "";
		String filenames = "";
		
		GuidancePreview guidprev = new GuidancePreview();
		// Maintain a list to send back the files info. to the client side
		List<FileUpload> uploadedFiles = new ArrayList<FileUpload>();

		for (MultipartFile multipartFile : fileMap.values()) {

			// Save the file to local disk
			try {
				guidprev.saveFileToLocalDisk(multipartFile);

				FileUpload fileInfo = guidprev.getUploadedFileInfo(multipartFile);
				fileids = fileInfo.getFileid();
				filenames = fileInfo.getName();
				String fileid = fileInfo.getFileid();
				FilePreview filepreview = new FilePreview();
				filepreview.saveFile(fileInfo);

				SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
		        //String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";//example
		        
				
				
	            Date datepack = new Date();
	            DateFunctionality datefunc = new DateFunctionality();
	            
	            String localdate = datefunc.getUniformDates(formatter.format(datepack));
	            
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(datepack);
	            
	            String yearpack = Integer.toString(cal.get(Calendar.YEAR));
	            String monthspack = Integer.toString(cal.get(Calendar.MONTH));
	            String daypack = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
	            String hourpack = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
	            String minutespack  = Integer.toString(cal.get(Calendar.MINUTE));
				
				String context = "GuidanceContentShare ::"+guidancedata+",GuidanceID ::"+token+" ,FileID ::"+fileid+" ,FileName ::"+filenames;
				
				guidprev.savetempfilehistory(userid, fileid, localdate,daypack,monthspack, hourpack,context,token);
				
				
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return fileids;
	}
	
	
	public void savetempfilehistory(String userid, String fileid, String date, String day,String month, String hour, String context,String  token ){
		
		AssignmentFilePreview assignprev = new AssignmentFilePreview();
		/*String uniqueid = "";
		
		try {
			uniqueid = assignprev.makeSHA1Hash(fileid+userid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		Set collectionset = requestobjectmap.entrySet();
		Iterator colliter = collectionset.iterator();
		while(colliter.hasNext()){
			
			Map.Entry me = (Map.Entry)colliter.next();
			
			if(me.getKey() == token){
				HashMap userval = (HashMap)me.getValue();
				Set userset = userval.entrySet();
				Iterator userit = userset.iterator();
				while(userit.hasNext()){
					Map.Entry met = (Map.Entry)userit.next();
					
					if(((String)met.getKey()).equalsIgnoreCase(userid)){
						
						LinkedList templist = (LinkedList)me.getValue();
						templist.add(fileid);
						
					}
					
				}
						
				
			}else{
				
				LinkedList templist = new LinkedList();
				templist.add(fileid);
				HashMap setupmap = new HashMap();
				setupmap.put(userid, templist);
				
				requestobjectmap.put(token, setupmap);
				
				
				
			}
			
		}
		
		FileUnionTimeFrame fileuntimeframe = new FileUnionTimeFrame();
		fileuntimeframe.setContext(context);
		fileuntimeframe.setDate(date);
		fileuntimeframe.setDay(day);
		fileuntimeframe.setFileid(fileid);
		fileuntimeframe.setHour(hour);
		fileuntimeframe.setMonth(month);
		fileuntimeframe.setTempid(token);
		fileuntimeframe.setUserid(userid);
		
		MongoConnection mongoconsearch = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch =  assignprev.formDBObject(fileuntimeframe);
		
		mongoconsearch.saveObject(basicreqobjsearch, "FileUnionTimeFrame");
		
	}

	public BasicDBObject formDBObject(FileUnionTimeFrame fileuntimeframe) {
		// TODO Auto-generated method stub
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("context", fileuntimeframe.getContext());
		basicdbobj.put("date", fileuntimeframe.getDate());
		basicdbobj.put("day", fileuntimeframe.getDay());
		basicdbobj.put("fileid", fileuntimeframe.getFileid());
		basicdbobj.put("hour", fileuntimeframe.getHour());
		basicdbobj.put("month", fileuntimeframe.getMonth());
		basicdbobj.put("tempid", fileuntimeframe.getTempid());
		basicdbobj.put("userid", fileuntimeframe.getUserid());
		
		
		return basicdbobj;
	}


	public void saveToShareDash(String fileid, String guidanceid) {
		// TODO Auto-generated method stub
		
		MongoConnection mongocon = new MongoConnection();
		mongocon.updateObject(new BasicDBObject("guidancesharedid", guidanceid),new BasicDBObject("$push", new BasicDBObject("guidancefilelistid", fileid)), "GuidanceContentShare");
		
	}


	public void saveFileToStudentsShare(String userids, String fileid, String guidanceid) {
		// TODO Auto-generated method stub
		
		GuidancePreview guidprev = new GuidancePreview();
		if(userids.equalsIgnoreCase("All")){
			MongoConnection mongocon = new MongoConnection();
			
			DBCursor profilecursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
			while(profilecursor.hasNext()){
				DBObject basicdbj = profilecursor.next();
				
				BasicDBList userlist = (BasicDBList)basicdbj.get("consumeruserid");
				for(int k=0;k<userlist.size();k++){

					DBCursor profileusercursor = mongocon.getDBObject("userid", (String)userlist.get(k), "Profile");
					while(profileusercursor.hasNext()){
						DBObject basicprofdbj = profileusercursor.next();
						
						BasicDBList guidancelist = (BasicDBList)basicprofdbj.get("guidanceids");
						for(int g=0;g<guidancelist.size();g++){
							
								DBCursor resultcursor = mongocon.getDBObject("guidanceid", (String)guidancelist.get(g), "GuidanceEntry");
								while(resultcursor.hasNext() ){
									DBObject dbj = resultcursor.next();
									
									String consumeguidanceid = (String)dbj.get("consumeguidanceid");
									if(consumeguidanceid.equalsIgnoreCase(guidanceid)){
										
										String sharetokenid = (String)dbj.get("sharetokenid");
										mongocon.updateObject(new BasicDBObject("guidanceshareid", sharetokenid),new BasicDBObject("$push", new BasicDBObject("guidancefileids", fileid)), "GuidanceEntryShare");
									}
									
									
								}
								
							
						}
					}
				
				}
			}
		}else{
		String[] useridrow =  userids.split(",");
		
		for(int i=0;i<useridrow.length;i++){
			MongoConnection mongocon = new MongoConnection();
			
			DBCursor profilecursor = mongocon.getDBObject("userid", useridrow[i], "Profile");
			while(profilecursor.hasNext()){
				DBObject basicdbj = profilecursor.next();
				
				BasicDBList guidancelist = (BasicDBList)basicdbj.get("guidanceids");
				for(int g=0;g<guidancelist.size();g++){
					
						DBCursor resultcursor = mongocon.getDBObject("guidanceid", (String)guidancelist.get(g), "GuidanceEntry");
						while(resultcursor.hasNext() ){
							DBObject dbj = resultcursor.next();
							
							String consumeguidanceid = (String)dbj.get("consumeguidanceid");
							if(consumeguidanceid.equalsIgnoreCase(guidanceid)){
								
								String sharetokenid = (String)dbj.get("sharetokenid");
								mongocon.updateObject(new BasicDBObject("guidanceshareid", sharetokenid),new BasicDBObject("$push", new BasicDBObject("guidancefileids", fileid)), "GuidanceEntryShare");
							}
							
							
						}
						
					
				}
			}
		}
		
		}
		
		GuidanceFileShare guidfileshare = new GuidanceFileShare();
		if(userids.equalsIgnoreCase("All")){
			String[] AllUser = {"All"};
			guidfileshare.setConsumerids(AllUser);
		}else{
			String[] useridnew =  userids.split(",");
			guidfileshare.setConsumerids(useridnew);
		}
		guidfileshare.setGuidancefileid(fileid);
		guidfileshare.setGuidanceid(guidanceid);
		
		MongoConnection mongocon = new MongoConnection();
		BasicDBObject basicreqobjsearch =  guidprev.formGuidShareDBObject(guidfileshare);
		mongocon.saveObject(basicreqobjsearch, "GuidanceDashFileShare");
		
		
	}


	private BasicDBObject formGuidShareDBObject(GuidanceFileShare guidfileshare) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("consumerids", guidfileshare.getConsumerids());
		basicdbobj.put("guidancefileid", guidfileshare.getGuidancefileid());
		basicdbobj.put("guidanceid", guidfileshare.getGuidanceid());
		
		return basicdbobj;
	}


	public String getFileInfoId(String tokenui, String userid) {
		// TODO Auto-generated method stub
		String fileid = "";
		MongoConnection mongocon = new MongoConnection();
		
		DBCursor filecursor = mongocon.getDBObject("tempid", tokenui, "FileUnionTimeFrame");
		while(filecursor.hasNext()){
			DBObject basicdbj = filecursor.next();
			String user = (String)basicdbj.get("userid");
			if(user.equalsIgnoreCase(fileid)){
				
				String context = (String)basicdbj.get("context");
				if(context.contains("GuidanceID ::"+tokenui)){
					fileid = (String)basicdbj.get("fileid");
				}
				
			}
			
		}
	
	
	 return fileid;
	}


	public ArrayList getAllGuidanceFiles(String guidanceid) {
		// TODO Auto-generated method stub
		ArrayList existingfiles = new ArrayList();
		MongoConnection mongocon = new MongoConnection();
		
		DBCursor filecursor = mongocon.getDBObject("guidancesharedid", guidanceid, "GuidanceContentShare");
		while(filecursor.hasNext()){
			DBObject basicdbj = filecursor.next();
			BasicDBList filelist = (BasicDBList)basicdbj.get("guidancefilelistid");
			for(int t=0;t<filelist.size();t++){
				String filename = "";
				String filesize="";
				DBCursor filenamecursor = mongocon.getDBObject("fileid", (String)filelist.get(t), "fileupload");
				if(filenamecursor.hasNext()){
					DBObject filedbj = filenamecursor.next();
					existingfiles.add((String)filelist.get(t)+":"+(String)filedbj.get("name")+":"+(String)filedbj.get("size")+":"+(String)filedbj.get("type"));
				}
			}
		}
		return existingfiles;
	}


	public ArrayList fileExisting(String guidanceid) {
		// TODO Auto-generated method stub
		
		ArrayList filelst = new ArrayList();
		FileUpload fileupload = new FileUpload();
		MongoConnection mongocon = new MongoConnection();
		
		DBCursor filecursor = mongocon.getDBObject("guidancesharedid", guidanceid, "GuidanceContentShare");
		while(filecursor.hasNext()){
			DBObject basicdbj = filecursor.next();
			
			BasicDBList filelist = (BasicDBList)basicdbj.get("guidancefilelistid");
			for(int t=0;t<filelist.size();t++){
				
				DBCursor fileitemcursor = mongocon.getDBObject("id", (String)filelist.get(t), "fileupload");
				while(fileitemcursor.hasNext()){
					
					DBObject filedbj = fileitemcursor.next();
					
					fileupload.setFileid((String)filedbj.get("id"));
					fileupload.setName((String)filedbj.get("name"));
					fileupload.setType((String)filedbj.get("type"));
					fileupload.setSize((Long)filedbj.get("size"));
					
					
					filelst.add(fileupload);
				}
				
			}
			
		}
		
		return filelst;
		
	}


	public void shareToConsumers(String fileid, String userids, String guidanceid) {
		// TODO Auto-generated method stub
		GuidancePreview guideprev = new GuidancePreview();
		String[] consumers = userids.split(",");
		
		GuidanceFileShare guidefileshare = new GuidanceFileShare();
		guidefileshare.setGuidancefileid(fileid);
		guidefileshare.setGuidanceid(guidanceid);
		guidefileshare.setConsumerids(consumers);
		
		MongoConnection mongoconsearch = new MongoConnection();
		BasicDBObject basicreqobjsearch =  guideprev.formShareGuidanceDBObject(guidefileshare);
		
		mongoconsearch.saveObject(basicreqobjsearch, "GuidanceDashFileShare");
		
	}


	private BasicDBObject formShareGuidanceDBObject(GuidanceFileShare guidefileshare) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("consumerids", guidefileshare.getConsumerids());
		basicdbobj.put("guidancefileid", guidefileshare.getGuidancefileid());
		basicdbobj.put("guidanceid", guidefileshare.getGuidanceid());
		
		return basicdbobj;
	}


	public ArrayList getUnSharedConsumers(String fileid, String guidanceid) {
		// TODO Auto-generated method stub
		ArrayList consumerlist = new ArrayList();
		ArrayList totaluserlst = new ArrayList();
		ArrayList shareduserlst = new ArrayList();
		MongoConnection mongocon = new MongoConnection();
		
		
		DBCursor filecursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		while(filecursor.hasNext()){
			DBObject basicdbj = filecursor.next();
			BasicDBList consumerlst = (BasicDBList)basicdbj.get("consumeruserid");
			for(int m=0;m<consumerlst.size();m++){
				totaluserlst.add((String)consumerlst.get(m));
			}
		}
		
		DBCursor usercursor = mongocon.getDBObject("guidancefileid", fileid, "GuidanceDashFileShare");
		while(usercursor.hasNext()){
			DBObject userdbj = usercursor.next();
			BasicDBList sharedconsumerlst = (BasicDBList)userdbj.get("consumerids");
			for(int n=0;n<sharedconsumerlst.size();n++){
				shareduserlst.add((String)sharedconsumerlst.get(n));
			}
		}
		
		for(int t=0;t<totaluserlst.size();t++){
			boolean isnotexist = false;
			String consumer = (String)totaluserlst.get(t);
			for(int i=0;i<shareduserlst.size();i++){
				String sharedconsumer = (String)shareduserlst.get(i);
				if(consumer.equalsIgnoreCase(sharedconsumer)){
					isnotexist = true;
				}
				
			}
			shareduserlst.add(consumer);
			
		}
		
		
		return shareduserlst;
	}


	public ArrayList getAllEvent(String guidanceid) {
		// TODO Auto-generated method stub
		ArrayList alleventlist = new ArrayList();
		MongoConnection mongocon = new MongoConnection();
		
		DBCursor filecursor = mongocon.getDBObject("guidancecalendarid", guidanceid, "GuidanceContentCalendar");
		while(filecursor.hasNext()){
			DBObject basicdbj = filecursor.next();
			BasicDBList eventobj = (BasicDBList)basicdbj.get("guidancecalendareventid");
			for(int i=0;i<eventobj.size();i++){
				
				DBCursor eventcursor = mongocon.getDBObject("eventid", (String)eventobj.get(i), "Event");
				while(eventcursor.hasNext()){
					DBObject eventdbj = eventcursor.next();
					Events events = new Events();
					events.setEvensharedbyuserid((String)eventdbj.get("evensharedbyuserid"));
					events.setEventDescription((String)eventdbj.get("eventDescription"));
					events.setEventendtime((String)eventdbj.get("eventendtime"));
					events.setEvententryid((String)eventdbj.get("evententryid"));
					events.setEventid((String)eventdbj.get("eventid"));
					events.setEventMonth((String)eventdbj.get("eventMonth"));
					events.setEventoccurance((String)eventdbj.get("eventoccurance"));
					events.setEventpriority((String)eventdbj.get("eventpriority"));
					BasicDBList eventsharedtouserids = (BasicDBList)eventdbj.get("eventsharedtouserids");
					ArrayList eventlist = new ArrayList();
					for(int m=0;m<eventsharedtouserids.size();m++){
						eventlist.add((String)eventsharedtouserids.get(m));
					}
					
					
					events.setEventsharedtouserids((String[])eventlist.toArray(new String[eventlist.size()]));
					events.setEventstarttime((String)eventdbj.get("eventstarttime"));
					events.setEventtitle((String)eventdbj.get("eventtitle"));
					events.setEventWeekDay((String)eventdbj.get("eventWeekDay"));
					events.setEventYear((String)eventdbj.get("eventYear"));
					alleventlist.add(events);
					
				}
				
			}
			
			
		}
		
		return alleventlist;
	}


	public void saveNewEvent(String guidanceid, String title, String description, String eventpriority,
			String prioritytype, String entryid, String userid) {
		// TODO Auto-generated method stub
		
		GuidanceContentCalendar guidcontcal = new GuidanceContentCalendar();
		guidcontcal.setGuidancecalendarid(guidanceid);
		
		Events event = new Events();
		event.setEventDescription(description);
		event.setEventendtime("");
		event.setEvententryid(entryid);
		event.setEventMonth("");
		event.setEventoccurance(eventpriority);
		event.setEventpriority(eventpriority);
		event.setEvensharedbyuserid(userid);
		event.setEventstarttime("");
		event.setEventtitle(title);
		event.setEventid(guidanceid);
		String[] eventtimesets = new String[0];
		event.setEventtimesets(eventtimesets);
		event.setEventWeekDay("");
		event.setEventYear("");
		
		Vote vote = new Vote();
		vote.setVoteid(guidanceid);
		//vote.setVoteOptions(voteOptions);
		
		
		
		//event.setEventvoteid(eventvoteid);
		
		
		Events events = new Events();
		
		
	}


	public HashMap getAvailableTime(String guidanceid, String entrydatetime, String entryendtime) {
		// TODO Auto-generated method stub
		
		HashMap profileavailable = new HashMap();
		MongoConnection mongocon = new MongoConnection();
		
		DBCursor guidecursor = mongocon.getDBObject("guidanceid", guidanceid, "GuidanceContent");
		while(guidecursor.hasNext()){
			DBObject guidedbj = guidecursor.next();
			
			BasicDBList consumerlist = (BasicDBList)guidedbj.get("consumeruserid");
			for(int m=0;m<consumerlist.size();m++){
				
				ProfilePreview profprev = new ProfilePreview();
				String eventAvail = profprev.getProfileEventList((String)consumerlist.get(m),entrydatetime,entryendtime);
				if(eventAvail.equalsIgnoreCase("true")){
					Profile profileinfo = profprev.getProfileData((String)consumerlist.get(m));
					profileavailable.put("true", profileinfo);
				}else{
					Profile profileinfo = profprev.getProfileData((String)consumerlist.get(m));
					profileavailable.put("false", profileinfo);
				}
				
			}
		}
		return profileavailable;
	}


	public HashMap getGuidanceInfo(String guidanceid) {
		// TODO Auto-generated method stub
		
		HashMap guidaninfomap = new HashMap();
		MongoConnection mongocon = new MongoConnection();
		
		DBCursor guidecursor = mongocon.getDBObject("guidanceinfoid", guidanceid, "GuidanceInfo");
		while(guidecursor.hasNext()){
			DBObject guidedbj = guidecursor.next();
			
			guidaninfomap.put("Description", (String)guidedbj.get("guidancedescription"));
			guidaninfomap.put("Price", (String)guidedbj.get("guidanceprice"));
			guidaninfomap.put("Experience", (String)guidedbj.get("guidancesubjectexperience"));
			
			ArrayList endorsementlist = new ArrayList();
			
			BasicDBList endorsebylist = (BasicDBList)guidedbj.get("guidanceendorseby");
			for(int m=0;m<endorsebylist.size();m++){
				
				DBCursor endorsecursor = mongocon.getDBObject("companyid",(String)endorsebylist.get(m), "Company");
				while(endorsecursor.hasNext()){
					DBObject companydbj = endorsecursor.next();
					
					endorsementlist.add((String)companydbj.get("companylogoid"));
				}
			}
			
			guidaninfomap.put("Endorsement", endorsementlist);
			
			BasicDBList achievementlist = (BasicDBList)guidedbj.get("guidanceachievements");
			guidaninfomap.put("Achievement", achievementlist);
			
			DBCursor dashcursor = mongocon.getDBObject("guidancecontentDashid",guidanceid, "GuidanceContentDash");
			if(dashcursor.hasNext()){
				DBObject dashdbj = dashcursor.next();
				
				BasicDBList dashdatalist = (BasicDBList)guidedbj.get("guidancedashdataid");
				int remarkavg = 0;
				if(dashdatalist!=null){
					int totaldash = dashdatalist.size();
					int dashcount = 0;
					for(int j=0;j<dashdatalist.size();j++){
						DBCursor dashdatacursor = mongocon.getDBObject("guidancedashdataid",guidanceid, "GuidanceContentDashData");
						while(dashdatacursor.hasNext()){
							DBObject dashdatadbj = dashdatacursor.next();
							String levelrem = (String)dashdatadbj.get("guidancedashlevelremark");
							String helpremark = (String)dashdatadbj.get("guidancedashhelpremark");
							
							dashcount = dashcount + (Integer.parseInt(levelrem)+ Integer.parseInt(helpremark))/2;
					}
					
				  }
					
					if(totaldash > 0 && dashcount > 0 ){
						remarkavg = dashcount/totaldash;
					}
				}
				guidaninfomap.put("Remarks", remarkavg);
				BasicDBList locationlist = (BasicDBList)guidedbj.get("guidancelocationids");
				guidaninfomap.put("Locations", locationlist);
				
				
			}
			
			DBCursor guidrstcursor = mongocon.getDBObject("guidanceid",guidanceid, "GuidanceSelection");
			while(guidrstcursor.hasNext()){
				DBObject guiderstdbj = guidrstcursor.next();
				
				guidaninfomap.put("Subject", (String)guiderstdbj.get("guidanceSubject"));
				guidaninfomap.put("GuidanceType", (String)guiderstdbj.get("guidencetype"));
				guidaninfomap.put("GuidanceDuration", (String)guiderstdbj.get("guidanceduration"));
				BasicDBList guidinterlist = (BasicDBList)guidedbj.get("guidanceinterest");
				
				guidaninfomap.put("GuidanceInterest", guidinterlist);
				guidaninfomap.put("Userid", (String)guiderstdbj.get("userid"));
				
					
			}
			
			
			
	}
		return guidaninfomap;
		
	}


	public String generateInvoice(String userid, String guidanceid, String guidanceitem, String price, String payableto) {
		// TODO Auto-generated method stub
		
		GuidancePreview guidprev = new GuidancePreview();
		
		String uniqueid = "";
		
		try {
			uniqueid = guidprev.makeSHA1Hash(guidanceitem+userid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
        //String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";//example
        
		
		
        Date datepack = new Date();
        DateFunctionality datefunc = new DateFunctionality();
        
        String localdate = datefunc.getUniformDates(formatter.format(datepack));
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(datepack);
        
        String datecurrent = formatter.format(datepack);
		
		Invoice invoice = new Invoice();
		invoice.setInvoicebuyer(userid);
		invoice.setInvoiceid(uniqueid);
		invoice.setInvoiceitem(guidanceid);
		invoice.setInvoiceprice(price);
		invoice.setInvoicedate(datecurrent);
		invoice.setInvoicelocaldate(localdate);
		
		MongoConnection mongoconsearch = new MongoConnection();
		BasicDBObject basicreqobjsearch =  guidprev.formInvoiceDBObject(invoice);
		mongoconsearch.saveObject(basicreqobjsearch, "Invoice");
		
		Bill bill = new Bill();
		bill.setBillid(uniqueid);
		bill.setContractid("");
		bill.setInvoiceid(uniqueid);
		bill.setItem(guidanceitem);
		bill.setLicenseid("");
		bill.setPayfromid(userid);
		bill.setPaymentmethods("");
		bill.setPaytoid(payableto);
		bill.setPlanid(guidanceid);
		bill.setTotalamount(price);
		bill.setBilllocaldate(localdate);
		bill.setBilldate(datecurrent);
		
		BasicDBObject billsaveobj =  guidprev.formBillDBObject(bill);
		mongoconsearch.saveObject(billsaveobj, "Bill");
		
		return uniqueid;
	}


	private BasicDBObject formBillDBObject(Bill bill) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("billid", bill.getBillid());
		basicdbobj.put("contractid", bill.getContractid());
		basicdbobj.put("planid", bill.getPlanid());
		basicdbobj.put("licenseid", bill.getLicenseid());
		basicdbobj.put("invoiceid", bill.getInvoiceid());
		basicdbobj.put("payfromid", bill.getPayfromid());
		basicdbobj.put("paytoid", bill.getPaytoid());
		basicdbobj.put("totalamount", bill.getTotalamount());
		basicdbobj.put("item", bill.getItem());
		basicdbobj.put("paymentmethods", bill.getPaymentmethods());
		basicdbobj.put("billdate", bill.getBilldate());
		basicdbobj.put("billlocaldate", bill.getBilllocaldate());
		
		return basicdbobj;
	}


	private BasicDBObject formInvoiceDBObject(Invoice invoice) {
		// TODO Auto-generated method stub
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("invoiceid", invoice.getInvoiceid());
		basicdbobj.put("invoiceitem", invoice.getInvoiceitem());
		basicdbobj.put("invoiceprice", invoice.getInvoiceprice());
		basicdbobj.put("invoicebuyer", invoice.getInvoicebuyer());
		basicdbobj.put("invoicedate", invoice.getInvoicedate());
		basicdbobj.put("invoicelocaldate", invoice.getInvoicelocaldate());
		
		return basicdbobj;
	}


	public HashMap getBillDetail(String billid) {
		// TODO Auto-generated method stub
		HashMap billmap = new HashMap();
		MongoConnection mongocon = new MongoConnection();
		
		DBCursor guidecursor = mongocon.getDBObject("billid", billid, "Bill");
		if(guidecursor.hasNext()){
			DBObject guidedbj = guidecursor.next();
			
			billmap.put("billid", (String)guidedbj.get("billid"));
			billmap.put("contractid", (String)guidedbj.get("contractid"));
			billmap.put("planid", (String)guidedbj.get("planid"));
			billmap.put("licenseid", (String)guidedbj.get("licenseid"));
			billmap.put("invoiceid", (String)guidedbj.get("invoiceid"));
			billmap.put("payfromid", (String)guidedbj.get("payfromid"));
			billmap.put("paytoid", (String)guidedbj.get("paytoid"));
			billmap.put("totalamount", (String)guidedbj.get("totalamount"));
			billmap.put("item", (String)guidedbj.get("item"));
			billmap.put("paymentmethods", (String)guidedbj.get("paymentmethods"));
			billmap.put("billdate", (String)guidedbj.get("billdate"));
			billmap.put("billlocaldate", (String)guidedbj.get("billlocaldate"));
		}
		
		return billmap;
	}


	public void saveInterest(String guidanceid, String userid) {
		// TODO Auto-generated method stub
		MongoConnection mongocon = new MongoConnection();
		boolean userpresent = false; 
		DBCursor guidrstcursor = mongocon.getDBObject("guidanceid",guidanceid, "GuidanceSelection");
		while(guidrstcursor.hasNext()){
			DBObject guiderstdbj = guidrstcursor.next();
			BasicDBList interestuserlist = (BasicDBList)guiderstdbj.get("guidanceinterest");
			for(int m=0;m<interestuserlist.size();m++){
				if(userid.equalsIgnoreCase((String)interestuserlist.get(m))){
					userpresent = true;
				}
			}
			
		}
		if(!userpresent){
			mongocon.updateObject(new BasicDBObject("guidanceid", guidanceid),new BasicDBObject("$push", new BasicDBObject("guidanceinterest", userid)), "GuidanceEntryShare");
		}
		
	}


	public void createGuidanceEntry(String guidanceid, String userid) {
		// TODO Auto-generated method stub
		String[] assignmentids = null;
		String[] quizids = null;
		String sharedid = "";
		String dashboardid = "";
		String calendarid = "";
		MongoConnection mongocon = new MongoConnection();
		DBCursor guidrstcursor = mongocon.getDBObject("guidanceid",guidanceid, "GuidanceContent");
		while(guidrstcursor.hasNext()){
			DBObject guiderstdbj = guidrstcursor.next();
			BasicDBList assignlist = (BasicDBList)guiderstdbj.get("assignmentids");
			if(assignlist != null){
				assignmentids = assignlist.toArray(new String[assignlist.size()]);
			}else{
				assignmentids = new String[0];
			}
			
			BasicDBList quizlist = (BasicDBList)guiderstdbj.get("quizids");
			if(quizlist !=null){
				quizids = quizlist.toArray(new String[quizlist.size()]);
			}else{
				quizids = new String[0];
			}
			sharedid = (String)guiderstdbj.get("sharetokenid");
			dashboardid = (String)guiderstdbj.get("dashboardid");
			calendarid = (String)guiderstdbj.get("timetableid");
		}
		List filelisttoadd = new ArrayList();
		DBCursor guidsharecursor = mongocon.getDBObject("guidancesharedid",sharedid, "GuidanceContentShare");
		while(guidsharecursor.hasNext()){
			DBObject guidesharedbj = guidsharecursor.next();
			BasicDBList sharedfilelist = (BasicDBList)guidesharedbj.get("guidancefilelistid");
			
			for(int x=0;x<sharedfilelist.size();x++){
				DBCursor guidfilesharecursor = mongocon.getDBObject("guidancefileid",(String)sharedfilelist.get(x), "GuidanceDashFileShare");
				while(guidfilesharecursor.hasNext()){
					DBObject guidefilesharedbj = guidfilesharecursor.next();
					BasicDBList userlist = (BasicDBList)guidefilesharedbj.get("consumerids");
					for(int s=0;s<userlist.size();s++){
						if(((String)userlist.get(s)).equalsIgnoreCase("All")){
							filelisttoadd.add((String)sharedfilelist.get(x));
						}
					}
				}
			}
		}
		
		List eventToAdd = new ArrayList();
		DBCursor guidcallcursor = mongocon.getDBObject("guidancecalendarid",calendarid, "GuidanceContentCalendar");
		while(guidcallcursor.hasNext()){
			DBObject guidecaldbj = guidcallcursor.next();
			BasicDBList calendarlist = (BasicDBList)guidecaldbj.get("guidancecalendareventid");
			
			for(int x=0;x<calendarlist.size();x++){
				DBCursor guidtimetablecursor = mongocon.getDBObject("guidancefileid",(String)calendarlist.get(x), "GuidanceDashFileShare");
				while(guidtimetablecursor.hasNext()){
					DBObject guideeventharedbj = guidtimetablecursor.next();
					BasicDBList userlist = (BasicDBList)guideeventharedbj.get("consumerids");
					for(int s=0;s<userlist.size();s++){
						if(((String)userlist.get(s)).equalsIgnoreCase("All")){
							filelisttoadd.add((String)sharedfilelist.get(x));
						}
					}
				}
			}
		}
		
		
		
		GuidancePreview guidprev = new GuidancePreview();
		
		String uniqueid = "";
		
		try {
			uniqueid = guidprev.makeSHA1Hash(guidanceid+userid);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GuidanceEntryShare guidentrshare = new GuidanceEntryShare();
		guidentrshare.setGuidancecontentshareid(sharedid);
		String[] sharedfileto = (String[]) filelisttoadd.toArray(new String[filelisttoadd.size()]);
		guidentrshare.setFileids(sharedfileto);
		guidentrshare.setGuidanceshareid(uniqueid);
		
		GuidanceContentDashBoardSet guiddasborset = new GuidanceContentDashBoardSet();
		guiddasborset.setGuidancedashboardid(dashboardid);
		String[] guidancedashdataid = new String[0];
		guiddasborset.setGuidancedashdataid(guidancedashdataid);
		guiddasborset.setGuidanceentrydashid(uniqueid);
		guiddasborset.setGuidanceuserid(userid);
		
		GuidanceEntryCalendar guidentrycal = new GuidanceEntryCalendar();
		guidentrycal.setGuidancecalendarid(uniqueid);
		
		GuidanceEntry guideentry = new GuidanceEntry();
		guideentry.setAssignmentids(assignmentids);
		guideentry.setQuizids(quizids);
		guideentry.setAverageVelocity("");
		guideentry.setConsumeguidanceid(guidanceid);
		guideentry.setDashboardid(uniqueid);
		guideentry.setProjectid("");
		guideentry.setSharetokenid(uniqueid);
		String[] topicid = new String[0];
		guideentry.setTopicid(topicid);
		guideentry.setTimetableid(uniqueid);
		
	}
	
}




