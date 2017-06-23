package com.fliker.Repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AccountDetail")
public class AccountDetail {

	@Id
	private String accountid;
	private String accountsandboxid;
	private String accounttype;
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getAccountsandboxid() {
		return accountsandboxid;
	}
	public void setAccountsandboxid(String accountsandboxid) {
		this.accountsandboxid = accountsandboxid;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	
	
	
}
