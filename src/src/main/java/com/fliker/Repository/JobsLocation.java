package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JobsLocation")
public class JobsLocation {

	@Id
	private String joblocationid;
	private String locationinfo;
	private String country;
	private String state;
	public String getJoblocationid() {
		return joblocationid;
	}
	public void setJoblocationid(String joblocationid) {
		this.joblocationid = joblocationid;
	}
	public String getLocationinfo() {
		return locationinfo;
	}
	public void setLocationinfo(String locationinfo) {
		this.locationinfo = locationinfo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
