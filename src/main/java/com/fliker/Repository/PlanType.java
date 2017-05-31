package com.fliker.Repository;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Plan")
public class PlanType {

	private String planid;
	private String planname;
	private String planamount;
	private String planduration;
	private String planexpirydate;
	private String planpermonth;
	private String planperyear;
	private String planperday;
	public String getPlanid() {
		return planid;
	}
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getPlanamount() {
		return planamount;
	}
	public void setPlanamount(String planamount) {
		this.planamount = planamount;
	}
	public String getPlanduration() {
		return planduration;
	}
	public void setPlanduration(String planduration) {
		this.planduration = planduration;
	}
	public String getPlanexpirydate() {
		return planexpirydate;
	}
	public void setPlanexpirydate(String planexpirydate) {
		this.planexpirydate = planexpirydate;
	}
	public String getPlanpermonth() {
		return planpermonth;
	}
	public void setPlanpermonth(String planpermonth) {
		this.planpermonth = planpermonth;
	}
	public String getPlanperyear() {
		return planperyear;
	}
	public void setPlanperyear(String planperyear) {
		this.planperyear = planperyear;
	}
	public String getPlanperday() {
		return planperday;
	}
	public void setPlanperday(String planperday) {
		this.planperday = planperday;
	}
	
	
	
	
}
