package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JobsPost")
public class JobsPost {

	@Id
	private String jobpostid;
	private String[] sharedid;
	private String jobpostownerid;
	private String[] likeid;
	private String[] commenids;
	private String[] spreadid;
	public String getJobpostid() {
		return jobpostid;
	}
	public void setJobpostid(String jobpostid) {
		this.jobpostid = jobpostid;
	}
	public String[] getSharedid() {
		return sharedid;
	}
	public void setSharedid(String[] sharedid) {
		this.sharedid = sharedid;
	}
	public String getJobpostownerid() {
		return jobpostownerid;
	}
	public void setJobpostownerid(String jobpostownerid) {
		this.jobpostownerid = jobpostownerid;
	}
	public String[] getLikeid() {
		return likeid;
	}
	public void setLikeid(String[] likeid) {
		this.likeid = likeid;
	}
	public String[] getCommenids() {
		return commenids;
	}
	public void setCommenids(String[] commenids) {
		this.commenids = commenids;
	}
	public String[] getSpreadid() {
		return spreadid;
	}
	public void setSpreadid(String[] spreadid) {
		this.spreadid = spreadid;
	}
	
	
}
