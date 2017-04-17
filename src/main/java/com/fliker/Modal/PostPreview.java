package com.fliker.Modal;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fliker.SpringMongoConfig;
import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Comment;
import com.fliker.Repository.FileUpload;
import com.fliker.Repository.Like;
import com.fliker.Repository.Post;
import com.fliker.Repository.SearchContent;
import com.fliker.Repository.Share;
import com.fliker.Repository.User;
import com.fliker.Utility.ServicesUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class PostPreview {

	
	public ArrayList getPosts(String lastid){
		
		ArrayList postlist = new ArrayList();
		
		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("Post");
		DBCursor cursor;
		if(lastid.isEmpty()){
			cursor = collection.find().limit(50).sort(new BasicDBObject("_id",-1));
		}else{
			cursor = collection.find(new BasicDBObject("_id", lastid)).limit(50).sort(new BasicDBObject("_id",-1));
		}
		
		while(cursor.hasNext()){
			postlist.add(cursor.next());
		}
		
		
		return postlist;
	}
	
	
	public void savePost(String userinformation,String PostComment, String[] filetoupload, String location){
		
		Post postentry = new Post();
		
		postentry.setUserid(userinformation);
		postentry.setPostType("Post");
		//postentry.setVoteid(null);
		postentry.setPostDescription(PostComment);
		
		postentry.setPostFileid(filetoupload);
		
		ServicesUtil servutil = new ServicesUtil();
		String locationaddress = servutil.getLocationAddress(location);
		System.out.println(" locationaddress ++"+locationaddress);
		postentry.setPostlocation(locationaddress);
		
		PostPreview postprev = new PostPreview();
		String uniqueid = "";
		
		try {
			uniqueid = postprev.makeSHA1Hash(PostComment);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		postentry.setPostid(userinformation+uniqueid+System.currentTimeMillis());
		
		MongoConnection mongocon = new MongoConnection();
		
		BasicDBObject basicreqobj =  postprev.formDBObject(postentry);
		
		mongocon.saveObject(basicreqobj, "Post");
		//lots of operation needed to do here
		
		
		SearchContent searchcontent = new SearchContent();
		searchcontent.setSearchid(uniqueid);
		searchcontent.setContentDescription(userinformation+":"+PostComment+":"+filetoupload.toString()+":"+locationaddress);
		searchcontent.setContentLink("");
		searchcontent.setContentType("Post");
		
		MongoConnection mongoconsearch = new MongoConnection();
		SearchPreview searchprev = new SearchPreview();
		BasicDBObject basicreqobjsearch =  searchprev.formDBObject(searchcontent);
		
		mongoconsearch.saveObject(basicreqobjsearch, "Content");
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
	
	
	public BasicDBObject formDBObject(Post postinfo){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("postid", postinfo.getPostid());
		basicdbobj.put("userid", postinfo.getUserid());
		basicdbobj.put("postFileid", postinfo.getPostFileid());
		basicdbobj.put("postType", postinfo.getPostType());
		basicdbobj.put("postDescription", postinfo.getPostDescription());
		basicdbobj.put("postiddate", System.currentTimeMillis());
		
		return basicdbobj;
		
	}
	
	
	public void publishPost(String userinformation, String PostComment, String location){
		
		Post postentry = new Post();
		
		postentry.setUserid(userinformation);
		postentry.setPostType("Publish");
		//postentry.setVoteid(null);
		postentry.setPostDescription(PostComment);
		
		ServicesUtil servutil = new ServicesUtil();
		String locationaddress = servutil.getLocationAddress(location);
		System.out.println(" locationaddress ++"+locationaddress);
		postentry.setPostlocation(locationaddress);
		
		PostPreview postprev = new PostPreview();
		String uniqueid = "";
		
		try {
			uniqueid = postprev.makeSHA1Hash(PostComment);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		postentry.setPostid(userinformation+uniqueid+System.currentTimeMillis());
		
		
		MongoConnection mongocon = new MongoConnection();
		
		BasicDBObject basicreqobj =  postprev.formDBObject(postentry);
		
		mongocon.saveObject(basicreqobj, "Post");
		
	}


	public String getPostID() {
		// TODO Auto-generated method stub
		return null;
	}
}
