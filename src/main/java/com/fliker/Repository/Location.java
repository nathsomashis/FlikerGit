package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Location")
public class Location {

	@Id
	private String locationid;
	private String locationcontent;
	public String getLocationid() {
		return locationid;
	}
	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}
	public String getLocationcontent() {
		return locationcontent;
	}
	public void setLocationcontent(String locationcontent) {
		this.locationcontent = locationcontent;
	}
	
	
	
}
