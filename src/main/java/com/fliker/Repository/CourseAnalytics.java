package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CourseAnalytics")
public class CourseAnalytics {

	@Id
	private String courseid;
	private String shareid;
	private String sharecommentid;
	private String sharelikedid;
	private String spreadid;
	private String spreadcommentid;
	private String visitorsid;
	private String takersid;
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getShareid() {
		return shareid;
	}
	public void setShareid(String shareid) {
		this.shareid = shareid;
	}
	public String getSharecommentid() {
		return sharecommentid;
	}
	public void setSharecommentid(String sharecommentid) {
		this.sharecommentid = sharecommentid;
	}
	public String getSharelikedid() {
		return sharelikedid;
	}
	public void setSharelikedid(String sharelikedid) {
		this.sharelikedid = sharelikedid;
	}
	public String getSpreadid() {
		return spreadid;
	}
	public void setSpreadid(String spreadid) {
		this.spreadid = spreadid;
	}
	public String getSpreadcommentid() {
		return spreadcommentid;
	}
	public void setSpreadcommentid(String spreadcommentid) {
		this.spreadcommentid = spreadcommentid;
	}
	public String getVisitorsid() {
		return visitorsid;
	}
	public void setVisitorsid(String visitorsid) {
		this.visitorsid = visitorsid;
	}
	public String getTakersid() {
		return takersid;
	}
	public void setTakersid(String takersid) {
		this.takersid = takersid;
	}
	
	
	
}
