package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentTempQuiz")
public class GuidanceContentTempQuiz {

	@Id
	private String tempquizid;
	private String quizname;
	private String quizdescription;
	private String quizid;
	private String guidanceid;
	private String userid;
	private String[] questionset;
	private String savedatetime;
	
	
	
	public String getQuizname() {
		return quizname;
	}
	public void setQuizname(String quizname) {
		this.quizname = quizname;
	}
	public String getQuizdescription() {
		return quizdescription;
	}
	public void setQuizdescription(String quizdescription) {
		this.quizdescription = quizdescription;
	}
	public String getTempquizid() {
		return tempquizid;
	}
	public void setTempquizid(String tempquizid) {
		this.tempquizid = tempquizid;
	}
	public String getQuizid() {
		return quizid;
	}
	public void setQuizid(String quizid) {
		this.quizid = quizid;
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
	public String[] getQuestionset() {
		return questionset;
	}
	public void setQuestionset(String[] questionset) {
		this.questionset = questionset;
	}
	public String getSavedatetime() {
		return savedatetime;
	}
	public void setSavedatetime(String savedatetime) {
		this.savedatetime = savedatetime;
	}
	
	
	
}
