package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProjectDistribution")
public class ProjectDistribution {

	@Id
	private String projectdistributorid;
	private String[] projectversionid;
	private String projectversionxml;
	
	
	
	public String getProjectversionxml() {
		return projectversionxml;
	}
	public void setProjectversionxml(String projectversionxml) {
		this.projectversionxml = projectversionxml;
	}
	public String getProjectdistributorid() {
		return projectdistributorid;
	}
	public void setProjectdistributorid(String projectdistributorid) {
		this.projectdistributorid = projectdistributorid;
	}
	public String[] getProjectversionid() {
		return projectversionid;
	}
	public void setProjectversionid(String[] projectversionid) {
		this.projectversionid = projectversionid;
	}
	
	
	
}
