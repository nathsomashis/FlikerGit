package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceEntryCalendar")
public class GuidanceEntryCalendar {

	@Id
	private String guidancecalendarid;
	private String[] eventids;
	public String getGuidancecalendarid() {
		return guidancecalendarid;
	}
	public void setGuidancecalendarid(String guidancecalendarid) {
		this.guidancecalendarid = guidancecalendarid;
	}
	public String[] getEventids() {
		return eventids;
	}
	public void setEventids(String[] eventids) {
		this.eventids = eventids;
	}
	
	
	
}
