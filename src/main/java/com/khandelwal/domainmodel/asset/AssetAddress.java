package com.khandelwal.domainmodel.asset;

import com.querydsl.core.annotations.QueryInit;

public class AssetAddress {

	@QueryInit(value = "asset.assetAddress.physicalAddress")
	private String[] physicalAddress;

	private String websiteURL;

	protected AssetAddress() {

	}

	public AssetAddress(String[] physicalAddress, String websiteURL) {
		super();
		this.physicalAddress = physicalAddress;
		this.websiteURL = websiteURL;
	}

	public String[] getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String[] physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getWebsiteURL() {
		return websiteURL;
	}

	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
	}

}
