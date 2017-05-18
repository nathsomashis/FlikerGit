package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMProjectInfo")
public class OSMProjectInfo {

	@Id
	private String projectinfoid;
	private String osmmodelid;
	private String projectname;
	private String projectdescription;
	private String[] projectdocs;
	private String projectmarkettingdoc;
	private String projectdemandchart;
	private String projectinvestors;
	private String projectbuyers;
	private String projectstockprice;
	private String projectresources;
	
	
	public String getOsmmodelid() {
		return osmmodelid;
	}
	public void setOsmmodelid(String osmmodelid) {
		this.osmmodelid = osmmodelid;
	}
	public String getProjectinfoid() {
		return projectinfoid;
	}
	public void setProjectinfoid(String projectinfoid) {
		this.projectinfoid = projectinfoid;
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
	public String[] getProjectdocs() {
		return projectdocs;
	}
	public void setProjectdocs(String[] projectdocs) {
		this.projectdocs = projectdocs;
	}
	public String getProjectmarkettingdoc() {
		return projectmarkettingdoc;
	}
	public void setProjectmarkettingdoc(String projectmarkettingdoc) {
		this.projectmarkettingdoc = projectmarkettingdoc;
	}
	public String getProjectdemandchart() {
		return projectdemandchart;
	}
	public void setProjectdemandchart(String projectdemandchart) {
		this.projectdemandchart = projectdemandchart;
	}
	public String getProjectinvestors() {
		return projectinvestors;
	}
	public void setProjectinvestors(String projectinvestors) {
		this.projectinvestors = projectinvestors;
	}
	public String getProjectbuyers() {
		return projectbuyers;
	}
	public void setProjectbuyers(String projectbuyers) {
		this.projectbuyers = projectbuyers;
	}
	public String getProjectstockprice() {
		return projectstockprice;
	}
	public void setProjectstockprice(String projectstockprice) {
		this.projectstockprice = projectstockprice;
	}
	public String getProjectresources() {
		return projectresources;
	}
	public void setProjectresources(String projectresources) {
		this.projectresources = projectresources;
	}
	
	
	
	
	
}
