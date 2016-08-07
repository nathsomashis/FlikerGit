package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Timeline")
public class Timeline {

	@Id
	private String timelineid;
	private String profileid;
	private String logEntry;
	private String event;
	public String getTimelineid() {
		return timelineid;
	}
	public void setTimelineid(String timelineid) {
		this.timelineid = timelineid;
	}
	public String getProfileid() {
		return profileid;
	}
	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}
	public String getLogEntry() {
		return logEntry;
	}
	public void setLogEntry(String logEntry) {
		this.logEntry = logEntry;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	
	
	
	
}
