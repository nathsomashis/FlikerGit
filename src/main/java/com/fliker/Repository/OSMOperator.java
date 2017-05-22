package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OSMOperator")
public class OSMOperator {

	@Id
	private String operatorid;
	private String userid;
	private String[] operatorComapnyid;
	private String operatorStory;
	private String[] oldinvestments;
	private String newsevents;
	private String[] oldbuyings;
	private String[] osmmodelid;
	private String activeCompany;
	private String[] stockholdings;
	private String[] olddevelopments;
	private String[] osmownerids;
	
	
	
	
	public String[] getOsmownerids() {
		return osmownerids;
	}
	public void setOsmownerids(String[] osmownerids) {
		this.osmownerids = osmownerids;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOperatorid() {
		return operatorid;
	}
	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}
	public String[] getOperatorComapnyid() {
		return operatorComapnyid;
	}
	public void setOperatorComapnyid(String[] operatorComapnyid) {
		this.operatorComapnyid = operatorComapnyid;
	}
	public String getOperatorStory() {
		return operatorStory;
	}
	public void setOperatorStory(String operatorStory) {
		this.operatorStory = operatorStory;
	}
	public String[] getOldinvestments() {
		return oldinvestments;
	}
	public void setOldinvestments(String[] oldinvestments) {
		this.oldinvestments = oldinvestments;
	}
	public String getNewsevents() {
		return newsevents;
	}
	public void setNewsevents(String newsevents) {
		this.newsevents = newsevents;
	}
	public String[] getOldbuyings() {
		return oldbuyings;
	}
	public void setOldbuyings(String[] oldbuyings) {
		this.oldbuyings = oldbuyings;
	}
	public String[] getOsmmodelid() {
		return osmmodelid;
	}
	public void setOsmmodelid(String[] osmmodelid) {
		this.osmmodelid = osmmodelid;
	}
	public String getActiveCompany() {
		return activeCompany;
	}
	public void setActiveCompany(String activeCompany) {
		this.activeCompany = activeCompany;
	}
	public String[] getStockholdings() {
		return stockholdings;
	}
	public void setStockholdings(String[] stockholdings) {
		this.stockholdings = stockholdings;
	}
	public String[] getOlddevelopments() {
		return olddevelopments;
	}
	public void setOlddevelopments(String[] olddevelopments) {
		this.olddevelopments = olddevelopments;
	}
	
	
	
	
}
