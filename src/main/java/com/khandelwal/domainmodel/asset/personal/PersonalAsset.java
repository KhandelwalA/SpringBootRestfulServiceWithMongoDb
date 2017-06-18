package com.khandelwal.domainmodel.asset.personal;

import org.springframework.data.mongodb.core.mapping.Document;

import com.khandelwal.domainmodel.asset.Asset;

@SuppressWarnings("serial")
@Document(collection = "PersonalAsset")
public class PersonalAsset extends Asset {

	private String miscellaneousInfo;

	protected PersonalAsset() {

	}

	public PersonalAsset(String miscellaneousInfo) {
		super();

		this.miscellaneousInfo = miscellaneousInfo;

	}

	public String getMiscellaneousInfo() {
		return miscellaneousInfo;
	}

	public void setMiscellaneousInfo(String miscellaneousInfo) {
		this.miscellaneousInfo = miscellaneousInfo;
	}

}
