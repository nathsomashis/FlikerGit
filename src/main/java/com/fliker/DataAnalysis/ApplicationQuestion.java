package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ApplicationQuestion")
public class ApplicationQuestion {

	@Id
	private String applicationid;
	private String applicatioin_question;
	private String application_qn_doc;
	private String application_qn_starttime;
	private String application_qn_endtime;
	private String application_qn_location;
	private String application_qn_generalsearch;
	private String application_qn_videosearch;
	private String application_answer;
	private String application_roughwork;
	private String application_approach;
	private String application_answer_number;
	private String application_answer_roughwork_number;
	private String application_answer_approach_number;
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getApplicatioin_question() {
		return applicatioin_question;
	}
	public void setApplicatioin_question(String applicatioin_question) {
		this.applicatioin_question = applicatioin_question;
	}
	public String getApplication_qn_doc() {
		return application_qn_doc;
	}
	public void setApplication_qn_doc(String application_qn_doc) {
		this.application_qn_doc = application_qn_doc;
	}
	public String getApplication_qn_starttime() {
		return application_qn_starttime;
	}
	public void setApplication_qn_starttime(String application_qn_starttime) {
		this.application_qn_starttime = application_qn_starttime;
	}
	public String getApplication_qn_endtime() {
		return application_qn_endtime;
	}
	public void setApplication_qn_endtime(String application_qn_endtime) {
		this.application_qn_endtime = application_qn_endtime;
	}
	public String getApplication_qn_location() {
		return application_qn_location;
	}
	public void setApplication_qn_location(String application_qn_location) {
		this.application_qn_location = application_qn_location;
	}
	public String getApplication_qn_generalsearch() {
		return application_qn_generalsearch;
	}
	public void setApplication_qn_generalsearch(String application_qn_generalsearch) {
		this.application_qn_generalsearch = application_qn_generalsearch;
	}
	public String getApplication_qn_videosearch() {
		return application_qn_videosearch;
	}
	public void setApplication_qn_videosearch(String application_qn_videosearch) {
		this.application_qn_videosearch = application_qn_videosearch;
	}
	public String getApplication_answer() {
		return application_answer;
	}
	public void setApplication_answer(String application_answer) {
		this.application_answer = application_answer;
	}
	public String getApplication_roughwork() {
		return application_roughwork;
	}
	public void setApplication_roughwork(String application_roughwork) {
		this.application_roughwork = application_roughwork;
	}
	public String getApplication_approach() {
		return application_approach;
	}
	public void setApplication_approach(String application_approach) {
		this.application_approach = application_approach;
	}
	public String getApplication_answer_number() {
		return application_answer_number;
	}
	public void setApplication_answer_number(String application_answer_number) {
		this.application_answer_number = application_answer_number;
	}
	public String getApplication_answer_roughwork_number() {
		return application_answer_roughwork_number;
	}
	public void setApplication_answer_roughwork_number(String application_answer_roughwork_number) {
		this.application_answer_roughwork_number = application_answer_roughwork_number;
	}
	public String getApplication_answer_approach_number() {
		return application_answer_approach_number;
	}
	public void setApplication_answer_approach_number(String application_answer_approach_number) {
		this.application_answer_approach_number = application_answer_approach_number;
	}
	
	
	
	
	
	
}
