package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Publish")
public class Publish {

	@Id
	private String publishid;
	private String publishsenderuserid;
	private String publishrecieveruserid;
	private String publishtype;
	private String publishdescription;
	private String publishacknowledgement;
	public String getPublishid() {
		return publishid;
	}
	public void setPublishid(String publishid) {
		this.publishid = publishid;
	}
	public String getPublishsenderuserid() {
		return publishsenderuserid;
	}
	public void setPublishsenderuserid(String publishsenderuserid) {
		this.publishsenderuserid = publishsenderuserid;
	}
	public String getPublishrecieveruserid() {
		return publishrecieveruserid;
	}
	public void setPublishrecieveruserid(String publishrecieveruserid) {
		this.publishrecieveruserid = publishrecieveruserid;
	}
	public String getPublishtype() {
		return publishtype;
	}
	public void setPublishtype(String publishtype) {
		this.publishtype = publishtype;
	}
	public String getPublishdescription() {
		return publishdescription;
	}
	public void setPublishdescription(String publishdescription) {
		this.publishdescription = publishdescription;
	}
	public String getPublishacknowledgement() {
		return publishacknowledgement;
	}
	public void setPublishacknowledgement(String publishacknowledgement) {
		this.publishacknowledgement = publishacknowledgement;
	}
	
	
	
	
}
