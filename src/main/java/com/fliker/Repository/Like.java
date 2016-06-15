package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Like")
public class Like {

	@Id
	private String likeid;
	private User likeOwner;
	public String getLikeid() {
		return likeid;
	}
	public void setLikeid(String likeid) {
		this.likeid = likeid;
	}
	public User getLikeOwner() {
		return likeOwner;
	}
	public void setLikeOwner(User likeOwner) {
		this.likeOwner = likeOwner;
	}
	
	
	
}
