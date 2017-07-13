package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InstituteSubjectSection")
public class InstituteSubjectSection {

	@Id
	private String subjectsectionid;
	private String[] subjectmatterid;
	private String subjectsectionname;
	private String headguidanceid;
	private String[] teachersuserid;
	private String headteacheruserid;
	public String getSubjectsectionid() {
		return subjectsectionid;
	}
	public void setSubjectsectionid(String subjectsectionid) {
		this.subjectsectionid = subjectsectionid;
	}
	public String[] getSubjectmatterid() {
		return subjectmatterid;
	}
	public void setSubjectmatterid(String[] subjectmatterid) {
		this.subjectmatterid = subjectmatterid;
	}
	public String getSubjectsectionname() {
		return subjectsectionname;
	}
	public void setSubjectsectionname(String subjectsectionname) {
		this.subjectsectionname = subjectsectionname;
	}
	public String getHeadguidanceid() {
		return headguidanceid;
	}
	public void setHeadguidanceid(String headguidanceid) {
		this.headguidanceid = headguidanceid;
	}
	public String[] getTeachersuserid() {
		return teachersuserid;
	}
	public void setTeachersuserid(String[] teachersuserid) {
		this.teachersuserid = teachersuserid;
	}
	public String getHeadteacheruserid() {
		return headteacheruserid;
	}
	public void setHeadteacheruserid(String headteacheruserid) {
		this.headteacheruserid = headteacheruserid;
	}
	
	
}
