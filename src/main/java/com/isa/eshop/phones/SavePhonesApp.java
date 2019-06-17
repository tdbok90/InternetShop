package com.isa.eshop.phones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.UUID;

public class SavePhonesApp {
    public static void main(String[] args) {
        // stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        // wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        //  wczytanie adnotacji
        conf.addAnnotatedClass(Phone.class);
        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        // pobranie sesji
         Session session =factory.getCurrentSession();
        // stworzenie obiektu
        Phone phone = new Phone();
        UUID uuid = UUID.randomUUID();
        phone.setId(uuid);

        // rozpoczecie transakcji

        // zapisanie pracownka

        // zakonczenie transakcji

        // zamkniecie obiektu SessionFactory
    }
}
