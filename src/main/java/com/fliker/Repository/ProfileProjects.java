package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProfileProject")
public class ProfileProjects {

	@Id
	private String projectid;
	private String projectname;
	private String[] projectassesments;
	private String projectdate;
	private String projectlocation;
	
	
	public String[] getProjectassesments() {
		return projectassesments;
	}
	public void setProjectassesments(String[] projectassesments) {
		this.projectassesments = projectassesments;
	}
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
