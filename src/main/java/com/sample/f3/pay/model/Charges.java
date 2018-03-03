package com.sample.f3.pay.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/*
 * Looks like a potential array for currency
 * So use another table and map it
 * 
 * Have to use @cacheable false. Updated were not being returned on saveandflush or save
 */

@Entity
@Table (name="charges")
@Cacheable(false)
public class Charges {
/*
 * 			"charges_information": {
 *                   "bearer_code": "SHAR",
 *                   "receiver_charges_amount": "1.00",
 *                   "receiver_charges_currency": "USD",
 *                   "sender_charges": [
 *                       {
 *                           "amount": "5.00",
 *                           "currency": "GBP"
 *                       },
 *                       {
 *                           "amount": "10.00",
 *                           "currency": "USD"
 *                       }
 *                   ]
 *               },
 */
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	int chargesId;
	
	String bearerCode; 
	BigDecimal receiverChargesAmount;
	String receiverChargesCurrency;
	
	@OneToMany(mappedBy = "charges",cascade=CascadeType.ALL)
	
	List<ChargeItem> senderCharges=null;

	public int getChargesId() {
		return chargesId;
	}

	public void setChargesId(int chargesId) {
		this.chargesId = chargesId;
	}

	public String getBearerCode() {
		return bearerCode;
	}

	public void setBearerCode(String bearerCode) {
		this.bearerCode = bearerCode;
	}

	public BigDecimal getReceiverChargesAmount() {
		return receiverChargesAmount;
	}

	public void setReceiverChargesAmount(BigDecimal receiverChargesAmount) {
		this.receiverChargesAmount = receiverChargesAmount;
	}

	public String getReceiverChargesCurrency() {
		return receiverChargesCurrency;
	}

	public void setReceiverChargesCurrency(String receiverChargesCurrency) {
		this.receiverChargesCurrency = receiverChargesCurrency;
	}

	public List<ChargeItem> getSenderCharges() {
		return senderCharges;
	}

	//public void setSenderCharges(List<ChargeItem> chargeItems) {
	//	this.senderCharges = chargeItems;
	//}
	public void addSenderCharges (ChargeItem chargeItem)
	{
		if (senderCharges==null)
			 senderCharges = new ArrayList <ChargeItem>();
		chargeItem.setCharges(this);
		senderCharges.add(chargeItem);
		//chargeItem.setCharges(this);
		
	}
	public void chargeItemReset ()
	{
		for (ChargeItem ci : senderCharges)
		{
			ci.setCharges(this);
		}
	}
	
	
	
}
