package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Assignment")
public class Assignment {

	
	@Id
	private String assignmentid;
	private String assignmentquestionsets;
	private String assignmentQDoc;
	private String assignmentanswersheet;
	private String assignmentADoc;
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String getAssignmentquestionsets() {
		return assignmentquestionsets;
	}
	public void setAssignmentquestionsets(String assignmentquestionsets) {
		this.assignmentquestionsets = assignmentquestionsets;
	}
	public String getAssignmentQDoc() {
		return assignmentQDoc;
	}
	public void setAssignmentQDoc(String assignmentQDoc) {
		this.assignmentQDoc = assignmentQDoc;
	}
	public String getAssignmentanswersheet() {
		return assignmentanswersheet;
	}
	public void setAssignmentanswersheet(String assignmentanswersheet) {
		this.assignmentanswersheet = assignmentanswersheet;
	}
	public String getAssignmentADoc() {
		return assignmentADoc;
	}
	public void setAssignmentADoc(String assignmentADoc) {
		this.assignmentADoc = assignmentADoc;
	}
	
	
	
	
}
