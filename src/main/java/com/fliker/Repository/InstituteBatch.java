package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="InstituteBatch")
public class InstituteBatch {
	
	@Id
	private String batchid;
	private String batchyear;
	private String batchterminaltime;
	private String batchstarttime;
	private String[] batchdata;
	private String[] students;
	
	
	public String[] getStudents() {
		return students;
	}
	public void setStudents(String[] students) {
		this.students = students;
	}
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public String getBatchyear() {
		return batchyear;
	}
	public void setBatchyear(String batchyear) {
		this.batchyear = batchyear;
	}
	public String getBatchterminaltime() {
		return batchterminaltime;
	}
	public void setBatchterminaltime(String batchterminaltime) {
		this.batchterminaltime = batchterminaltime;
	}
	public String getBatchstarttime() {
		return batchstarttime;
	}
	public void setBatchstarttime(String batchstarttime) {
		this.batchstarttime = batchstarttime;
	}
	public String[] getBatchdata() {
		return batchdata;
	}
	public void setBatchdata(String[] batchdata) {
		this.batchdata = batchdata;
	}
	
	
}
