package com.khandelwal.domainmodel.asset;

import java.io.Serializable;

@SuppressWarnings(value = "serial")

public class AssetContactInformation implements Serializable {

	private String type;

	private String number;

	protected AssetContactInformation() {

	}

	public AssetContactInformation(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
