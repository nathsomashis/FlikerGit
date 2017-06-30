package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="EschoolClassData")
public class ESchoolClassData {

	@Id
	private String eclasdataid;
	private String eclasssessionid;
	private String eschoolsessionstarttime;
	private String eschoolsessionendtime;
	private String processedfileid;
	private String[] attendeesuser;
	
	
	
	public String[] getAttendeesuser() {
		return attendeesuser;
	}
	public void setAttendeesuser(String[] attendeesuser) {
		this.attendeesuser = attendeesuser;
	}
	public String getEclasdataid() {
		return eclasdataid;
	}
	public void setEclasdataid(String eclasdataid) {
		this.eclasdataid = eclasdataid;
	}
	public String getEclasssessionid() {
		return eclasssessionid;
	}
	public void setEclasssessionid(String eclasssessionid) {
		this.eclasssessionid = eclasssessionid;
	}
	public String getEschoolsessionstarttime() {
		return eschoolsessionstarttime;
	}
	public void setEschoolsessionstarttime(String eschoolsessionstarttime) {
		this.eschoolsessionstarttime = eschoolsessionstarttime;
	}
	public String getEschoolsessionendtime() {
		return eschoolsessionendtime;
	}
	public void setEschoolsessionendtime(String eschoolsessionendtime) {
		this.eschoolsessionendtime = eschoolsessionendtime;
	}
	public String getProcessedfileid() {
		return processedfileid;
	}
	public void setProcessedfileid(String processedfileid) {
		this.processedfileid = processedfileid;
	}
	
	
	
	
}
