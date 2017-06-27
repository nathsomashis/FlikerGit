package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntryTempAssignment")
public class GuidanceEntryTempAsignmentSet {

	@Id
	private String tempassignid;
	private String assignmentid;
	private String guidanceid;
	private String userid;
	private String[] assignmentanswerssheet;
	private String savedatetime;
	public String getTempassignid() {
		return tempassignid;
	}
	public void setTempassignid(String tempassignid) {
		this.tempassignid = tempassignid;
	}
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
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
	public String[] getAssignmentanswerssheet() {
		return assignmentanswerssheet;
	}
	public void setAssignmentanswerssheet(String[] assignmentanswerssheet) {
		this.assignmentanswerssheet = assignmentanswerssheet;
	}
	public String getSavedatetime() {
		return savedatetime;
	}
	public void setSavedatetime(String savedatetime) {
		this.savedatetime = savedatetime;
	}
	
	
	
}
