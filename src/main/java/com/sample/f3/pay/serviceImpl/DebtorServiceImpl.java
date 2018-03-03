package com.sample.f3.pay.serviceImpl;

import org.springframework.stereotype.Service;

import com.sample.f3.pay.model.Debtor;
import com.sample.f3.pay.service.DebtorService;

/*
 * Currently do not really know the rules for data
 * Some assumptions have been made and placed in each class
 * This would need to be fine tuned
 * 
 * Also assuming if data is bad then we would log it or return something useful
 */
@Service
public class DebtorServiceImpl implements DebtorService {

	@Override
	public boolean checkDebtorData(Debtor debtor) {
		boolean status = true;
		if (debtor==null)
		{ 
			status=false;
		}
		if (status) 
			if (
			(debtor.getAccountName()==null) ||
			(debtor.getAccountNumber()==null) ||
			(debtor.getAccountNumberCode()==null) ||
			(debtor.getAddress()==null) ||
			(debtor.getBankId()==null) ||
			(debtor.getBankIdCode()==null) ||
			(debtor.getName()==null))
			{
				status=false;
			}
				
			
		if ((status) && (debtor.getAccountName().trim().equals("")))
		{
			status=false;
		}
		if ((status) && (debtor.getAccountNumber().trim().equals("")))
		{
			status=false;
		}
		if ((status) && (debtor.getAccountNumberCode().trim().equals("")))
		{
			status=false;
		}
		if ((status) && (debtor.getAddress().trim().equals("")))
		{
			status=false;
		}
		if ((status) && (debtor.getBankId().trim().equals("")))
		{
			status=false;
		}
		if ((status) && (debtor.getBankIdCode().trim().equals("")))
		{
			status=false;
		}
		if ((status) && (debtor.getName().trim().equals("")))
		{
			status=false;
		}
		return status;
	}

}
