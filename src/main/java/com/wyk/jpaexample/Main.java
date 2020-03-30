package com.wyk.jpaexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.wyk.jpaexample.connection.ConnectionFactory;
import com.wyk.jpaexample.model.Customer;

public class Main {

	public static void main(String[] args) {
		
		EntityManager entityManager = ConnectionFactory.getEntityManager();
		
		try {
			Customer customer = new Customer();
			customer.setName("Fulano"); //Estado new ou transient pelo EntityManager
			
			entityManager.getTransaction().begin();
			entityManager.persist(customer); //Estado managed pelo EntityManager
			entityManager.getTransaction().commit(); //Fez o insert
			
			customer = entityManager.find(Customer.class, 1l);
			
			entityManager.getTransaction().begin();
			customer.setName("Fulano de tal");
			entityManager.getTransaction().commit(); //Fez o update
			
			Customer customer2 = new Customer();
			customer2.setId(1l);
			customer2.setName("Ciclano de tal");
			
			entityManager.getTransaction().begin();
			entityManager.merge(customer2);
			entityManager.getTransaction().commit(); //Fez update
			
			Customer customer3 = new Customer();
			customer3.setName("Beltrano de tal");
			
			entityManager.getTransaction().begin();
			entityManager.merge(customer3);
			entityManager.getTransaction().commit(); //Fez insert
			
			entityManager.getTransaction().begin();
			entityManager.remove(customer); //Estado removed pelo EntityManager
			entityManager.getTransaction().commit(); //Fez o remove
			
			entityManager.detach(customer3); //Estado detached pelo EntityManager, ou seja, não é mais gerenciado
			
			TypedQuery<Customer> customersQuery = entityManager.createQuery("from Customer c", Customer.class);
			customersQuery.setMaxResults(10);
			List<Customer> customers = customersQuery.getResultList();
			
			entityManager.close();
			
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
	
}
