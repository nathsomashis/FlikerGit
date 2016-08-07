package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="EnentEntry")
public class EventEntry {

	@Id
	private String evententryid;
	private String eventtime;
	private String eventlocation;
	private String eventdescription;
	public String getEvententryid() {
		return evententryid;
	}
	public void setEvententryid(String evententryid) {
		this.evententryid = evententryid;
	}
	public String getEventtime() {
		return eventtime;
	}
	public void setEventtime(String eventtime) {
		this.eventtime = eventtime;
	}
	public String getEventlocation() {
		return eventlocation;
	}
	public void setEventlocation(String eventlocation) {
		this.eventlocation = eventlocation;
	}
	public String getEventdescription() {
		return eventdescription;
	}
	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription;
	}
	
	
	
}
