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
import com.fliker.Repository.Post;
import com.fliker.Repository.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

public class CommentsPreview {

	private static final String HOST = "localhost";

	private static final int PORT = 27017;

	private static final String dbname = "fliker";

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
	private static DBCollection getCollection( String dbName, String collectionName)
			throws UnknownHostException {
		MongoConnection mongoconn = new MongoConnection();
		return mongoconn.getDBConnection(collectionName);
	}

	public static void arrayToPost(Comment comment, String postid)
			throws UnknownHostException {

		/*
		 * ApplicationContext ctx = new
		 * AnnotationConfigApplicationContext(SpringMongoConfig.class);
		 * MongoOperations mongoOperation = (MongoOperations)
		 * ctx.getBean("mongoTemplate");
		 * 
		 * Query searchUserQuery1 = new
		 * Query(Criteria.where("_id").is("Reetesh1462933165931bicycle-1280x720"
		 * )); Post postentry = mongoOperation.findOne(searchUserQuery1,
		 * Post.class);
		 */

		/*ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");*/

		

		String commentid = comment.getCommentid();
		/*String commentOwner = comment.getCommentOwnerid();
		String comments = comment.getComments();
		String commentPost = postid;
		String commentDate = comment.getCommentdate();*/

		/*
		 * Comment comments = new Comment();
		 * comments.setCommentid(userentry.getId()+System.currentTimeMillis()+
		 * "Reetesh1462933165931bicycle-1280x720");
		 * comments.setCommentOwner(userentry);
		 * comments.setComments(newComment);
		 * comments.setPostcommentid("Reetesh1462933165931bicycle-1280x720");
		 * comments.setReply(true);
		 */

		WriteResult result = addComment(new BasicDBObject("postid", postid), commentid );
		/*
		 * if (null == result.) {
		 * System.out.println("Comment is Successfully added"); }
		 */
	}

	private static WriteResult addComment(BasicDBObject incidentObject, String commentid) throws UnknownHostException {
		BasicDBObject commentObject = new BasicDBObject();
		commentObject.put("commentid", commentid);
		/*commentObject.put("commentOwner", commentOwner);
		commentObject.put("commentsPosted", commentsPosted);
		commentObject.put("commentOfPost", commentOfPost);*/
		
		
		/*DBObject listItem = new BasicDBObject("scores", new BasicDBObject("type","quiz").append("score",99));
		DBObject updateQuery = new BasicDBObject("$push", listItem);
		myCol.update(findQuery, updateQuery);*/

		DBCollection incidentsCollection = getCollection(dbname, "Post");
		return incidentsCollection.update(incidentObject,
				new BasicDBObject("$push", new BasicDBObject("postcommentsids", commentObject)));
	}

	public void updateCommentTable(User usercommented, String commentedtoPostid, String comment) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		Query searchUserQuery = new Query(Criteria.where("username").is(usercommented.getUsername()));
		User userentry = mongoOperation.findOne(searchUserQuery, User.class);

		StringBuilder commentsection = new StringBuilder();
		commentsection.append(comment);

		Comment comments = new Comment();
		comments.setCommentid(userentry.getUsername() + System.currentTimeMillis() + commentedtoPostid);
		comments.setCommentOwnerid(userentry.getUserid());// (userentry);
		comments.setComments(comment);// (commentsection);
		// comments.setPostcommentid(commentedtoPostid);

		mongoOperation.save(comments);

	}

	public void saveComment(String userid, String commentPostid, String comment) {

		MongoConnection mongoconn = new MongoConnection();
		CommentsPreview commprev = new CommentsPreview();
		
		Comment comments = new Comment();
		try {
			comments.setCommentid(commprev.makeSHA1Hash(comment));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comments.setCommentdate(String.valueOf(System.currentTimeMillis()));
		comments.setCommentOwnerid(userid);
		comments.setComments(comment);
		comments.setReplyids(null);
		

		mongoconn.saveObject(commprev.formDBObject(comments), "Comment");
		
		try {
			CommentsPreview.arrayToPost(comments, commentPostid);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public BasicDBObject formDBObject(Comment commentinfo) {

		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("commentid", commentinfo.getCommentid());
		basicdbobj.put("userid", commentinfo.getCommentOwnerid());
		basicdbobj.put("commentdate", commentinfo.getCommentdate());
		basicdbobj.put("comment", commentinfo.getComments());
		basicdbobj.put("replyids", commentinfo.getReplyids());

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
	
	
	public void saveCommentToPost(){
		
	}

}
