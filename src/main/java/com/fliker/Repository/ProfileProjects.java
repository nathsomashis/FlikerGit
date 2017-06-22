package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProfileProject")
public class ProfileProjects {

	@Id
	private String projectid;
	private String projectname;
	private String[] projectskill;
	private String projectrole;
	private String projectdescription;
	private String projectdate;
	private String projectlocation;
	private String[] projectfile;
	
	
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String[] getProjectskill() {
		return projectskill;
	}
	public void setProjectskill(String[] projectskill) {
		this.projectskill = projectskill;
	}
	public String getProjectrole() {
		return projectrole;
	}
	public void setProjectrole(String projectrole) {
		this.projectrole = projectrole;
	}
	public String getProjectdescription() {
		return projectdescription;
	}
	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}
	public String getProjectdate() {
		return projectdate;
	}
	public void setProjectdate(String projectdate) {
		this.projectdate = projectdate;
	}
	public String getProjectlocation() {
		return projectlocation;
	}
	public void setProjectlocation(String projectlocation) {
		this.projectlocation = projectlocation;
	}
	
	
	
}
