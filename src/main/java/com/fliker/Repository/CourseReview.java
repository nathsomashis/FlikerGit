package com.fliker.Repository;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CourseReview")
public class CourseReview {

	@Id
	private String coursereviewid;
	private String userid;
	private String comment;
	private String reviewtime;
	private String[] replyid;
	private String[] likeids;
	public String getCoursereviewid() {
		return coursereviewid;
	}
	public void setCoursereviewid(String coursereviewid) {
		this.coursereviewid = coursereviewid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String[] getReplyid() {
		return replyid;
	}
	public void setReplyid(String[] replyid) {
		this.replyid = replyid;
	}
	public String[] getLikeids() {
		return likeids;
	}
	public void setLikeids(String[] likeids) {
		this.likeids = likeids;
	}
	public String getReviewtime() {
		return reviewtime;
	}
	public void setReviewtime(String reviewtime) {
		this.reviewtime = reviewtime;
	}
	
	
	
	
	
	
}
