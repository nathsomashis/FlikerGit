package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SkillSet")
public class SkillSet {

	@Id
	private String skillid;
	private String skillname;
	private String[] skillAssesment;
	private String skilllocation;
	private String skilldatetime;
	public String getSkillid() {
		return skillid;
	}
	public void setSkillid(String skillid) {
		this.skillid = skillid;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public String[] getSkillAssesment() {
		return skillAssesment;
	}
	public void setSkillAssesment(String[] skillAssesment) {
		this.skillAssesment = skillAssesment;
	}
	public String getSkilllocation() {
		return skilllocation;
	}
	public void setSkilllocation(String skilllocation) {
		this.skilllocation = skilllocation;
	}
	public String getSkilldatetime() {
		return skilldatetime;
	}
	public void setSkilldatetime(String skilldatetime) {
		this.skilldatetime = skilldatetime;
	}
	
	
	
}
