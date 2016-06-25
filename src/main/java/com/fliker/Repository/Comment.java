package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Comment")
public class Comment {
	
	@Id
	private String commentid;
	private String commentOwnerid;
	private String comments;
	private String[] replyids;
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getCommentOwnerid() {
		return commentOwnerid;
	}
	public void setCommentOwnerid(String commentOwnerid) {
		this.commentOwnerid = commentOwnerid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String[] getReplyids() {
		return replyids;
	}
	public void setReplyids(String[] replyids) {
		this.replyids = replyids;
	}
	
	
	
	

}
