package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Shared")
public class Share {

	@Id
	private String shareid;
	private String shareOwner;
	private String sharedTime;
	private String sharedlocation;
	private String shareComment;
	
	public String getShareid() {
		return shareid;
	}
	public void setShareid(String shareid) {
		this.shareid = shareid;
	}
	
	public String getSharedTime() {
		return sharedTime;
	}
	public void setSharedTime(String sharedTime) {
		this.sharedTime = sharedTime;
	}
	public String getShareOwner() {
		return shareOwner;
	}
	public void setShareOwner(String shareOwner) {
		this.shareOwner = shareOwner;
	}
	public String getSharedlocation() {
		return sharedlocation;
	}
	public void setSharedlocation(String sharedlocation) {
		this.sharedlocation = sharedlocation;
	}
	public String getShareComment() {
		return shareComment;
	}
	public void setShareComment(String shareComment) {
		this.shareComment = shareComment;
	}
	
	
	
	
}
