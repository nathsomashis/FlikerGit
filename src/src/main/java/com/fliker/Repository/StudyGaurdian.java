package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="StudyGaurdian")
public class StudyGaurdian {

	@Id
	private String studyguardid;
	private String studyguardianprofileid;
	private String[] studentContextid;
	public String getStudyguardid() {
		return studyguardid;
	}
	public void setStudyguardid(String studyguardid) {
		this.studyguardid = studyguardid;
	}
	public String getStudyguardianprofileid() {
		return studyguardianprofileid;
	}
	public void setStudyguardianprofileid(String studyguardianprofileid) {
		this.studyguardianprofileid = studyguardianprofileid;
	}
	public String[] getStudentContextid() {
		return studentContextid;
	}
	public void setStudentContextid(String[] studentContextid) {
		this.studentContextid = studentContextid;
	}
	
	
	
}
