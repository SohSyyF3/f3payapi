package com.sample.f3.pay.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sample.f3.pay.model.ChargeItem;
import com.sample.f3.pay.model.Charges;
import com.sample.f3.pay.repository.ChargesRepository;
import com.sample.f3.pay.service.ChargesService;


@RunWith(MockitoJUnitRunner.class)
public class ChargesServiceImplTest {
	
	@Mock
	Charges charges;
	@Mock
	ChargesRepository repository;
	@Mock
	ChargesService service;
	@Mock
	CurrencyServiceImpl currencyService;
	@Mock
	List<ChargeItem> chargeItems;
	@InjectMocks
	ChargesServiceImpl CSI = new ChargesServiceImpl();
	
	@Before
	public void prepopulate ()
	{
		
		when (currencyService.checkCurrencyCode("USD")).thenReturn(true);
		when (currencyService.checkCurrencyCode("ERE")).thenReturn(false);

		when (charges.getBearerCode()).thenReturn ("11111");
		when (charges.getReceiverChargesAmount()).thenReturn (BigDecimal.valueOf(1.2));
		when (charges.getReceiverChargesCurrency()).thenReturn ("USD");
		when ((charges.getSenderCharges())).thenReturn(chargeItems);
		when (chargeItems.size()).thenReturn(1);
	}
	@Test
	public void testGood() {
	
		boolean status = false;
		status = CSI.checkCharges(charges);
		assertTrue ("Charges Test = good",status);
	}
	@Test
	public void testBearer() {
	
		boolean status = false;
		when (charges.getBearerCode()).thenReturn ("");
		status = CSI.checkCharges(charges);
		assertFalse ("Charges Bearer = blank",status);
		when (charges.getBearerCode()).thenReturn (null);
		status = CSI.checkCharges(charges);
		assertFalse ("Charges Bearer = null",status);
	}
	
	@Test 
	public void testGetReceiverChargesAmount()
	{
		boolean status = false;
		when (charges.getReceiverChargesAmount()).thenReturn (null);
		status = CSI.checkCharges(charges);
		assertFalse ("Charges getReceiverChargesAmount = null",status);
		when (charges.getReceiverChargesAmount()).thenReturn (BigDecimal.valueOf(0));
		status = CSI.checkCharges(charges);
		assertFalse ("Charges getReceiverChargesAmount = 0",status);
		when (charges.getReceiverChargesAmount()).thenReturn (BigDecimal.valueOf(-0.020));
		status = CSI.checkCharges(charges);
		assertFalse ("Charges getReceiverChargesAmount = -0.3",status);
	}
	
	@Test 
	public void testGetReceiverChargesCurrency()
	{
		boolean status = false;
		
		when (charges.getReceiverChargesCurrency()).thenReturn (null);
		status = CSI.checkCharges(charges);
		assertFalse ("Charges getReceiverChargesCurrency = null",status);
		
		when (charges.getReceiverChargesCurrency()).thenReturn ("USD");
		status = CSI.checkCharges(charges);
		assertTrue ("Charges getReceiverChargesCurrency = USD",status);
		
		when (charges.getReceiverChargesCurrency()).thenReturn ("ERE");
		status = CSI.checkCharges(charges);
		assertFalse ("Charges getReceiverChargesCurrency = ERE",status);
	}
	@Test 
	public void testGetChargeItems()
	{
		boolean status = false;
		
		status = CSI.checkCharges(charges);
		assertTrue ("Charges getChargeItems = 1",status);
		
		when (charges.getSenderCharges()).thenReturn (null);
		status = CSI.checkCharges(charges);
		assertFalse ("Charges getChargeItems = null",status);
		
		when (chargeItems.size()).thenReturn(0);
		status = CSI.checkCharges(charges);
		assertFalse ("Charges getChargeItems = 0",status);
		
	}

}
