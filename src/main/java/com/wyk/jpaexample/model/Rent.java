package com.wyk.jpaexample.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(RentId.class) //Tem id composto assim tem que colocar essa anotação e declarar os ids na classe indicada
public class Rent {

	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "property_id")
	private Property property;
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tenant_id")
	private Tenant tenant;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date contract;

	@Enumerated(EnumType.STRING) //O default é ORDINAL, nesse caso vai ser salvo o nome do enum no banco
	private StatusRent statusRent;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Date getContract() {
		return contract;
	}

	public void setContract(Date contract) {
		this.contract = contract;
	}

	public StatusRent getStatusRent() {
		return statusRent;
	}

	public void setStatusRent(StatusRent statusRent) {
		this.statusRent = statusRent;
	}
	
}
