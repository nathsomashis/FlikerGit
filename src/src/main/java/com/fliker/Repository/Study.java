package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Study")
public class Study {

	@Id
	private String studyid;
	private String[] courseid;
	private String[] skillid;
	public String getStudyid() {
		return studyid;
	}
	public void setStudyid(String studyid) {
		this.studyid = studyid;
	}
	public String[] getCourseid() {
		return courseid;
	}
	public void setCourseid(String[] courseid) {
		this.courseid = courseid;
	}
	public String[] getSkillid() {
		return skillid;
	}
	public void setSkillid(String[] skillid) {
		this.skillid = skillid;
	}
	
	
	
	
}
