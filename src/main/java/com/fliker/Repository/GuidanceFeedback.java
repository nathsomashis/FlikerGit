package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceFeedback")
public class GuidanceFeedback {

	private String feedbackid;
	private String guidanceid;
	private String assignmentid;
	private String quizid;
	private String userid;
	private String feedbacktype;
	private String[] specificationid;
	private String[] feedback;
	public String getFeedbackid() {
		return feedbackid;
	}
	public void setFeedbackid(String feedbackid) {
		this.feedbackid = feedbackid;
	}
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFeedbacktype() {
		return feedbacktype;
	}
	public void setFeedbacktype(String feedbacktype) {
		this.feedbacktype = feedbacktype;
	}
	public String[] getSpecificationid() {
		return specificationid;
	}
	public void setSpecificationid(String[] specificationid) {
		this.specificationid = specificationid;
	}
	public String[] getFeedback() {
		return feedback;
	}
	public void setFeedback(String[] feedback) {
		this.feedback = feedback;
	}
	
	
	
	
}
