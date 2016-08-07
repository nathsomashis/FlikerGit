package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SearchContent")
public class SearchContent {
	
	@Id
	private String searchid;
	private String searchdocid;
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
