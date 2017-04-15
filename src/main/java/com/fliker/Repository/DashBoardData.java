package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DashBoardData")
public class DashBoardData {

	@Id
	private String dashdataid;
	private String dashdatatype;
	private String dashXdata;
	private String dashYdata;
	
	
	public String getDashdatatype() {
		return dashdatatype;
	}
	public void setDashdatatype(String dashdatatype) {
		this.dashdatatype = dashdatatype;
	}
	public String getDashdataid() {
		return dashdataid;
	}
	public void setDashdataid(String dashdataid) {
		this.dashdataid = dashdataid;
	}
	public String getDashXdata() {
		return dashXdata;
	}
	public void setDashXdata(String dashXdata) {
		this.dashXdata = dashXdata;
	}
	public String getDashYdata() {
		return dashYdata;
	}
	public void setDashYdata(String dashYdata) {
		this.dashYdata = dashYdata;
	}
	
}
