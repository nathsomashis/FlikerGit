package com.fliker.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SearchResult")
public class SearchResult {

	@Id
	private String searchresultid;
	private ArrayList searchContentid;
	public String getSearchresultid() {
		return searchresultid;
	}
	public void setSearchresultid(String searchresultid) {
		this.searchresultid = searchresultid;
	}
	public ArrayList getSearchContentid() {
		return searchContentid;
	}
	public void setSearchContentid(ArrayList searchContentid) {
		this.searchContentid = searchContentid;
	}
	
	
	
	
	
}
