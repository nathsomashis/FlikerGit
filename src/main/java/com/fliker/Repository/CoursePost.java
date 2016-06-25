package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CoursePost")
public class CoursePost {

	@Id
	private String coursepostid;
	private String[] courseshareids;
	private String[] likeids;
	private String[] commentids;
	public String getCoursepostid() {
		return coursepostid;
	}
	public void setCoursepostid(String coursepostid) {
		this.coursepostid = coursepostid;
	}
	public String[] getCourseshareids() {
		return courseshareids;
	}
	public void setCourseshareids(String[] courseshareids) {
		this.courseshareids = courseshareids;
	}
	public String[] getLikeids() {
		return likeids;
	}
	public void setLikeids(String[] likeids) {
		this.likeids = likeids;
	}
	public String[] getCommentids() {
		return commentids;
	}
	public void setCommentids(String[] commentids) {
		this.commentids = commentids;
	}
	
	
	
	
}
