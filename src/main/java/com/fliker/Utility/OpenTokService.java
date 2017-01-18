package com.fliker.Utility;

import com.opentok.ArchiveMode;
import com.opentok.MediaMode;
import com.opentok.OpenTok;
import com.opentok.Session;
import com.opentok.SessionProperties;
import com.opentok.exception.OpenTokException;

public class OpenTokService {

	private int apiKey = 45637402;
	private String apiSecret = "8a2e40957c2a3c6159c47b757a906271a34d9fb2";
	
	public String createSession(){
		
		OpenTok opentok = new OpenTok(apiKey, apiSecret);
		
		// A session that attempts to stream media directly between clients:
		//Session session = opentok.createSession();

		// A session that uses the OpenTok Media Router (which is required for archiving):
		/*Session session = opentok.createSession(new SessionProperties.Builder()
		  .mediaMode(MediaMode.ROUTED)
		  .build());*/

		// A Session with a location hint:
		/*Session session = opentok.createSession(new SessionProperties.Builder()
		  .location("12.34.56.78")
		  .build());*/

		// A session that is automatically archived (it must used the routed media mode)
		Session session = null;
		try {
			session = opentok.createSession(new SessionProperties.Builder()
			  .mediaMode(MediaMode.ROUTED)
			  .archiveMode(ArchiveMode.ALWAYS)
			  .build());
		} catch (OpenTokException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Store this sessionId in the database for later use:
		String sessionId = session.getSessionId();
		
		return sessionId;
	}
	
	public String generateTokens( String sesionids){
		
		OpenTok opentok = new OpenTok(apiKey, apiSecret);
		
		OpenTokService opentokser = new OpenTokService();
		
		// Generate a token from just a sessionId (fetched from a database)
		String token = null;
		try {
			token = opentok.generateToken(sesionids);
		} catch (OpenTokException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Generate a token by calling the method on the Session (returned from createSession)
		//String token = session.generateToken();

		// Set some options in a token
		/*String token = session.generateToken(new TokenOptions.Builder()
		  .role(Role.MODERATOR)
		  .expireTime((System.currentTimeMillis() / 1000L) + (7 * 24 * 60 * 60)) // in one week
		  .data("name=Johnny")
		  .build());*/
		
		return token;
		
	}
	
	public void archieveOperation(){
		
	}
	
	public void savearchieves(){
		
	}
	
	public static void main(String args[]){
		
		OpenTokService opentokser = new OpenTokService();
		
		String sessionid = opentokser.createSession();
		
		String token = opentokser.generateTokens(sessionid);
		
		System.out.println(token);
	}
	
}
