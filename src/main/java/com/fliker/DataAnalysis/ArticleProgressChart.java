package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ArticleProgressChart")
public class ArticleProgressChart {

	@Id
	private String articleid;
	private String article_average_feedback_rate;
	private String article_average_spend_time;
	private String article_location_set;
	private String article_completion_feedback_rate;
	private String article_location_completion_feedback_rate;
	private String article_location_spend_time;
	private String article_location_completion;
	public String getArticleid() {
		return articleid;
	}
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	public String getArticle_average_feedback_rate() {
		return article_average_feedback_rate;
	}
	public void setArticle_average_feedback_rate(String article_average_feedback_rate) {
		this.article_average_feedback_rate = article_average_feedback_rate;
	}
	public String getArticle_average_spend_time() {
		return article_average_spend_time;
	}
	public void setArticle_average_spend_time(String article_average_spend_time) {
		this.article_average_spend_time = article_average_spend_time;
	}
	public String getArticle_location_set() {
		return article_location_set;
	}
	public void setArticle_location_set(String article_location_set) {
		this.article_location_set = article_location_set;
	}
	public String getArticle_completion_feedback_rate() {
		return article_completion_feedback_rate;
	}
	public void setArticle_completion_feedback_rate(String article_completion_feedback_rate) {
		this.article_completion_feedback_rate = article_completion_feedback_rate;
	}
	public String getArticle_location_completion_feedback_rate() {
		return article_location_completion_feedback_rate;
	}
	public void setArticle_location_completion_feedback_rate(String article_location_completion_feedback_rate) {
		this.article_location_completion_feedback_rate = article_location_completion_feedback_rate;
	}
	public String getArticle_location_spend_time() {
		return article_location_spend_time;
	}
	public void setArticle_location_spend_time(String article_location_spend_time) {
		this.article_location_spend_time = article_location_spend_time;
	}
	public String getArticle_location_completion() {
		return article_location_completion;
	}
	public void setArticle_location_completion(String article_location_completion) {
		this.article_location_completion = article_location_completion;
	}
	
	
	
}
