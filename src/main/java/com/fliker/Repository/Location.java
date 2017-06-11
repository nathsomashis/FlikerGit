package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Location")
public class Location {

	@Id
	private String locationid;
	private String lotitude;
	private String longitude;
	private String city;
	private String place;
	private String country;
	private String locationcontent;
	
	
	
	public String getLotitude() {
		return lotitude;
	}
	public void setLotitude(String lotitude) {
		this.lotitude = lotitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
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
