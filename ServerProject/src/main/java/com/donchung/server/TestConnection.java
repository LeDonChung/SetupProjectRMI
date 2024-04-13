package com.donchung.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.donchung.server.utils.AppUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class TestConnection {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
    	EntityManager em = Persistence.createEntityManagerFactory(AppUtils.PERSISTENCE_UNIT_NAME).createEntityManager();
		em.getTransaction().begin();
		em.getTransaction().commit();
    }
}