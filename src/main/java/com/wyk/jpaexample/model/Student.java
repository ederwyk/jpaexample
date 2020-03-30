package com.wyk.jpaexample.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//@NamedQuery(name = Student.FIND_BY_NAME, query = "select s from s where name = :name")
@NamedQueries({
	@NamedQuery(name = Student.FIND_BY_NAME, query = "select s from s where name = :name"),
	@NamedQuery(name = Student.FIND_BY_AGE, query = "select s from s where age = :age")
})
public class Student {

	public static final String FIND_BY_NAME = "Student.FindByName";
	public static final String FIND_BY_AGE = "Student.FindByAge";
	
	//other things
}
