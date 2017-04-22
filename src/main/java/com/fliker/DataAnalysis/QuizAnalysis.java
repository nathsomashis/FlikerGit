package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="QuizAnalysis")
public class QuizAnalysis {

	@Id
	private String quizid;
	private String quizstarttime;
	private String quizendtime;
	private String quizaveragerate;
	private String quizfeedbackrate;
	private String quizstartdate;
	private String quizenddate;
	private String quizpercentage;
	private String quizQuestionOneid;
	private String quizQuestionTwoid;
	private String quizQuestionThreeid;
	private String quizQuestionFourid;
	private String quizQuestionFiveid;
	private String quizQuestionSixid;
	private String quizQuestionSevenid;
	private String quizQuestionEightid;
	private String quizQuestionNineid;
	private String quizQuestionTenid;
	private String quizlocation;
	public String getQuizid() {
		return quizid;
	}
	public void setQuizid(String quizid) {
		this.quizid = quizid;
	}
	public String getQuizstarttime() {
		return quizstarttime;
	}
	public void setQuizstarttime(String quizstarttime) {
		this.quizstarttime = quizstarttime;
	}
	public String getQuizendtime() {
		return quizendtime;
	}
	public void setQuizendtime(String quizendtime) {
		this.quizendtime = quizendtime;
	}
	public String getQuizaveragerate() {
		return quizaveragerate;
	}
	public void setQuizaveragerate(String quizaveragerate) {
		this.quizaveragerate = quizaveragerate;
	}
	public String getQuizfeedbackrate() {
		return quizfeedbackrate;
	}
	public void setQuizfeedbackrate(String quizfeedbackrate) {
		this.quizfeedbackrate = quizfeedbackrate;
	}
	public String getQuizstartdate() {
		return quizstartdate;
	}
	public void setQuizstartdate(String quizstartdate) {
		this.quizstartdate = quizstartdate;
	}
	public String getQuizenddate() {
		return quizenddate;
	}
	public void setQuizenddate(String quizenddate) {
		this.quizenddate = quizenddate;
	}
	public String getQuizpercentage() {
		return quizpercentage;
	}
	public void setQuizpercentage(String quizpercentage) {
		this.quizpercentage = quizpercentage;
	}
	public String getQuizQuestionOneid() {
		return quizQuestionOneid;
	}
	public void setQuizQuestionOneid(String quizQuestionOneid) {
		this.quizQuestionOneid = quizQuestionOneid;
	}
	public String getQuizQuestionTwoid() {
		return quizQuestionTwoid;
	}
	public void setQuizQuestionTwoid(String quizQuestionTwoid) {
		this.quizQuestionTwoid = quizQuestionTwoid;
	}
	public String getQuizQuestionThreeid() {
		return quizQuestionThreeid;
	}
	public void setQuizQuestionThreeid(String quizQuestionThreeid) {
		this.quizQuestionThreeid = quizQuestionThreeid;
	}
	public String getQuizQuestionFourid() {
		return quizQuestionFourid;
	}
	public void setQuizQuestionFourid(String quizQuestionFourid) {
		this.quizQuestionFourid = quizQuestionFourid;
	}
	public String getQuizQuestionFiveid() {
		return quizQuestionFiveid;
	}
	public void setQuizQuestionFiveid(String quizQuestionFiveid) {
		this.quizQuestionFiveid = quizQuestionFiveid;
	}
	public String getQuizQuestionSixid() {
		return quizQuestionSixid;
	}
	public void setQuizQuestionSixid(String quizQuestionSixid) {
		this.quizQuestionSixid = quizQuestionSixid;
	}
	public String getQuizQuestionSevenid() {
		return quizQuestionSevenid;
	}
	public void setQuizQuestionSevenid(String quizQuestionSevenid) {
		this.quizQuestionSevenid = quizQuestionSevenid;
	}
	public String getQuizQuestionEightid() {
		return quizQuestionEightid;
	}
	public void setQuizQuestionEightid(String quizQuestionEightid) {
		this.quizQuestionEightid = quizQuestionEightid;
	}
	public String getQuizQuestionNineid() {
		return quizQuestionNineid;
	}
	public void setQuizQuestionNineid(String quizQuestionNineid) {
		this.quizQuestionNineid = quizQuestionNineid;
	}
	public String getQuizQuestionTenid() {
		return quizQuestionTenid;
	}
	public void setQuizQuestionTenid(String quizQuestionTenid) {
		this.quizQuestionTenid = quizQuestionTenid;
	}
	public String getQuizlocation() {
		return quizlocation;
	}
	public void setQuizlocation(String quizlocation) {
		this.quizlocation = quizlocation;
	}
	
	
}
