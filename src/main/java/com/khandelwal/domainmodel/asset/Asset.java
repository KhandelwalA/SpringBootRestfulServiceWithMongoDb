package com.khandelwal.domainmodel.asset;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

@SuppressWarnings("serial")
public class Asset implements Serializable {

	@Id
	private String assetNumber;

	private String assetName;

	private String assetType;

	private AssetAddress assetAddress;

	private AssetCredentials assetCredentials;

	private AssetContactInformation[] assetContactInformation;

	private AssetSecurityInformation[] assetSecurityInformation;

	protected Asset() {

	}

	public Asset(String assetNumber, String assetName, String assetType, AssetAddress assetAddress,
			AssetCredentials assetCredentials, AssetContactInformation[] assetContactInformation,
			AssetSecurityInformation[] assetSecurityInformation) {
		super();
		this.assetNumber = assetNumber;
		this.assetName = assetName;
		this.assetType = assetType;
		this.assetAddress = assetAddress;
		this.assetCredentials = assetCredentials;
		this.assetContactInformation = assetContactInformation;
		this.assetSecurityInformation = assetSecurityInformation;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public AssetAddress getAssetAddress() {
		return assetAddress;
	}

	public void setAssetAddress(AssetAddress assetAddress) {
		this.assetAddress = assetAddress;
	}

	public AssetCredentials getAssetCredentials() {
		return assetCredentials;
	}

	public void setAssetCredentials(AssetCredentials assetCredentials) {
		this.assetCredentials = assetCredentials;
	}

	public AssetContactInformation[] getAssetContactInformation() {
		return assetContactInformation;
	}

	public void setAssetContactInformation(AssetContactInformation[] assetContactInformation) {
		this.assetContactInformation = assetContactInformation;
	}

	public AssetSecurityInformation[] getAssetSecurityInformation() {
		return assetSecurityInformation;
	}

	public void setAssetSecurityInformation(AssetSecurityInformation[] assetSecurityInformation) {
		this.assetSecurityInformation = assetSecurityInformation;
	}

}
