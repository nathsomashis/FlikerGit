package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Content")
public class SearchContent {
	
	@Id
	private String searchid;
	private String searchdocid;
	private String contentDescription;
	private String contentType;
	private String contentLink;
	
	public String getContentDescription() {
		return contentDescription;
	}
	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContentLink() {
		return contentLink;
	}
	public void setContentLink(String contentLink) {
		this.contentLink = contentLink;
	}
	
	public String getSearchid() {
		return searchid;
	}
	public void setSearchid(String searchid) {
		this.searchid = searchid;
	}
	public String getSearchdocid() {
		return searchdocid;
	}
	public void setSearchdocid(String searchdocid) {
		this.searchdocid = searchdocid;
	}
	
	

}
