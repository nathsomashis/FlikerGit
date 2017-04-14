package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Topic")
public class Topic {

	
	@Id
	private String topicid;
	private String[] postid;
	private String topiccreateduserid;
	private String topiccreatedtime;
	private String topiclocation;
	public String getTopicid() {
		return topicid;
	}
	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}
	public String[] getPostid() {
		return postid;
	}
	public void setPostid(String[] postid) {
		this.postid = postid;
	}
	public String getTopiccreateduserid() {
		return topiccreateduserid;
	}
	public void setTopiccreateduserid(String topiccreateduserid) {
		this.topiccreateduserid = topiccreateduserid;
	}
	public String getTopiccreatedtime() {
		return topiccreatedtime;
	}
	public void setTopiccreatedtime(String topiccreatedtime) {
		this.topiccreatedtime = topiccreatedtime;
	}
	public String getTopiclocation() {
		return topiclocation;
	}
	public void setTopiclocation(String topiclocation) {
		this.topiclocation = topiclocation;
	}
	
	
}
