package com.sample.f3.pay.utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class UtilitiesTest {

	@Test
	public void testIsNumberGEZeroBigDecimal() {
	    
		BigDecimal bd1 = new BigDecimal (0);
		assertTrue (Utilities.isNumberGEZero(bd1));
		bd1 = new BigDecimal (0.000001);
		assertTrue (Utilities.isNumberGEZero(bd1));
		bd1 = new BigDecimal (-0.000001);
		assertFalse (Utilities.isNumberGEZero(bd1));
		bd1 = new BigDecimal (-0122.000001);
		assertFalse (Utilities.isNumberGEZero(bd1));
		
		 
	}

	@Test
	public void testIsNumberGEZeroLong() {
		long data = 0;
		assertTrue (Utilities.isNumberGEZero(data));
		data = 1;
		assertTrue (Utilities.isNumberGEZero(data));
		data = -1;
		assertFalse (Utilities.isNumberGEZero(data));
	}

	@Test
	public void testIsNumberGEZeroInt() {
		int data = 0;
		assertTrue (Utilities.isNumberGEZero(data));
		data = 1;
		assertTrue (Utilities.isNumberGEZero(data));
		data = -1;
		assertFalse (Utilities.isNumberGEZero(data));
	}

	@Test
	public void testIsNotNullAndNotEmpty() {
		String data = "";
		assertFalse (Utilities.isNotNullAndNotEmpty(data));
		 data = null;
		assertFalse (Utilities.isNotNullAndNotEmpty(data));
		 data = " ";
		assertFalse (Utilities.isNotNullAndNotEmpty(data));
		 data = "Something";
		assertTrue (Utilities.isNotNullAndNotEmpty(data));

	}

	@Test
	public void testIsNullOrEmpty() {
		String data = "";
		  assertTrue (Utilities.isNullOrEmpty(data));
		 data = null;
		 assertTrue (Utilities.isNullOrEmpty(data));
		 data = " ";
		 assertTrue (Utilities.isNullOrEmpty(data));
		 data = "Something";
		assertFalse(Utilities.isNullOrEmpty(data));
	}
	
	@Test
	public void testIsNumberGtZeroBigDecimal() {
	    
		BigDecimal bd1 = new BigDecimal (0);
		assertFalse (Utilities.isNumberGtZero(bd1));
		bd1 = new BigDecimal (0.000001);
		assertTrue (Utilities.isNumberGtZero(bd1));
		bd1 = new BigDecimal (-0.000001);
		assertFalse (Utilities.isNumberGtZero(bd1));
		bd1 = new BigDecimal (-0122.000001);
		assertFalse (Utilities.isNumberGEZero(bd1));
		
		 
	}

	@Test
	public void testIsNumberGtZeroLong() {
		long data = 0;
		assertFalse (Utilities.isNumberGtZero(data));
		data = 1;
		assertTrue (Utilities.isNumberGtZero(data));
		data = -1;
		assertFalse (Utilities.isNumberGtZero(data));
	}

	@Test
	public void testIsNumberGtZeroInt() {
		int data = 0;
		assertFalse (Utilities.isNumberGtZero(data));
		data = 1;
		assertTrue (Utilities.isNumberGtZero(data));
		data = -1;
		assertFalse (Utilities.isNumberGtZero(data));
	}
	

	
	@Test
	public void testIsValidCurrencyTransBD() {
	    
		BigDecimal bd1 = new BigDecimal (0);
		assertFalse (Utilities.isValidCurrencyTrans(bd1));
		bd1 = new BigDecimal (0.000001);
		assertTrue (Utilities.isValidCurrencyTrans(bd1));
		bd1 = new BigDecimal (-0.000001);
		assertFalse (Utilities.isValidCurrencyTrans(bd1));
		bd1 = new BigDecimal (-0122.000001);
		assertFalse (Utilities.isValidCurrencyTrans(bd1));
		
		 
	}

	@Test
	public void testIsValidCurrencyTransLong() {
		long data = 0;
		assertFalse (Utilities.isValidCurrencyTrans(data));
		data = 1;
		assertTrue (Utilities.isValidCurrencyTrans(data));
		data = -1;
		assertFalse (Utilities.isValidCurrencyTrans(data));
	}

	@Test
	public void testIsValidCurrencyTransInt() {
		int data = 0;
		assertFalse (Utilities.isValidCurrencyTrans(data));
		data = 1;
		assertTrue (Utilities.isValidCurrencyTrans(data));
		data = -1;
		assertFalse (Utilities.isValidCurrencyTrans(data));
	}

}
