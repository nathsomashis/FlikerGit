package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CompanyProfile")
public class CompanyProfile {

	@Id
	private String companyid;
	private String companyDescription;
	private String companywebsite;
	private String companyindustry;
	private String companyType;
	private String companyheadquarter;
	private String companySize;
	private String companyFounded;
	private String[] companyprofiledataid;
	
	public String[] getCompanyprofiledataid() {
		return companyprofiledataid;
	}
	public void setCompanyprofiledataid(String[] companyprofiledataid) {
		this.companyprofiledataid = companyprofiledataid;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public String getCompanyDescription() {
		return companyDescription;
	}
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	public String getCompanywebsite() {
		return companywebsite;
	}
	public void setCompanywebsite(String companywebsite) {
		this.companywebsite = companywebsite;
	}
	public String getCompanyindustry() {
		return companyindustry;
	}
	public void setCompanyindustry(String companyindustry) {
		this.companyindustry = companyindustry;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCompanyheadquarter() {
		return companyheadquarter;
	}
	public void setCompanyheadquarter(String companyheadquarter) {
		this.companyheadquarter = companyheadquarter;
	}
	public String getCompanySize() {
		return companySize;
	}
	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}
	public String getCompanyFounded() {
		return companyFounded;
	}
	public void setCompanyFounded(String companyFounded) {
		this.companyFounded = companyFounded;
	}
	
	
	
}
