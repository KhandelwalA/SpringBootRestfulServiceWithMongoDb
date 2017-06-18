package com.khandelwal.domainmodel.asset;

import java.io.Serializable;

@SuppressWarnings(value = { "serial" })

public class AssetCredentials implements Serializable {

	private String loginId;

	private String password;

	private String phonePassword;

	public AssetCredentials() {

	}

	public AssetCredentials(String loginId, String password, String phonePassword) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.phonePassword = phonePassword;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonePassword() {
		return phonePassword;
	}

	public void setPhonePassword(String phonePassword) {
		this.phonePassword = phonePassword;
	}

}
