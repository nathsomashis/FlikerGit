package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Project")
public class Project {

	@Id
	private String projectid;
	private String projectDescription;
	private String projectSkillsAdded;
	private String projectname;
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public String getProjectSkillsAdded() {
		return projectSkillsAdded;
	}
	public void setProjectSkillsAdded(String projectSkillsAdded) {
		this.projectSkillsAdded = projectSkillsAdded;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	
	
}
