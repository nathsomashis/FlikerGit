package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Skill")
public class Skill {

	@Id
	private String skillid;
	private String skillname;
	private String skillimageid;
	private String skillcategory;
	private String skilldescription;
	private String skillreview;
	private String skillfee;
	private String[] skillsponsors;
	private String[] skillpartners;
	private String FAQid;
	private String skillownerid;
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
	public String getSkillimageid() {
		return skillimageid;
	}
	public void setSkillimageid(String skillimageid) {
		this.skillimageid = skillimageid;
	}
	public String getSkillcategory() {
		return skillcategory;
	}
	public void setSkillcategory(String skillcategory) {
		this.skillcategory = skillcategory;
	}
	public String getSkilldescription() {
		return skilldescription;
	}
	public void setSkilldescription(String skilldescription) {
		this.skilldescription = skilldescription;
	}
	public String getSkillreview() {
		return skillreview;
	}
	public void setSkillreview(String skillreview) {
		this.skillreview = skillreview;
	}
	public String getSkillfee() {
		return skillfee;
	}
	public void setSkillfee(String skillfee) {
		this.skillfee = skillfee;
	}
	public String[] getSkillsponsors() {
		return skillsponsors;
	}
	public void setSkillsponsors(String[] skillsponsors) {
		this.skillsponsors = skillsponsors;
	}
	public String[] getSkillpartners() {
		return skillpartners;
	}
	public void setSkillpartners(String[] skillpartners) {
		this.skillpartners = skillpartners;
	}
	public String getFAQid() {
		return FAQid;
	}
	public void setFAQid(String fAQid) {
		FAQid = fAQid;
	}
	public String getSkillownerid() {
		return skillownerid;
	}
	public void setSkillownerid(String skillownerid) {
		this.skillownerid = skillownerid;
	}
	
	
	
}
