package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceInfo")
public class GuidanceInfo {

	@Id
	private String guidanceinfoid;
	private String guidancedescription;
	private String guidanceprice;
	private String guidancesubjectexperience;
	private String[] guidanceendorseby;
	private String[] guidanceachievements;
	public String getGuidanceinfoid() {
		return guidanceinfoid;
	}
	public void setGuidanceinfoid(String guidanceinfoid) {
		this.guidanceinfoid = guidanceinfoid;
	}
	public String getGuidancedescription() {
		return guidancedescription;
	}
	public void setGuidancedescription(String guidancedescription) {
		this.guidancedescription = guidancedescription;
	}
	public String getGuidanceprice() {
		return guidanceprice;
	}
	public void setGuidanceprice(String guidanceprice) {
		this.guidanceprice = guidanceprice;
	}
	public String getGuidancesubjectexperience() {
		return guidancesubjectexperience;
	}
	public void setGuidancesubjectexperience(String guidancesubjectexperience) {
		this.guidancesubjectexperience = guidancesubjectexperience;
	}
	public String[] getGuidanceendorseby() {
		return guidanceendorseby;
	}
	public void setGuidanceendorseby(String[] guidanceendorseby) {
		this.guidanceendorseby = guidanceendorseby;
	}
	public String[] getGuidanceachievements() {
		return guidanceachievements;
	}
	public void setGuidanceachievements(String[] guidanceachievements) {
		this.guidanceachievements = guidanceachievements;
	}
	
	
}
