package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Articles")
public class Articles {

	private String articleid;
	private String articledescription;
	public String getArticleid() {
		return articleid;
	}
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	public String getArticledescription() {
		return articledescription;
	}
	public void setArticledescription(String articledescription) {
		this.articledescription = articledescription;
	}
	
	public Articles(){
		
	}
	
	public Articles(String articleid, String articledesc){
		
		this.articledescription= articledesc;
		this.articleid = articleid;
	}
	
	
}
