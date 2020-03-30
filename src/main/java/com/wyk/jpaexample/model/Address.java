package com.wyk.jpaexample.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private Long id;
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
