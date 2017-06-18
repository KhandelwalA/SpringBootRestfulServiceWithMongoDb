package com.khandelwal.controller.asset.investment;

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

import com.khandelwal.domainmodel.asset.investment.InvestmentAsset;
import com.khandelwal.model.asset.investment.InvestmentAssetService;

/**
 * This is restful controller class calling service layer
 * 
 * @author khabh
 *
 */
@RequestMapping("/investment")
@RestController
public class InvestmentAssetController {

	private InvestmentAssetService investmentAssetService;

	@Autowired
	public InvestmentAssetController(InvestmentAssetService investmentAssetService) {
		super();
		this.investmentAssetService = investmentAssetService;
	}

	@PostMapping(value = "/addInvestmentAsset")
	public void addInvestmentAsset(@RequestBody InvestmentAsset investmentAsset) {

		investmentAssetService.addInvestmentAsset(investmentAsset);
	}

	@GetMapping(value = "/getAllInvestmentAsset")
	public ResponseEntity<Collection<InvestmentAsset>> getAllInvestmentAsset() {

		return new ResponseEntity<Collection<InvestmentAsset>>(investmentAssetService.getAllInvestmentAsset(),
				HttpStatus.OK);
	}

	@GetMapping(value = "/getInvestmentAssetByNumber/{assetnumber}")
	public ResponseEntity<InvestmentAsset> getInvestmentAssetByNumber(@PathVariable String assetnumber) {

		return new ResponseEntity<InvestmentAsset>(investmentAssetService.getInvestmentAssetByNumber(assetnumber),
				HttpStatus.OK);
	}

	@GetMapping(value = "/getInvestmentAssetByName/{assetName}")
	public ResponseEntity<Collection<InvestmentAsset>> getInvestmentAssetByName(@PathVariable String assetName) {

		return new ResponseEntity<Collection<InvestmentAsset>>(
				investmentAssetService.getInvestmentAssetByName(assetName), HttpStatus.OK);
	}

	@GetMapping(value = "/getInvestmentAssetByType/{assetType}")
	public ResponseEntity<Collection<InvestmentAsset>> getInvestmentAssetByType(@PathVariable String assetType) {

		return new ResponseEntity<Collection<InvestmentAsset>>(
				investmentAssetService.getInvestmentAssetByType(assetType), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteInvestmentAssetById/{assetNumber}")
	public void deleteInvestmentAssetByName(@PathVariable String assetNumber) {

		investmentAssetService.deleteInvestmentAsset(assetNumber);
	}
}
