package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ESchoolEntry")
public class ESchoolEntry {

	@Id
	private String eschoolid;
	private String timetableid;
	private String playgroundid;
	public String getEschoolid() {
		return eschoolid;
	}
	public void setEschoolid(String eschoolid) {
		this.eschoolid = eschoolid;
	}
	public String getTimetableid() {
		return timetableid;
	}
	public void setTimetableid(String timetableid) {
		this.timetableid = timetableid;
	}
	public String getPlaygroundid() {
		return playgroundid;
	}
	public void setPlaygroundid(String playgroundid) {
		this.playgroundid = playgroundid;
	}
	
	
	
}
