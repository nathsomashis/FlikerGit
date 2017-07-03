package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InstituteStudentParentPortal")
public class InstituteStudentParentPortal {

	@Id
	private String studentparentportalid;
	private String studentid;
	private String parentid;
	private String dashboardid;
	private String[] subjectmatterid;
	
	
	public String[] getSubjectmatterid() {
		return subjectmatterid;
	}
	public void setSubjectmatterid(String[] subjectmatterid) {
		this.subjectmatterid = subjectmatterid;
	}
	public String getStudentparentportalid() {
		return studentparentportalid;
	}
	public void setStudentparentportalid(String studentparentportalid) {
		this.studentparentportalid = studentparentportalid;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getDashboardid() {
		return dashboardid;
	}
	public void setDashboardid(String dashboardid) {
		this.dashboardid = dashboardid;
	}
	
	
	
}
