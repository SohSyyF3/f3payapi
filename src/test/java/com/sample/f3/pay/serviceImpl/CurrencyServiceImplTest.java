package com.sample.f3.pay.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.github.springtestdbunit.annotation.*;
import com.sample.f3.pay.model.Currency;
import com.sample.f3.pay.repository.CurrencyRepository;
import com.sample.f3.pay.serviceImpl.CurrencyServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class CurrencyServiceImplTest {


	@InjectMocks
	CurrencyServiceImpl currency =new CurrencyServiceImpl();;

	@Mock
	CurrencyRepository repository ;
	
	@Test
	@DatabaseSetup  ("currencyDataSet.xml")
	public void testCheckCurrencyCode() 
	{
		MockitoAnnotations.initMocks(this);
		
		when(repository.findByCurrencyCode("USD")).thenReturn(new Currency());
		when(repository.findByCurrencyCode("RPK")).thenReturn(null);
		
		assertTrue(currency.checkCurrencyCode("USD"));
		assertFalse(currency.checkCurrencyCode("RPK"));
		assertFalse(currency.checkCurrencyCode(""));
		assertFalse(currency.checkCurrencyCode(null));
		assertFalse(currency.checkCurrencyCode("USDD"));
		assertFalse(currency.checkCurrencyCode("UUSD"));
	}
}
