package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CoursesReview")
public class CoursesReview {

	@Id
	private String reviewid;
	private String reviewcomment;
	private String reviewavg;
	private String coursereview;
	private String reviewdatetime;
	private String reviewdone;
	private String reviewlocation;
	public String getReviewid() {
		return reviewid;
	}
	public void setReviewid(String reviewid) {
		this.reviewid = reviewid;
	}
	public String getReviewcomment() {
		return reviewcomment;
	}
	public void setReviewcomment(String reviewcomment) {
		this.reviewcomment = reviewcomment;
	}
	public String getReviewavg() {
		return reviewavg;
	}
	public void setReviewavg(String reviewavg) {
		this.reviewavg = reviewavg;
	}
	public String getCoursereview() {
		return coursereview;
	}
	public void setCoursereview(String coursereview) {
		this.coursereview = coursereview;
	}
	public String getReviewdatetime() {
		return reviewdatetime;
	}
	public void setReviewdatetime(String reviewdatetime) {
		this.reviewdatetime = reviewdatetime;
	}
	public String getReviewdone() {
		return reviewdone;
	}
	public void setReviewdone(String reviewdone) {
		this.reviewdone = reviewdone;
	}
	public String getReviewlocation() {
		return reviewlocation;
	}
	public void setReviewlocation(String reviewlocation) {
		this.reviewlocation = reviewlocation;
	}
	
	
	
	
}
