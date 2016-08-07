package com.fliker.Modal;

import java.net.UnknownHostException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fliker.SpringMongoConfig;
import com.fliker.Repository.Share;
import com.fliker.Repository.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

public class SharePreview {

	private static final String HOST = "localhost";
	 
    private static final int PORT = 27017;
 
    private static final String dbname = "testdb";
    
    private static final String collectionname = "Post";
    /**
     * @return Mongo
     * @throws UnknownHostException
     */
    public static Mongo getConnection() throws UnknownHostException {
        return new Mongo(HOST, PORT);
    }
 
    /**
     * @param dbName
     * @param collectionName
     * @return
     * @throws UnknownHostException
     */
    private static DBCollection getCollection(final String dbName,
            final String collectionName) throws UnknownHostException {
        Mongo mongo = getConnection();
        DB db = mongo.getDB(dbName);
        return db.getCollection(collectionName);
    }
    
    public void sharedToPost(User usershared, String commentedtoPostid, String commentOnShare) throws UnknownHostException {
    	
    	/*ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    	
    	Query searchUserQuery1 = new Query(Criteria.where("_id").is("Reetesh1462933165931bicycle-1280x720"));
		Post postentry = mongoOperation.findOne(searchUserQuery1, Post.class);*/
    	
    	
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Query searchUserQuery = new Query(Criteria.where("username").is(usershared.getUsername()));
		User userentry = mongoOperation.findOne(searchUserQuery, User.class);
		
		
		String sharedid = userentry.getUserid()+System.currentTimeMillis()+commentedtoPostid;
		String shareowner = userentry.getUsername();
		String shareToPostid = commentedtoPostid;
		String shareOnComment = commentOnShare;
    	
    	/*Comment comments = new Comment();
    	comments.setCommentid(userentry.getId()+System.currentTimeMillis()+"Reetesh1462933165931bicycle-1280x720");
    	comments.setCommentOwner(userentry);
    	comments.setComments(newComment);
    	comments.setPostcommentid("Reetesh1462933165931bicycle-1280x720");
    	comments.setReply(true);*/
    	
    	
        WriteResult result = addShare(new BasicDBObject("_id", commentedtoPostid),sharedid,shareowner, shareToPostid,shareOnComment );
        /*if (null == result.getError()) {
            System.out.println("Comment is Successfully added");
        }*/
    }
 
    private WriteResult addShare(final BasicDBObject incidentObject,String sharedid, String shareowner, String shareToPostid, String shareOnComment)
            throws UnknownHostException {
        final BasicDBObject commentObject = new BasicDBObject();
        commentObject.put("sharedid", sharedid);
        commentObject.put("shareowner", shareowner);
        commentObject.put("shareToPostid", shareToPostid);
        if(shareOnComment.isEmpty()){
        	commentObject.put("sharedComment", " ");
        }else{
        	commentObject.put("sharedComment", shareOnComment);
        }
        
 
        final DBCollection incidentsCollection = getCollection(dbname,
        		collectionname);
        return incidentsCollection.update(incidentObject, new BasicDBObject(
                "$push", new BasicDBObject("postshared", commentObject)), false,
                false);
    }
    
    
    public void updateShareTable(User usercommented, String sharetoPostid, String sharedcomment){
    	
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Query searchUserQuery = new Query(Criteria.where("username").is(usercommented.getUsername()));
		User userentry = mongoOperation.findOne(searchUserQuery, User.class);
		
		String currentTime = String.valueOf(System.currentTimeMillis());
		
		Share shared = new Share();
		shared.setShareComment(sharedcomment);
		shared.setShareid(userentry.getUsername()+System.currentTimeMillis()+sharetoPostid);
		shared.setSharedTime(currentTime);
		shared.setShareOwner(userentry.getUserid());
		
		mongoOperation.save(shared);
		
    	
    }
	
}
