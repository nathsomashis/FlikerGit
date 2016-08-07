package com.fliker.Utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.fliker.Connection.MongoConnection;
import com.fliker.Repository.User;
import com.fliker.Repository.VerificationToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ActivationUtility {

	
	public String createActivationLink(String newuserid){
		
		
		String newhyper = "";
		ActivationUtility activate = new ActivationUtility();
		String activationtoken = "";
		try {
			activationtoken = activate.makeSHA1Hash(newuserid);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		newhyper="http://localhost:8080/Fliker/dashboardactivate?activation="+activationtoken;
		
		if(!newuserid.isEmpty()){
			VerificationToken verifytok = new VerificationToken(newhyper, newuserid);
			ActivationUtility activutil = new ActivationUtility();
			activutil.saveTokenForUser(verifytok);
		}
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("somashis.nath@gmail.com","lamborghinireventon");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("somashis.nath@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("somashis.nath@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n Verification mail from fliker, please click on the link to activate your account!"+
					"\n\n"+newhyper);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
		return newhyper;
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
	
	
	public void saveTokenForUser(VerificationToken veriftok){
		
		MongoConnection mongoconn = new MongoConnection();
		ActivationUtility activutil = new ActivationUtility();
		
		mongoconn.saveObject(activutil.formDBObject(veriftok), "VerificationToken");
		
	}
	
	public BasicDBObject formDBObject(VerificationToken veriftok){
		
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.put("token", veriftok.getToken());
		basicdbobj.put("userid", veriftok.getUserid());
		basicdbobj.put("expiryDate", veriftok.getExpiryDate());
		basicdbobj.put("verified", veriftok.isVerified());
		
		return basicdbobj;
		
	}
	
	
	public String activateUser(String activation){
		
		String message="";
		String tokens = "http://localhost:8080/Fliker/dashboardactivate?activation="+activation;
		
		MongoConnection mongocon = new MongoConnection();
		DBCursor resultcursor = mongocon.getDBObject("token", tokens, "VerificationToken");
		 
		if(resultcursor.hasNext()){
			DBObject theObj = resultcursor.next();
		    //How to get the DBObject value to ArrayList of Java Object?

		    /*BasicDBList passwordlist = (BasicDBList) theObj.get("password");
		    for (int i = 0; i < passwordlist.size(); i++) {
		        BasicDBObject passwordobj = (BasicDBObject) passwordlist.get(i);
		        String passwordword = passwordobj.getString("password");
		        

		        students.add(student);
		    } */
			
			/*BasicDBObject passwordobj = (BasicDBObject)theObj.get("password");*/
			String userid = (String) theObj.get("userid");
			DBCursor useridconn = mongocon.getDBObject("userid", userid, "User");
			
			BasicDBObject searchQuery = new BasicDBObject().append("userid", userid);
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.append("$set", new BasicDBObject().append("enabled", true));
			
			mongocon.updateObject(searchQuery, newDocument, "User");
			
			/*if(useridconn.hasNext()){
				DBObject userobj = resultcursor.next();
				
				BasicDBObject passwordobj = (BasicDBObject)userobj.get("password");
				
				
			}*/
			
		}else{
			message = "The username is not valid";
		}
		
		
		return message;
		
	}
	
	
	
}
