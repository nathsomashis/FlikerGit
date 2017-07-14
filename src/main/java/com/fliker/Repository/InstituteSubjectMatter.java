package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InstituteSubjectMatter")
public class InstituteSubjectMatter {

	@Id
	private String subjectmatterid;
	private String subjectname;
	private String[] teacheruserid;
	private String guidanceid;
	private String divisionid;
	private String headguidanceid;
	private String subjectlabid;
	
	
	public String getDivisionid() {
		return divisionid;
	}
	public void setDivisionid(String divisionid) {
		this.divisionid = divisionid;
	}
	public String getHeadguidanceid() {
		return headguidanceid;
	}
	public void setHeadguidanceid(String headguidanceid) {
		this.headguidanceid = headguidanceid;
	}
	public String getSubjectlabid() {
		return subjectlabid;
	}
	public void setSubjectlabid(String subjectlabid) {
		this.subjectlabid = subjectlabid;
	}
	public String getSubjectmatterid() {
		return subjectmatterid;
	}
	public void setSubjectmatterid(String subjectmatterid) {
		this.subjectmatterid = subjectmatterid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
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
