package com.khandelwal.model.asset.utility;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.khandelwal.domainmodel.asset.utility.UtilityAsset;

/**
 * This interface extends MongoRepository of Springframework, implementation of
 * which is provided by Spring with basic CRUD operations and developer neither
 * need to make connection with db nor to write basic CRUD operations
 * 
 * @author Abhishek Khandelwal
 *
 */
public interface UtilityAssetRepository extends
		MongoRepository<UtilityAsset, String>,
		QueryDslPredicateExecutor<UtilityAsset> {

	public Collection<UtilityAsset> findByAssetName(String assetName);

	public Collection<UtilityAsset> findByAssetType(String assetType);

	/* Example to use Query annotation to query the db */
	@Query(value = "{$and[{'assetName':?0},{'assettype':?1}]}")
	public Collection<UtilityAsset> findByAssetNameAndType(String assetName,
			String assetType);
}
