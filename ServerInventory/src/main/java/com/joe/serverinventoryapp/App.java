/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.serverinventoryapp;

import com.joe.serverinventory.dao.ServerDao;
import com.joe.serverinventory.dao.ServerDaoInMemImpl;
import com.joe.serverinventory.dto.Server;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author joe
 */
public class App {

    public static void main(String[] args) {
        ServerDao dao = new ServerDaoInMemImpl();

        //create several Servers to manipulate
        Server myServer = new Server();
        myServer.setName("web01");
        myServer.setIp("192.168.1.1");
        myServer.setManufacturer("Dell");
        myServer.setRam(8);
        myServer.setNumProcessors(9);
        myServer.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));

        dao.addServer(myServer);

        //create several Servers to manipulate
        myServer = new Server();
        myServer.setName("db01");
        myServer.setIp("192.168.3.45");
        myServer.setManufacturer("HP");
        myServer.setRam(16);
        myServer.setNumProcessors(24);
        myServer.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));

        dao.addServer(myServer);

        //create several Servers to manipulate
        myServer = new Server();
        myServer.setName("hr124");
        myServer.setIp("192.168.32.111");
        myServer.setManufacturer("IBM");
        myServer.setRam(16);
        myServer.setNumProcessors(12);
        myServer.setPurchaseDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));

        dao.addServer(myServer);

        //create several Servers to manipulate
        myServer = new Server();
        myServer.setName("eng16");
        myServer.setIp("192.168.32.56");
        myServer.setManufacturer("HP");
        myServer.setRam(4);
        myServer.setNumProcessors(8);
        myServer.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        dao.addServer(myServer);

        //create several Servers to manipulate
        myServer = new Server();
        myServer.setName("eng64");
        myServer.setIp("192.168.34.56");
        myServer.setManufacturer("HP");
        myServer.setRam(8);
        myServer.setNumProcessors(16);
        myServer.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        dao.addServer(myServer);

        List<Server> dells = dao.getServersByManufacturer("Dell");
        for (Server currentServer : dells) {
            System.out.println(currentServer.getName());
        }
        dells.stream()
                .forEach(s -> System.out.println(s.getName()));

        Map<String, List<Server>> serverMap = dao.getAllServersGroupByManufacturer();

        Set<String> manufacturers = serverMap.keySet();

        manufacturers.stream()
                .forEach(name -> {
                    System.out.println("==================");
                    System.out.println("Manufactur: " + name);
                    serverMap.get(name).stream().forEach(s -> System.out.println(s.getName()));
                });
    }
}
