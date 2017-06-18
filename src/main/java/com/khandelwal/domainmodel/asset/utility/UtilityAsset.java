package com.khandelwal.domainmodel.asset.utility;

import org.springframework.data.mongodb.core.mapping.Document;

import com.khandelwal.domainmodel.asset.Asset;

@SuppressWarnings(value = "serial")
@Document(collection = "UtilityAsset")
public class UtilityAsset extends Asset {

	private String areaReference;

	private String zoneCode;

	private String mrNumber;

	private String meterNumber;

	private String wcNumber;

	private String licenseNumber;

	protected UtilityAsset() {

	}

	public UtilityAsset(String areaReference, String zoneCode, String mrNumber, String meterNumber, String wcNumber,
			String licenseNumber) {
		super();

		this.areaReference = areaReference;
		this.zoneCode = zoneCode;
		this.mrNumber = mrNumber;
		this.meterNumber = meterNumber;
		this.wcNumber = wcNumber;
		this.licenseNumber = licenseNumber;
	}

	public String getAreaReference() {
		return areaReference;
	}

	public void setAreaReference(String areaReference) {
		this.areaReference = areaReference;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getMrNumber() {
		return mrNumber;
	}

	public void setMrNumber(String mrNumber) {
		this.mrNumber = mrNumber;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public String getWcNumber() {
		return wcNumber;
	}

	public void setWcNumber(String wcNumber) {
		this.wcNumber = wcNumber;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

}
