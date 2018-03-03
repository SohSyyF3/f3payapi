package com.sample.f3.pay.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sample.f3.pay.model.Sponsor;
import com.sample.f3.pay.repository.SponsorRepository;

@RunWith(MockitoJUnitRunner.class)
public class SponsorServiceImplTest {

	@Mock
	Sponsor sponsor;
	@Mock
	SponsorRepository repository;
	@Mock
	SponsorServiceImpl SponsorService;
	@InjectMocks
	SponsorServiceImpl SSI = new SponsorServiceImpl();
	
	@Before
	public void prepopulate ()
	{
		when (sponsor.getAccountNumber()).thenReturn ("11111");
		when (sponsor.getBankId()).thenReturn ("BNKBNK");
		when (sponsor.getBankIdCode()).thenReturn ("RBSOK");
	}
	
	@Test
	public void testGoodData() 
	{
		
		boolean status = false;
		status = SSI.checkData(sponsor);
		assertTrue ("Sponsor service Impl good check",status);
	}
	@Test
	public void testAccountNumber() 
	{
		
		boolean status = false;
		when (sponsor.getAccountNumber()).thenReturn ("");
		status = SSI.checkData(sponsor);
		assertFalse ("Sponsor service Impl accountnumber check",status);
		
		when (sponsor.getAccountNumber()).thenReturn (null);
		status = SSI.checkData(sponsor);
		assertFalse ("Sponsor service Impl accountnumber check",status);
	}

	@Test
	public void testBankId() 
	{
		
		boolean status = false;
		when (sponsor.getBankId()).thenReturn ("");
		status = SSI.checkData(sponsor);
		assertFalse ("Sponsor service Impl getBankId check",status);
		
		when (sponsor.getBankId()).thenReturn (null);
		status = SSI.checkData(sponsor);
		assertFalse ("Sponsor service Impl getBankId check",status);
	}
	@Test
	public void testBankIdCode() 
	{
		
		boolean status = false;
		when (sponsor.getBankIdCode()).thenReturn ("");
		status = SSI.checkData(sponsor);
		assertFalse ("Sponsor service Impl getBankIdCode check",status);
		
		when (sponsor.getBankIdCode()).thenReturn (null);
		status = SSI.checkData(sponsor);
		assertFalse ("Sponsor service Impl getBankIdCode check",status);
	}
}
