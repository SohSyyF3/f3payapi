package com.sample.f3.pay.model;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 *				Attributes
     *           "id": "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43",
	 *           "organisation_id": "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb",
	 *           "type": "Payment",
	 *           "version": 0
 */


@Entity
@Table (name="payment")
@Cacheable(false)
public class Payment {
	
	@Id
	@GeneratedValue
	int paymentId;
	@NotNull
	String id; 					//length
	@NotNull
	String organisationId; 		//length
	@NotNull
	String type; 				//range
	@NotNull
	String version;
	
	@OneToOne (cascade=CascadeType.ALL)
	@NotNull
	Attributes attributes;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(String organisationId) {
		this.organisationId = organisationId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

}
