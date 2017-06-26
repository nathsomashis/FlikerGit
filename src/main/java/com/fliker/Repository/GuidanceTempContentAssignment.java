package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceTempContentAssignment")
public class GuidanceTempContentAssignment {

	@Id
	private String tempcontentassignmentid;
	private String assignmentid;
	private String[] assingmentquestionset;
	private String savedatetime;
	private String guidanceid;
	private String creationdate;
	private String userid;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTempcontentassignmentid() {
		return tempcontentassignmentid;
	}
	public void setTempcontentassignmentid(String tempcontentassignmentid) {
		this.tempcontentassignmentid = tempcontentassignmentid;
	}
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String[] getAssingmentquestionset() {
		return assingmentquestionset;
	}
	public void setAssingmentquestionset(String[] assingmentquestionset) {
		this.assingmentquestionset = assingmentquestionset;
	}
	public String getSavedatetime() {
		return savedatetime;
	}
	public void setSavedatetime(String savedatetime) {
		this.savedatetime = savedatetime;
	}
	public String getGuidanceid() {
		return guidanceid;
	}
	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	
	
	
}
