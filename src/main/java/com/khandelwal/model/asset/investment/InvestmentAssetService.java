package com.khandelwal.model.asset.investment;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khandelwal.domainmodel.asset.investment.InvestmentAsset;

@Service
public class InvestmentAssetService {

	private InvestmentAssetRepository investmentAssetRepository;

	@Autowired
	public InvestmentAssetService(
			InvestmentAssetRepository investmentAssetRepository) {
		super();
		this.investmentAssetRepository = investmentAssetRepository;
	}

	/**
	 * This method adds Investment Asset in db
	 * 
	 * @param InvestmentAsset
	 */
	public void addInvestmentAsset(InvestmentAsset investmentAsset) {

		investmentAssetRepository.save(investmentAsset);
	}

	/**
	 * This method returns all the InvestmentAsset records
	 * 
	 * @return
	 */
	public Collection<InvestmentAsset> getAllInvestmentAsset() {

		Collection<InvestmentAsset> InvestmentAssetCollection = new ArrayList<InvestmentAsset>();

		for (InvestmentAsset InvestmentAsset : investmentAssetRepository
				.findAll()) {
			InvestmentAssetCollection.add(InvestmentAsset);
		}

		return InvestmentAssetCollection;
	}

	/**
	 * This method returns the InvestmentAsset record matched by Id
	 * 
	 * @return
	 */
	public InvestmentAsset getInvestmentAssetByNumber(String assetNumber) {

		return investmentAssetRepository.findOne(assetNumber);

	}

	/**
	 * This method returns the InvestmentAsset record matched by AssetName
	 * 
	 * @return
	 */
	public Collection<InvestmentAsset> getInvestmentAssetByName(String assetName) {

		return investmentAssetRepository.findByAssetName(assetName);

	}

	/**
	 * This method returns the InvestmentAsset record matched by AssetType
	 * 
	 * @return
	 */
	public Collection<InvestmentAsset> getInvestmentAssetByType(String assettype) {

		return investmentAssetRepository.findByAssetType(assettype);

	}

	/**
	 * This method delete the InvestmentAsset record matched by Id
	 * 
	 * @return
	 */
	public void deleteInvestmentAsset(String assetNumber) {

		investmentAssetRepository.delete(assetNumber);

	}
}
