package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="PostCache")
public class PostCache {

	
	private String profileid;
	private String[] postid;
	public String getProfileid() {
		return profileid;
	}
	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}
	public String[] getPostid() {
		return postid;
	}
	public void setPostid(String[] postid) {
		this.postid = postid;
	}
	
	
	
}
