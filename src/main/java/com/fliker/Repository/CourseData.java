package com.fliker.Repository;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CourseData")
public class CourseData {

	@Id
	private String coursedataid;
	public String getCoursedataid() {
		return coursedataid;
	}
	public void setCoursedataid(String coursedataid) {
		this.coursedataid = coursedataid;
	}
	private String[] coursefilid;
	private String[] weekid;
	private String stardate;
	private String enddate;
	private HashMap coursemappedWeek;
	public String[] getCoursefilid() {
		return coursefilid;
	}
	public void setCoursefilid(String[] coursefilid) {
		this.coursefilid = coursefilid;
	}
	public String[] getWeekid() {
		return weekid;
	}
	public void setWeekid(String[] weekid) {
		this.weekid = weekid;
	}
	public String getStardate() {
		return stardate;
	}
	public void setStardate(String stardate) {
		this.stardate = stardate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public HashMap getCoursemappedWeek() {
		return coursemappedWeek;
	}
	public void setCoursemappedWeek(HashMap coursemappedWeek) {
		this.coursemappedWeek = coursemappedWeek;
	}
	
	
}
