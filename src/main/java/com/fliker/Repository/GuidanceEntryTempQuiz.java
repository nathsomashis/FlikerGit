package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntryTempQuiz")
public class GuidanceEntryTempQuiz {

	@Id
	private String tempquizid;
	private String guidanceid;
	private String quizid;
	private String userid;
	private String[] quizanswerset;
	private String savedatetime;
	public String getTempquizid() {
		return tempquizid;
	}
	public void setTempquizid(String tempquizid) {
		this.tempquizid = tempquizid;
	}
	public String getGuidanceid() {
		return guidanceid;
	}
	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
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
	public String[] getQuizanswerset() {
		return quizanswerset;
	}
	public void setQuizanswerset(String[] quizanswerset) {
		this.quizanswerset = quizanswerset;
	}
	public String getSavedatetime() {
		return savedatetime;
	}
	public void setSavedatetime(String savedatetime) {
		this.savedatetime = savedatetime;
	}
	
	
	
}
