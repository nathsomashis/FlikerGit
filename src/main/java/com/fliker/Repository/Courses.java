package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Courses")
public class Courses {

	@Id
	private String courseid;
	private String courseName;
	private byte[] courseimage;
	private String courseCategory;
	private String courseDescription;
	private float courseReview;
	private int courseFee;
	private String courseTrend;
	
	public String getCourseTrend() {
		return courseTrend;
	}
	public void setCourseTrend(String courseTrend) {
		this.courseTrend = courseTrend;
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
	public byte[] getCourseimage() {
		return courseimage;
	}
	public void setCourseimage(byte[] courseimage) {
		this.courseimage = courseimage;
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
	public float getCourseReview() {
		return courseReview;
	}
	public void setCourseReview(float courseReview) {
		this.courseReview = courseReview;
	}
	public int getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	
	
	
}
