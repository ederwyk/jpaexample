package com.wyk.jpaexample.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * 
 * Classe de id composto
 * Deve implementar serializable
 * Deve ter construtor publico sem parametros
 * Deve sobrercrever os metos equals e hashcode
 * 
 */
@Embeddable
public class PaymentId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long transaction;
	
	private Long seller;

	public PaymentId() {}
	
	public Long getTransaction() {
		return transaction;
	}

	public void setTransaction(Long transaction) {
		this.transaction = transaction;
	}

	public Long getSeller() {
		return seller;
	}

	public void setSeller(Long seller) {
		this.seller = seller;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		result = prime * result + ((transaction == null) ? 0 : transaction.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentId other = (PaymentId) obj;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		if (transaction == null) {
			if (other.transaction != null)
				return false;
		} else if (!transaction.equals(other.transaction))
			return false;
		return true;
	}
	
}
