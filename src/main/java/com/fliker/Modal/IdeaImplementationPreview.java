package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.IdeaToWork;
import com.fliker.Repository.Post;
import com.fliker.Repository.Profile;
import com.fliker.Repository.SearchContent;
import com.fliker.Utility.ServicesUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class IdeaImplementationPreview {

	public ArrayList getAllIdeaWork(String lastid){
		
		ArrayList ideaworklist = new ArrayList();
		
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("IdeaWork");
		DBCursor cursor;
		if(lastid.isEmpty()){
			cursor = collection.find().limit(50).sort(new BasicDBObject("ideaworkid",-1));
		}else{
			cursor = collection.find(new BasicDBObject("ideaworkid", lastid)).limit(50).sort(new BasicDBObject("ideaworkid",-1));
		}
		
		while(cursor.hasNext()){
			ideaworklist.add(cursor.next());
		}
		
		
		return ideaworklist;
	}
	
	public void saveIdeaWork(String textsection,String userid, String[] filetoupload, String location,HttpServletRequest request){
		
		IdeaToWork ideawork = new IdeaToWork();
		ideawork.setTextwork(textsection);
		ideawork.setFiletoupload(filetoupload);
		ideawork.setUserid(userid);
		
		
		ServicesUtil servutil = new ServicesUtil();
		String locationaddress = servutil.getLocationAddress(location);
		System.out.println(" locationaddress ++"+locationaddress);
		ideawork.setLocation(locationaddress);
		
		IdeaImplementationPreview ideaprev = new IdeaImplementationPreview();
		String uniqueid = "";
		
		try {
			uniqueid = ideaprev.makeSHA1Hash(userid+locationaddress);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ideawork.setIdeaworkid(uniqueid+System.currentTimeMillis());
		
		String ideaworkid = ideawork.getIdeaworkid();
		
		MongoConnection mongocon = new MongoConnection();
		
		BasicDBObject basicreqobj =  ideaprev.formDBObject(ideawork);
		
		mongocon.saveObject(basicreqobj, "Post");
		//lots of operation needed to do here
		
		ArrayList profileinfos = new ArrayList();
		
		ProfilePreview profprev = new ProfilePreview();
		profileinfos = profprev.getProfileInfo(userid);
		
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
		
		
		for(int m=0;m<profileinfos.size();m++){
			
			
			if(profileinfos.get(m) instanceof Profile){
				Profile profileinfo = (Profile)profileinfos.get(m);
				imageid = profileinfo.getProfileImageid();
				skypeid = profileinfo.getSkypeid();
				name = profileinfo.getName();
				emailid = profileinfo.getEmailid();
				currentStatus = profileinfo.getCurrentStatus();
				experience = profileinfo.getExperience();
				hangoverid = profileinfo.getHangoverid();
				contact = profileinfo.getContact();
				
				
			}else{
				
				HashMap collectionlist = (HashMap)profileinfos.get(m);
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
		
		
		String postlink = ideaprev.formLink(request.getRequestURL().toString(), request.getContextPath().toString(),"projectview",ideaworkid);
		SearchContent searchcontent = new SearchContent();
		searchcontent.setSearchid(uniqueid);
		searchcontent.setContentDescription("Idea ::"+textsection+" Profile Image ::"+imageid+" Profile Name ::"+name+" Profile Email ::"+emailid+
				" Profile Status ::"+currentStatus+" Profile Experience ::"+experience+" Profile Hangover ::"+hangoverid+" Profile Articles ::"+articlecount+
				" Idea Link ::");
		searchcontent.setContentLink("");
		searchcontent.setContentType("IdeaWork");
		
		MongoConnection mongoconsearch = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch =  searchprev.formDBObject(searchcontent);
		
		mongoconsearch.saveObject(basicreqobjsearch, "SearchContent");
		//mongoOperation.save(postentry);
		
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
	
	
	public BasicDBObject formDBObject(IdeaToWork ideawork){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("ideaworkid", ideawork.getIdeaworkid());
		basicdbobj.put("userid", ideawork.getUserid());
		basicdbobj.put("textwork", ideawork.getTextwork());
		basicdbobj.put("filetoupload", ideawork.getFiletoupload());
		basicdbobj.put("location", ideawork.getLocation());
		
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
	
}
