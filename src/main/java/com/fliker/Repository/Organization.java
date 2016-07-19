package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Organization")
public class Organization {

	
	private String organizationID;
	private String organizationName;
	private String orgaboutme;
	private String[] courseids;
	private String orgwebsite;
	private String orgimageid;
	private String orglogoid;
	private String orgType;
	private String[] orgFollowers;
	private String[] orgPosts;
	private String[] orgreviews;
	public String getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(String organizationID) {
		this.organizationID = organizationID;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrgaboutme() {
		return orgaboutme;
	}
	public void setOrgaboutme(String orgaboutme) {
		this.orgaboutme = orgaboutme;
	}
	public String[] getCourseids() {
		return courseids;
	}
	public void setCourseids(String[] courseids) {
		this.courseids = courseids;
	}
	public String getOrgwebsite() {
		return orgwebsite;
	}
	public void setOrgwebsite(String orgwebsite) {
		this.orgwebsite = orgwebsite;
	}
	public String getOrgimageid() {
		return orgimageid;
	}
	public void setOrgimageid(String orgimageid) {
		this.orgimageid = orgimageid;
	}
	public String getOrglogoid() {
		return orglogoid;
	}
	public void setOrglogoid(String orglogoid) {
		this.orglogoid = orglogoid;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String[] getOrgFollowers() {
		return orgFollowers;
	}
	public void setOrgFollowers(String[] orgFollowers) {
		this.orgFollowers = orgFollowers;
	}
	public String[] getOrgPosts() {
		return orgPosts;
	}
	public void setOrgPosts(String[] orgPosts) {
		this.orgPosts = orgPosts;
	}
	public String[] getOrgreviews() {
		return orgreviews;
	}
	public void setOrgreviews(String[] orgreviews) {
		this.orgreviews = orgreviews;
	}
	
	
	
	
}
