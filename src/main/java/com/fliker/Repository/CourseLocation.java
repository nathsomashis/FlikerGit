package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CourseLocation")
public class CourseLocation {

	@Id
	private String courselocationid;
	private String location;
	private String Country;
	private String State;
	private String Place;
	public String getCourselocationid() {
		return courselocationid;
	}
	public void setCourselocationid(String courselocationid) {
		this.courselocationid = courselocationid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	
	
	
}
