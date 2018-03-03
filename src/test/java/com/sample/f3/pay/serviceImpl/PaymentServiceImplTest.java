package com.sample.f3.pay.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sample.f3.pay.model.Attributes;
import com.sample.f3.pay.model.Beneficiary;
import com.sample.f3.pay.model.Charges;
import com.sample.f3.pay.model.Debtor;
import com.sample.f3.pay.model.Fx;
import com.sample.f3.pay.model.Payment;
import com.sample.f3.pay.model.Sponsor;
import com.sample.f3.pay.repository.PaymentRepository;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {

	@Mock private	Payment     payment;
	@Mock private	Attributes  attributes;
	@Mock private	Beneficiary beneficiary;
	@Mock private	Charges     charges;
	@Mock private	Debtor		debtor;
	@Mock private	Fx			fx;
	@Mock private	Sponsor sponsor;
	
	@Mock private	PaymentRepository repository;

	@Mock private SponsorServiceImpl sponsorService;
	@Mock private BeneficiaryServiceImpl beneficiaryService;
	@Mock private FxServiceImpl fxService;
	@Mock private ChargesServiceImpl chargesService;
	@Mock private DebtorServiceImpl debtorService;
	@Mock private AttributesServiceImpl attributesService;

	@InjectMocks
	private PaymentServiceImpl paymentService = new PaymentServiceImpl();
	
	
	@Before
	public void prepopulate ()
	{
		when (payment.getId()).thenReturn ("11111");
		when (payment.getOrganisationId()).thenReturn ("BNKBNK");
		when (payment.getType()).thenReturn ("Payment");
		when (payment.getVersion()).thenReturn ("0");
		when (payment.getAttributes()).thenReturn (attributes);
		
		when (attributesService.checkAttributesData(attributes)).thenReturn(true);
		when (sponsorService.checkData(sponsor)).thenReturn(true);
		when (beneficiaryService.checkBeneficiaryData(beneficiary)).thenReturn(true);
		when (fxService.checkFxData(fx)).thenReturn(true);
		when (chargesService.checkCharges(charges)).thenReturn(true);
		when (debtorService.checkDebtorData(debtor)).thenReturn(true);
		
		
		
	}
	@Test
	public void testGood() {
		boolean status=false;
		status = paymentService.checkPaymentData(payment);
		assertTrue ("payment service test good ", status);
	}
	@Test
	public void testNullAndEmptyID() {
		boolean status=false;
		when (payment.getId()).thenReturn ("");
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test good ", status);

		when (payment.getId()).thenReturn (null);
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test testNullAndEmptyID ", status);
	}
	@Test
	public void testNullAndEmptyOrganistaion() {
		boolean status=false;
		when (payment.getOrganisationId()).thenReturn ("");
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test testNullAndEmptyOrganistaion ", status);

		when (payment.getOrganisationId()).thenReturn (null);
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test testNullAndEmptyOrganistaion ", status);
	}
	@Test
	public void testGetType() {
		boolean status=false;
		when (payment.getType()).thenReturn ("");
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test getType ", status);

		when (payment.getType()).thenReturn (null);
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test getType ", status);
		
		when (payment.getType()).thenReturn ("Buy");
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test getType ", status);
	}
	@Test
	public void testVersion() {
		boolean status=false;
		when (payment.getVersion()).thenReturn ("");
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test getVersion ", status);

		when (payment.getVersion()).thenReturn (null);
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test getVersion ", status);
		
		when (payment.getVersion()).thenReturn ("1");
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test getVersion ", status);
	}
	@Test
	public void testAttributes() {
		boolean status=false;
		
		//when (payment.getAttributes()).thenReturn (attributes);
		//status = paymentService.checkPaymentData(payment);
		//assertTrue ("payment service test getVersion ", status);

		when (payment.getAttributes()).thenReturn (null);
		status = paymentService.checkPaymentData(payment);
		assertFalse ("payment service test getVersion ", status);

	}
}
