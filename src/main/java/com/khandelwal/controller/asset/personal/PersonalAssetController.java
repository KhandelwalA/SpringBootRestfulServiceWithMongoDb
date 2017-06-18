package com.khandelwal.controller.asset.personal;

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

import com.khandelwal.domainmodel.asset.personal.PersonalAsset;
import com.khandelwal.model.asset.personal.PersonalAssetService;

/**
 * This is restful controller class calling service layer
 * 
 * @author khabh
 *
 */
@RequestMapping("/personal")
@RestController
public class PersonalAssetController {

	private PersonalAssetService personalAssetService;

	@Autowired
	public PersonalAssetController(PersonalAssetService personalAssetService) {
		super();
		this.personalAssetService = personalAssetService;
	}

	@PostMapping(value = "/addPersonalAsset")
	public void addPersonalAsset(@RequestBody PersonalAsset personalAsset) {

		personalAssetService.addPersonalAsset(personalAsset);
	}

	@GetMapping(value = "/getAllPersonalAsset")
	public ResponseEntity<Collection<PersonalAsset>> getAllPersonalAsset() {

		return new ResponseEntity<Collection<PersonalAsset>>(personalAssetService.getAllPersonalAsset(), HttpStatus.OK);
	}

	@GetMapping(value = "/getPersonalAssetByNumber/{assetnumber}")
	public ResponseEntity<PersonalAsset> getPersonalAssetByNumber(@PathVariable String assetnumber) {

		return new ResponseEntity<PersonalAsset>(personalAssetService.getPersonalAssetByNumber(assetnumber),
				HttpStatus.OK);
	}

	@GetMapping(value = "/getPersonalAssetByName/{assetName}")
	public ResponseEntity<Collection<PersonalAsset>> getPersonalAssetByName(@PathVariable String assetName) {

		return new ResponseEntity<Collection<PersonalAsset>>(personalAssetService.getPersonalAssetByName(assetName),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletePersonalAssetById/{assetNumber}")
	public void deletePersonalAssetByName(@PathVariable String assetNumber) {

		personalAssetService.deletePersonalAsset(assetNumber);
	}
}
