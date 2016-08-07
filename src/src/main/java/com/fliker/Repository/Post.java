package com.fliker.Repository;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Post")
public class Post {

	@Id
	private String postid;
	private String[] postFileid;
	private String[] postsharedids;
	private String[] postcommentsids;
	private String[] postlikedids;
	private String userid;
	private String postType;
	private String postDescription;
	private String postiddate;
	private String postlocation;
	
	
	public String getPostlocation() {
		return postlocation;
	}
	public void setPostlocation(String postlocation) {
		this.postlocation = postlocation;
	}
	public String getPostiddate() {
		return postiddate;
	}
	public void setPostiddate(String postiddate) {
		this.postiddate = postiddate;
	}
	public String getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	
	public String[] getPostFileid() {
		return postFileid;
	}
	public void setPostFileid(String[] postFileid) {
		this.postFileid = postFileid;
	}
	public String[] getPostsharedids() {
		return postsharedids;
	}
	public void setPostsharedids(String[] postsharedids) {
		this.postsharedids = postsharedids;
	}
	public String[] getPostcommentsids() {
		return postcommentsids;
	}
	public void setPostcommentsids(String[] postcommentsids) {
		this.postcommentsids = postcommentsids;
	}
	public String[] getPostlikedids() {
		return postlikedids;
	}
	public void setPostlikedids(String[] postlikedids) {
		this.postlikedids = postlikedids;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	
	
	
}
