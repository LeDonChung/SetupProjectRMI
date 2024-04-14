package com.donchung.server.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.donchung.server.entities.Person;

public interface PersonDAO extends Remote{
	List<Person> findAll() throws RemoteException;
	Person save(Person person) throws RemoteException;
}
