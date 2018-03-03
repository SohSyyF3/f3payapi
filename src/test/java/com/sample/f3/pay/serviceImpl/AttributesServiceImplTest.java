package com.sample.f3.pay.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sample.f3.pay.model.Attributes;
import com.sample.f3.pay.model.Beneficiary;
import com.sample.f3.pay.model.ChargeItem;
import com.sample.f3.pay.model.Charges;
import com.sample.f3.pay.model.Debtor;
import com.sample.f3.pay.model.Fx;
import com.sample.f3.pay.model.Sponsor;
import com.sample.f3.pay.repository.AttributesRepository;
import com.sample.f3.pay.service.ChargesService;


@RunWith(MockitoJUnitRunner.class)
public class AttributesServiceImplTest {
	
	@Mock
	Attributes attributes;
	@Mock
	Charges charges;
	@Mock
	Debtor debtor;
	@Mock
	Fx fx;
	@Mock
	Sponsor sponsor;
	@Mock
	Beneficiary beneficiary;
	@Mock
	AttributesRepository repository;
	@Mock
	ChargesService service;
	
	@Mock
	List<ChargeItem> chargeItems;
	
	@Mock
	BeneficiaryServiceImpl beneficiaryService;
	@Mock
	SponsorServiceImpl sponsorService;
	@Mock
	FxServiceImpl fxService;
	@Mock
	DebtorServiceImpl debtorService;
	@Mock
	ChargesServiceImpl chargesService;
	@Mock
	CurrencyServiceImpl currencyService;
	
	@InjectMocks
	AttributesServiceImpl ASI = new AttributesServiceImpl();
	@Before
	public void prepopulate ()
	{
		
		when (attributes.getAmount()).thenReturn (BigDecimal.valueOf(2.2));
		when (attributes.getBeneficiaryParty()).thenReturn (beneficiary);
		when (attributes.getChargesInformation()).thenReturn (charges);
		when (attributes.getDebtorParty()).thenReturn (debtor);
		when (attributes.getFx()).thenReturn (fx);
		when (attributes.getSponsorParty()).thenReturn (sponsor);
		
		when (attributes.getCurrency()).thenReturn ("USD");
		when (attributes.getEndToEndReference()).thenReturn ("Test");
		when (attributes.getNumericReference()).thenReturn (1212);
		when (attributes.getPaymentPurpose()).thenReturn ("TestPurpose");
		when (attributes.getPaymentScheme()).thenReturn ("Testschem");
		when (attributes.getPaymentType()).thenReturn ("Credit");
		when (attributes.getReference()).thenReturn ("Ref");
		when (attributes.getSchemePaymentSubType()).thenReturn ("Sub");
		when (attributes.getSchemePaymentType()).thenReturn ("Main");

		when (attributes.getProcessingDate()).thenReturn (Date.valueOf("2018-12-02"));
		
		when (currencyService.checkCurrencyCode("USD")).thenReturn(true);
		when (currencyService.checkCurrencyCode("ERE")).thenReturn(false);

		when (charges.getBearerCode()).thenReturn ("11111");
		when (charges.getReceiverChargesAmount()).thenReturn (BigDecimal.valueOf(1.2));
		when (charges.getReceiverChargesCurrency()).thenReturn ("USD");
		when ((charges.getSenderCharges())).thenReturn(chargeItems);
		when (chargeItems.size()).thenReturn(1);
		
		when (beneficiaryService.checkBeneficiaryData(beneficiary)).thenReturn(true);
		when (sponsorService.checkData(sponsor)).thenReturn(true);
		when (debtorService.checkDebtorData(debtor)).thenReturn(true);
		when (fxService.checkFxData(fx)).thenReturn(true);
		when (chargesService.checkCharges(charges)).thenReturn(true);
		
		
	}


	@Test
	public void testGoodData() {
		boolean status=false;
		status = ASI.checkAttributesData(attributes);
		assertTrue ("attributes checking", status);
	}
	@Test
	public void testBeneficiaryData() {
		boolean status=false;
		when (attributes.getBeneficiaryParty()).thenReturn (null);
		status = ASI.checkAttributesData(attributes);
		assertFalse ("beneficary service",status);
	}
	@Test
	public void testSponsorData() {
		boolean status=false;
		when (attributes.getSponsorParty()).thenReturn (null);
		status = ASI.checkAttributesData(attributes);
		assertFalse ("sponsor service",status);
	}
	@Test
	public void testFxData() {
		boolean status=false;
		when (attributes.getFx()).thenReturn (null);
		status = ASI.checkAttributesData(attributes);
		assertFalse ("fx service",status);
	}
	@Test
	public void testDebtorData() {
		boolean status=false;
		when (attributes.getDebtorParty()).thenReturn (null);
		status = ASI.checkAttributesData(attributes);
		assertFalse ("debtor service",status);
	}
	@Test
	public void testChargesData() {
		boolean status=false;
		when (attributes.getChargesInformation()).thenReturn (null);
		status = ASI.checkAttributesData(attributes);
		assertFalse ("charges service",status);
	}
	@Test
	public void testCurrencyData() {
		boolean status=false;
		when (attributes.getCurrency()).thenReturn (null);
		status = ASI.checkAttributesData(attributes);
		assertFalse ("currency data",status);
		when (attributes.getCurrency()).thenReturn ("E");
		status = ASI.checkAttributesData(attributes);
		assertFalse ("currency data",status);
		
	}
	@Test
	public void getEndToEndReference() {
		boolean status=false;
		when (attributes.getEndToEndReference()).thenReturn (null);
		status = ASI.checkAttributesData(attributes);
		assertFalse ("getEndToEndReference",status);
		when (attributes.getEndToEndReference()).thenReturn ("");
		status = ASI.checkAttributesData(attributes);
		assertFalse ("getEndToEndReference",status);
		
	}
	@Test
	public void getNumericReference() {
		boolean status=false;
		//when (attributes.getNumericReference()).thenReturn (null);
		//status = ASI.checkAttributesData(attributes);
		//assertFalse ("getNumericReference",status);
		when (attributes.getNumericReference()).thenReturn (-2);
		status = ASI.checkAttributesData(attributes);
		assertFalse ("getNumericReference",status);
	}
	
	//TODO other basic checks / tests
}
