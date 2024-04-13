package com.donchung.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.donchung.server.dao.CourseService;

public class Main {
    public static final String URL = "rmi://LAPTOP-646QQPK1:23862/";
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        CourseService courseService = (CourseService) Naming.lookup(URL + "courseService");
        courseService.findAll().forEach(System.out::println);
    }
}