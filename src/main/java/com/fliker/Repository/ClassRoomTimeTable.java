package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ClassRoomTimeTable")
public class ClassRoomTimeTable {

	@Id
	private String timetableid;
	private String[] timetableform;
	public String getTimetableid() {
		return timetableid;
	}
	public void setTimetableid(String timetableid) {
		this.timetableid = timetableid;
	}
	public String[] getTimetableform() {
		return timetableform;
	}
	public void setTimetableform(String[] timetableform) {
		this.timetableform = timetableform;
	}
	
	
	
}
