package com.wyk.jpaexample;

import java.util.List;

import javax.persistence.Query;

import com.wyk.jpaexample.connection.ConnectionFactory;
import com.wyk.jpaexample.model.Student;

public class NativeQuery {

@SuppressWarnings("unchecked")
public List<Student> getCustomersByName(String name){
		
		Query query = ConnectionFactory.getEntityManager().createNativeQuery("select * from Student s where s.name = :name", Student.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
}
