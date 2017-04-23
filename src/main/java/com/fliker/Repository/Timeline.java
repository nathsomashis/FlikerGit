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
	private String timelineentrytype;
	private String timelinedescription;
	private String timelineimageid;
	private String timelinelink;
	private String timelinedate;
	private String timelinelocation;
	
	
	
	public String getTimelinedate() {
		return timelinedate;
	}
	public void setTimelinedate(String timelinedate) {
		this.timelinedate = timelinedate;
	}
	public String getTimelinelocation() {
		return timelinelocation;
	}
	public void setTimelinelocation(String timelinelocation) {
		this.timelinelocation = timelinelocation;
	}
	public String getTimelineentrytype() {
		return timelineentrytype;
	}
	public void setTimelineentrytype(String timelineentrytype) {
		this.timelineentrytype = timelineentrytype;
	}
	public String getTimelinedescription() {
		return timelinedescription;
	}
	public void setTimelinedescription(String timelinedescription) {
		this.timelinedescription = timelinedescription;
	}
	public String getTimelineimageid() {
		return timelineimageid;
	}
	public void setTimelineimageid(String timelineimageid) {
		this.timelineimageid = timelineimageid;
	}
	public String getTimelinelink() {
		return timelinelink;
	}
	public void setTimelinelink(String timelinelink) {
		this.timelinelink = timelinelink;
	}
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
