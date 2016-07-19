package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Reply")
public class Reply {

	@Id
	private String replyid;
	private String replycomment;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String[] likeid;
	private String replyownerid;
	public String getReplyid() {
		return replyid;
	}
	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}
	public String getReplycomment() {
		return replycomment;
	}
	public void setReplycomment(String replycomment) {
		this.replycomment = replycomment;
	}
	public String[] getLikeid() {
		return likeid;
	}
	public void setLikeid(String[] likeid) {
		this.likeid = likeid;
	}
	public String getReplyownerid() {
		return replyownerid;
	}
	public void setReplyownerid(String replyownerid) {
		this.replyownerid = replyownerid;
	}
	
	
}
