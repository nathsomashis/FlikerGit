package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntryDashboard")
public class GuidanceEntryDashboard {

	@Id
	private String guidanceentrydashid;
	private String[] guidanceentrydashdataid;
	public String getGuidanceentrydashid() {
		return guidanceentrydashid;
	}
	public void setGuidanceentrydashid(String guidanceentrydashid) {
		this.guidanceentrydashid = guidanceentrydashid;
	}
	public String[] getGuidanceentrydashdataid() {
		return guidanceentrydashdataid;
	}
	public void setGuidanceentrydashdataid(String[] guidanceentrydashdataid) {
		this.guidanceentrydashdataid = guidanceentrydashdataid;
	}
	
	
	
}
