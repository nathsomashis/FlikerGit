package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntryShare")
public class GuidanceEntryShare {

	@Id
	private String guidanceshareid;
	private String[] guidancefileids;
	public String getGuidanceshareid() {
		return guidanceshareid;
	}
	public void setGuidanceshareid(String guidanceshareid) {
		this.guidanceshareid = guidanceshareid;
	}
	public String[] getGuidancefileids() {
		return guidancefileids;
	}
	public void setGuidancefileids(String[] guidancefileids) {
		this.guidancefileids = guidancefileids;
	}
	
	
}
