package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InstituteTimetable")
public class InstituteTimeTable {

	private String timtableid;
	private String[] tracktimetablechange;
	public String getTimtableid() {
		return timtableid;
	}
	public void setTimtableid(String timtableid) {
		this.timtableid = timtableid;
	}
	public String[] getTracktimetablechange() {
		return tracktimetablechange;
	}
	public void setTracktimetablechange(String[] tracktimetablechange) {
		this.tracktimetablechange = tracktimetablechange;
	}
	
	
}
