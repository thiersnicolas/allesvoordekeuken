package be.vdab.services;

import javax.persistence.EntityManager;

import be.vdab.filters.JPAFilter;

public abstract class AbstractService {
	
	EntityManager getEntityManagers() {
		return JPAFilter.getEntityManager();
	}
	
	void beginTransaction() {
		getEntityManagers().getTransaction().begin();
	}
	
	void commit() {
		getEntityManagers().getTransaction().commit();
	}
	
	void rollback() {
		getEntityManagers().getTransaction().rollback();
	}
}
