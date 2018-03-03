package com.sample.f3.pay.serviceImpl;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.f3.pay.model.Fx;
import com.sample.f3.pay.service.*;
import com.sample.f3.pay.utils.Utilities;
@Service
public class FxServiceImpl implements FxService {

	@Autowired
	CurrencyService currencyService;
	public boolean checkFxData (Fx data)
	{
		
		boolean datagood = true;
		if (data == null) datagood = false; //TODO perhaps this is valid blank data
		if (datagood)
		{
			datagood = Utilities.isNumberGtZero(data.getExchangeRate());
			Logger.getGlobal().log(Level.FINE, "exchangerate check");
		}
		if (datagood)
		{
			datagood = Utilities.isNumberGtZero(data.getOriginalAmount());
			Logger.getGlobal().log(Level.FINE, "original amount");
		}
		if (datagood)
		{
			datagood = Utilities.isNotNullAndNotEmpty(data.getContractReference());
			Logger.getGlobal().log(Level.FINE, "contract check");
		}
		
		if (datagood) 
		{
			datagood = (currencyService.checkCurrencyCode(data.getOriginalCurrency()));
			Logger.getGlobal().log(Level.INFO, "currency check " + data.getOriginalCurrency() + " " +datagood);
		}
		return datagood;
	}
}
