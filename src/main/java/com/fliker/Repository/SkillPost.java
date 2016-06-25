package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SkillPost")
public class SkillPost {

	@Id
	private String skillpostid;
	private String[] skillsharedids;
	private String[] likeids;
	private String[] commentids;
	public String getSkillpostid() {
		return skillpostid;
	}
	public void setSkillpostid(String skillpostid) {
		this.skillpostid = skillpostid;
	}
	public String[] getSkillsharedids() {
		return skillsharedids;
	}
	public void setSkillsharedids(String[] skillsharedids) {
		this.skillsharedids = skillsharedids;
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
