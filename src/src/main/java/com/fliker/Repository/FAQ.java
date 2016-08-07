package com.fliker.Repository;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="FAQ")
public class FAQ {

	@Id
	private String faqid;
	private HashMap questionanswers;
	public String getFaqid() {
		return faqid;
	}
	public void setFaqid(String faqid) {
		this.faqid = faqid;
	}
	public HashMap getQuestionanswers() {
		return questionanswers;
	}
	public void setQuestionanswers(HashMap questionanswers) {
		this.questionanswers = questionanswers;
	}
	
	
	
	
}
