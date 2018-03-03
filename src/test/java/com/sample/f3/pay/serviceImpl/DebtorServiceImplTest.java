package com.sample.f3.pay.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sample.f3.pay.model.Debtor;
import com.sample.f3.pay.model.Fx;

@RunWith(MockitoJUnitRunner.class)
public class DebtorServiceImplTest {
	@Mock
	Fx fx;
	@Mock
	Debtor debtor;
	@Mock
	DebtorServiceImpl debtorService;
	@InjectMocks
	DebtorServiceImpl debtorServiceImpl = new DebtorServiceImpl();

	/*
	 * Populate with good data (will change as rules are added)
	 */
	@Before
	public void populateGoodData ()
	{
		when(debtor.getAccountName()).thenReturn("da");
		when(debtor.getAccountNumber()).thenReturn("da");
		when(debtor.getAccountNumberCode()).thenReturn("da");
		when(debtor.getAddress()).thenReturn("da");
		when(debtor.getBankId()).thenReturn("da");
		when(debtor.getBankId()).thenReturn("da");
		when(debtor.getBankIdCode()).thenReturn("da");
		when(debtor.getName()).thenReturn("da");

	}
	/*
	 * A basic data check, that nulls/"" are being checked
	 */
	@Test
	public void testBasicDataCheck() {
		

		boolean status = false;
		
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertTrue("test basic good",status);
		
		when(debtor.getAccountName()).thenReturn(null);
		when(debtor.getAccountNumber()).thenReturn(null);
		when(debtor.getAccountNumberCode()).thenReturn(null);
		when(debtor.getAddress()).thenReturn(null);
		when(debtor.getBankId()).thenReturn(null);
		when(debtor.getBankId()).thenReturn(null);
		when(debtor.getBankIdCode()).thenReturn(null);
		when(debtor.getName()).thenReturn(null);

		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("test all nulls",status);

		
		
	}
	@Test
	public void testBasicAccountNameCheck() {
		boolean status = false;

		when(debtor.getAccountName()).thenReturn(" ");
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse(status);
		when(debtor.getAccountName()).thenReturn(null);
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse(status);
	}
	@Test
	public void testAccountNumber ()
	{
		boolean status =true;
		when(debtor.getAccountName()).thenReturn(null);
				status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse(status);
		when(debtor.getAccountName()).thenReturn(" ");
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse(status);
		// TODO other rules?
		
}
	@Test
	public void testgetAccountNumber ()
	{
		boolean status =true;
		when(debtor.getAccountNumber()).thenReturn(null);
				status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("testgetAccountNumber",status);
		when(debtor.getAccountNumber()).thenReturn(" ");
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("testgetAccountNumber",status);
		// TODO other rules?
	}
	@Test
	public void testgetAccountNumberCode()
	{
		boolean status =true;
		when(debtor.getAccountNumberCode()).thenReturn(null);
				status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("testgetAccountNumberCode",status);
		when(debtor.getAccountNumberCode()).thenReturn(" ");
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("testgetAccountNumberCode",status);
		// TODO other rules?
	}
	@Test
	public void testGetAddress()
	{
		boolean status =true;
		when(debtor.getAddress()).thenReturn(null);
				status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("getAddress",status);
		when(debtor.getAddress()).thenReturn(" ");
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("getAddress",status);
		// TODO other rules?
	}
	@Test
	public void testGetBankId()
	{
		boolean status =true;
		when(debtor.getBankId()).thenReturn(null);
				status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("getBankId",status);
		when(debtor.getBankId()).thenReturn(" ");
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("getBankId",status);
		// TODO other rules?
	}
	@Test
	public void testGetBankCode()
	{
		boolean status =true;
		when(debtor.getBankIdCode()).thenReturn(null);
				status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("getBankIdCode",status);
		when(debtor.getBankIdCode()).thenReturn(" ");
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("getBankIdCode",status);
		// TODO other rules?
	}
	@Test
	public void testGetName()
	{
		boolean status =true;
		when(debtor.getName()).thenReturn(null);
				status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("getName",status);
		when(debtor.getName()).thenReturn(" ");
		status = debtorServiceImpl.checkDebtorData(debtor);
		assertFalse("getName",status);
		// TODO other rules?
	}
}
