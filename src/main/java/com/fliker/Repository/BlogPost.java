package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="BlogPost")
public class BlogPost {

	@Id
	private String postid;
	private String postuserid;
	private String postdatetime;
	private String postdata;
	private String[] postfileids;
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getPostuserid() {
		return postuserid;
	}
	public void setPostuserid(String postuserid) {
		this.postuserid = postuserid;
	}
	public String getPostdatetime() {
		return postdatetime;
	}
	public void setPostdatetime(String postdatetime) {
		this.postdatetime = postdatetime;
	}
	public String getPostdata() {
		return postdata;
	}
	public void setPostdata(String postdata) {
		this.postdata = postdata;
	}
	public String[] getPostfileids() {
		return postfileids;
	}
	public void setPostfileids(String[] postfileids) {
		this.postfileids = postfileids;
	}
	
	
	
}
