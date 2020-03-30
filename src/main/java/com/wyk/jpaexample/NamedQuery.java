package com.wyk.jpaexample;

import java.util.List;

import javax.persistence.TypedQuery;

import com.wyk.jpaexample.connection.ConnectionFactory;
import com.wyk.jpaexample.model.Student;

public class NamedQuery {

	public List<Student> getCustomersByName(String name){
		
		TypedQuery<Student> typedQuery = ConnectionFactory.getEntityManager().createNamedQuery(Student.FIND_BY_NAME, Student.class);
		typedQuery.setParameter("name", name);
		return typedQuery.getResultList();
	}
	
}
