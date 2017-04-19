package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="PostAnalysis")
public class PostAnalysis {

	@Id
	private String postid;
	private String postcommented;
	private String postshared;
	private String postliked;
	private String postlocationshared;
	private String postcontentid;
	
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getPostcommented() {
		return postcommented;
	}
	public void setPostcommented(String postcommented) {
		this.postcommented = postcommented;
	}
	public String getPostshared() {
		return postshared;
	}
	public void setPostshared(String postshared) {
		this.postshared = postshared;
	}
	public String getPostliked() {
		return postliked;
	}
	public void setPostliked(String postliked) {
		this.postliked = postliked;
	}
	public String getPostlocationshared() {
		return postlocationshared;
	}
	public void setPostlocationshared(String postlocationshared) {
		this.postlocationshared = postlocationshared;
	}
	public String getPostcontentid() {
		return postcontentid;
	}
	public void setPostcontentid(String postcontentid) {
		this.postcontentid = postcontentid;
	}
	
	
	
}
