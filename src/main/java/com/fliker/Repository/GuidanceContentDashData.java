package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentDashData")
public class GuidanceContentDashData {

	@Id
	private String guidancedashdataid;
	private String guidancedashlevelremark;
	private String guidancedashhelpremark;
	private String guidancespecificationOne;
	private String guidancedashspeconeremark;
	private String guidancespecificationTwo;
	private String guidancedashspectworemark;
	private String guidancespecificationThree;
	private String guidancedashspecthreeremark;
	private String guidancespecificationFour;
	private String guidancedashspecfourremark;
	private String guidancespecificationFive;
	private String guidancedashspecfiveremark;
	private String guidancespecchange;
	
	
	public String getGuidancespecificationOne() {
		return guidancespecificationOne;
	}
	public void setGuidancespecificationOne(String guidancespecificationOne) {
		this.guidancespecificationOne = guidancespecificationOne;
	}
	public String getGuidancespecificationTwo() {
		return guidancespecificationTwo;
	}
	public void setGuidancespecificationTwo(String guidancespecificationTwo) {
		this.guidancespecificationTwo = guidancespecificationTwo;
	}
	public String getGuidancespecificationThree() {
		return guidancespecificationThree;
	}
	public void setGuidancespecificationThree(String guidancespecificationThree) {
		this.guidancespecificationThree = guidancespecificationThree;
	}
	public String getGuidancespecificationFour() {
		return guidancespecificationFour;
	}
	public void setGuidancespecificationFour(String guidancespecificationFour) {
		this.guidancespecificationFour = guidancespecificationFour;
	}
	public String getGuidancespecificationFive() {
		return guidancespecificationFive;
	}
	public void setGuidancespecificationFive(String guidancespecificationFive) {
		this.guidancespecificationFive = guidancespecificationFive;
	}
	public String getGuidancespecchange() {
		return guidancespecchange;
	}
	public void setGuidancespecchange(String guidancespecchange) {
		this.guidancespecchange = guidancespecchange;
	}
	public String getGuidancedashdataid() {
		return guidancedashdataid;
	}
	public void setGuidancedashdataid(String guidancedashdataid) {
		this.guidancedashdataid = guidancedashdataid;
	}
	public String getGuidancedashlevelremark() {
		return guidancedashlevelremark;
	}
	public void setGuidancedashlevelremark(String guidancedashlevelremark) {
		this.guidancedashlevelremark = guidancedashlevelremark;
	}
	public String getGuidancedashhelpremark() {
		return guidancedashhelpremark;
	}
	public void setGuidancedashhelpremark(String guidancedashhelpremark) {
		this.guidancedashhelpremark = guidancedashhelpremark;
	}
	public String getGuidancedashspeconeremark() {
		return guidancedashspeconeremark;
	}
	public void setGuidancedashspeconeremark(String guidancedashspeconeremark) {
		this.guidancedashspeconeremark = guidancedashspeconeremark;
	}
	public String getGuidancedashspectworemark() {
		return guidancedashspectworemark;
	}
	public void setGuidancedashspectworemark(String guidancedashspectworemark) {
		this.guidancedashspectworemark = guidancedashspectworemark;
	}
	public String getGuidancedashspecthreeremark() {
		return guidancedashspecthreeremark;
	}
	public void setGuidancedashspecthreeremark(String guidancedashspecthreeremark) {
		this.guidancedashspecthreeremark = guidancedashspecthreeremark;
	}
	public String getGuidancedashspecfourremark() {
		return guidancedashspecfourremark;
	}
	public void setGuidancedashspecfourremark(String guidancedashspecfourremark) {
		this.guidancedashspecfourremark = guidancedashspecfourremark;
	}
	public String getGuidancedashspecfiveremark() {
		return guidancedashspecfiveremark;
	}
	public void setGuidancedashspecfiveremark(String guidancedashspecfiveremark) {
		this.guidancedashspecfiveremark = guidancedashspecfiveremark;
	}
	
	
	
}
