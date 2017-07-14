package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InstituteSubjectLab")
public class InstituteSubjectLab {

	@Id
	private String subjectlabid;
	private String subjectformatterid;
	private String[] teacheruserid;
	private String guidanceid;
	public String getSubjectlabid() {
		return subjectlabid;
	}
	public void setSubjectlabid(String subjectlabid) {
		this.subjectlabid = subjectlabid;
	}
	public String getSubjectformatterid() {
		return subjectformatterid;
	}
	public void setSubjectformatterid(String subjectformatterid) {
		this.subjectformatterid = subjectformatterid;
	}
	public String[] getTeacheruserid() {
		return teacheruserid;
	}
	public void setTeacheruserid(String[] teacheruserid) {
		this.teacheruserid = teacheruserid;
	}
	public String getGuidanceid() {
		return guidanceid;
	}
	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
	}
	
	
	
}
