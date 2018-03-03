package com.sample.f3.pay.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Fx")
public class Fx {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	long 		fxId;
	String 		contractReference;
    BigDecimal 	exchangeRate;
    BigDecimal	originalAmount;
    String 		originalCurrency;

    /*
     * Standard getters and setters
     */
    public long getfxId() {
		return fxId;
	}
	public void setfXId(long fxId) {
		this.fxId = fxId;
	}
	public String getContractReference() {
		return contractReference;
	}
	public void setContractReference(String contractReference) {
		this.contractReference = contractReference;
	}
	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}
	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}
	//public String getCurrencyCode() {
	//	return originalCurrency;
	//}
	//public void setCurrencyCode(String currencyCode) {
	//	this.originalCurrency = currencyCode;
	//	
	//}
	public String getOriginalCurrency() {
		return originalCurrency;
	}
	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
	}
	
}
