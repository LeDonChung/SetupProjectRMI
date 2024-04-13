package com.donchung.server.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class AppUtils {
	public static final String PERSISTENCE_UNIT_NAME = "ServerProject MSSQL";
	public static final String SERVER_URL = "rmi://LAPTOP-646QQPK1:23861/";
	
	public static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }
}
