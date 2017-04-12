package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="IdeaWork")
public class IdeaToWork {

	@Id
	private String ideaworkid;
	private String textwork;
	private String[] filetoupload;
	private String location;
	private String userid;
	
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIdeaworkid() {
		return ideaworkid;
	}
	public void setIdeaworkid(String ideaworkid) {
		this.ideaworkid = ideaworkid;
	}
	public String getTextwork() {
		return textwork;
	}
	public void setTextwork(String textwork) {
		this.textwork = textwork;
	}
	public String[] getFiletoupload() {
		return filetoupload;
	}
	public void setFiletoupload(String[] filetoupload) {
		this.filetoupload = filetoupload;
	}
	
	
	
}
