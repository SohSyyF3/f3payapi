package com.sample.f3.pay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.f3.pay.model.Attributes;
import com.sample.f3.pay.service.AttributesService;
import com.sample.f3.pay.service.BeneficiaryService;
import com.sample.f3.pay.service.ChargesService;
import com.sample.f3.pay.service.CurrencyService;
import com.sample.f3.pay.service.DebtorService;
import com.sample.f3.pay.service.FxService;
import com.sample.f3.pay.service.SponsorService;
import com.sample.f3.pay.utils.Utilities;
@Service
public class AttributesServiceImpl implements AttributesService {

	@Autowired BeneficiaryService beneficiaryService;
	@Autowired SponsorService sponsorService;
	@Autowired FxService fxService;
	@Autowired DebtorService debtorService;
	@Autowired ChargesService chargesService;
	@Autowired CurrencyService currencyService;
	
	
	/*
	 * (non-Javadoc)
	 * @see com.sample.f3.pay.service.AttributesService#checkAttributesData(com.sample.f3.pay.model.Attributes)
	 * 
	 * Basic valid data checker
	 */
	@Override
	public boolean checkAttributesData(Attributes attributes) {
		boolean status = true;
		if (status) 
			if (attributes.getBeneficiaryParty()==null)
			{
				status=false;
				System.out.println ("Missing getBeneficiary");
			};
		if (status)
			if (!beneficiaryService.checkBeneficiaryData(attributes.getBeneficiaryParty()))
			{
				status=false;
				System.out.println("Bad getBeneficiary");
			}
		if (status) 
			if (attributes.getSponsorParty()==null)
			{
				status=false;
				System.out.println ("Missing getSponsor");
			};
		if (status)
			if (!sponsorService.checkData(attributes.getSponsorParty()))
			{
				status=false;
				System.out.println("Bad getSponsor");
			}
		if (status) 
			if (attributes.getFx()==null)
			{
				status=false;
				System.out.println ("Missing getFx");
			};
		if (status)
			if (!fxService.checkFxData(attributes.getFx()))
			{
				status=false;
				System.out.println("Bad getFx");
			}
		if (status) 
			if (attributes.getDebtorParty()==null)
			{
				status=false;
				System.out.println ("Missing getDebtor");
			};
		if (status)
			if (!debtorService.checkDebtorData(attributes.getDebtorParty()))
			{
				status=false;
				System.out.println("Bad getDebtor");
			}
		if (status) 
			if (attributes.getChargesInformation()==null)
			{
				status=false;
				System.out.println ("Missing getCharges");
			};
		if (status)
			if (!chargesService.checkCharges(attributes.getChargesInformation()))
			{
				status=false;
				System.out.println("Bad getCharges");
			}
		
		if (status) 
			if (attributes.getCurrency()==null)
			{
				status=false;
				System.out.println ("Missing getCurrency");
			};
		if (status)
			if (!currencyService.checkCurrencyCode(attributes.getCurrency()))
			{
				status=false;
				System.out.println("Bad checkCurrencyCode");
			}
		if (status) 
			if (attributes.getEndToEndReference()==null)
			{
				status=false;
				System.out.println ("Missing getEndToEndReference");
			};
		if (status) 
			if (attributes.getEndToEndReference().trim().equals(""))
			{
				status=false;
				System.out.println("Bad getEndToEndReference");
			};
		/*if (status) 
			if (attributes.getNumericReference()==null)
			{
				status=false;
			};
			*/
		if (status) 
			if (!Utilities.isNumberGEZero(attributes.getNumericReference()))
			{
				status=false;
				System.out.println("Bad getNumericReference");
			};
		return status;
	}

}
