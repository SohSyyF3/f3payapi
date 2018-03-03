package com.sample.f3.pay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.f3.pay.model.Charges;
import com.sample.f3.pay.service.CurrencyService;
import com.sample.f3.pay.utils.Utilities;
@Service
public class ChargesServiceImpl implements com.sample.f3.pay.service.ChargesService {
	
	@Autowired
	CurrencyService currencyService;
	@Override
	public boolean checkCharges(Charges charges) {
		
		// TODO Auto-generated method stub
		boolean status=true;
		if (status)
			if (charges.getBearerCode()==null)
			{
				status=false;
				System.out.println("Missing getBearerCode");
			}
		if (status)
			if (charges.getBearerCode().trim().equals(""))
			{
				status=false;
				System.out.println("Bad getBearerCode");
			}
		
		if (status)
			if (charges.getReceiverChargesAmount()==null)
			{
				status=false;
				System.out.println("Missing getReceiverChargesAmount");
			}
		if (status)
			if (!Utilities.isNumberGtZero(charges.getReceiverChargesAmount()))
			{
				status=false;
				System.out.println("Bad getReceiverChargesAmount");
			}
		if (status)
			if (charges.getReceiverChargesCurrency()==null)
			{
				status=false;
				System.out.println("Missing getReceiverChargesCurrency");
			}
		if (status)
			if (!currencyService.checkCurrencyCode(charges.getReceiverChargesCurrency()))
			{
				status=false;
				System.out.println("Bad checkCurrencyCode");
			}
		if (status)
			if (charges.getSenderCharges()==null)
			{
				status=false;
				System.out.println("Missing getChargeItems");
			}
		if (status)
			if (charges.getSenderCharges().size()<=0)
			{
				status=false;
				System.out.println("Bad getChargeItems");
			}	
		return status;
	}

}
