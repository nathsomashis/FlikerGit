package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ApplicationProblemSolverAnalysis")
public class ApplicationPSAnalysis {

	@Id
	private String applicationid;
	private String[] application_qn;
	private String noOfDateToFinish;
	private String application_start_time;
	private String application_end_time;
	private String[] application_location_set;
	private String[] application_books_refered;
	private String[] application_links_captured;
	private String application_feedback_student;
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String[] getApplication_qn() {
		return application_qn;
	}
	public void setApplication_qn(String[] application_qn) {
		this.application_qn = application_qn;
	}
	public String getNoOfDateToFinish() {
		return noOfDateToFinish;
	}
	public void setNoOfDateToFinish(String noOfDateToFinish) {
		this.noOfDateToFinish = noOfDateToFinish;
	}
	public String getApplication_start_time() {
		return application_start_time;
	}
	public void setApplication_start_time(String application_start_time) {
		this.application_start_time = application_start_time;
	}
	public String getApplication_end_time() {
		return application_end_time;
	}
	public void setApplication_end_time(String application_end_time) {
		this.application_end_time = application_end_time;
	}
	public String[] getApplication_location_set() {
		return application_location_set;
	}
	public void setApplication_location_set(String[] application_location_set) {
		this.application_location_set = application_location_set;
	}
	public String[] getApplication_books_refered() {
		return application_books_refered;
	}
	public void setApplication_books_refered(String[] application_books_refered) {
		this.application_books_refered = application_books_refered;
	}
	public String[] getApplication_links_captured() {
		return application_links_captured;
	}
	public void setApplication_links_captured(String[] application_links_captured) {
		this.application_links_captured = application_links_captured;
	}
	public String getApplication_feedback_student() {
		return application_feedback_student;
	}
	public void setApplication_feedback_student(String application_feedback_student) {
		this.application_feedback_student = application_feedback_student;
	}
	
	
	
	
}
