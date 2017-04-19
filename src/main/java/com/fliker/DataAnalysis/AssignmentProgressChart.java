package com.fliker.DataAnalysis;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AssignmentProgressChart")
public class AssignmentProgressChart {

	@Id
	private String assignmentid;
	private String assignment_average_ending_time;
	private String assignment_average_feedback_rate;
	private String assignment_attempt_number;
	private String assignment_completion;
	private String assignment_average_location_attempt;
	private String assignment_average_location_completion;
	private String assignment_average_location_feedback_rate;
	private String assignment_average_completion_feedback_rate;
	private String assignment_average_location_ending_time;
	private String assignment_videosearchFor;
	private String assignment_location_videosearchFor;
	private String assignment_topicSearchFor;
	private String assignment_location_topicSearchFor;
	private String assignment_generalSearchFor;
	private String assignment_location_generalSearchFor;
	public String getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String getAssignment_average_ending_time() {
		return assignment_average_ending_time;
	}
	public void setAssignment_average_ending_time(String assignment_average_ending_time) {
		this.assignment_average_ending_time = assignment_average_ending_time;
	}
	public String getAssignment_average_feedback_rate() {
		return assignment_average_feedback_rate;
	}
	public void setAssignment_average_feedback_rate(String assignment_average_feedback_rate) {
		this.assignment_average_feedback_rate = assignment_average_feedback_rate;
	}
	public String getAssignment_attempt_number() {
		return assignment_attempt_number;
	}
	public void setAssignment_attempt_number(String assignment_attempt_number) {
		this.assignment_attempt_number = assignment_attempt_number;
	}
	public String getAssignment_completion() {
		return assignment_completion;
	}
	public void setAssignment_completion(String assignment_completion) {
		this.assignment_completion = assignment_completion;
	}
	public String getAssignment_average_location_attempt() {
		return assignment_average_location_attempt;
	}
	public void setAssignment_average_location_attempt(String assignment_average_location_attempt) {
		this.assignment_average_location_attempt = assignment_average_location_attempt;
	}
	public String getAssignment_average_location_completion() {
		return assignment_average_location_completion;
	}
	public void setAssignment_average_location_completion(String assignment_average_location_completion) {
		this.assignment_average_location_completion = assignment_average_location_completion;
	}
	public String getAssignment_average_location_feedback_rate() {
		return assignment_average_location_feedback_rate;
	}
	public void setAssignment_average_location_feedback_rate(String assignment_average_location_feedback_rate) {
		this.assignment_average_location_feedback_rate = assignment_average_location_feedback_rate;
	}
	public String getAssignment_average_completion_feedback_rate() {
		return assignment_average_completion_feedback_rate;
	}
	public void setAssignment_average_completion_feedback_rate(String assignment_average_completion_feedback_rate) {
		this.assignment_average_completion_feedback_rate = assignment_average_completion_feedback_rate;
	}
	public String getAssignment_average_location_ending_time() {
		return assignment_average_location_ending_time;
	}
	public void setAssignment_average_location_ending_time(String assignment_average_location_ending_time) {
		this.assignment_average_location_ending_time = assignment_average_location_ending_time;
	}
	public String getAssignment_videosearchFor() {
		return assignment_videosearchFor;
	}
	public void setAssignment_videosearchFor(String assignment_videosearchFor) {
		this.assignment_videosearchFor = assignment_videosearchFor;
	}
	public String getAssignment_location_videosearchFor() {
		return assignment_location_videosearchFor;
	}
	public void setAssignment_location_videosearchFor(String assignment_location_videosearchFor) {
		this.assignment_location_videosearchFor = assignment_location_videosearchFor;
	}
	public String getAssignment_topicSearchFor() {
		return assignment_topicSearchFor;
	}
	public void setAssignment_topicSearchFor(String assignment_topicSearchFor) {
		this.assignment_topicSearchFor = assignment_topicSearchFor;
	}
	public String getAssignment_location_topicSearchFor() {
		return assignment_location_topicSearchFor;
	}
	public void setAssignment_location_topicSearchFor(String assignment_location_topicSearchFor) {
		this.assignment_location_topicSearchFor = assignment_location_topicSearchFor;
	}
	public String getAssignment_generalSearchFor() {
		return assignment_generalSearchFor;
	}
	public void setAssignment_generalSearchFor(String assignment_generalSearchFor) {
		this.assignment_generalSearchFor = assignment_generalSearchFor;
	}
	public String getAssignment_location_generalSearchFor() {
		return assignment_location_generalSearchFor;
	}
	public void setAssignment_location_generalSearchFor(String assignment_location_generalSearchFor) {
		this.assignment_location_generalSearchFor = assignment_location_generalSearchFor;
	}
	
	
	
	
}
