package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntryQuiz")
public class GuidanceEntryQuiz {

	private String guidanceentryquizid;
	private String quizid;
	private String[] questionset;
	private String[] answeroption;
	private String guidanceentryid;
	private String userid;
	private String noofAnswers;
	private String feedbackid;
	private String remarkid;
	
	
	public String[] getQuestionset() {
		return questionset;
	}
	public void setQuestionset(String[] questionset) {
		this.questionset = questionset;
	}
	public String getGuidanceentryquizid() {
		return guidanceentryquizid;
	}
	public void setGuidanceentryquizid(String guidanceentryquizid) {
		this.guidanceentryquizid = guidanceentryquizid;
	}
	public String getQuizid() {
		return quizid;
	}
	public void setQuizid(String quizid) {
		this.quizid = quizid;
	}
	
	public String[] getAnsweroption() {
		return answeroption;
	}
	public void setAnsweroption(String[] answeroption) {
		this.answeroption = answeroption;
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
