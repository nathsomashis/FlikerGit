package com.fliker.Repository;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OrganizationData")
public class OrganizationData {

	@Id
	private String organizationdataid;
	private String organizationownerid ;
	private String[] organizationProfileids;
	private String[] organizationPostids;
	private HashMap organizationFileContent;
	public String getOrganizationdataid() {
		return organizationdataid;
	}
	public void setOrganizationdataid(String organizationdataid) {
		this.organizationdataid = organizationdataid;
	}
	public String getOrganizationownerid() {
		return organizationownerid;
	}
	public void setOrganizationownerid(String organizationownerid) {
		this.organizationownerid = organizationownerid;
	}
	public String[] getOrganizationProfileids() {
		return organizationProfileids;
	}
	public void setOrganizationProfileids(String[] organizationProfileids) {
		this.organizationProfileids = organizationProfileids;
	}
	public String[] getOrganizationPostids() {
		return organizationPostids;
	}
	public void setOrganizationPostids(String[] organizationPostids) {
		this.organizationPostids = organizationPostids;
	}
	public HashMap getOrganizationFileContent() {
		return organizationFileContent;
	}
	public void setOrganizationFileContent(HashMap organizationFileContent) {
		this.organizationFileContent = organizationFileContent;
	}
	
	
}
