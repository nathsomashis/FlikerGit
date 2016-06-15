package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Post")
public class Post {

	@Id
	private String postid;
	private byte[] postContent;
	private Share[] postshared;
	private Comment[] postcomments;
	private Like[] postliked;
	private User postowner;
	private Vote voteid;
	private String postType;
	
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
	public byte[] getPostContent() {
		return postContent;
	}
	public void setPostContent(byte[] postContent) {
		this.postContent = postContent;
	}
	public Share[] getPostshared() {
		return postshared;
	}
	public void setPostshared(Share[] postshared) {
		this.postshared = postshared;
	}
	public Comment[] getPostcomments() {
		return postcomments;
	}
	public void setPostcomments(Comment[] postcomments) {
		this.postcomments = postcomments;
	}
	public Like[] getPostliked() {
		return postliked;
	}
	public void setPostliked(Like[] postliked) {
		this.postliked = postliked;
	}
	public User getPostowner() {
		return postowner;
	}
	public void setPostowner(User postowner) {
		this.postowner = postowner;
	}
	public Vote getVoteid() {
		return voteid;
	}
	public void setVoteid(Vote voteid) {
		this.voteid = voteid;
	}
	
	
	
}
