package com.khandelwal.domainmodel.asset;

import java.io.Serializable;

@SuppressWarnings(value = "serial")
public class AssetSecurityInformation implements Serializable {

	private String securityQuestion;

	private String securityAnswer;

	protected AssetSecurityInformation() {

	}

	public AssetSecurityInformation(String securityQuestion, String securityAnswer) {
		super();
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

}
