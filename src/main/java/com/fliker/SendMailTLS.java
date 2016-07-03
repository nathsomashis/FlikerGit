package com.fliker;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public static void main(String[] args) {

		final String username = "somashis.nath@gmail.com";
		final String password = "lamborginireventon";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("somashis.nath@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("somashis.nath@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			System.out.println("before transport"+message);
			
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		
		class GMailAuthenticator extends Authenticator {
		     String user;
		     String pw;
		     public GMailAuthenticator (String username, String password)
		     {
		        super();
		        this.user = username;
		        this.pw = password;
		     }
		    public PasswordAuthentication getPasswordAuthentication()
		    {
		       return new PasswordAuthentication(user, pw);
		    }
		}
		
		
	}
}
