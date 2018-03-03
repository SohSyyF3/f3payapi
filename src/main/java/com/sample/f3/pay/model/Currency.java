package com.sample.f3.pay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * Table holding currency description
 */

@Entity
@Table (name="Currency")
public class Currency {
	@Id
	@GeneratedValue
	private Long   currencyId;
	private String currencyCode;   	// 3 Character code, e.g. USB, GBP
	private String description;		// Description in text US Dollars, British Pounds

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
