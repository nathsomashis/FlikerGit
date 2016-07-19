package com.fliker.Modal;

import java.net.UnknownHostException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fliker.SpringMongoConfig;
import com.fliker.Repository.Comment;
import com.fliker.Repository.Like;
import com.fliker.Repository.Post;
import com.fliker.Repository.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

public class CommentsPreview {

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
    
    public static void arrayToPost(User usercommented, String commentedtoPostid, String comment) throws UnknownHostException {
    	
    	/*ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    	
    	Query searchUserQuery1 = new Query(Criteria.where("_id").is("Reetesh1462933165931bicycle-1280x720"));
		Post postentry = mongoOperation.findOne(searchUserQuery1, Post.class);*/
    	
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Query searchUserQuery = new Query(Criteria.where("username").is(usercommented.getUsername()));
		User userentry = mongoOperation.findOne(searchUserQuery, User.class);
		
		
		String commentid = userentry.getUserid()+System.currentTimeMillis()+commentedtoPostid;
		String commentOwner = userentry.getUsername();
		String comments = comment;
		String commentPost = commentedtoPostid;
		
    	
    	/*Comment comments = new Comment();
    	comments.setCommentid(userentry.getId()+System.currentTimeMillis()+"Reetesh1462933165931bicycle-1280x720");
    	comments.setCommentOwner(userentry);
    	comments.setComments(newComment);
    	comments.setPostcommentid("Reetesh1462933165931bicycle-1280x720");
    	comments.setReply(true);*/
    	
    	
        WriteResult result = addComment(new BasicDBObject("_id", commentedtoPostid),commentid,commentOwner, comments, commentPost );
        /*if (null == result.) {
            System.out.println("Comment is Successfully added");
        }*/
    }
 
    private static WriteResult addComment(final BasicDBObject incidentObject,String commentid, String commentOwner, String commentsPosted, String commentOfPost)
            throws UnknownHostException {
        final BasicDBObject commentObject = new BasicDBObject();
        commentObject.put("commentid", commentid);
        commentObject.put("commentOwner", commentOwner);
        commentObject.put("commentsPosted", commentsPosted);
        commentObject.put("commentOfPost", commentOfPost);
        
 
        final DBCollection incidentsCollection = getCollection(dbname,
        		collectionname);
        return incidentsCollection.update(incidentObject, new BasicDBObject(
                "$push", new BasicDBObject("postcomments", commentObject)), false,
                false);
    }
    
public void updateCommentTable(User usercommented, String commentedtoPostid, String comment){
    	
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		
		Query searchUserQuery = new Query(Criteria.where("username").is(usercommented.getUsername()));
		User userentry = mongoOperation.findOne(searchUserQuery, User.class);
		
		StringBuilder commentsection = new StringBuilder();
		commentsection.append(comment);
		
		Comment comments = new Comment();
		comments.setCommentid(userentry.getUsername()+System.currentTimeMillis()+commentedtoPostid);
		comments.setCommentOwnerid(userentry.getUserid());//(userentry);
		comments.setComments(comment);//(commentsection);
		//comments.setPostcommentid(commentedtoPostid);
		
		
		mongoOperation.save(comments);
		
    	
    }
    
	
}
