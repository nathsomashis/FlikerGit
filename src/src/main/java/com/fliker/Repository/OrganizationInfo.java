package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OrganizationInfo")
public class OrganizationInfo {
	
	@Id
	private String organizationid;
	private String organizationcreatedate;
	private String organizationlocation;
	private String organizationName;
	private String organizationdescription;
	private String organizationImageid;
	public String getOrganizationid() {
		return organizationid;
	}
	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}
	public String getOrganizationcreatedate() {
		return organizationcreatedate;
	}
	public void setOrganizationcreatedate(String organizationcreatedate) {
		this.organizationcreatedate = organizationcreatedate;
	}
	public String getOrganizationlocation() {
		return organizationlocation;
	}
	public void setOrganizationlocation(String organizationlocation) {
		this.organizationlocation = organizationlocation;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationdescription() {
		return organizationdescription;
	}
	public void setOrganizationdescription(String organizationdescription) {
		this.organizationdescription = organizationdescription;
	}
	public String getOrganizationImageid() {
		return organizationImageid;
	}
	public void setOrganizationImageid(String organizationImageid) {
		this.organizationImageid = organizationImageid;
	}
	
	

}
