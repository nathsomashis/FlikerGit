package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="EschoolBatch")
public class ESchoolBatch {

	private String batchid;
	private String batchstartdate;
	private String batchenddate;
	private String[] studentinfoid;
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
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
	public String[] getStudentinfoid() {
		return studentinfoid;
	}
	public void setStudentinfoid(String[] studentinfoid) {
		this.studentinfoid = studentinfoid;
	}
	
	
}
