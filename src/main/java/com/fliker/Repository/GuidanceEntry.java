package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntry")
public class GuidanceEntry {

	@Id
	private String guidanceid;
	private String userid;
	private String[] guidanceselectionids;
	public String getGuidanceid() {
		return guidanceid;
	}
	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String[] getGuidanceselectionids() {
		return guidanceselectionids;
	}
	public void setGuidanceselectionids(String[] guidanceselectionids) {
		this.guidanceselectionids = guidanceselectionids;
	}
	
	
	
}
