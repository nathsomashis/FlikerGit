package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceLocationData")
public class GuidanceLocationData {

	@Id
	private String locationid;
	private String guidanceid;
	private String userid;
	public String getLocationid() {
		return locationid;
	}
	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}
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
	
	
	
}
