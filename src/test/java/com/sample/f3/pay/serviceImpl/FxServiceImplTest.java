package com.sample.f3.pay.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sample.f3.pay.model.Fx;
import com.sample.f3.pay.repository.CurrencyRepository;


@RunWith(MockitoJUnitRunner.class)
public class FxServiceImplTest {
	@Mock
	Fx fx;
	@Mock
	CurrencyRepository repository;
	@Mock
	CurrencyServiceImpl currencyService;
	@InjectMocks
	FxServiceImpl fxServiceImpl = new FxServiceImpl();
	
	@Test
	
	/*
	 * Test some basic checks on the data being performed.
	 * Will break this down later as more information is known.
	 */
	public void testcheckFxData() {
	
	boolean status=false;

	when (currencyService.checkCurrencyCode("USD")).thenReturn(true);
	//when (currencyService.checkCurrencyCode("")).thenReturn(false);
	
	when (fx.getContractReference()).thenReturn(null);
	when (fx.getExchangeRate()).thenReturn(null);
	when (fx.getOriginalAmount()).thenReturn(null);
	when (fx.getOriginalCurrency()).thenReturn(null);
	status= fxServiceImpl.checkFxData(fx);

	assertFalse ("testcheckFxData nulls",status);
	
	when (fx.getContractReference()).thenReturn("12");
	when (fx.getExchangeRate()).thenReturn(BigDecimal.valueOf(1.4));
	when (fx.getOriginalAmount()).thenReturn(BigDecimal.valueOf(19.02));
	when (fx.getOriginalCurrency()).thenReturn("USDd");
	status= fxServiceImpl.checkFxData(fx);

	assertFalse ("testcheckFxData bad currency", status);
	
	when (fx.getContractReference()).thenReturn("      ");
	when (fx.getExchangeRate()).thenReturn(BigDecimal.valueOf(1.4));
	when (fx.getOriginalAmount()).thenReturn(BigDecimal.valueOf(19.02));
	when (fx.getOriginalCurrency()).thenReturn("USD");
	status= fxServiceImpl.checkFxData(fx);

	assertFalse ("testcheckFxData bad contract ref",status);
	
	when (fx.getContractReference()).thenReturn("12");
	when (fx.getExchangeRate()).thenReturn(BigDecimal.valueOf(-1.4));
	when (fx.getOriginalAmount()).thenReturn(BigDecimal.valueOf(19.02));
	when (fx.getOriginalCurrency()).thenReturn("USD");
	status= fxServiceImpl.checkFxData(fx);

	assertFalse ("testcheckFxData bad exchange rate", status);
	
	when (fx.getContractReference()).thenReturn("12");
	when (fx.getExchangeRate()).thenReturn(BigDecimal.valueOf(1.4));
	when (fx.getOriginalAmount()).thenReturn(BigDecimal.valueOf(0));
	when (fx.getOriginalCurrency()).thenReturn("USD");
	status= fxServiceImpl.checkFxData(fx);

	assertFalse ("testcheckFxData zero value", status);
	
	when (fx.getContractReference()).thenReturn("12");
	when (fx.getExchangeRate()).thenReturn(BigDecimal.valueOf(1.4));
	when (fx.getOriginalAmount()).thenReturn(BigDecimal.valueOf(19.02));
	when (fx.getOriginalCurrency()).thenReturn("USD");
	status= fxServiceImpl.checkFxData(fx);

	assertTrue ("testcheckFxData all good", status);
	
		
		
	}

}
