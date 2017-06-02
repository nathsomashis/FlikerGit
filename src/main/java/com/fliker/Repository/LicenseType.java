package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="License")
public class LicenseType {

	private String licenseid;
	private String licenseTo;
	private String licenseduration;
	private String licensetype;
	
	
	
	public String getLicenseid() {
		return licenseid;
	}
	public void setLicenseid(String licenseid) {
		this.licenseid = licenseid;
	}
	public String getLicenseTo() {
		return licenseTo;
	}
	public void setLicenseTo(String licenseTo) {
		this.licenseTo = licenseTo;
	}
	
	public String getLicenseduration() {
		return licenseduration;
	}
	public void setLicenseduration(String licenseduration) {
		this.licenseduration = licenseduration;
	}
	public String getLicensetype() {
		return licensetype;
	}
	public void setLicensetype(String licensetype) {
		this.licensetype = licensetype;
	}
	
	
	
}
