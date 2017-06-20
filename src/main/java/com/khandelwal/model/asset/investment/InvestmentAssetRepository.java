package com.khandelwal.model.asset.investment;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.khandelwal.domainmodel.asset.investment.InvestmentAsset;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * This interface extends MongoRepository of Springframework, implementation of
 * which is provided by Spring with basic CRUD operations and developer neither
 * need to make connection with db nor to write basic CRUD operations
 * 
 * @author Abhishek Khandelwal
 *
 */
public interface InvestmentAssetRepository extends MongoRepository<InvestmentAsset, String>, QueryDslPredicateExecutor<InvestmentAsset> {

	public Collection<InvestmentAsset> findByAssetName(String assetName);

	public Collection<InvestmentAsset> findByAssetType(String assetType);

	/* Example to use Query annotation to query the db */
	@Query(value="{'$and':[{'assetName':?0}, {'assetType':?1}]}")
	public Collection<InvestmentAsset> findByAssetNameAndType(String assetName,
			String assetType);

}