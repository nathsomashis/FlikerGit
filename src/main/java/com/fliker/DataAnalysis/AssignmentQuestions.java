package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Questions")
public class AssignmentQuestions {

	@Id
	private String questionid;
	private String questionstarttime;
	private String questionendtime;
	private String questionrate;
	private String questioncomplete;
	private String videosearchidInBetween;
	private String topicsearchforInBetween;
	private String generalsearchInBetween;
	private String questionlocation;
	
	
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getQuestionstarttime() {
		return questionstarttime;
	}
	public void setQuestionstarttime(String questionstarttime) {
		this.questionstarttime = questionstarttime;
	}
	public String getQuestionendtime() {
		return questionendtime;
	}
	public void setQuestionendtime(String questionendtime) {
		this.questionendtime = questionendtime;
	}
	public String getQuestionrate() {
		return questionrate;
	}
	public void setQuestionrate(String questionrate) {
		this.questionrate = questionrate;
	}
	public String getQuestioncomplete() {
		return questioncomplete;
	}
	public void setQuestioncomplete(String questioncomplete) {
		this.questioncomplete = questioncomplete;
	}
	public String getVideosearchidInBetween() {
		return videosearchidInBetween;
	}
	public void setVideosearchidInBetween(String videosearchidInBetween) {
		this.videosearchidInBetween = videosearchidInBetween;
	}
	public String getTopicsearchforInBetween() {
		return topicsearchforInBetween;
	}
	public void setTopicsearchforInBetween(String topicsearchforInBetween) {
		this.topicsearchforInBetween = topicsearchforInBetween;
	}
	public String getGeneralsearchInBetween() {
		return generalsearchInBetween;
	}
	public void setGeneralsearchInBetween(String generalsearchInBetween) {
		this.generalsearchInBetween = generalsearchInBetween;
	}
	public String getQuestionlocation() {
		return questionlocation;
	}
	public void setQuestionlocation(String questionlocation) {
		this.questionlocation = questionlocation;
	}
	
	
	
}
