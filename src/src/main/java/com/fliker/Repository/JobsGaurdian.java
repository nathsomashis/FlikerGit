package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="JobsGaurdian")
public class JobsGaurdian {

	private String jobguardid;
	private String jobguardianprofileid;
	private String[] studentContextid;
	
	
	
	public String getJobguardid() {
		return jobguardid;
	}
	public void setJobguardid(String jobguardid) {
		this.jobguardid = jobguardid;
	}
	public String getJobguardianprofileid() {
		return jobguardianprofileid;
	}
	public void setJobguardianprofileid(String jobguardianprofileid) {
		this.jobguardianprofileid = jobguardianprofileid;
	}
	public String[] getStudentContextid() {
		return studentContextid;
	}
	public void setStudentContextid(String[] studentContextid) {
		this.studentContextid = studentContextid;
	}
	
	
	
}
