package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="QuizProgressChart")
public class QuizProgressChart {

	@Id
	private String quizid;
	private String quiz_average_ending_time;
	private String quiz_average_feedback_rate;
	private String quiz_attempt_number;
	private String quiz_completion;
	private String quiz_average_location_attempt;
	private String quiz_average_location_completion;
	private String quiz_average_location_feedback_rate;
	private String quiz_average_completion_feedback_rate;
	private String quiz_average_location_ending_time;
	private String quiz_videosearchFor;
	private String quiz_location_videosearchFor;
	private String quiz_topicSearchFor;
	private String quiz_location_topicSearchFor;
	private String quiz_generalSearchFor;
	private String quiz_location_generalSearchFor;
	public String getQuizid() {
		return quizid;
	}
	public void setQuizid(String quizid) {
		this.quizid = quizid;
	}
	public String getQuiz_average_ending_time() {
		return quiz_average_ending_time;
	}
	public void setQuiz_average_ending_time(String quiz_average_ending_time) {
		this.quiz_average_ending_time = quiz_average_ending_time;
	}
	public String getQuiz_average_feedback_rate() {
		return quiz_average_feedback_rate;
	}
	public void setQuiz_average_feedback_rate(String quiz_average_feedback_rate) {
		this.quiz_average_feedback_rate = quiz_average_feedback_rate;
	}
	public String getQuiz_attempt_number() {
		return quiz_attempt_number;
	}
	public void setQuiz_attempt_number(String quiz_attempt_number) {
		this.quiz_attempt_number = quiz_attempt_number;
	}
	public String getQuiz_completion() {
		return quiz_completion;
	}
	public void setQuiz_completion(String quiz_completion) {
		this.quiz_completion = quiz_completion;
	}
	public String getQuiz_average_location_attempt() {
		return quiz_average_location_attempt;
	}
	public void setQuiz_average_location_attempt(String quiz_average_location_attempt) {
		this.quiz_average_location_attempt = quiz_average_location_attempt;
	}
	public String getQuiz_average_location_completion() {
		return quiz_average_location_completion;
	}
	public void setQuiz_average_location_completion(String quiz_average_location_completion) {
		this.quiz_average_location_completion = quiz_average_location_completion;
	}
	public String getQuiz_average_location_feedback_rate() {
		return quiz_average_location_feedback_rate;
	}
	public void setQuiz_average_location_feedback_rate(String quiz_average_location_feedback_rate) {
		this.quiz_average_location_feedback_rate = quiz_average_location_feedback_rate;
	}
	public String getQuiz_average_completion_feedback_rate() {
		return quiz_average_completion_feedback_rate;
	}
	public void setQuiz_average_completion_feedback_rate(String quiz_average_completion_feedback_rate) {
		this.quiz_average_completion_feedback_rate = quiz_average_completion_feedback_rate;
	}
	public String getQuiz_average_location_ending_time() {
		return quiz_average_location_ending_time;
	}
	public void setQuiz_average_location_ending_time(String quiz_average_location_ending_time) {
		this.quiz_average_location_ending_time = quiz_average_location_ending_time;
	}
	public String getQuiz_videosearchFor() {
		return quiz_videosearchFor;
	}
	public void setQuiz_videosearchFor(String quiz_videosearchFor) {
		this.quiz_videosearchFor = quiz_videosearchFor;
	}
	public String getQuiz_location_videosearchFor() {
		return quiz_location_videosearchFor;
	}
	public void setQuiz_location_videosearchFor(String quiz_location_videosearchFor) {
		this.quiz_location_videosearchFor = quiz_location_videosearchFor;
	}
	public String getQuiz_topicSearchFor() {
		return quiz_topicSearchFor;
	}
	public void setQuiz_topicSearchFor(String quiz_topicSearchFor) {
		this.quiz_topicSearchFor = quiz_topicSearchFor;
	}
	public String getQuiz_location_topicSearchFor() {
		return quiz_location_topicSearchFor;
	}
	public void setQuiz_location_topicSearchFor(String quiz_location_topicSearchFor) {
		this.quiz_location_topicSearchFor = quiz_location_topicSearchFor;
	}
	public String getQuiz_generalSearchFor() {
		return quiz_generalSearchFor;
	}
	public void setQuiz_generalSearchFor(String quiz_generalSearchFor) {
		this.quiz_generalSearchFor = quiz_generalSearchFor;
	}
	public String getQuiz_location_generalSearchFor() {
		return quiz_location_generalSearchFor;
	}
	public void setQuiz_location_generalSearchFor(String quiz_location_generalSearchFor) {
		this.quiz_location_generalSearchFor = quiz_location_generalSearchFor;
	}
	
	
	
	
}
