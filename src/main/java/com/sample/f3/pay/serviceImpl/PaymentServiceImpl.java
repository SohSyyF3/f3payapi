package com.sample.f3.pay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.f3.pay.model.Payment;
import com.sample.f3.pay.service.AttributesService;
import com.sample.f3.pay.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	AttributesService attributesService;
	
	
	/*
	 * (non-Javadoc)
	 * @see com.sample.f3.pay.service.PaymentService#checkPaymentData(com.sample.f3.pay.model.Payment)
	 * 
	 * Rudimentary data checker. Need to understand more detailed rules to correct
	 * Additionally we should return an object with the error to report back
	 */
	@Override
	public boolean checkPaymentData(Payment payment) {
		boolean status=true;
		if (status) if (payment.getId()==null)
		{
			status=false;
			System.out.println ("Missing payment ID");
		}
		if (status) if (payment.getId().trim().equals(""))
		{
			status=false;
			System.out.println ("Missing payment ID");
		}
			if (status) if (payment.getOrganisationId()==null)
		{
			status=false;
			System.out.println ("Missing Org ID");
		}
		if (status) if (payment.getOrganisationId().trim().equals(""))
		{
			status=false;
			System.out.println ("Missing Org ID");
		}
		if (status) if (payment.getType()==null)
		{
			status=false;
			System.out.println ("Missing payment type");
		}
		/*
		 * currently hard-coded to payment, this could be a database entry instead once
		 * we get more details
		 */
		if (status) if (!payment.getType().trim().equals("Payment"))
		{
			status=false;
			System.out.println ("Missing payment type not equal");
		}
		if (status) if (payment.getVersion()==null)
		{
			status=false;
			System.out.println ("Missing version");
		}
		/*
		 * Currently coded to 0, the only version we know
		 */
		if (status) if (!payment.getVersion().trim().equals("0"))
		{
			status=false;
			System.out.println ("Missing version not 0");
		}
		
		if (status) if (payment.getAttributes()==null)
		{
			status=false;
			System.out.println ("Missing attributes");
		}
		if (status) 
			if (!(attributesService.checkAttributesData(payment.getAttributes())))
		{
			status=false;
			System.out.println ("Bad attributes");
		}
		
		return status;
	}


	@Override
	public boolean copyKeysForUpdate(Payment src, Payment dest) 
	{
		dest.setPaymentId(src.getPaymentId());
		dest.getAttributes().setAttributesId(src.getAttributes().getAttributesId());
		dest.getAttributes().getBeneficiaryParty().setBenId(src.getAttributes().getBeneficiaryParty().getBenId());
		dest.getAttributes().getChargesInformation().setChargesId(src.getAttributes().getChargesInformation().getChargesId());
		dest.getAttributes().getDebtorParty().setDebtorId(src.getAttributes().getDebtorParty().getDebtorId());
		dest.getAttributes().getFx().setfXId(src.getAttributes().getFx().getfxId());
		dest.getAttributes().getSponsorParty().setSponsorid(src.getAttributes().getSponsorParty().getSponsorid());
		
		/*
		 * set chargesItems ids for new entries
		 */
		dest.getAttributes().getChargesInformation().chargeItemReset();

		/*
		 * Assume data in same order. If missing then should get deleted
		 * if extra then will get added
		 * This is only to map existing ones to get updated
		 * 
		 * TODO : Bug : If data is missing in new one, then old ones remain
		 * 			  : as mapping is from items to parent
		 * 			  : Perhaps should delete items and allow reinsert
		 * 			  : or reset parent field to null
		 */

		int max=0;
		if (src.getAttributes().getChargesInformation().getSenderCharges().size()<dest.getAttributes().getChargesInformation().getSenderCharges().size())
			max = src.getAttributes().getChargesInformation().getSenderCharges().size();
		else
			max = dest.getAttributes().getChargesInformation().getSenderCharges().size();
		for (int n=0;n<max;n++)
		{
			dest.getAttributes().getChargesInformation().getSenderCharges().get(n).setChargeitemId(
			   src.getAttributes().getChargesInformation().getSenderCharges().get(n).getChargeitemId());
		}
		return false;
	}
	
	

}
