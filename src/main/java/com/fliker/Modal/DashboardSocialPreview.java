package com.fliker.Modal;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fliker.SpringMongoConfig;
import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Comment;
import com.fliker.Repository.Like;
import com.fliker.Repository.Post;
import com.fliker.Repository.Profile;
import com.fliker.Repository.Reply;
import com.fliker.Repository.Share;
import com.fliker.Repository.User;
import com.fliker.Utility.DateFunctionality;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class DashboardSocialPreview {

	public ArrayList postlist() {

		ArrayList postlist = new ArrayList<Post>();

		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("Post");
		DBCursor cursor;
		cursor = collection.find().skip(2).limit(10).sort(new BasicDBObject("postid", -1));

		while (cursor.hasNext()) {
			DBObject dbj = cursor.next();
			HashMap totalSet = new HashMap();
			totalSet.put("postid", dbj.get("postid"));
			totalSet.put("postFileid", dbj.get("postFileid"));
			totalSet.put("postType", dbj.get("postType"));
			totalSet.put("postDescription", dbj.get("postDescription"));
			totalSet.put("postiddate", dbj.get("postiddate"));
			totalSet.put("userid", dbj.get("userid"));
			// User Details

			ProfilePreview profprev = new ProfilePreview();
			//User user = profprev.getUser((String) dbj.get("userid"));

			DashboardSocialPreview dashprev = new DashboardSocialPreview();

			//totalSet.put("postuser", user.getUsername());

			// SharedDetails

			ArrayList shareinfo = new ArrayList();
			ArrayList likedinfo = new ArrayList();
			ArrayList commentinfo = new ArrayList();
			
			shareinfo = dashprev.basicdbobj(shareinfo, dbj, "postsharedids");
			likedinfo = dashprev.basicdbobj(likedinfo, dbj, "postlikedids");
			commentinfo = dashprev.basicdbobj(commentinfo, dbj, "postcommentsids");
			
			
			/*BasicDBList sharedids = (BasicDBList) cursor.next().get("postsharedids");
			for (Object shares : sharedids) {
				HashMap shareper = dashprev.getSharedInfo((String)shares);
				shareinfo.add(shareper);
			}*/
			
			/*String sharedstr = (String) dbj.get("postsharedids");
			String[] sharedinfo = null;*/
			
			/*if(!sharedstr.isEmpty()){
				sharedinfo = sharedstr.split(",");
				for (int d = 0; d < sharedinfo.length; d++) {
					HashMap shareper = dashprev.getSharedInfo(sharedinfo[d]);
					shareinfo.add(shareper);
				}
			}*/
			

			// Liked Details
			
			/*ArrayList likedinfo = new ArrayList();
			System.out.println(" objects >?>?>?"+dbj.get("postlikedids"));
			BasicDBList likedidss = (BasicDBList) cursor.next().get("postlikedids");
			
			if(!likedidss.isEmpty()){
			
				BasicDBList likedids = (BasicDBList) cursor.next().get("postlikedids");
				for (Object likes : likedids) {
					HashMap likedper = dashprev.getLikedInfo((String)likes);
					likedinfo.add(likedper);
				}
			}
			
			String likedstr = (String)dbj.get("postlikedids");
			String[] likedinf = null;
			
			if(!likedstr.isEmpty()){		
				likedinf = likedstr.split(",");
				for(int s=0;s<likedinf.length;s++){
					
					HashMap likedper = dashprev.getLikedInfo(likedinf[s]);
					likedinfo.add(likedper);
				}
			}
			
			totalSet.put("postlikeids", likedinfo);*/
			
			/*ArrayList commentinfo = new ArrayList();
			BasicDBList commentids = (BasicDBList) cursor.next().get("postcommentsids");
			for (Object comments : commentids) {
				HashMap commentper = dashprev.getLikedInfo((String)comments);
				commentinfo.add(commentper);
			}*/
			
			/*String commentstr = (String)dbj.get("postcommentsids");
			if(commentstr.isEmpty()){
			
				String[] commentinf = commentstr.split(",");
				for(int s=0;s<commentinf.length;s++){
					
					HashMap commentper = dashprev.getLikedInfo(commentinf[s]);
					commentinfo.add(commentper);
				}

			}*/
			totalSet.put("postsharedids", shareinfo);
			totalSet.put("postlikeids", likedinfo);
			totalSet.put("postcommentids", commentinfo);
			
			postlist.add(totalSet);
		}

		return postlist;
	}

	public ArrayList firstpostlist() {

		ArrayList postlist = new ArrayList<Post>();

		MongoConnection mongoconn = new MongoConnection();
		DBCollection collection = mongoconn.getDBConnection("Post");
		DBCursor cursor;
		cursor = collection.find().limit(8).sort(new BasicDBObject("postid", -1));

		while (cursor.hasNext()) {

			DBObject dbj = cursor.next();
			HashMap totalSet = new HashMap();
			totalSet.put("postid", dbj.get("postid"));
			totalSet.put("postFileid", dbj.get("postFileid"));
			totalSet.put("postType", dbj.get("postType"));
			totalSet.put("postDescription", dbj.get("postDescription"));
			
			Long newtime = (Long) dbj.get("postiddate");
			Long currentTime = System.currentTimeMillis();
			
		    Format format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    //System.out.println("Normal Date ::"+format.format());
		    
		    String postcreatedate = format.format(newtime);
		    String currentdate = format.format(currentTime);
		    
		    DateFunctionality datefunc = new DateFunctionality();
			String postdate = datefunc.getDateDiffference(postcreatedate, currentdate);
			
			System.out.println("Normal Date ::"+postdate);
			
			totalSet.put("postiddate", postdate);
			totalSet.put("userid", dbj.get("userid"));
			// User Details

			ProfilePreview profprev = new ProfilePreview();
			DBObject dbusder = profprev.getUser((String) dbj.get("userid"));

			DashboardSocialPreview dashprev = new DashboardSocialPreview();

			totalSet.put("postuser", dbusder.get("name"));
			totalSet.put("postuserImage", dbusder.get("profileImageid"));

			// SharedDetails

			ArrayList shareinfo = new ArrayList();
			ArrayList likedinfo = new ArrayList();
			ArrayList commentinfo = new ArrayList();
			
			shareinfo = dashprev.basicdbobj(shareinfo, dbj, "postsharedids");
			likedinfo = dashprev.basicdbobj(likedinfo, dbj, "postlikedids");
			commentinfo = dashprev.basicdbobj(commentinfo, dbj, "postcommentsids");
			
			
			/*BasicDBList sharedids = (BasicDBList) cursor.next().get("postsharedids");
			for (Object shares : sharedids) {
				HashMap shareper = dashprev.getSharedInfo((String)shares);
				shareinfo.add(shareper);
			}*/
			
			/*String sharedstr = (String) dbj.get("postsharedids");
			String[] sharedinfo = null;*/
			
			/*if(!sharedstr.isEmpty()){
				sharedinfo = sharedstr.split(",");
				for (int d = 0; d < sharedinfo.length; d++) {
					HashMap shareper = dashprev.getSharedInfo(sharedinfo[d]);
					shareinfo.add(shareper);
				}
			}*/
			

			// Liked Details
			
			/*ArrayList likedinfo = new ArrayList();
			System.out.println(" objects >?>?>?"+dbj.get("postlikedids"));
			BasicDBList likedidss = (BasicDBList) cursor.next().get("postlikedids");
			
			if(!likedidss.isEmpty()){
			
				BasicDBList likedids = (BasicDBList) cursor.next().get("postlikedids");
				for (Object likes : likedids) {
					HashMap likedper = dashprev.getLikedInfo((String)likes);
					likedinfo.add(likedper);
				}
			}
			
			String likedstr = (String)dbj.get("postlikedids");
			String[] likedinf = null;
			
			if(!likedstr.isEmpty()){		
				likedinf = likedstr.split(",");
				for(int s=0;s<likedinf.length;s++){
					
					HashMap likedper = dashprev.getLikedInfo(likedinf[s]);
					likedinfo.add(likedper);
				}
			}
			
			totalSet.put("postlikeids", likedinfo);*/
			
			/*ArrayList commentinfo = new ArrayList();
			BasicDBList commentids = (BasicDBList) cursor.next().get("postcommentsids");
			for (Object comments : commentids) {
				HashMap commentper = dashprev.getLikedInfo((String)comments);
				commentinfo.add(commentper);
			}*/
			
			/*String commentstr = (String)dbj.get("postcommentsids");
			if(commentstr.isEmpty()){
			
				String[] commentinf = commentstr.split(",");
				for(int s=0;s<commentinf.length;s++){
					
					HashMap commentper = dashprev.getLikedInfo(commentinf[s]);
					commentinfo.add(commentper);
				}

			}*/
			totalSet.put("postsharedids", shareinfo);
			totalSet.put("postlikeids", likedinfo);
			totalSet.put("postcommentids", commentinfo);
			
			postlist.add(totalSet);
		}

		
		
		return postlist;
	}

	public HashMap getSharedInfo(String shareid) {

		HashMap sharedinf = new HashMap();

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		Query query = new Query();
		// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
		query.addCriteria(Criteria.where("shareid").is(shareid));
		List<Share> sharelist = mongoOperation.find(query, Share.class);

		for (int i = 0; i < sharelist.size(); i++) {
			Share sharedper = sharelist.get(i);
			
			sharedinf.put("sharedcomment",sharedper.getShareComment());
			sharedinf.put("sharedtime",sharedper.getSharedTime());
			sharedinf.put("sharedLocation",sharedper.getSharedlocation());
			
			ProfilePreview profprev = new ProfilePreview();
			//User userinfo = profprev.getUser(sharedper.getShareOwner());
			
			Profile profprv = profprev.getProfile(sharedper.getShareOwner());
			
			//sharedinf.put("sharedPerson",userinfo.getUsername());
			sharedinf.put("sharedPersonImage",profprv.getProfileImageid());
			
		}

		return sharedinf;

	}

	public HashMap getLikedInfo(String likeid) {

		HashMap likedinf = new HashMap();

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		Query query = new Query();
		// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
		query.addCriteria(Criteria.where("likeid").is(likeid));
		List<Like> likelist = mongoOperation.find(query, Like.class);

		for (int i = 0; i < likelist.size(); i++) {
			Like likedper = likelist.get(i);
			
			likedinf.put("likedtime",likedper.getLiketime());
			
			ProfilePreview profprev = new ProfilePreview();
			//User userinfo = profprev.getUser(likedper.getLikeid());
			
			Profile profprv = profprev.getProfile(likedper.getLikeid());
			
			//likedinf.put("likedOwnerName",userinfo.getUsername());
			likedinf.put("likedOwnerImage",profprv.getProfileImageid());
			
		}

		return likedinf;

	}
	public HashMap getCommentInfo(String commentid) {

		HashMap commentinf = new HashMap();

		MongoConnection mongoconn = new MongoConnection();
		DBCursor commmcursor = mongoconn.getDBObject("commentid", commentid, "Comment");
		
		while(commmcursor.hasNext()){
			
			DBObject dbobj = commmcursor.next();
			
			commentinf.put("commentid",dbobj.get("commentid"));
			commentinf.put("userid",dbobj.get("userid"));
			commentinf.put("commentdate",dbobj.get("commentdate"));
			commentinf.put("comment",dbobj.get("comment"));
			//commentinf.put("replyids",dbobj.get("replyids"));
			
			ProfilePreview profprev = new ProfilePreview();
			//User userinfo = profprev.getUser(commentper.getCommentOwnerid());
			
			ArrayList profprv = new ArrayList();
			profprv = profprev.getProfileInfo(String.valueOf(dbobj.get("userid")));
			
			DashboardSocialPreview dashprev = new DashboardSocialPreview();
			ArrayList replylist = new ArrayList();
			
			String[] replyids = (String.valueOf(dbobj.get("replyids"))).split(",");
			for(int j=0;j<replyids.length;j++){
				
				HashMap replyset = dashprev.getReplyInfo(replyids[j]);
				replylist.add(replyset);
			}
			
			//commentinf.put("commentsOwner",userinfo.getUsername());
			
			commentinf.put("replyids", replylist);
			
		}
		
		
		/*Query query = new Query();
		// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
		query.addCriteria(Criteria.where("commentid").is(commentid));
		List<Comment> commentlist = mongoOperation.find(query, Comment.class);

		for (int i = 0; i < commentlist.size(); i++) {
			Comment commentper = commentlist.get(i);
			
			commentinf.put("comments",commentper.getComments());
			commentinf.put("commentdate",commentper.getCommentdate());
			commentinf.put("commentid",commentper.getCommentid());
			
			
			ProfilePreview profprev = new ProfilePreview();
			//User userinfo = profprev.getUser(commentper.getCommentOwnerid());
			
			Profile profprv = profprev.getProfile(commentper.getCommentOwnerid());
			
			DashboardSocialPreview dashprev = new DashboardSocialPreview();
			ArrayList replylist = new ArrayList();
			
			
			String[] replyids = commentper.getReplyids();
			for(int j=0;j<replyids.length;j++){
				
				HashMap replyset = dashprev.getReplyInfo(replyids[j]);
				replylist.add(replyset);
			}
			
			//commentinf.put("commentsOwner",userinfo.getUsername());
			
			commentinf.put("replyperComment", replylist);*/
			
			
		//}

		return commentinf;

	}
	
	public HashMap getReplyInfo(String replyid) {

		HashMap likedinf = new HashMap();

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		Query query = new Query();
		// query2.addCriteria(Criteria.where("courseOwner").is("dog").and("age").is(40));
		query.addCriteria(Criteria.where("replyid").is(replyid));
		List<Reply> replylist = mongoOperation.find(query, Reply.class);

		for (int i = 0; i < replylist.size(); i++) {
			Reply replyper = replylist.get(i);
			
			likedinf.put("replycomment",replyper.getReplycomment());
			likedinf.put("replytime",replyper.getTime());
			
			ProfilePreview profprev = new ProfilePreview();
			//User userinfo = profprev.getUser(replyper.getReplyownerid());
			
			Profile profprv = profprev.getProfile(replyper.getReplyownerid());
			
			DashboardSocialPreview dashprev = new DashboardSocialPreview();
			
			String[] likeids = replyper.getLikeid();
			
			ArrayList likedlist = new ArrayList();
			
			for(int l=0;l<likeids.length;l++){
				
				HashMap likeidSet = dashprev.getLikedInfo(likeids[l]);
				likedlist.add(likeidSet);
				
			}
			
			likedinf.put("replyliked",likedlist);
			
		}

		return likedinf;

	}
	
	
	public ArrayList basicdbobj(ArrayList resultlist, DBObject dbj, String requiredprop ){
		
		DashboardSocialPreview dashprev = new DashboardSocialPreview();
		
		BasicDBList resultids = (BasicDBList) dbj.get(requiredprop);
		if(resultids!= null){
		for (Object results : resultids) {
			if(requiredprop.equalsIgnoreCase("postsharedids")){
				HashMap commentper = dashprev.getSharedInfo((String)results);
				resultlist.add(commentper);
			}else if(requiredprop.equalsIgnoreCase("postlikedids")){
				HashMap commentper = dashprev.getLikedInfo((String)results);
				resultlist.add(commentper);
			}else if(requiredprop.equalsIgnoreCase("postcommentsids")){
				BasicDBObject resuobj = (BasicDBObject) results;
				HashMap commentper = dashprev.getCommentInfo((String)resuobj.getString("comments"));
				resultlist.add(commentper);
			}
			}
		}else{
			resultlist.add("");
		}
		
		return resultlist;
	}
	
	
}
