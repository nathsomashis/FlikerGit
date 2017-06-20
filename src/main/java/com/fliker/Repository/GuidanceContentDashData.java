package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GuidanceContentDashData")
public class GuidanceContentDashData {

	@Id
	private String guidancedashdataid;
	private String guidancedashlevelremark;
	private String guidancedashhelpremark;
	private String guidancedashspeconeremark;
	private String guidancedashspectworemark;
	private String guidancedashspecthreeremark;
	private String guidancedashspecfourremark;
	private String guidancedashspecfiveremark;
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
