package com.wyk.jpaexample.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Payment {

	@EmbeddedId
	private PaymentId paymentid;

	public PaymentId getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(PaymentId paymentid) {
		this.paymentid = paymentid;
	}
	
}
