package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ClassRoom")
public class ClassRoom {

	@Id
	private String classroomid;
	private String classname;
	private String democlassid;
	private String timtableid;
	private String[] partnerid;
	private String profileid;
	private String owner;
	private String[] enrollprofiles;
	
	public String[] getEnrollprofiles() {
		return enrollprofiles;
	}
	public void setEnrollprofiles(String[] enrollprofiles) {
		this.enrollprofiles = enrollprofiles;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(String classroomid) {
		this.classroomid = classroomid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getDemoclassid() {
		return democlassid;
	}
	public void setDemoclassid(String democlassid) {
		this.democlassid = democlassid;
	}
	public String getTimtableid() {
		return timtableid;
	}
	public void setTimtableid(String timtableid) {
		this.timtableid = timtableid;
	}
	public String[] getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(String[] partnerid) {
		this.partnerid = partnerid;
	}
	public String getProfileid() {
		return profileid;
	}
	public void setProfileid(String profileid) {
		this.profileid = profileid;
	}
	
	
	
}
