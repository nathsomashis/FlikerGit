package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ArticleAnalysis")
public class ArticleAnalysis {

	@Id
	private String articleid;
	private String articlefeedbackrate;
	private String articlecompleted;
	private String articlestarttime;
	private String articleendtime;
	private String articleshared;
	private String articleliked;
	private String articleendorsed;
	private String articlerepeat;
	private String articlelocationset;
	public String getArticleid() {
		return articleid;
	}
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	public String getArticlefeedbackrate() {
		return articlefeedbackrate;
	}
	public void setArticlefeedbackrate(String articlefeedbackrate) {
		this.articlefeedbackrate = articlefeedbackrate;
	}
	public String getArticlecompleted() {
		return articlecompleted;
	}
	public void setArticlecompleted(String articlecompleted) {
		this.articlecompleted = articlecompleted;
	}
	public String getArticlestarttime() {
		return articlestarttime;
	}
	public void setArticlestarttime(String articlestarttime) {
		this.articlestarttime = articlestarttime;
	}
	public String getArticleendtime() {
		return articleendtime;
	}
	public void setArticleendtime(String articleendtime) {
		this.articleendtime = articleendtime;
	}
	public String getArticleshared() {
		return articleshared;
	}
	public void setArticleshared(String articleshared) {
		this.articleshared = articleshared;
	}
	public String getArticleliked() {
		return articleliked;
	}
	public void setArticleliked(String articleliked) {
		this.articleliked = articleliked;
	}
	public String getArticleendorsed() {
		return articleendorsed;
	}
	public void setArticleendorsed(String articleendorsed) {
		this.articleendorsed = articleendorsed;
	}
	public String getArticlerepeat() {
		return articlerepeat;
	}
	public void setArticlerepeat(String articlerepeat) {
		this.articlerepeat = articlerepeat;
	}
	public String getArticlelocationset() {
		return articlelocationset;
	}
	public void setArticlelocationset(String articlelocationset) {
		this.articlelocationset = articlelocationset;
	}
	
	
	
}
