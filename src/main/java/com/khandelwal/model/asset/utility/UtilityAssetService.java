package com.khandelwal.model.asset.utility;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khandelwal.domainmodel.asset.utility.QUtilityAsset;
import com.khandelwal.domainmodel.asset.utility.UtilityAsset;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class UtilityAssetService {

	private UtilityAssetRepository utilityAssetRepository;

	@Autowired
	public UtilityAssetService(UtilityAssetRepository utilityAssetRepository) {
		super();
		this.utilityAssetRepository = utilityAssetRepository;
	}

	/**
	 * This method adds Utility Asset in db
	 * 
	 * @param UtilityAsset
	 */
	public void addUtilityAsset(UtilityAsset utilityAsset) {

		utilityAssetRepository.save(utilityAsset);
	}

	/**
	 * This method returns all the UtilityAsset records
	 * 
	 * @return
	 */
	public Collection<UtilityAsset> getAllUtilityAsset() {

		Collection<UtilityAsset> UtilityAssetCollection = new ArrayList<UtilityAsset>();

		for (UtilityAsset UtilityAsset : utilityAssetRepository.findAll()) {
			UtilityAssetCollection.add(UtilityAsset);
		}

		return UtilityAssetCollection;
	}

	/**
	 * This method returns the UtilityAsset record matched by Id
	 * 
	 * @return
	 */
	public UtilityAsset getUtilityAssetByNumber(String assetNumber) {

		return utilityAssetRepository.findOne(assetNumber);

	}

	/**
	 * This method returns the UtilityAsset record matched by AssetName
	 * 
	 * @return
	 */
	public Collection<UtilityAsset> getUtilityAssetByName(String assetName) {

		return utilityAssetRepository.findByAssetName(assetName);

	}

	/**
	 * This method returns the UtilityAsset record matched by AssetType
	 * 
	 * @return
	 */
	public Collection<UtilityAsset> getUtilityAssetByType(String assetType) {

		return utilityAssetRepository.findByAssetType(assetType);

	}

	/**
	 * This method delete the UtilityAsset record matched by Id
	 * 
	 * @return
	 */
	public void deleteUtilityAsset(String assetNumber) {

		utilityAssetRepository.delete(assetNumber);

	}

	/**
	 * This method find the InvestmentAsset record matched by asset name & type
	 * 
	 * @param assetName
	 * @param assetType
	 * @return
	 */
	public Collection<UtilityAsset> getUtilityAssetByNameAndType(
			String assetName, String assetType) {

		return utilityAssetRepository.findByAssetNameAndType(assetName,
				assetType);

	}

	/**
	 * This method uses 'querydsl-mongodb' jar for complex queries
	 * 
	 * @param assetNumber
	 * @param meterNumber
	 */
	@SuppressWarnings("unchecked")
	public void deleteByAssetNumberOrMeterNumber(String assetNumber,
			String meterNumber) {

		QUtilityAsset utilityAsset = new QUtilityAsset("utilityAsset");

		/* Creating filter expressions */
		BooleanExpression filterByAssetNumber = utilityAsset.assetNumber
				.equalsIgnoreCase(assetNumber);
		BooleanExpression filterByMeterNumber = utilityAsset.meterNumber
				.equalsIgnoreCase(meterNumber);

		utilityAssetRepository
				.delete((Iterable<? extends UtilityAsset>) filterByAssetNumber
						.or(filterByMeterNumber));
	}
}
