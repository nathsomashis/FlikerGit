package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Institute")
public class Institute {

	@Id
	private String instituteid;
	private String institutename;
	private String institutedesc;
	private String instituteaddress;
	private String currentstatus;
	private String[] divisionid;
	private String playgroundid;
	private String[] testtemplateid;
	private String scheduletimetable;
	private String[] studentparentportalid;
	private String instituteadmissionprice;
	private String accountid;
	private String[] planinfoid;
	
	
	
	
	public String[] getPlaninfoid() {
		return planinfoid;
	}
	public void setPlaninfoid(String[] planinfoid) {
		this.planinfoid = planinfoid;
	}
	public String getInstituteadmissionprice() {
		return instituteadmissionprice;
	}
	public void setInstituteadmissionprice(String instituteadmissionprice) {
		this.instituteadmissionprice = instituteadmissionprice;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getInstitutedesc() {
		return institutedesc;
	}
	public void setInstitutedesc(String institutedesc) {
		this.institutedesc = institutedesc;
	}
	public String getInstituteid() {
		return instituteid;
	}
	public void setInstituteid(String instituteid) {
		this.instituteid = instituteid;
	}
	public String getInstitutename() {
		return institutename;
	}
	public void setInstitutename(String institutename) {
		this.institutename = institutename;
	}
	public String getInstituteaddress() {
		return instituteaddress;
	}
	public void setInstituteaddress(String instituteaddress) {
		this.instituteaddress = instituteaddress;
	}
	public String getCurrentstatus() {
		return currentstatus;
	}
	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}
	public String[] getDivisionid() {
		return divisionid;
	}
	public void setDivisionid(String[] divisionid) {
		this.divisionid = divisionid;
	}
	public String getPlaygroundid() {
		return playgroundid;
	}
	public void setPlaygroundid(String playgroundid) {
		this.playgroundid = playgroundid;
	}
	public String[] getTesttemplateid() {
		return testtemplateid;
	}
	public void setTesttemplateid(String[] testtemplateid) {
		this.testtemplateid = testtemplateid;
	}
	public String getScheduletimetable() {
		return scheduletimetable;
	}
	public void setScheduletimetable(String scheduletimetable) {
		this.scheduletimetable = scheduletimetable;
	}
	public String[] getStudentparentportalid() {
		return studentparentportalid;
	}
	public void setStudentparentportalid(String[] studentparentportalid) {
		this.studentparentportalid = studentparentportalid;
	}
	
	
	
	
}
