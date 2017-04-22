package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AssignmentAnalysis")
public class AssignmentAnalysis {

	@Id
	private String assignmentid;
	private String assignmentstarttime;
	private String assignmentendtime;
	private String assignmentaveragerate;
	private String assignmentfeedbackrate;
	private String assignmentstartdate;
	private String assignmentcurrentdate;
	private String assignmentenddate;
	private String assignmentpercentage;
	private String assignmentQuestionOneid;
	private String assignmentQuestionTwoid;
	private String assignmentQuestionThreeid;
	private String assignmentQuestionFourid;
	private String assignmentQuestionFiveid;
	private String assignmentQuestionSixid;
	private String assignmentQuestionSevenid;
	private String assignmentQuestionEightid;
	private String assignmentQuestionNineid;
	private String assignmentQuestionTenid;
	private String assignmentQuestionElevenid;
	private String assignmentQuestionTwelveid;
	private String assignmentQuestionThirteenid;
	private String assignmentQuestionFourteenid;
	private String assignmentQuestionFifteenid;
	private String assignmentlocation;
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String getAssignmentstarttime() {
		return assignmentstarttime;
	}
	public void setAssignmentstarttime(String assignmentstarttime) {
		this.assignmentstarttime = assignmentstarttime;
	}
	public String getAssignmentendtime() {
		return assignmentendtime;
	}
	public void setAssignmentendtime(String assignmentendtime) {
		this.assignmentendtime = assignmentendtime;
	}
	public String getAssignmentaveragerate() {
		return assignmentaveragerate;
	}
	public void setAssignmentaveragerate(String assignmentaveragerate) {
		this.assignmentaveragerate = assignmentaveragerate;
	}
	public String getAssignmentfeedbackrate() {
		return assignmentfeedbackrate;
	}
	public void setAssignmentfeedbackrate(String assignmentfeedbackrate) {
		this.assignmentfeedbackrate = assignmentfeedbackrate;
	}
	public String getAssignmentstartdate() {
		return assignmentstartdate;
	}
	public void setAssignmentstartdate(String assignmentstartdate) {
		this.assignmentstartdate = assignmentstartdate;
	}
	public String getAssignmentcurrentdate() {
		return assignmentcurrentdate;
	}
	public void setAssignmentcurrentdate(String assignmentcurrentdate) {
		this.assignmentcurrentdate = assignmentcurrentdate;
	}
	public String getAssignmentenddate() {
		return assignmentenddate;
	}
	public void setAssignmentenddate(String assignmentenddate) {
		this.assignmentenddate = assignmentenddate;
	}
	public String getAssignmentpercentage() {
		return assignmentpercentage;
	}
	public void setAssignmentpercentage(String assignmentpercentage) {
		this.assignmentpercentage = assignmentpercentage;
	}
	public String getAssignmentQuestionOneid() {
		return assignmentQuestionOneid;
	}
	public void setAssignmentQuestionOneid(String assignmentQuestionOneid) {
		this.assignmentQuestionOneid = assignmentQuestionOneid;
	}
	public String getAssignmentQuestionTwoid() {
		return assignmentQuestionTwoid;
	}
	public void setAssignmentQuestionTwoid(String assignmentQuestionTwoid) {
		this.assignmentQuestionTwoid = assignmentQuestionTwoid;
	}
	public String getAssignmentQuestionThreeid() {
		return assignmentQuestionThreeid;
	}
	public void setAssignmentQuestionThreeid(String assignmentQuestionThreeid) {
		this.assignmentQuestionThreeid = assignmentQuestionThreeid;
	}
	public String getAssignmentQuestionFourid() {
		return assignmentQuestionFourid;
	}
	public void setAssignmentQuestionFourid(String assignmentQuestionFourid) {
		this.assignmentQuestionFourid = assignmentQuestionFourid;
	}
	public String getAssignmentQuestionFiveid() {
		return assignmentQuestionFiveid;
	}
	public void setAssignmentQuestionFiveid(String assignmentQuestionFiveid) {
		this.assignmentQuestionFiveid = assignmentQuestionFiveid;
	}
	public String getAssignmentQuestionSixid() {
		return assignmentQuestionSixid;
	}
	public void setAssignmentQuestionSixid(String assignmentQuestionSixid) {
		this.assignmentQuestionSixid = assignmentQuestionSixid;
	}
	public String getAssignmentQuestionSevenid() {
		return assignmentQuestionSevenid;
	}
	public void setAssignmentQuestionSevenid(String assignmentQuestionSevenid) {
		this.assignmentQuestionSevenid = assignmentQuestionSevenid;
	}
	public String getAssignmentQuestionEightid() {
		return assignmentQuestionEightid;
	}
	public void setAssignmentQuestionEightid(String assignmentQuestionEightid) {
		this.assignmentQuestionEightid = assignmentQuestionEightid;
	}
	public String getAssignmentQuestionNineid() {
		return assignmentQuestionNineid;
	}
	public void setAssignmentQuestionNineid(String assignmentQuestionNineid) {
		this.assignmentQuestionNineid = assignmentQuestionNineid;
	}
	public String getAssignmentQuestionTenid() {
		return assignmentQuestionTenid;
	}
	public void setAssignmentQuestionTenid(String assignmentQuestionTenid) {
		this.assignmentQuestionTenid = assignmentQuestionTenid;
	}
	public String getAssignmentQuestionElevenid() {
		return assignmentQuestionElevenid;
	}
	public void setAssignmentQuestionElevenid(String assignmentQuestionElevenid) {
		this.assignmentQuestionElevenid = assignmentQuestionElevenid;
	}
	public String getAssignmentQuestionTwelveid() {
		return assignmentQuestionTwelveid;
	}
	public void setAssignmentQuestionTwelveid(String assignmentQuestionTwelveid) {
		this.assignmentQuestionTwelveid = assignmentQuestionTwelveid;
	}
	public String getAssignmentQuestionThirteenid() {
		return assignmentQuestionThirteenid;
	}
	public void setAssignmentQuestionThirteenid(String assignmentQuestionThirteenid) {
		this.assignmentQuestionThirteenid = assignmentQuestionThirteenid;
	}
	public String getAssignmentQuestionFourteenid() {
		return assignmentQuestionFourteenid;
	}
	public void setAssignmentQuestionFourteenid(String assignmentQuestionFourteenid) {
		this.assignmentQuestionFourteenid = assignmentQuestionFourteenid;
	}
	public String getAssignmentQuestionFifteenid() {
		return assignmentQuestionFifteenid;
	}
	public void setAssignmentQuestionFifteenid(String assignmentQuestionFifteenid) {
		this.assignmentQuestionFifteenid = assignmentQuestionFifteenid;
	}
	public String getAssignmentlocation() {
		return assignmentlocation;
	}
	public void setAssignmentlocation(String assignmentlocation) {
		this.assignmentlocation = assignmentlocation;
	}
	
	
	
	
}
