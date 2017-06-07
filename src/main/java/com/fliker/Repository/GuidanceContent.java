package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "GuidanceContent")
public class GuidanceContent {

	@Id
	private String guidanceid;
	private String provideruserid;
	private String[] consumeruserid;
	private String sharetokenid;
	private String dashboardid;
	private String averageVelocity;
	private String blogid;
	private String timetableid;
	private String projectid;
	private String[] likeid;
	private String[] sharedid;
	private String price;
	
	
	
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getAverageVelocity() {
		return averageVelocity;
	}

	public void setAverageVelocity(String averageVelocity) {
		this.averageVelocity = averageVelocity;
	}

	public String getBlogid() {
		return blogid;
	}

	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}

	public String getTimetableid() {
		return timetableid;
	}

	public void setTimetableid(String timetableid) {
		this.timetableid = timetableid;
	}

	public String getGuidanceid() {
		return guidanceid;
	}

	public void setGuidanceid(String guidanceid) {
		this.guidanceid = guidanceid;
	}

	public String getProvideruserid() {
		return provideruserid;
	}

	public void setProvideruserid(String provideruserid) {
		this.provideruserid = provideruserid;
	}

	

	public String[] getConsumeruserid() {
		return consumeruserid;
	}

	public void setConsumeruserid(String[] consumeruserid) {
		this.consumeruserid = consumeruserid;
	}

	

	public String[] getLikeid() {
		return likeid;
	}

	public void setLikeid(String[] likeid) {
		this.likeid = likeid;
	}

	public String[] getSharedid() {
		return sharedid;
	}

	public void setSharedid(String[] sharedid) {
		this.sharedid = sharedid;
	}

	public String getSharetokenid() {
		return sharetokenid;
	}

	public void setSharetokenid(String sharetokenid) {
		this.sharetokenid = sharetokenid;
	}

	public String getDashboardid() {
		return dashboardid;
	}

	public void setDashboardid(String dashboardid) {
		this.dashboardid = dashboardid;
	}

}
