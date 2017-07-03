package com.fliker.Repository;

import org.springframework.data.annotation.Id;

public class InstituteSubDivision {

	@Id
	private String subdivisionid;
	private String blackboardid;
	private String[] subjectmatter;
	private String[] students;
	private String timetableid;
	private String historybatchid;
	
	
	public String getHistorybatchid() {
		return historybatchid;
	}
	public void setHistorybatchid(String historybatchid) {
		this.historybatchid = historybatchid;
	}
	public String getSubdivisionid() {
		return subdivisionid;
	}
	public void setSubdivisionid(String subdivisionid) {
		this.subdivisionid = subdivisionid;
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
	
	
	
	
}
