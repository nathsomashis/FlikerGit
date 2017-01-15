package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SearchHistory")
public class SearchHistory {

	@Id
	private String searchid;
	private String searchresultid;
	public String getSearchid() {
		return searchid;
	}
	public void setSearchid(String searchid) {
		this.searchid = searchid;
	}
	public String getSearchresultid() {
		return searchresultid;
	}
	public void setSearchresultid(String searchresultid) {
		this.searchresultid = searchresultid;
	}
	
	
	
}
