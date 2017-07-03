package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="EschoolStudentInfo")
public class EschoolStudentInfo {

	@Id
	private String studentinfoid;
	private String studentuserid;
	private String batchstartdate;
	private String batchenddate;
	private String[] attendeesession;
	private String invoiceid;
	private String optonlycourse;
	private String optguidanceonly;
	private String optall;
	private String[] guidanceselection;
	private String[] courseselection;
	private String playgroundid;
	private String timetableid;
	private String schoolid;
	
	
	
	
	public String getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}
	public String getOptall() {
		return optall;
	}
	public void setOptall(String optall) {
		this.optall = optall;
	}
	public String getPlaygroundid() {
		return playgroundid;
	}
	public void setPlaygroundid(String playgroundid) {
		this.playgroundid = playgroundid;
	}
	public String getTimetableid() {
		return timetableid;
	}
	public void setTimetableid(String timetableid) {
		this.timetableid = timetableid;
	}
	public String[] getGuidanceselection() {
		return guidanceselection;
	}
	public void setGuidanceselection(String[] guidanceselection) {
		this.guidanceselection = guidanceselection;
	}
	public String[] getCourseselection() {
		return courseselection;
	}
	public void setCourseselection(String[] courseselection) {
		this.courseselection = courseselection;
	}
	public String getStudentinfoid() {
		return studentinfoid;
	}
	public void setStudentinfoid(String studentinfoid) {
		this.studentinfoid = studentinfoid;
	}
	public String getStudentuserid() {
		return studentuserid;
	}
	public void setStudentuserid(String studentuserid) {
		this.studentuserid = studentuserid;
	}
	public String getBatchstartdate() {
		return batchstartdate;
	}
	public void setBatchstartdate(String batchstartdate) {
		this.batchstartdate = batchstartdate;
	}
	public String getBatchenddate() {
		return batchenddate;
	}
	public void setBatchenddate(String batchenddate) {
		this.batchenddate = batchenddate;
	}
	public String[] getAttendeesession() {
		return attendeesession;
	}
	public void setAttendeesession(String[] attendeesession) {
		this.attendeesession = attendeesession;
	}
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getOptonlycourse() {
		return optonlycourse;
	}
	public void setOptonlycourse(String optonlycourse) {
		this.optonlycourse = optonlycourse;
	}
	public String getOptguidanceonly() {
		return optguidanceonly;
	}
	public void setOptguidanceonly(String optguidanceonly) {
		this.optguidanceonly = optguidanceonly;
	}
	
	
	
}
