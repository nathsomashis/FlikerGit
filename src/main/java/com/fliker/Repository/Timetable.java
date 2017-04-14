package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Timetable")
public class Timetable {

	@Id
	private String timeableid;
	private String[] eventid;
	public String getTimeableid() {
		return timeableid;
	}
	public void setTimeableid(String timeableid) {
		this.timeableid = timeableid;
	}
	public String[] getEventid() {
		return eventid;
	}
	public void setEventid(String[] eventid) {
		this.eventid = eventid;
	}
	
	
	
}
