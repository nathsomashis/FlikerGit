package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Like")
public class Like {

	@Id
	private String likeid;
	private String likeOwnerid;
	public String getLikeid() {
		return likeid;
	}
	public void setLikeid(String likeid) {
		this.likeid = likeid;
	}
	public String getLikeOwnerid() {
		return likeOwnerid;
	}
	public void setLikeOwnerid(String likeOwnerid) {
		this.likeOwnerid = likeOwnerid;
	}
	
	
	
	
}
