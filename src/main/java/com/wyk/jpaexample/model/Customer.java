package com.wyk.jpaexample.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Table(name = "customer") //Necessario somente se o nome no banco for diferente
@Entity
@DiscriminatorValue("customer")
public class Customer extends Person {

	@Transient
	private String metaTemp;

	public String getMetaTemp() {
		return metaTemp;
	}

	public void setMetaTemp(String metaTemp) {
		this.metaTemp = metaTemp;
	}
	
}
