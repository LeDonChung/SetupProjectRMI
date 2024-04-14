package com.donchung.server.dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import com.donchung.server.dao.PersonDAO;
import com.donchung.server.entities.Person;
import com.donchung.server.utils.AppUtils;

public class PersonDAOImpl extends UnicastRemoteObject implements PersonDAO  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonDAOImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Person> findAll() throws RemoteException {
		try (var em = AppUtils.getEntityManager()) {
			return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
		}
	}

	@Override
	public Person save(Person person) {
		try (var em = AppUtils.getEntityManager()) {
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
			return person;
		}
	}
}
