package com.ketaetc.hibernate.example.config;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 */
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {

    private static HibernateConnector me;
    private Configuration cfg;
    private SessionFactory sessionFactory;

    private HibernateConnector() throws HibernateException {

        // build the config
        cfg = new Configuration();

        /**
         * Connection Information..
         */
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/");
        cfg.setProperty("hibernate.connection.username", "testuser");
        cfg.setProperty("hibernate.connection.password", "123456");
        cfg.setProperty("hibernate.show_sql", "true");

        /**
         * Mapping Resources..
         */
        cfg.addResource("com/ketaetc/hibernate/example/pojo/Student.hbm.xml");

        sessionFactory = cfg.buildSessionFactory();
    }

    public static synchronized HibernateConnector getInstance() throws HibernateException {
        if (me == null) {
            me = new HibernateConnector();
        }

        return me;
    }

    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }

    private void reconnect() throws HibernateException {
        this.sessionFactory = cfg.buildSessionFactory();
    }
}
