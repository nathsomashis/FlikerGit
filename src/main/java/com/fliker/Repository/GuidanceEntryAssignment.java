package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntryAssignment")
public class GuidanceEntryAssignment {

	private String guidanceentryassignid;
	private String assignmentid;
	private String[] assignmentanswersheet;
	private String guidanceentryid;
	private String userid;
	private String noofAnswers;
	private String feedbackid;
	private String remarkid;
	
	public String getGuidanceentryassignid() {
		return guidanceentryassignid;
	}
	public void setGuidanceentryassignid(String guidanceentryassignid) {
		this.guidanceentryassignid = guidanceentryassignid;
	}
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String[] getAssignmentanswersheet() {
		return assignmentanswersheet;
	}
	public void setAssignmentanswersheet(String[] assignmentanswersheet) {
		this.assignmentanswersheet = assignmentanswersheet;
	}
	public String getGuidanceentryid() {
		return guidanceentryid;
	}
	public void setGuidanceentryid(String guidanceentryid) {
		this.guidanceentryid = guidanceentryid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNoofAnswers() {
		return noofAnswers;
	}
	public void setNoofAnswers(String noofAnswers) {
		this.noofAnswers = noofAnswers;
	}
	public String getFeedbackid() {
		return feedbackid;
	}
	public void setFeedbackid(String feedbackid) {
		this.feedbackid = feedbackid;
	}
	public String getRemarkid() {
		return remarkid;
	}
	public void setRemarkid(String remarkid) {
		this.remarkid = remarkid;
	}
	
	
	
}
