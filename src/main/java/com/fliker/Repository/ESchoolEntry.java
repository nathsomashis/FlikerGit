package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ESchoolEntry")
public class ESchoolEntry {

	@Id
	private String eschoolid;
	private String timetableid;
	private String playgroundid;
	private String[] batchid;
	private String[] guidanceids;
	private String[] courseids;
	
	
	
	
	public String[] getBatchid() {
		return batchid;
	}
	public void setBatchid(String[] batchid) {
		this.batchid = batchid;
	}
	public String[] getGuidanceids() {
		return guidanceids;
	}
	public void setGuidanceids(String[] guidanceids) {
		this.guidanceids = guidanceids;
	}
	public String[] getCourseids() {
		return courseids;
	}
	public void setCourseids(String[] courseids) {
		this.courseids = courseids;
	}
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
