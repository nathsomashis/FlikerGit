package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProfileProjectAssesment")
public class ProfileProjectAssesment {

	private String projectassesmentid;
	private String projectrole;
	private String profileproject;
	private String projectfiles;
	private String projectdescription;
	public String getProjectassesmentid() {
		return projectassesmentid;
	}
	public void setProjectassesmentid(String projectassesmentid) {
		this.projectassesmentid = projectassesmentid;
	}
	public String getProjectrole() {
		return projectrole;
	}
	public void setProjectrole(String projectrole) {
		this.projectrole = projectrole;
	}
	public String getProfileproject() {
		return profileproject;
	}
	public void setProfileproject(String profileproject) {
		this.profileproject = profileproject;
	}
	
	public String getProjectfiles() {
		return projectfiles;
	}
	public void setProjectfiles(String projectfiles) {
		this.projectfiles = projectfiles;
	}
	public String getProjectdescription() {
		return projectdescription;
	}
	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}
	
	
}
