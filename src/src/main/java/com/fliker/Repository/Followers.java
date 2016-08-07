package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Followers")
public class Followers {

	private String followerid;
	private String userid;
	public String getFollowerid() {
		return followerid;
	}
	public void setFollowerid(String followerid) {
		this.followerid = followerid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	public Followers(){
		
	}
	
	public Followers(String followerid, String userid){
		
		this.followerid = followerid;
		this.userid = userid;
		
	}
	
}
