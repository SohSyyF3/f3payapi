package com.sample.f3.pay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.f3.pay.model.Currency;
import com.sample.f3.pay.repository.CurrencyRepository;
import com.sample.f3.pay.service.CurrencyService;

/*
 * Implementation for Currency Service
 * A utility function to check currencies returned
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {
	
@Autowired 
CurrencyRepository repository;

/*
 * (non-Javadoc)
 * @see com.sample.f3.pay.service.CurrencyService#checkCurrencyCode(java.lang.String)
 * 
 * Check if currency code supplied is in list of currency codes for us
 */
@Override
public boolean checkCurrencyCode(String currencyCode) {
	Currency currency = repository.findByCurrencyCode (currencyCode);
	if (currency != null) return true;
	else return false;
}


}
