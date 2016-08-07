package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ProfileData")
public class ProfileData {

	@Id
	private String profiledataid;
	private String[] projectids;
	private String[] skillids;
	private String[] filecontentids;
	public String getProfiledataid() {
		return profiledataid;
	}
	public void setProfiledataid(String profiledataid) {
		this.profiledataid = profiledataid;
	}
	public String[] getProjectids() {
		return projectids;
	}
	public void setProjectids(String[] projectids) {
		this.projectids = projectids;
	}
	public String[] getSkillids() {
		return skillids;
	}
	public void setSkillids(String[] skillids) {
		this.skillids = skillids;
	}
	public String[] getFilecontentids() {
		return filecontentids;
	}
	public void setFilecontentids(String[] filecontentids) {
		this.filecontentids = filecontentids;
	}
	
	
}
