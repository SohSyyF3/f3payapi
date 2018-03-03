package com.sample.f3.pay.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sample.f3.pay.model.Payment;
import com.sample.f3.pay.repository.PaymentRepository;
import com.sample.f3.pay.service.PaymentService;
import com.sample.f3.pay.utils.Utilities;

/**
 * Main page to add/delete/get all resource
 * Mapped to sub path "/payment"
 *		/get/{id} -- id is the payment id in the json, not the table id 
 *		/delete/{id} -- id is the payment id as above
 *		/all	- return the list of payments as json array
 *		/update/{id} - update the record with this id		
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired private PaymentRepository paymentRepository;
	@Autowired private PaymentService paymentService;

/*
 * get
 * 		- Get a single payment resource by the payment ID
 * 		- return the data
 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	Payment getPayment(@PathVariable (value="id") String Id) 
	{
		return this.paymentRepository.findById(Id);
	}
	
/*
 * delete
 * 		- Delete a single payment resource by the payment ID
 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	ResponseEntity<?> deletePayment (@PathVariable (value="id") String Id) 
	{
		Payment pay = this.paymentRepository.findById(Id);
		if (pay != null)
			paymentRepository.delete(pay);
		else return new ResponseEntity<>(HttpStatus.CONFLICT);
		
		pay = this.paymentRepository.findById(Id);
		if (pay==null)
		{
			// return 204 : Some places not recommended
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			// Only for now to return something
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

/*
 * 
 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	List<Payment> getCurrency() 
	{
		return this.paymentRepository.findAll();
	}
	
/*
 * Update procedure
 * 		- accept id from payment
 * 		- check data input is valid
 *  	- check id exists
 *  	- check if matches
 *  	- update keys and call addSimple
 */
	@RequestMapping(value = "/update/{id}" , method = RequestMethod.POST)
	ResponseEntity<?> update (@RequestBody Payment data, @PathVariable (value="id") String Id) 
	{
		/*
		 * validate input data first
		 * before wasting resources pulling existing data
		 */
		boolean datagood = checkDataValid(data);
		if (datagood)
			if (Utilities.isNotNullAndNotEmpty(Id))
			{
				Payment payExist = paymentRepository.findById(Id);
				if (payExist!=null)
				{
					if (payExist.getId().equals(Id))
					{
						/*
						 * Copy keys over for update to happen
						 */
						paymentService.copyKeysForUpdate(payExist, data);
						return addSimple (data);
					} else return new ResponseEntity<>(HttpStatus.CONFLICT);
				} else return new ResponseEntity<>(HttpStatus.CONFLICT);
			} else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
/*
 * add procedure
 * 		- call addSimple 
 */
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Payment data) 
	{
		return addSimple(data);
	}
/*
 * 
 */
	
	ResponseEntity<?> addSimple(Payment data) 
	{
		Payment result 	 = null;
		URI 	location = null;
		System.out.println("** ADDSIMPLE **");
		
		try {
			location = new URI("");
		} catch (URISyntaxException e) {
			location = null;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean datagood = checkDataValid(data);
		
		
		if ((datagood)) {
			/*
			 * Strange behaviour, although updated entity
			 * the returned results were showing old data
			 * Adding @cacheable false on tables seemed to solve
			 * Debugging statements left here
			 */
			
			result = paymentRepository.saveAndFlush(data);
			System.out.println("Debug 2r " + result.getAttributes().getAttributesId() + " " + result.getAttributes().getBeneficiaryParty().getBankId());
			System.out.println("Debug 2d " + data.getAttributes().getAttributesId() + " " + data.getAttributes().getBeneficiaryParty().getBankId());
			
			
			System.out.println("Debug  = " + result.getPaymentId());
			System.out.println("Debug  cs = " + result.getAttributes().getChargesInformation().getChargesId());
			System.out.println("Debug  cisize = " + result.getAttributes().getChargesInformation().getSenderCharges().size());
			
			// Klodge here: But I've committed to this model for this exercise
			// so using this double save to get around this issue.
			// This is only updating the chargesID which is set to null, but never updated
			// suspect this is due to the DB providing the key
			// so one potential idea is to change the ID key to be generated inside
			result.getAttributes().getChargesInformation().chargeItemReset();
			result = paymentRepository.save(result);
			location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/payment/get/{Id}").buildAndExpand(result.getId())
					.toUri();
		}
		// TODO handle not good data
		return ResponseEntity.created(location).build();
	}

/*
 * checkDataValid
 * 		- call the services to check data
 */
	boolean checkDataValid (Payment data)
	{
		boolean datagood = paymentService.checkPaymentData(data);
		return datagood;
	}

}
