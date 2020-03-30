package com.wyk.jpaexample.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Property {

	private Long id;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",
		column=@Column(name="adress_id")) //Para evitar conflito de atributos com o mesmo nome
		})
	private Address adress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
