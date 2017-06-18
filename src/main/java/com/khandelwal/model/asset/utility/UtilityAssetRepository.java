package com.khandelwal.model.asset.utility;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.khandelwal.domainmodel.asset.utility.UtilityAsset;

/**
 * This interface extends MongoRepository of Springframework, implementation of
 * which is provided by Spring with basic CRUD operations and developer neither
 * need to make connection with db nor to write basic CRUD operations
 * 
 * @author Abhishek Khandelwal
 *
 */
public interface UtilityAssetRepository extends MongoRepository<UtilityAsset, String> {

	public Collection<UtilityAsset> findByAssetName(String assetName);

	public Collection<UtilityAsset> findByAssetType(String assetType);
}