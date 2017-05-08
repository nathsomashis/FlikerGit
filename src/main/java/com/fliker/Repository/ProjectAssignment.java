package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProjectAssignment")
public class ProjectAssignment {
	
	@Id
	private String projectid;
	private String[] project_doc;
	private String[] project_links;
	private String project_article;
	private String project_flow;
	private String[] project_answer_doc;
	private String[] project_answer_links;
	private String project_answer_architechture;
	private String[] project_answer_reference_doc;
	private String[] project_answer_reference_link;
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String[] getProject_doc() {
		return project_doc;
	}
	public void setProject_doc(String[] project_doc) {
		this.project_doc = project_doc;
	}
	public String[] getProject_links() {
		return project_links;
	}
	public void setProject_links(String[] project_links) {
		this.project_links = project_links;
	}
	public String getProject_article() {
		return project_article;
	}
	public void setProject_article(String project_article) {
		this.project_article = project_article;
	}
	public String getProject_flow() {
		return project_flow;
	}
	public void setProject_flow(String project_flow) {
		this.project_flow = project_flow;
	}
	public String[] getProject_answer_doc() {
		return project_answer_doc;
	}
	public void setProject_answer_doc(String[] project_answer_doc) {
		this.project_answer_doc = project_answer_doc;
	}
	public String[] getProject_answer_links() {
		return project_answer_links;
	}
	public void setProject_answer_links(String[] project_answer_links) {
		this.project_answer_links = project_answer_links;
	}
	public String getProject_answer_architechture() {
		return project_answer_architechture;
	}
	public void setProject_answer_architechture(String project_answer_architechture) {
		this.project_answer_architechture = project_answer_architechture;
	}
	public String[] getProject_answer_reference_doc() {
		return project_answer_reference_doc;
	}
	public void setProject_answer_reference_doc(String[] project_answer_reference_doc) {
		this.project_answer_reference_doc = project_answer_reference_doc;
	}
	public String[] getProject_answer_reference_link() {
		return project_answer_reference_link;
	}
	public void setProject_answer_reference_link(String[] project_answer_reference_link) {
		this.project_answer_reference_link = project_answer_reference_link;
	}
	
	

}
