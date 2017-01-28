package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Course")
public class Courses {

	@Id
	private String courseid;
	private String courseName;
	private String courseimageid;
	private String courseCategory;
	private String courseDescription;
	private String courseReview;
	private String courseFee;
	private String[] courseSponsors;
	private String[] coursePartners;
	private String[] FAQid;
	private String courseownerid;
	private String coursecreatedate;
	private String coursepublisheddate;
	private String coursecreatelocation;
	private String coursepublishlocation;
	private String[] courseweekids;
	private String courselinkid;
	
	
	
	
	public String getCoursecreatedate() {
		return coursecreatedate;
	}
	public void setCoursecreatedate(String coursecreatedate) {
		this.coursecreatedate = coursecreatedate;
	}
	public String getCoursepublisheddate() {
		return coursepublisheddate;
	}
	public void setCoursepublisheddate(String coursepublisheddate) {
		this.coursepublisheddate = coursepublisheddate;
	}
	public String getCoursecreatelocation() {
		return coursecreatelocation;
	}
	public void setCoursecreatelocation(String coursecreatelocation) {
		this.coursecreatelocation = coursecreatelocation;
	}
	public String getCoursepublishlocation() {
		return coursepublishlocation;
	}
	public void setCoursepublishlocation(String coursepublishlocation) {
		this.coursepublishlocation = coursepublishlocation;
	}
	public String[] getCourseweekids() {
		return courseweekids;
	}
	public void setCourseweekids(String[] courseweekids) {
		this.courseweekids = courseweekids;
	}
	public String getCourselinkid() {
		return courselinkid;
	}
	public void setCourselinkid(String courselinkid) {
		this.courselinkid = courselinkid;
	}
	public String[] getCourseSponsors() {
		return courseSponsors;
	}
	public void setCourseSponsors(String[] courseSponsors) {
		this.courseSponsors = courseSponsors;
	}
	public String[] getCoursePartners() {
		return coursePartners;
	}
	public void setCoursePartners(String[] coursePartners) {
		this.coursePartners = coursePartners;
	}
	
	public String[] getFAQid() {
		return FAQid;
	}
	public void setFAQid(String[] fAQid) {
		FAQid = fAQid;
	}
	public String getCourseownerid() {
		return courseownerid;
	}
	public void setCourseownerid(String courseownerid) {
		this.courseownerid = courseownerid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseimageid() {
		return courseimageid;
	}
	public void setCourseimageid(String courseimageid) {
		this.courseimageid = courseimageid;
	}
	public String getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	public String getCourseReview() {
		return courseReview;
	}
	public void setCourseReview(String courseReview) {
		this.courseReview = courseReview;
	}
	public String getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(String courseFee) {
		this.courseFee = courseFee;
	}
	
	
	
	
	
	
}
