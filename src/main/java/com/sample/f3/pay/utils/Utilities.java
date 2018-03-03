package com.sample.f3.pay.utils;

import java.math.BigDecimal;

public class Utilities 
{
	public static boolean isNumberGEZero (BigDecimal data)
	{
		if (data!=null)
		{
			BigDecimal val = new BigDecimal(0);
			if (data.compareTo(val) < 0)
				return false;
			return true;
		} 
		return false;
	}
	public static boolean isNumberGEZero (long data)
	{
		if (data < 0)
			return false;
		return true;
	}
	public static boolean isNumberGEZero (int data)
	{
		if (data < 0)
			return false;
		return true;
	}
	public static boolean isNotNullAndNotEmpty (String data)
	{
		if (data==null) return false;
		if (data.trim().equals("")) return false;
		return true;
	}
	public static boolean isNullOrEmpty (String data)
	{
		return !isNotNullAndNotEmpty(data);
	}
	public static boolean isValidCurrencyTrans (BigDecimal data)
	{
		return isNumberGtZero (data);
	}
	public static boolean isValidCurrencyTrans (long data)
	{
		return isNumberGtZero (data);
	}
	public static boolean isValidCurrencyTrans (int data)
	{
		return isNumberGtZero (data);
	}
	public static boolean isNumberGtZero (BigDecimal data)
	{
		if (data!=null)
		{
			BigDecimal val = new BigDecimal(0);
			if (data.compareTo(val) <= 0)
				return false;
			return true;
		}
		return false;
	}
	public static boolean isNumberGtZero (long data)
	{
		if (data <= 0)
			return false;
		return true;
	}
	public static boolean isNumberGtZero (int data)
	{
		if (data <= 0)
			return false;
		return true;
	}
}
