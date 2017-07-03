package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InstituteExamTemplate")
public class InstituteExamTemplate {

	@Id
	private String examid;
	private String datetime;
	private String divisionid;
	private String subjectmatterid;
	private String examqnpaperid;
	private String accessdatetime;
	private String[] studentresultid;
	
	
	public String[] getStudentresultid() {
		return studentresultid;
	}
	public void setStudentresultid(String[] studentresultid) {
		this.studentresultid = studentresultid;
	}
	public String getAccessdatetime() {
		return accessdatetime;
	}
	public void setAccessdatetime(String accessdatetime) {
		this.accessdatetime = accessdatetime;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getDivisionid() {
		return divisionid;
	}
	public void setDivisionid(String divisionid) {
		this.divisionid = divisionid;
	}
	public String getSubjectmatterid() {
		return subjectmatterid;
	}
	public void setSubjectmatterid(String subjectmatterid) {
		this.subjectmatterid = subjectmatterid;
	}
	public String getExamqnpaperid() {
		return examqnpaperid;
	}
	public void setExamqnpaperid(String examqnpaperid) {
		this.examqnpaperid = examqnpaperid;
	}
	
	
	
}
