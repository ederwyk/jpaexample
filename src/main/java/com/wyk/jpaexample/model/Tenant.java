package com.wyk.jpaexample.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("tenant")
public class Tenant extends Person {
	
}
