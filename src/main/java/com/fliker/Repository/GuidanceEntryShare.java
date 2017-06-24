package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntryShare")
public class GuidanceEntryShare {

	@Id
	private String guidanceshareid;
	private String guidancecontentshareid;
	private String[] fileids;
	
	
	public String getGuidancecontentshareid() {
		return guidancecontentshareid;
	}
	public void setGuidancecontentshareid(String guidancecontentshareid) {
		this.guidancecontentshareid = guidancecontentshareid;
	}
	public String getGuidanceshareid() {
		return guidanceshareid;
	}
	public void setGuidanceshareid(String guidanceshareid) {
		this.guidanceshareid = guidanceshareid;
	}
	public String[] getFileids() {
		return fileids;
	}
	public void setFileids(String[] fileids) {
		this.fileids = fileids;
	}
	
	
	
}
