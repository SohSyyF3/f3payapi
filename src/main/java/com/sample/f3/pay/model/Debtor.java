package com.sample.f3.pay.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 			"debtor_party": {
 *                   "account_name": "EJ Brown Black",
 *                   "account_number": "GB29XABC10161234567801",
 *                   "account_number_code": "IBAN",
 *                   "address": "10 Debtor Crescent Sourcetown NE1",
 *                   "bank_id": "203301",
 *                   "bank_id_code": "GBDSC",
 *                   "name"	: "Emelia Jane Brown"
 *               			},
 */
@Entity
@Table (name="Debtor")
public class Debtor 
{
	@Id
	@GeneratedValue
	long debtorId;
	
	String accountName; 		// Name on account
    String accountNumber;	  	// Account number 
    String accountNumberCode; 	// Account number code - e.g IBAN
    String address;				// Address of receiver
    String bankId;				// Bank ID - possibly known codes only?
    String bankIdCode;			// Bank's ID code
    String name;				// person name

	public long getDebtorId() {
		return debtorId;
	}
	public void setDebtorId(long debtorId) {
		this.debtorId = debtorId;
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
