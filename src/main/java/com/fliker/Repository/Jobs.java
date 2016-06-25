package com.fliker.Repository;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Jobs")
public class Jobs {

	@Id
	private String Jobid;
	public String getJobid() {
		return Jobid;
	}
	public void setJobid(String jobid) {
		Jobid = jobid;
	}
	private String JobTitle;
	private String JobProgress;
	private String JobContacts;
	private String jobcreaterid;
	private boolean JobActivation;
	private HashMap JobPercentage;
	private String JobStartDate;
	private String JobEndDate;
	private boolean JobTrack;
	private String JobResponsibilities;
	private String[] SkillsIncluded;
	private String JobProjectDescription;
	
	public String getJobProgress() {
		return JobProgress;
	}
	public void setJobProgress(String jobProgress) {
		JobProgress = jobProgress;
	}
	public String getJobContacts() {
		return JobContacts;
	}
	public void setJobContacts(String jobContacts) {
		JobContacts = jobContacts;
	}
	public boolean isJobActivation() {
		return JobActivation;
	}
	public void setJobActivation(boolean jobActivation) {
		JobActivation = jobActivation;
	}
	public HashMap getJobPercentage() {
		return JobPercentage;
	}
	public void setJobPercentage(HashMap jobPercentage) {
		JobPercentage = jobPercentage;
	}
	public String getJobStartDate() {
		return JobStartDate;
	}
	public void setJobStartDate(String jobStartDate) {
		JobStartDate = jobStartDate;
	}
	public String getJobEndDate() {
		return JobEndDate;
	}
	public void setJobEndDate(String jobEndDate) {
		JobEndDate = jobEndDate;
	}
	public boolean isJobTrack() {
		return JobTrack;
	}
	public void setJobTrack(boolean jobTrack) {
		JobTrack = jobTrack;
	}
	public String getJobResponsibilities() {
		return JobResponsibilities;
	}
	public void setJobResponsibilities(String jobResponsibilities) {
		JobResponsibilities = jobResponsibilities;
	}
	
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public String getJobcreaterid() {
		return jobcreaterid;
	}
	public void setJobcreaterid(String jobcreaterid) {
		this.jobcreaterid = jobcreaterid;
	}
	public String[] getSkillsIncluded() {
		return SkillsIncluded;
	}
	public void setSkillsIncluded(String[] skillsIncluded) {
		SkillsIncluded = skillsIncluded;
	}
	public String getJobProjectDescription() {
		return JobProjectDescription;
	}
	public void setJobProjectDescription(String jobProjectDescription) {
		JobProjectDescription = jobProjectDescription;
	}
	
	
	
	
}
