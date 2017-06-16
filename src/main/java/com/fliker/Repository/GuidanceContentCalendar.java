package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentCalendar")
public class GuidanceContentCalendar {
	
	@Id
	private String guidancecalendarid;
	private String[] guidancecalendareventid;
	public String getGuidancecalendarid() {
		return guidancecalendarid;
	}
	public void setGuidancecalendarid(String guidancecalendarid) {
		this.guidancecalendarid = guidancecalendarid;
	}
	public String[] getGuidancecalendareventid() {
		return guidancecalendareventid;
	}
	public void setGuidancecalendareventid(String[] guidancecalendareventid) {
		this.guidancecalendareventid = guidancecalendareventid;
	}
	
	

}
