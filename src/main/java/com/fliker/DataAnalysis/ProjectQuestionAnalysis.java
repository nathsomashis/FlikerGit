package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProjectAnswerAnalysis")
public class ProjectQuestionAnalysis {

	
	@Id
	private String projectid;
	private String[] projectmoduleid;
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String[] getProjectmoduleid() {
		return projectmoduleid;
	}
	public void setProjectmoduleid(String[] projectmoduleid) {
		this.projectmoduleid = projectmoduleid;
	}
	
	
	
}
