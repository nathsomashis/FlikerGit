package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProjectVersion")
public class ProjectVersion {

	@Id
	private String projectversionid;
	private String projectxml;
	private String versionchangedate;
	private String[] fileidChanges;
	private String previousversion;
	public String getProjectversionid() {
		return projectversionid;
	}
	public void setProjectversionid(String projectversionid) {
		this.projectversionid = projectversionid;
	}
	public String getProjectxml() {
		return projectxml;
	}
	public void setProjectxml(String projectxml) {
		this.projectxml = projectxml;
	}
	public String getVersionchangedate() {
		return versionchangedate;
	}
	public void setVersionchangedate(String versionchangedate) {
		this.versionchangedate = versionchangedate;
	}
	public String[] getFileidChanges() {
		return fileidChanges;
	}
	public void setFileidChanges(String[] fileidChanges) {
		this.fileidChanges = fileidChanges;
	}
	public String getPreviousversion() {
		return previousversion;
	}
	public void setPreviousversion(String previousversion) {
		this.previousversion = previousversion;
	}
	
	
	
}
