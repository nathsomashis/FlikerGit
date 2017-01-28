package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CourseWeek")
public class CourseWeek {

	@Id
	private String weekid;
	private String sequencefileid;
	private String courseid;
	private String editid;
	private String blogid;
	public String getWeekid() {
		return weekid;
	}
	public void setWeekid(String weekid) {
		this.weekid = weekid;
	}
	public String getSequencefileid() {
		return sequencefileid;
	}
	public void setSequencefileid(String sequencefileid) {
		this.sequencefileid = sequencefileid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getEditid() {
		return editid;
	}
	public void setEditid(String editid) {
		this.editid = editid;
	}
	public String getBlogid() {
		return blogid;
	}
	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}
	
	
	
	
}
