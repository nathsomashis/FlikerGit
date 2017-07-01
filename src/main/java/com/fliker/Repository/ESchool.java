package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ESchool")
public class ESchool {

	@Id
	private String eschoolid;
	private String eschoolname;
	private String duration;
	private String[] eschoolguidancelink;  
	private String[] eschoolbackedbycompany;
	private String[] eschoolinverstors;
	private String[] eschoolendorseby;
	private String[] likes;
	private String[] shares;
	private String admissioncharges;
	private String[] eschoolcourselink;
	private String onlycheckguidance;
	private String onlycheckcourse;
	private String accountid;
	private String[] studentslistinfo;
	private String eschoolimageid;
	private String resourcenumber;
	private String[] specification;
	private String eschooldescription;
	private String schoollocation;
	private String[] resources;
	private String[] pricevariation;
	private String playgroundid;
	private String[] batchesinfo;
	
	
	
	public String[] getBatchesinfo() {
		return batchesinfo;
	}
	public void setBatchesinfo(String[] batchesinfo) {
		this.batchesinfo = batchesinfo;
	}
	public String getPlaygroundid() {
		return playgroundid;
	}
	public void setPlaygroundid(String playgroundid) {
		this.playgroundid = playgroundid;
	}
	public String[] getPricevariation() {
		return pricevariation;
	}
	public void setPricevariation(String[] pricevariation) {
		this.pricevariation = pricevariation;
	}
	public String[] getResources() {
		return resources;
	}
	public void setResources(String[] resources) {
		this.resources = resources;
	}
	public String getEschoolimageid() {
		return eschoolimageid;
	}
	public void setEschoolimageid(String eschoolimageid) {
		this.eschoolimageid = eschoolimageid;
	}
	public String getResourcenumber() {
		return resourcenumber;
	}
	public void setResourcenumber(String resourcenumber) {
		this.resourcenumber = resourcenumber;
	}
	public String[] getSpecification() {
		return specification;
	}
	public void setSpecification(String[] specification) {
		this.specification = specification;
	}
	public String getEschooldescription() {
		return eschooldescription;
	}
	public void setEschooldescription(String eschooldescription) {
		this.eschooldescription = eschooldescription;
	}
	public String getSchoollocation() {
		return schoollocation;
	}
	public void setSchoollocation(String schoollocation) {
		this.schoollocation = schoollocation;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String[] getStudentslistinfo() {
		return studentslistinfo;
	}
	public void setStudentslistinfo(String[] studentslistinfo) {
		this.studentslistinfo = studentslistinfo;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getOnlycheckguidance() {
		return onlycheckguidance;
	}
	public void setOnlycheckguidance(String onlycheckguidance) {
		this.onlycheckguidance = onlycheckguidance;
	}
	public String getOnlycheckcourse() {
		return onlycheckcourse;
	}
	public void setOnlycheckcourse(String onlycheckcourse) {
		this.onlycheckcourse = onlycheckcourse;
	}
	public String[] getEschoolcourselink() {
		return eschoolcourselink;
	}
	public void setEschoolcourselink(String[] eschoolcourselink) {
		this.eschoolcourselink = eschoolcourselink;
	}
	public String getAdmissioncharges() {
		return admissioncharges;
	}
	public void setAdmissioncharges(String admissioncharges) {
		this.admissioncharges = admissioncharges;
	}
	public String getEschoolid() {
		return eschoolid;
	}
	public void setEschoolid(String eschoolid) {
		this.eschoolid = eschoolid;
	}
	public String getEschoolname() {
		return eschoolname;
	}
	public void setEschoolname(String eschoolname) {
		this.eschoolname = eschoolname;
	}
	public String[] getEschoolguidancelink() {
		return eschoolguidancelink;
	}
	public void setEschoolguidancelink(String[] eschoolguidancelink) {
		this.eschoolguidancelink = eschoolguidancelink;
	}
	public String[] getEschoolbackedbycompany() {
		return eschoolbackedbycompany;
	}
	public void setEschoolbackedbycompany(String[] eschoolbackedbycompany) {
		this.eschoolbackedbycompany = eschoolbackedbycompany;
	}
	public String[] getEschoolinverstors() {
		return eschoolinverstors;
	}
	public void setEschoolinverstors(String[] eschoolinverstors) {
		this.eschoolinverstors = eschoolinverstors;
	}
	public String[] getEschoolendorseby() {
		return eschoolendorseby;
	}
	public void setEschoolendorseby(String[] eschoolendorseby) {
		this.eschoolendorseby = eschoolendorseby;
	}
	public String[] getLikes() {
		return likes;
	}
	public void setLikes(String[] likes) {
		this.likes = likes;
	}
	public String[] getShares() {
		return shares;
	}
	public void setShares(String[] shares) {
		this.shares = shares;
	}
	
	
}
