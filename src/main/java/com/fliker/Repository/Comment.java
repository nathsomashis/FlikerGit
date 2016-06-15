package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Comment")
public class Comment {
	
	@Id
	private String commentid;
	private User commentOwner;
	private StringBuilder comments;
	private boolean reply;
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public User getCommentOwner() {
		return commentOwner;
	}
	public void setCommentOwner(User commentOwner) {
		this.commentOwner = commentOwner;
	}
	public StringBuilder getComments() {
		return comments;
	}
	public void setComments(StringBuilder comments) {
		this.comments = comments;
	}
	public boolean isReply() {
		return reply;
	}
	public void setReply(boolean reply) {
		this.reply = reply;
	}
	

}
