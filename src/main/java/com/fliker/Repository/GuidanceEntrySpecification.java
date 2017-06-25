package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntrySpecification")
public class GuidanceEntrySpecification {

	@Id
	private String guidancespecificationid;
	private String guidanceid;
	private String userid;
	private String[] specifications;
	public String getGuidancespecificationid() {
		return guidancespecificationid;
	}
	public void setGuidancespecificationid(String guidancespecificationid) {
		this.guidancespecificationid = guidancespecificationid;
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
	public String[] getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String[] specifications) {
		this.specifications = specifications;
	}
	
	
}
