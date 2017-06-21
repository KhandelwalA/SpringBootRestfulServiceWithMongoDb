package com.khandelwal.model.asset.investment;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.khandelwal.domainmodel.asset.investment.InvestmentAsset;
import com.khandelwal.domainmodel.asset.investment.QInvestmentAsset;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class InvestmentAssetService {

	private InvestmentAssetRepository investmentAssetRepository;
	private MongoTemplate mongoTemplate;

	@Autowired
	public InvestmentAssetService(InvestmentAssetRepository investmentAssetRepository, MongoTemplate mongoTemplate) {
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

		for (InvestmentAsset InvestmentAsset : investmentAssetRepository.findAll()) {
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

	/**
	 * This method find the InvestmentAsset record matched by asset name & type
	 * 
	 * @param assetName
	 * @param assetType
	 * @return
	 */
	public Collection<InvestmentAsset> getInvestmentAssetByNameAndType(String assetName, String assetType) {

		return investmentAssetRepository.findByAssetNameAndType(assetName, assetType);

	}

	/**
	 * This method uses 'querydsl-mongodb' jar for complex queries
	 * 
	 * @param assetName
	 * @param assetType
	 * @param ifscCode
	 * @return
	 */
	public Collection<InvestmentAsset> getAssetByNumberOrIfscCodeOrSortCodeOrNameAndType(String assetNumber,
			String ifscCode, String sortCode, String assetName, String assetType) {

		Collection<InvestmentAsset> investmentAssetCollection = new ArrayList<>();
		QInvestmentAsset investmentAsset = new QInvestmentAsset("investmentAsset");

		/* Creating filter expressions */
		BooleanExpression filterByAssetNumber = investmentAsset.assetNumber.equalsIgnoreCase(assetNumber);
		BooleanExpression filterByAssetIfscCode = investmentAsset.ifscCode.equalsIgnoreCase(ifscCode);
		BooleanExpression filterByAssetSortCode = investmentAsset.sortCode.equalsIgnoreCase(sortCode);
		BooleanExpression filterByName = investmentAsset.assetName.equalsIgnoreCase(assetName);
		BooleanExpression filterByType = investmentAsset.assetType.equalsIgnoreCase(assetType);

		for (InvestmentAsset investment : investmentAssetRepository.findAll(filterByAssetNumber
				.or(filterByAssetIfscCode).or(filterByAssetSortCode).or(filterByName.and(filterByType)))) {
			investmentAssetCollection.add(investment);
		}

		return investmentAssetCollection;
	}
	
	/**
	 * This method uses MongoTemplate for CRUD on MongoDb
	 * 
	 * @param assetNumber
	 * @param ifscCode
	 * @param sortCode
	 * @param assetName
	 * @param assetType
	 */
	public void deleteAssetByNumberOrIfscCodeOrSortCodeOrNameAndType(
			String assetNumber, String ifscCode, String sortCode,
			String assetName, String assetType) {

		Query query = new Query(Criteria
				.where("assetNumber")
				.is(assetNumber)
				.orOperator(Criteria.where("ifscCode").is(ifscCode))
				.orOperator(Criteria.where("sortCode").is(sortCode))
				.orOperator(
						Criteria.where("assetName")
								.is(assetName)
								.orOperator(
										Criteria.where("assetType").is(
												assetType))));

		mongoTemplate.remove(query, InvestmentAsset.class);
	}

}
