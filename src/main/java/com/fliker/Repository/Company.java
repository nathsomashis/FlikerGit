package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Company")
public class Company {

	@Id
	private String companyid;
	private String companyname;
	private String companyImageid;
	private String companylogoid;
	private String companyWebsite;
	private String companyEmployeeNumber;
	private String companyType;
	private String companyRevenue;
	private String companyHeadQuarters;
	private String companyfounded;
	private String[] companypostid;
	private String aboutvideoid;
	private String AboutUs;
	private String ourpeoplevideoid;
	private String ourPeopleComment;
	private String communityvideoid;
	private String[] Communityids;
	private String differencefileid;

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	private String differemnce;
	private String companyIndustry;
	private String[] companyCompetitors;
	private String companyDescription;
	private String[] companyReviewids;

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyHeadQuarters() {
		return companyHeadQuarters;
	}

	public void setCompanyHeadQuarters(String companyHeadQuarters) {
		this.companyHeadQuarters = companyHeadQuarters;
	}

	public String getCompanyIndustry() {
		return companyIndustry;
	}

	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}

	public String[] getCompanyCompetitors() {
		return companyCompetitors;
	}

	public void setCompanyCompetitors(String[] companyCompetitors) {
		this.companyCompetitors = companyCompetitors;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getCompanyImageid() {
		return companyImageid;
	}

	public void setCompanyImageid(String companyImageid) {
		this.companyImageid = companyImageid;
	}

	public String getCompanylogoid() {
		return companylogoid;
	}

	public void setCompanylogoid(String companylogoid) {
		this.companylogoid = companylogoid;
	}

	public String getCompanyEmployeeNumber() {
		return companyEmployeeNumber;
	}

	public void setCompanyEmployeeNumber(String companyEmployeeNumber) {
		this.companyEmployeeNumber = companyEmployeeNumber;
	}

	public String getCompanyRevenue() {
		return companyRevenue;
	}

	public void setCompanyRevenue(String companyRevenue) {
		this.companyRevenue = companyRevenue;
	}

	public String getCompanyfounded() {
		return companyfounded;
	}

	public void setCompanyfounded(String companyfounded) {
		this.companyfounded = companyfounded;
	}

	public String[] getCompanypostid() {
		return companypostid;
	}

	public void setCompanypostid(String[] companypostid) {
		this.companypostid = companypostid;
	}

	public String getAboutvideoid() {
		return aboutvideoid;
	}

	public void setAboutvideoid(String aboutvideoid) {
		this.aboutvideoid = aboutvideoid;
	}

	public String getAboutUs() {
		return AboutUs;
	}

	public void setAboutUs(String aboutUs) {
		AboutUs = aboutUs;
	}

	public String getOurpeoplevideoid() {
		return ourpeoplevideoid;
	}

	public void setOurpeoplevideoid(String ourpeoplevideoid) {
		this.ourpeoplevideoid = ourpeoplevideoid;
	}

	public String getOurPeopleComment() {
		return ourPeopleComment;
	}

	public void setOurPeopleComment(String ourPeopleComment) {
		this.ourPeopleComment = ourPeopleComment;
	}

	public String getCommunityvideoid() {
		return communityvideoid;
	}

	public void setCommunityvideoid(String communityvideoid) {
		this.communityvideoid = communityvideoid;
	}

	public String[] getCommunityids() {
		return Communityids;
	}

	public void setCommunityids(String[] communityids) {
		Communityids = communityids;
	}

	public String getDifferencefileid() {
		return differencefileid;
	}

	public void setDifferencefileid(String differencefileid) {
		this.differencefileid = differencefileid;
	}

	public String getDifferemnce() {
		return differemnce;
	}

	public void setDifferemnce(String differemnce) {
		this.differemnce = differemnce;
	}

	public String[] getCompanyReviewids() {
		return companyReviewids;
	}

	public void setCompanyReviewids(String[] companyReviewids) {
		this.companyReviewids = companyReviewids;
	}

}
