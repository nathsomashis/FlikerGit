package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="EschoolGuidanceLink")
public class ESchoolGuidanceLink {

	@Id
	private String eschoolid;
	private String eschoolteacheruserid;
	private String eschoolguidanceid;
	private String eschoolteacherclassid;
	private String[] eschoolteachersessionid;
	
	
	public String[] getEschoolteachersessionid() {
		return eschoolteachersessionid;
	}
	public void setEschoolteachersessionid(String[] eschoolteachersessionid) {
		this.eschoolteachersessionid = eschoolteachersessionid;
	}
	public String getEschoolid() {
		return eschoolid;
	}
	public void setEschoolid(String eschoolid) {
		this.eschoolid = eschoolid;
	}
	public String getEschoolteacheruserid() {
		return eschoolteacheruserid;
	}
	public void setEschoolteacheruserid(String eschoolteacheruserid) {
		this.eschoolteacheruserid = eschoolteacheruserid;
	}
	public String getEschoolguidanceid() {
		return eschoolguidanceid;
	}
	public void setEschoolguidanceid(String eschoolguidanceid) {
		this.eschoolguidanceid = eschoolguidanceid;
	}
	public String getEschoolteacherclassid() {
		return eschoolteacherclassid;
	}
	public void setEschoolteacherclassid(String eschoolteacherclassid) {
		this.eschoolteacherclassid = eschoolteacherclassid;
	}
	
	
}
