package com.fliker.Repository;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CompanyReview")
public class CompanyReview {

	@Id
	private String reviewid;
	public String getReviewid() {
		return reviewid;
	}
	public void setReviewid(String reviewid) {
		this.reviewid = reviewid;
	}
	private String enteredTime;
	
	private String reviewTopic;
	private String reviewmark;
	private String reviewpros;
	private String reviewcons;
	private String reviewRecommends;
	private String positiveOutlook;
	private String ceoapproves;
	public String getReviewTopic() {
		return reviewTopic;
	}
	public void setReviewTopic(String reviewTopic) {
		this.reviewTopic = reviewTopic;
	}
	
	public String getReviewpros() {
		return reviewpros;
	}
	public void setReviewpros(String reviewpros) {
		this.reviewpros = reviewpros;
	}
	public String getReviewcons() {
		return reviewcons;
	}
	public void setReviewcons(String reviewcons) {
		this.reviewcons = reviewcons;
	}
	public String getReviewRecommends() {
		return reviewRecommends;
	}
	public void setReviewRecommends(String reviewRecommends) {
		this.reviewRecommends = reviewRecommends;
	}
	public String getPositiveOutlook() {
		return positiveOutlook;
	}
	public void setPositiveOutlook(String positiveOutlook) {
		this.positiveOutlook = positiveOutlook;
	}
	public String getCeoapproves() {
		return ceoapproves;
	}
	public void setCeoapproves(String ceoapproves) {
		this.ceoapproves = ceoapproves;
	}
	public String getEnteredTime() {
		return enteredTime;
	}
	public void setEnteredTime(String enteredTime) {
		this.enteredTime = enteredTime;
	}
	public String getReviewmark() {
		return reviewmark;
	}
	public void setReviewmark(String reviewmark) {
		this.reviewmark = reviewmark;
	}
	
	
	
}
