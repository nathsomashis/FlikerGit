package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceRemarks")
public class GuidanceRemarks {

	
	private String guidanceid;
	private String assignmentid;
	private String quizid;
	private String remarktype;
	private String userid;
	private String[] specificationid;
	private String[] remarks;
	public String getGuidanceid() {
		return guidanceid;
	}
	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
	}
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String getQuizid() {
		return quizid;
	}
	public void setQuizid(String quizid) {
		this.quizid = quizid;
	}
	public String getRemarktype() {
		return remarktype;
	}
	public void setRemarktype(String remarktype) {
		this.remarktype = remarktype;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String[] getSpecificationid() {
		return specificationid;
	}
	public void setSpecificationid(String[] specificationid) {
		this.specificationid = specificationid;
	}
	public String[] getRemarks() {
		return remarks;
	}
	public void setRemarks(String[] remarks) {
		this.remarks = remarks;
	}
	
	
	
}
