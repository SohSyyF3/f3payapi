package com.sample.f3.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.f3.pay.model.Currency;



/**
 * @author sohail
 *
 */
@Repository
public interface CurrencyRepository extends JpaRepository <Currency, Long> {

	Currency findByCurrencyId (Long currencyId);
	Currency findByCurrencyCode (String currencyCode);
	 

}
