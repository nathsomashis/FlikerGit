package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Blog")
public class Blog {

	@Id
	private String blogid;
	private String[] topicid;
	private String blogname;
	private String blogactive;
	private String[] blogaccessuserids;
	public String getBlogid() {
		return blogid;
	}
	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}
	public String[] getTopicid() {
		return topicid;
	}
	public void setTopicid(String[] topicid) {
		this.topicid = topicid;
	}
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public String getBlogactive() {
		return blogactive;
	}
	public void setBlogactive(String blogactive) {
		this.blogactive = blogactive;
	}
	public String[] getBlogaccessuserids() {
		return blogaccessuserids;
	}
	public void setBlogaccessuserids(String[] blogaccessuserids) {
		this.blogaccessuserids = blogaccessuserids;
	}
	
	
	
}
