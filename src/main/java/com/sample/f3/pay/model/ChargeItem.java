package com.sample.f3.pay.model;

import java.math.BigDecimal;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="chargeitem")
@Cacheable(false)
public class ChargeItem {
	
	@Id
	@GeneratedValue
	int chargeitemId;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JsonIgnore
	private Charges charges;
	private BigDecimal amount;
	private String currency;
	public int getChargeitemId() {
		return chargeitemId;
	}
	public Charges getCharges() {
		return charges;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setChargeitemId(int chargeitemId) {
		
		this.chargeitemId = chargeitemId;
	}
	public void setCharges(Charges charges) {
		
		this.charges = charges;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setCurrency(String currencyCode) {
		this.currency = currencyCode;
	}
}
