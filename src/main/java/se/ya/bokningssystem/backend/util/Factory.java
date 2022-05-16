package se.ya.bokningssystem.backend.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {

    public static SessionFactory getFactory(){
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
}
