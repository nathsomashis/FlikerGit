package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Share")
public class Share {

	@Id
	private String shareid;
	private User shareOwner;
	private String sharedTime;
	private Comment shareComment;
	public String getShareid() {
		return shareid;
	}
	public void setShareid(String shareid) {
		this.shareid = shareid;
	}
	
	public User getShareOwner() {
		return shareOwner;
	}
	public void setShareOwner(User shareOwner) {
		this.shareOwner = shareOwner;
	}
	public String getSharedTime() {
		return sharedTime;
	}
	public void setSharedTime(String sharedTime) {
		this.sharedTime = sharedTime;
	}
	public Comment getShareComment() {
		return shareComment;
	}
	public void setShareComment(Comment shareComment) {
		this.shareComment = shareComment;
	}
	
	
	
}
