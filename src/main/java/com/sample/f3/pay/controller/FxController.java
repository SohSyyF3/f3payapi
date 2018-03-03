package com.sample.f3.pay.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.sample.f3.pay.model.Fx;
//import com.sample.f3.pay.model.Fx;
import com.sample.f3.pay.repository.FxRepository;
import com.sample.f3.pay.service.FxService;

/**
 * @author sohail
 *
 */
@RestController
@RequestMapping("/fx")
public class FxController {

	@Autowired
	private FxRepository fxRepository;

	@Autowired
	private FxService fxService;

	@RequestMapping(value = "/fx/{fxId}", method = RequestMethod.GET)
	Fx getFx(@PathVariable Long fxId) {
		return this.fxRepository.findByFxId(fxId);
	}

	@RequestMapping(value = "/fx", method = RequestMethod.GET)
	List<Fx> getFx() {
		return this.fxRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Fx data) {

		Fx result = null;
		URI location = null;
		try {
			location = new URI("");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//  Should check data integrity before saving into the database
		//  
		/*
		 * "fx": {
         *           "contract_reference": "FX123",
         *           "exchange_rate": "2.00000",
         *           "original_amount": "200.42",
         *           "original_currency": "USD"
         *       },
		 */
		boolean datagood = checkDataValid(data);
		if ((datagood)) {
			result = fxRepository.save(data);
			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{fxId}").buildAndExpand(result.getfxId())
					.toUri();
			
		}
		// TODO handle not good data
		return ResponseEntity.created(location).build();
	}
	
	boolean checkDataValid (Fx data)
	{
		boolean datagood = fxService.checkFxData(data);
		return datagood;
	}

}
