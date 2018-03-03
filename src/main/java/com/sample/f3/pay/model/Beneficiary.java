package com.sample.f3.pay.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * Beneficiary part of the document
 * 
 * cacheable set to false, updates were not being returned
 */
@Entity
@Table (name="beneficiary")
@Cacheable(false)
public class Beneficiary {
	/*
	"beneficiary_party": {
    "account_name": "W Owens",
    "account_number": "31926819",
    "account_number_code": "BBAN",
    "account_type": 0,
    "address": "1 The Beneficiary Localtown SE2",
    "bank_id": "403000",
    "bank_id_code": "GBDSC",
    "name": "Wilfred Jeremiah Owens"
    */
	@Id
	@GeneratedValue
	int benId;
	
	String accountName;
	@NotNull
	String accountNumber;
	@NotNull
	String accountNumberCode;
	@NotNull
	String accountType;
	String address;
	@NotNull
	String bankId; 		//format - could be checked
	@NotNull
	String bankIdCode; 	//range - like currency from another table check
	String name;
	public int getBenId() {
		return benId;
	}
	public void setBenId(int benId) {
		this.benId = benId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumberCode() {
		return accountNumberCode;
	}
	public void setAccountNumberCode(String accountNumberCode) {
		this.accountNumberCode = accountNumberCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getBankIdCode() {
		return bankIdCode;
	}
	public void setBankIdCode(String bankIdCode) {
		this.bankIdCode = bankIdCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
