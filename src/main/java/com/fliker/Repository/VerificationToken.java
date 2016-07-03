package com.fliker.Repository;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="VerificationToken")
public class VerificationToken {

	 private static final int EXPIRATION = 60 * 24;
	 
	 @Id
	 private String token;
	 private String userid;
	 private String expiryDate;
	 private boolean verified;
	 
	
    public VerificationToken(String token, String userid) {
        super();
        this.token = token;
        this.userid = userid;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
        this.verified = false;
    }
     
    private String calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        String newtime = Long.toString(cal.getTime().getTime());
        
        return newtime;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
    
    
	
}
