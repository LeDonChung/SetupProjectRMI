package com.donchung.server;

import com.donchung.server.dao.PersonDAO;
import com.donchung.server.dao.impl.PersonDAOImpl;
import com.donchung.server.utils.AppUtils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException, NamingException {
    	
    	// Test find all persons	
    	PersonDAO personDAO = new PersonDAOImpl();
    	personDAO.findAll().forEach(System.out::println);
        LocateRegistry.createRegistry(23861);

        Context context = new InitialContext();


        context.rebind(AppUtils.SERVER_URL + "personDAO", personDAO);

        System.out.println("Server is running...: " + 23861);
    }
}
