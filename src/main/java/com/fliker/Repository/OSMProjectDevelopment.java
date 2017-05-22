package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMProjectDevelopment")
public class OSMProjectDevelopment {

	@Id
	private String osmprojectdevelopmentid;
	private String osmmodelid;
	private String[] osmresourceid;
	private String[] projectflodocs;
	private String projectslidesid;
	private String projectidlink;
	private String projectlinkaccess;
	
	public String getOsmprojectdevelopmentid() {
		return osmprojectdevelopmentid;
	}
	public void setOsmprojectdevelopmentid(String osmprojectdevelopmentid) {
		this.osmprojectdevelopmentid = osmprojectdevelopmentid;
	}
	public String getOsmmodelid() {
		return osmmodelid;
	}
	public void setOsmmodelid(String osmmodelid) {
		this.osmmodelid = osmmodelid;
	}
	public String[] getOsmresourceid() {
		return osmresourceid;
	}
	public void setOsmresourceid(String[] osmresourceid) {
		this.osmresourceid = osmresourceid;
	}
	public String[] getProjectflodocs() {
		return projectflodocs;
	}
	public void setProjectflodocs(String[] projectflodocs) {
		this.projectflodocs = projectflodocs;
	}
	public String getProjectslidesid() {
		return projectslidesid;
	}
	public void setProjectslidesid(String projectslidesid) {
		this.projectslidesid = projectslidesid;
	}
	public String getProjectidlink() {
		return projectidlink;
	}
	public void setProjectidlink(String projectidlink) {
		this.projectidlink = projectidlink;
	}
	public String getProjectlinkaccess() {
		return projectlinkaccess;
	}
	public void setProjectlinkaccess(String projectlinkaccess) {
		this.projectlinkaccess = projectlinkaccess;
	}
	
	
	
	
	
	
	
}
