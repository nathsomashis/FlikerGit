package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="StudentContext")
public class StudentContext {

	@Id
	private String studentcontextid;
	private String[] assignmentids;
	private String[] postids;
	private String[] courseids;
	public String getStudentcontextid() {
		return studentcontextid;
	}
	public void setStudentcontextid(String studentcontextid) {
		this.studentcontextid = studentcontextid;
	}
	public String[] getAssignmentids() {
		return assignmentids;
	}
	public void setAssignmentids(String[] assignmentids) {
		this.assignmentids = assignmentids;
	}
	public String[] getPostids() {
		return postids;
	}
	public void setPostids(String[] postids) {
		this.postids = postids;
	}
	public String[] getCourseids() {
		return courseids;
	}
	public void setCourseids(String[] courseids) {
		this.courseids = courseids;
	}
	
	
	
}
