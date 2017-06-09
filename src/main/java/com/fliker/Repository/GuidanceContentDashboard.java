package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentDash")
public class GuidanceContentDashboard {

	@Id
	private String guidancecontentDashid;
	private String[] guidancedashdataid;
	private String[] guidancelocationids;
	
	
	
	
	public String[] getGuidancedashdataid() {
		return guidancedashdataid;
	}
	public void setGuidancedashdataid(String[] guidancedashdataid) {
		this.guidancedashdataid = guidancedashdataid;
	}
	public String getGuidancecontentDashid() {
		return guidancecontentDashid;
	}
	public void setGuidancecontentDashid(String guidancecontentDashid) {
		this.guidancecontentDashid = guidancecontentDashid;
	}
	public String[] getGuidancelocationids() {
		return guidancelocationids;
	}
	public void setGuidancelocationids(String[] guidancelocationids) {
		this.guidancelocationids = guidancelocationids;
	}
	
	
	
	
}
