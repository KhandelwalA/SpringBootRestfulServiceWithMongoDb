package com.khandelwal.controller.asset.utility;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khandelwal.domainmodel.asset.utility.UtilityAsset;
import com.khandelwal.model.asset.utility.UtilityAssetService;

/**
 * This is restful controller class calling service layer
 * 
 * @author khabh
 *
 */
@RequestMapping("/utility")
@RestController
public class UtilityAssetController {

	private UtilityAssetService utilityAssetService;

	@Autowired
	public UtilityAssetController(UtilityAssetService utilityAssetService) {
		super();
		this.utilityAssetService = utilityAssetService;
	}

	@PostMapping(value = "/addUtilityAsset")
	public void addUtilityAsset(@RequestBody UtilityAsset utilityAsset) {

		utilityAssetService.addUtilityAsset(utilityAsset);
	}

	@GetMapping(value = "/getAllUtilityAsset")
	public ResponseEntity<Collection<UtilityAsset>> getAllUtilityAsset() {

		return new ResponseEntity<Collection<UtilityAsset>>(
				utilityAssetService.getAllUtilityAsset(), HttpStatus.OK);
	}

	@GetMapping(value = "/getUtilityAssetByNumber/{assetnumber}")
	public ResponseEntity<UtilityAsset> getUtilityAssetByNumber(
			@PathVariable String assetnumber) {

		return new ResponseEntity<UtilityAsset>(
				utilityAssetService.getUtilityAssetByNumber(assetnumber),
				HttpStatus.OK);
	}

	@GetMapping(value = "/getUtilityAssetByName/{assetName}")
	public ResponseEntity<Collection<UtilityAsset>> getUtilityAssetByName(
			@PathVariable String assetName) {

		return new ResponseEntity<Collection<UtilityAsset>>(
				utilityAssetService.getUtilityAssetByName(assetName),
				HttpStatus.OK);
	}

	@GetMapping(value = "/getUtilityAssetByType/{assetType}")
	public ResponseEntity<Collection<UtilityAsset>> getUtilityAssetByType(
			@PathVariable String assetType) {

		return new ResponseEntity<Collection<UtilityAsset>>(
				utilityAssetService.getUtilityAssetByType(assetType),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteUtilityAssetByNumber/{assetNumber}")
	public void deleteUtilityAssetByName(@PathVariable String assetNumber) {

		utilityAssetService.deleteUtilityAsset(assetNumber);
	}

	@GetMapping(value = "/getUtilityAssetByNameAndtype")
	public ResponseEntity<Collection<UtilityAsset>> getUtilityAssetByNameAndType(
			@RequestBody UtilityAsset utilityAsset) {

		return new ResponseEntity<Collection<UtilityAsset>>(
				(utilityAssetService.getUtilityAssetByNameAndType(
						utilityAsset.getAssetName(),
						utilityAsset.getAssetType())), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByAssetNumberOrMeterNumber/{assetNumber}/{meterNumber}")
	public void deleteByAssetNumberOrMeterNumber(
			@PathVariable String assetNumber, @PathVariable String meterNumber) {

		utilityAssetService.deleteByAssetNumberOrMeterNumber(assetNumber,
				meterNumber);
	}
}