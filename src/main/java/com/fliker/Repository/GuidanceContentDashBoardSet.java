package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentDashBoardSet")
public class GuidanceContentDashBoardSet {

	@Id
	private String guidancedashboardid;
	private String[] guidancedashdataid;
	private String guidanceentrydashid;
	private String guidanceuserid;
	public String getGuidancedashboardid() {
		return guidancedashboardid;
	}
	public void setGuidancedashboardid(String guidancedashboardid) {
		this.guidancedashboardid = guidancedashboardid;
	}
	public String[] getGuidancedashdataid() {
		return guidancedashdataid;
	}
	public void setGuidancedashdataid(String[] guidancedashdataid) {
		this.guidancedashdataid = guidancedashdataid;
	}
	public String getGuidanceentrydashid() {
		return guidanceentrydashid;
	}
	public void setGuidanceentrydashid(String guidanceentrydashid) {
		this.guidanceentrydashid = guidanceentrydashid;
	}
	public String getGuidanceuserid() {
		return guidanceuserid;
	}
	public void setGuidanceuserid(String guidanceuserid) {
		this.guidanceuserid = guidanceuserid;
	}
	
	
}
