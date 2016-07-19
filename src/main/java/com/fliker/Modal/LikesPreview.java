package com.fliker.Modal;

import java.net.UnknownHostException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fliker.SpringMongoConfig;
import com.fliker.Repository.Like;
import com.fliker.Repository.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

public class LikesPreview {
	
	
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
    
    public void likeToPost(User usercommented, String commentedtoPostid, boolean liked) throws UnknownHostException {
    	
    	/*ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    	
    	Query searchUserQuery1 = new Query(Criteria.where("_id").is("Reetesh1462933165931bicycle-1280x720"));
		Post postentry = mongoOperation.findOne(searchUserQuery1, Post.class);*/
    	
    	
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Query searchUserQuery = new Query(Criteria.where("username").is(usercommented.getUsername()));
		User userentry = mongoOperation.findOne(searchUserQuery, User.class);
		
		
		String likeid = userentry.getUserid()+System.currentTimeMillis()+commentedtoPostid;
		String likeowner = userentry.getUsername();
		String likedPost = "";
		if(liked){
			likedPost = "true";
		}else{
			likedPost = "false";
		}
		String likeToPostid = commentedtoPostid;
		
    	
    	/*Comment comments = new Comment();
    	comments.setCommentid(userentry.getId()+System.currentTimeMillis()+"Reetesh1462933165931bicycle-1280x720");
    	comments.setCommentOwner(userentry);
    	comments.setComments(newComment);
    	comments.setPostcommentid("Reetesh1462933165931bicycle-1280x720");
    	comments.setReply(true);*/
    	
    	
        WriteResult result = addLike(new BasicDBObject("_id", commentedtoPostid),likeid,likeowner, likedPost, likeToPostid );
       /* if (null == result.getError()) {
            System.out.println("Comment is Successfully added");
        }*/
    }
 
    private WriteResult addLike(final BasicDBObject incidentObject,String likeid, String likeowner, String likedPost, String likeToPostid)
            throws UnknownHostException {
        final BasicDBObject commentObject = new BasicDBObject();
        commentObject.put("likeid", likeid);
        commentObject.put("likeowner", likeowner);
        commentObject.put("likedPost", likedPost);
        commentObject.put("likeToPostid", likeToPostid);
        
 
        final DBCollection incidentsCollection = getCollection(dbname,
        		collectionname);
        return incidentsCollection.update(incidentObject, new BasicDBObject(
                "$push", new BasicDBObject("postliked", commentObject)), false,
                false);
    }
    
    
    public void updateLikeTable(User usercommented, String commentedtoPostid){
    	
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Query searchUserQuery = new Query(Criteria.where("username").is(usercommented.getUsername()));
		User userentry = mongoOperation.findOne(searchUserQuery, User.class);
		
		Like likes = new Like();
		likes.setLikeOwner(usercommented.getUserid());
		//likes.setLikedpost(commentedtoPostid);
		likes.setLikeid(usercommented.getUsername()+System.currentTimeMillis()+commentedtoPostid);
		
		mongoOperation.save(likes);
		
    	
    }

}
