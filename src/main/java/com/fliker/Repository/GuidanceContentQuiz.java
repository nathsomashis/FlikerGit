package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentQuiz")
public class GuidanceContentQuiz {

	@Id
	private String quizid;
	private String quizname;
	private String quizcreatedby;
	private String quizdescription;
	private String quizsubject;
	private String[] quizquestionsets;
	private String quizdatetime;
	private String noOfQuestions;
	private String[] quizshareids;
	public String getQuizid() {
		return quizid;
	}
	public void setQuizid(String quizid) {
		this.quizid = quizid;
	}
	public String getQuizname() {
		return quizname;
	}
	public void setQuizname(String quizname) {
		this.quizname = quizname;
	}
	public String getQuizcreatedby() {
		return quizcreatedby;
	}
	public void setQuizcreatedby(String quizcreatedby) {
		this.quizcreatedby = quizcreatedby;
	}
	public String getQuizdescription() {
		return quizdescription;
	}
	public void setQuizdescription(String quizdescription) {
		this.quizdescription = quizdescription;
	}
	public String getQuizsubject() {
		return quizsubject;
	}
	public void setQuizsubject(String quizsubject) {
		this.quizsubject = quizsubject;
	}
	public String[] getQuizquestionsets() {
		return quizquestionsets;
	}
	public void setQuizquestionsets(String[] quizquestionsets) {
		this.quizquestionsets = quizquestionsets;
	}
	public String getQuizdatetime() {
		return quizdatetime;
	}
	public void setQuizdatetime(String quizdatetime) {
		this.quizdatetime = quizdatetime;
	}
	public String getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(String noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public String[] getQuizshareids() {
		return quizshareids;
	}
	public void setQuizshareids(String[] quizshareids) {
		this.quizshareids = quizshareids;
	}
	
	
	
}
