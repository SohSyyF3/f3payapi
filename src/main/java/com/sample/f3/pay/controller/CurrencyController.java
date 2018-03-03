package com.sample.f3.pay.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sample.f3.pay.model.Currency;
import com.sample.f3.pay.repository.CurrencyRepository;
import com.sample.f3.pay.service.CurrencyService;

/**
 * @author sohail
 *
 */
@RestController
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private CurrencyService currencyService;

	@RequestMapping(value = "/currency/{id}", method = RequestMethod.GET)
	Currency getCurrency(@PathVariable (value="id") Long Id) {
		return this.currencyRepository.findByCurrencyId(Id);
	}

	@RequestMapping(value = "/currency", method = RequestMethod.GET)
	List<Currency> getCurrency() {
		return this.currencyRepository.findAll();
	}

	boolean checkDataValid (String data)
	{
		boolean datagood = currencyService.checkCurrencyCode(data);
		return datagood;
	}

}
