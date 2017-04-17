package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Assignment")
public class Assignment {

	
	@Id
	private String assignmentid;
	private String[] assignmentquestionsets;
	private String[] assignmentQDoc;
	private String[] assignmentanswersheet;
	private String[] assignmentADoc;
	private String assignmentstartdatetime;
	private String assignmentenddatetime;
	private String noOfQuestions;
	private String averageVelocity;
	private String percentagescore;
	
	
	
	public String getAssignmentstartdatetime() {
		return assignmentstartdatetime;
	}
	public void setAssignmentstartdatetime(String assignmentstartdatetime) {
		this.assignmentstartdatetime = assignmentstartdatetime;
	}
	public String getAssignmentenddatetime() {
		return assignmentenddatetime;
	}
	public void setAssignmentenddatetime(String assignmentenddatetime) {
		this.assignmentenddatetime = assignmentenddatetime;
	}
	public String getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(String noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public String getAverageVelocity() {
		return averageVelocity;
	}
	public void setAverageVelocity(String averageVelocity) {
		this.averageVelocity = averageVelocity;
	}
	public String getPercentagescore() {
		return percentagescore;
	}
	public void setPercentagescore(String percentagescore) {
		this.percentagescore = percentagescore;
	}
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String[] getAssignmentquestionsets() {
		return assignmentquestionsets;
	}
	public void setAssignmentquestionsets(String[] assignmentquestionsets) {
		this.assignmentquestionsets = assignmentquestionsets;
	}
	public String[] getAssignmentQDoc() {
		return assignmentQDoc;
	}
	public void setAssignmentQDoc(String[] assignmentQDoc) {
		this.assignmentQDoc = assignmentQDoc;
	}
	public String[] getAssignmentanswersheet() {
		return assignmentanswersheet;
	}
	public void setAssignmentanswersheet(String[] assignmentanswersheet) {
		this.assignmentanswersheet = assignmentanswersheet;
	}
	public String[] getAssignmentADoc() {
		return assignmentADoc;
	}
	public void setAssignmentADoc(String[] assignmentADoc) {
		this.assignmentADoc = assignmentADoc;
	}
	
	
	
	
	
}
