package com.wyk.jpaexample;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import com.wyk.jpaexample.connection.ConnectionFactory;
import com.wyk.jpaexample.model.Customer;

public class JPQL {
	
	/**
	 * "select c from Customer c where c.name = lower(:name)";
	 * "select c from Customer c where c.name = trim(:name)";
	 * "select c from Customer c where c.name = upper(:name)";
	 * "select lenght(c.name) from Customer c order by c.age";
	 * "select count(c.name) from Customer c";
	 * "select max(c.name) from Customer c";
	 * MOD //resto da divisão
	 * SQRT //reiz quadrada
	 * AVG //media
	 * SUBSTRING(a.name, 1, 3)
	 * select c from Customer c where c.name is not empty
	 * select c from Customer c where c.name is empty
	 * select c from Customer c where c.name between 'b' and 'd'
	 * select c from Customer c where c.name = concat(:firstName, :lastName)
	 * select c from Customer c where c.birthday < CURRENT_DATE
	 */

	public List<Customer> getCustomersByName(String name){
		
		String query = "select c from Customer c where c.name = lower(:name)";
		TypedQuery<Customer> typedQuery = ConnectionFactory.getEntityManager().createQuery(query, Customer.class);
		typedQuery.setParameter("name", name);
		typedQuery.setFirstResult(5);
		typedQuery.setMaxResults(10);
		return typedQuery.getResultList();
	}
	
	public Customer getCustomerByAge(List<Integer> ages) throws NoResultException, NonUniqueResultException{
		String query = "select c from Customer c where c.age in(:age)";
		TypedQuery<Customer> typedQuery = ConnectionFactory.getEntityManager().createQuery(query, Customer.class);
		typedQuery.setParameter("age", ages);
		return typedQuery.getSingleResult();
	}
	
	public Customer getCustomerByName(String name){
		String query = "select c from Customer c where c.name = like(:name)";
		TypedQuery<Customer> typedQuery = ConnectionFactory.getEntityManager().createQuery(query, Customer.class);
		typedQuery.setParameter("name", "%" + name + "%");
		return typedQuery.getSingleResult();
	}
	
	public Object[] getMinAndMaxAge() {
		String query = "SELECT max(c.age), min(c.age) FROM Customer c";
		TypedQuery<Object[]> typedQuery = ConnectionFactory.getEntityManager().createQuery(query, Object[].class);
		Object[] result = typedQuery.getSingleResult();
		//result[0] -> max age
		//result[1] -> min age
		return result;
	}
	
	public Number getCustomerCount() {
		String query = "SELECT COUNT(c) FROM Customer c";
		TypedQuery<Number> typedQuery = ConnectionFactory.getEntityManager().createQuery(query, Number.class);
		Number result = typedQuery.getSingleResult();
		return result;
	}
	
}
