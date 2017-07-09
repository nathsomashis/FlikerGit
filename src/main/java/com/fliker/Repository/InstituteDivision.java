package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InstituteDivision")
public class InstituteDivision {

	@Id
	private String divisionid;
	private String divisiontype;
	private String[] subdivisiontype;
	private String blackboardid;
	private String[] subjectmatter;
	private String[] students;
	private String timetableid;
	private String[] historybatchid;
	
	
	
	public String[] getHistorybatchid() {
		return historybatchid;
	}
	public void setHistorybatchid(String[] historybatchid) {
		this.historybatchid = historybatchid;
	}
	public String[] getStudents() {
		return students;
	}
	public void setStudents(String[] students) {
		this.students = students;
	}
	public String getTimetableid() {
		return timetableid;
	}
	public void setTimetableid(String timetableid) {
		this.timetableid = timetableid;
	}
	public String getDivisionid() {
		return divisionid;
	}
	public void setDivisionid(String divisionid) {
		this.divisionid = divisionid;
	}
	public String getDivisiontype() {
		return divisiontype;
	}
	public void setDivisiontype(String divisiontype) {
		this.divisiontype = divisiontype;
	}
	public String[] getSubdivisiontype() {
		return subdivisiontype;
	}
	public void setSubdivisiontype(String[] subdivisiontype) {
		this.subdivisiontype = subdivisiontype;
	}
	public String getBlackboardid() {
		return blackboardid;
	}
	public void setBlackboardid(String blackboardid) {
		this.blackboardid = blackboardid;
	}
	public String[] getSubjectmatter() {
		return subjectmatter;
	}
	public void setSubjectmatter(String[] subjectmatter) {
		this.subjectmatter = subjectmatter;
	}
	
	
	
	
	
}
