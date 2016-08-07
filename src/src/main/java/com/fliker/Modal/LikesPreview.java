package com.fliker.Modal;

import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fliker.SpringMongoConfig;
import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.Comment;
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
    
    public void likeToPost(Like likes, String commentedtoPostid) throws UnknownHostException {
    	
    	/*ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    	
    	Query searchUserQuery1 = new Query(Criteria.where("_id").is("Reetesh1462933165931bicycle-1280x720"));
		Post postentry = mongoOperation.findOne(searchUserQuery1, Post.class);*/
    	
    	
    	/*ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
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
		String likeToPostid = commentedtoPostid;*/
		
    	
    	/*Comment comments = new Comment();
    	comments.setCommentid(userentry.getId()+System.currentTimeMillis()+"Reetesh1462933165931bicycle-1280x720");
    	comments.setCommentOwner(userentry);
    	comments.setComments(newComment);
    	comments.setPostcommentid("Reetesh1462933165931bicycle-1280x720");
    	comments.setReply(true);*/
    	
    	
        WriteResult result = addLike(new BasicDBObject("postid", commentedtoPostid),likes.getLikeid() );
       /* if (null == result.getError()) {
            System.out.println("Comment is Successfully added");
        }*/
    }
 
    private WriteResult addLike(BasicDBObject incidentObject,String likeid)
            throws UnknownHostException {
         BasicDBObject likeobject = new BasicDBObject();
        likeobject.put("likeid", likeid);
        
        MongoConnection mongoconn = new MongoConnection();
		mongoconn.updateObject(incidentObject, new BasicDBObject("$push", new BasicDBObject("postliked", likeobject)), "Post");
 
        final DBCollection incidentsCollection = getCollection(dbname,
        		collectionname);
        return incidentsCollection.update(incidentObject, new BasicDBObject(
                "$push", new BasicDBObject("postliked", likeobject)), false,
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
    
    public void saveLike(String userid, String commentPostid) {

		MongoConnection mongoconn = new MongoConnection();
		LikesPreview likeprev = new LikesPreview();
		
		Like likes = new Like();
		try {
			likes.setLikeid(likeprev.makeSHA1Hash(userid));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		likes.setLiketime(String.valueOf(System.currentTimeMillis()));
		likes.setLikeOwner(userid);
		
		

		mongoconn.saveObject(likeprev.formDBObject(likes), "Like");
		
		try {
			likeprev.likeToPost(likes, commentPostid);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
    
    public BasicDBObject formDBObject(Like likeinfo) {

		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("likeid", likeinfo.getLikeid());
		basicdbobj.put("userid",likeinfo.getLikeOwner() );
		basicdbobj.put("likedate", likeinfo.getLiketime());

		return basicdbobj;

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
    

}
