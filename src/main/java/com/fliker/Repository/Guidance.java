package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "GuidanceSelection")
public class Guidance {

	@Id
	private String guidanceid;
	private String[] guidanceSubject;
	private String userid;
	private String guidanceflag;
	private String guidencetype;
	
	
	
	
	public String getGuidencetype() {
		return guidencetype;
	}
	public void setGuidencetype(String guidencetype) {
		this.guidencetype = guidencetype;
	}
	public String getGuidanceflag() {
		return guidanceflag;
	}
	public void setGuidanceflag(String guidanceflag) {
		this.guidanceflag = guidanceflag;
	}
	public String getGuidanceid() {
		return guidanceid;
	}
	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
	}
	public String[] getGuidanceSubject() {
		return guidanceSubject;
	}
	public void setGuidanceSubject(String[] guidanceSubject) {
		this.guidanceSubject = guidanceSubject;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	
}
