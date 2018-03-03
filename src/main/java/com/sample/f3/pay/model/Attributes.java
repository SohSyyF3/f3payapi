package com.sample.f3.pay.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * Storing the attributes part of the document
 * 
 * cacheable set to false, updates were not being returned
 */
@Entity
@Table (name="attributes")
@Cacheable(false)
public class Attributes {

	/*
	 * 			 "amount": "100.21",
	 *           "currency": "GBP",
	 *           "end_to_end_reference": "Wil piano Jan",
	 *           "numeric_reference": "1002001",
	 *           "payment_id": "123456789012345678",
	 *           "payment_purpose": "Paying for goods/services",
	 *           "payment_scheme": "FPS",
	 *           "payment_type": "Credit",
	 *           "processing_date": "2017-01-18",
	 *           "reference": "Payment for Em's piano lessons",
	 *           "scheme_payment_sub_type": "InternetBanking",
	 *           "scheme_payment_type": "ImmediatePayment",
	 
	 */
	
	@Id
	@GeneratedValue
	int attributesId;
	BigDecimal amount;
	String currency;
	String endToEndReference;
	int    numericReference;
	String paymentId;
	String paymentPurpose;
	String paymentScheme;       // Could this be a fixed range?
	String paymentType;         // fixed range?
	@JsonFormat(pattern="yyyy-MM-dd")
	Date   processingDate;
	String reference;
	String schemePaymentSubType;
	String schemePaymentType; 	// range?
	
	
	
	@OneToOne (cascade=CascadeType.ALL)
	@NotNull
	Beneficiary beneficiaryParty;
	
	@OneToOne(cascade=CascadeType.ALL)
	@NotNull
	Charges     chargesInformation;
	
	@OneToOne (cascade=CascadeType.ALL)
	@NotNull
	Debtor		debtorParty;
	
	@OneToOne (cascade=CascadeType.ALL)
	@NotNull
	Fx			fx;
	
	@OneToOne (cascade=CascadeType.ALL)
	@NotNull
	Sponsor		sponsorParty;

	public int getAttributesId() {
		return attributesId;
	}

	public void setAttributesId(int attributesId) {
		this.attributesId = attributesId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEndToEndReference() {
		return endToEndReference;
	}

	public void setEndToEndReference(String endToEndReference) {
		this.endToEndReference = endToEndReference;
	}

	public int getNumericReference() {
		return numericReference;
	}

	public void setNumericReference(int numericReference) {
		this.numericReference = numericReference;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentPurpose() {
		return paymentPurpose;
	}

	public void setPaymentPurpose(String paymentPurpose) {
		this.paymentPurpose = paymentPurpose;
	}

	public String getPaymentScheme() {
		return paymentScheme;
	}

	public void setPaymentScheme(String paymentScheme) {
		this.paymentScheme = paymentScheme;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(Date processingDate) {
		this.processingDate = processingDate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getSchemePaymentSubType() {
		return schemePaymentSubType;
	}

	public void setSchemePaymentSubType(String schemePaymentSubType) {
		this.schemePaymentSubType = schemePaymentSubType;
	}

	public String getSchemePaymentType() {
		return schemePaymentType;
	}

	public void setSchemePaymentType(String schemePaymentType) {
		this.schemePaymentType = schemePaymentType;
	}@NotNull

	
	public Beneficiary getBeneficiaryParty() {
		return beneficiaryParty;
	}

	public void setBeneficiaryParty(Beneficiary beneficiary) {
		this.beneficiaryParty = beneficiary;
	}

	public Charges getChargesInformation() {
		return chargesInformation;
	}

	public void setChargesInformation(Charges charges) {
		this.chargesInformation = charges;
	}

	public Debtor getDebtorParty() {
		return debtorParty;
	}

	public void setDebtorParty(Debtor debtor) {
		this.debtorParty = debtor;
	}

	public Fx getFx() {
		return fx;
	}

	public void setFx(Fx fx) {
		this.fx = fx;
	}

	public Sponsor getSponsorParty() {
		return sponsorParty;
	}

	public void setSponsorParty(Sponsor sponsor) {
		this.sponsorParty = sponsor;
	}
	
	
	
}
