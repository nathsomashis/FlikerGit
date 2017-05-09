package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceProjectSubmission")
public class GuidanceProjectSubmission {

	@Id
	private String guidancesubmissionid;
	private String[] projectcodeid;
	public String getGuidancesubmissionid() {
		return guidancesubmissionid;
	}
	public void setGuidancesubmissionid(String guidancesubmissionid) {
		this.guidancesubmissionid = guidancesubmissionid;
	}
	public String[] getProjectcodeid() {
		return projectcodeid;
	}
	public void setProjectcodeid(String[] projectcodeid) {
		this.projectcodeid = projectcodeid;
	}
	
	
	
	
	
}
