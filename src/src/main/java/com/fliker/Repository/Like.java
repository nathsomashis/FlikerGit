package com.fliker.Repository;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Like")
public class Like {

	@Id
	private String likeid;
	private String likeOwner;
	private String liketime;
	
	public String getLikeid() {
		return likeid;
	}
	public void setLikeid(String likeid) {
		this.likeid = likeid;
	}
	public String getLikeOwner() {
		return likeOwner;
	}
	public void setLikeOwner(String likeOwner) {
		this.likeOwner = likeOwner;
	}
	public String getLiketime() {
		return liketime;
	}
	public void setLiketime(String liketime) {
		this.liketime = liketime;
	}
	
	
	
	
}
