 package com.sample.f3.pay.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

	/*
 	 * Entity representing the Sponsor information
  	 *
	 *      "sponsor_party": {
     *               "account_number": "56781234",
     *               "bank_id": "123123",
     *               "bank_id_code": "GBDSC"
     *                       }
     *           
	 * Assumption ? that Bank ID is a numeric code
	 * Assumption ? account is numeric code
	 */
	
@Entity
@Table (name="sponsor")
public class Sponsor {
	@Id
	@GeneratedValue
	private Long Sponsorid;
	@NotNull
	String accountNumber;  
	@NotNull
	String BankId;
	@NotNull
	String BankIdCode;
	
	
	public Long getSponsorid() {
		return Sponsorid;
	}
	public void setSponsorid(Long sponsorid) {
		Sponsorid = sponsorid;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankId() {
		return BankId;
	}
	public void setBankId(String bankId) {
		BankId = bankId;
	}
	public String getBankIdCode() {
		return BankIdCode;
	}
	public void setBankIdCode(String bankIdCode) {
		BankIdCode = bankIdCode;
	}

}
