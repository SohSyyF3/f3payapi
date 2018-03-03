package com.sample.f3.pay.serviceImpl;

import org.springframework.stereotype.Service;

import com.sample.f3.pay.model.Sponsor;
import com.sample.f3.pay.service.SponsorService;
@Service
public class SponsorServiceImpl implements SponsorService {
	
	public boolean checkData (Sponsor sponsor)
	{
		boolean status=true;
		if (sponsor==null) status = false;
		if (status)
			if (sponsor.getAccountNumber() == null)
			{
				status=false;
			}
	
		if (status)
			if (sponsor.getBankId() == null)
			{
				status=false;
			}
		if (status)
			if (sponsor.getBankIdCode() == null)
			{
				status=false;
			}
		if (status)
			if (sponsor.getAccountNumber().trim().equals(""))
			{
				status=false;
			}
	
		if (status)
			if (sponsor.getBankId().trim().equals(""))
			{
				status=false;
			}
		if (status)
			if (sponsor.getBankIdCode().trim().equals(""))
			{
				status=false;
			}
		
		return status;
	}

}
