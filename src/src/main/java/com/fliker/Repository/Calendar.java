package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Calendar")
public class Calendar {

	private String programid;
	private String stardate;
	private String enddate;
	private String bufferday;
	private String modifiedenddate;
	private String notificationid;
	public String getProgramid() {
		return programid;
	}
	public void setProgramid(String programid) {
		this.programid = programid;
	}
	public String getStardate() {
		return stardate;
	}
	public void setStardate(String stardate) {
		this.stardate = stardate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getBufferday() {
		return bufferday;
	}
	public void setBufferday(String bufferday) {
		this.bufferday = bufferday;
	}
	public String getModifiedenddate() {
		return modifiedenddate;
	}
	public void setModifiedenddate(String modifiedenddate) {
		this.modifiedenddate = modifiedenddate;
	}
	public String getNotificationid() {
		return notificationid;
	}
	public void setNotificationid(String notificationid) {
		this.notificationid = notificationid;
	}
	
	
	
	
	
}
