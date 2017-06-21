package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SkillAssesment")
public class SkillAssesment {

	@Id
	private String skillassesmentid;
	private String skilldescription;
	private String skillfileid;
	public String getSkillassesmentid() {
		return skillassesmentid;
	}
	public void setSkillassesmentid(String skillassesmentid) {
		this.skillassesmentid = skillassesmentid;
	}
	public String getSkilldescription() {
		return skilldescription;
	}
	public void setSkilldescription(String skilldescription) {
		this.skilldescription = skilldescription;
	}
	public String getSkillfileid() {
		return skillfileid;
	}
	public void setSkillfileid(String skillfileid) {
		this.skillfileid = skillfileid;
	}
	
	
}
