package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceSpecificationData")
public class GuidanceSpecificationData {

	@Id
	private String specificationid;
	private String specificationname;
	private String specificationdetails;
	private String specificationpercentage;
	private String[] specificationremarks;
	
	
	public String getSpecificationpercentage() {
		return specificationpercentage;
	}
	public void setSpecificationpercentage(String specificationpercentage) {
		this.specificationpercentage = specificationpercentage;
	}
	public String getSpecificationid() {
		return specificationid;
	}
	public void setSpecificationid(String specificationid) {
		this.specificationid = specificationid;
	}
	public String getSpecificationname() {
		return specificationname;
	}
	public void setSpecificationname(String specificationname) {
		this.specificationname = specificationname;
	}
	public String getSpecificationdetails() {
		return specificationdetails;
	}
	public void setSpecificationdetails(String specificationdetails) {
		this.specificationdetails = specificationdetails;
	}
	public String[] getSpecificationremarks() {
		return specificationremarks;
	}
	public void setSpecificationremarks(String[] specificationremarks) {
		this.specificationremarks = specificationremarks;
	}
	
	
	
}
