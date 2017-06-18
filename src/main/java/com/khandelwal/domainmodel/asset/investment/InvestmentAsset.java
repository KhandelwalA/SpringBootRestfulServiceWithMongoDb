package com.khandelwal.domainmodel.asset.investment;

import org.springframework.data.mongodb.core.mapping.Document;

import com.khandelwal.domainmodel.asset.Asset;

@SuppressWarnings("serial")
@Document(collection = "InvestmentAsset")
public class InvestmentAsset extends Asset {

	private String ifscCode;

	private String sortCode;

	private String uidNumber;

	private String dpNumber;

	private String repositoryId;

	private String clientId;

	protected InvestmentAsset() {

	}

	public InvestmentAsset(String ifscCode, String sortCode, String uidNumber, String dpNumber, String repositoryId,
			String clientId) {
		super();

		this.ifscCode = ifscCode;
		this.sortCode = sortCode;
		this.uidNumber = uidNumber;
		this.dpNumber = dpNumber;
		this.repositoryId = repositoryId;
		this.clientId = clientId;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public String getUidNumber() {
		return uidNumber;
	}

	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}

	public String getDpNumber() {
		return dpNumber;
	}

	public void setDpNumber(String dpNumber) {
		this.dpNumber = dpNumber;
	}

	public String getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(String repositoryId) {
		this.repositoryId = repositoryId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}
