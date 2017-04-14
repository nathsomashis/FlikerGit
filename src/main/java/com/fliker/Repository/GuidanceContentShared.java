package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentShare")
public class GuidanceContentShared {

	@Id
	private String guidancesharedid;
	private String[] guidancefilelistid;
	public String getGuidancesharedid() {
		return guidancesharedid;
	}
	public void setGuidancesharedid(String guidancesharedid) {
		this.guidancesharedid = guidancesharedid;
	}
	public String[] getGuidancefilelistid() {
		return guidancefilelistid;
	}
	public void setGuidancefilelistid(String[] guidancefilelistid) {
		this.guidancefilelistid = guidancefilelistid;
	}
	
	
	
}
