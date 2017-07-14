package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CollegeBranch")
public class CollegeBranch {

	@Id
	private String collegebranchid;
	private String collegebranchname;
	private String[] semesterid;
	private String[] subjectid;
	private String[] batchid;
	private String playgroundid;
	public String getCollegebranchid() {
		return collegebranchid;
	}
	public void setCollegebranchid(String collegebranchid) {
		this.collegebranchid = collegebranchid;
	}
	public String getCollegebranchname() {
		return collegebranchname;
	}
	public void setCollegebranchname(String collegebranchname) {
		this.collegebranchname = collegebranchname;
	}
	public String[] getSemesterid() {
		return semesterid;
	}
	public void setSemesterid(String[] semesterid) {
		this.semesterid = semesterid;
	}
	public String[] getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String[] subjectid) {
		this.subjectid = subjectid;
	}
	public String[] getBatchid() {
		return batchid;
	}
	public void setBatchid(String[] batchid) {
		this.batchid = batchid;
	}
	public String getPlaygroundid() {
		return playgroundid;
	}
	public void setPlaygroundid(String playgroundid) {
		this.playgroundid = playgroundid;
	}
	
	
	
}
