package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentDash")
public class GuidanceContentDashboard {

	@Id
	private String guidancecontentDashid;
	private String[] guidancedashdataid;
	private String[] guidancefilelistid;
	public String getGuidancecontentDashid() {
		return guidancecontentDashid;
	}
	public void setGuidancecontentDashid(String guidancecontentDashid) {
		this.guidancecontentDashid = guidancecontentDashid;
	}
	public String[] getGuidancefilelistid() {
		return guidancefilelistid;
	}
	public void setGuidancefilelistid(String[] guidancefilelistid) {
		this.guidancefilelistid = guidancefilelistid;
	}
	
	
	
}
