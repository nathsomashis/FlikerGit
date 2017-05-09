package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceProject")
public class GuidanceProject {

	@Id
	private String projectid;
	private String projectname;
	private String projectdescription;
	private String projectevaluation;
	private String[] projectsubmissionid;
	private String[] remarks;
	private String[] docid;
	private String[] discussiontopicid;
	private String projectstartdate;
	private String projectenddate;
	
	
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
	public String getProjectdescription() {
		return projectdescription;
	}
	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}
	public String getProjectevaluation() {
		return projectevaluation;
	}
	public void setProjectevaluation(String projectevaluation) {
		this.projectevaluation = projectevaluation;
	}
	public String[] getProjectsubmissionid() {
		return projectsubmissionid;
	}
	public void setProjectsubmissionid(String[] projectsubmissionid) {
		this.projectsubmissionid = projectsubmissionid;
	}
	public String[] getRemarks() {
		return remarks;
	}
	public void setRemarks(String[] remarks) {
		this.remarks = remarks;
	}
	public String[] getDocid() {
		return docid;
	}
	public void setDocid(String[] docid) {
		this.docid = docid;
	}
	public String[] getDiscussiontopicid() {
		return discussiontopicid;
	}
	public void setDiscussiontopicid(String[] discussiontopicid) {
		this.discussiontopicid = discussiontopicid;
	}
	public String getProjectstartdate() {
		return projectstartdate;
	}
	public void setProjectstartdate(String projectstartdate) {
		this.projectstartdate = projectstartdate;
	}
	public String getProjectenddate() {
		return projectenddate;
	}
	public void setProjectenddate(String projectenddate) {
		this.projectenddate = projectenddate;
	}
	
	
	
	
	
}
