package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.service.ServiceRegistry;
// import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.*;


public class Util {
    public static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/testbase";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static Configuration configuration;
    private static SessionFactory sessionFactory;


    // Настройки Hibernate
    private static Configuration hibernateConfiguration() {
        Configuration configuration = new Configuration();
        configuration
                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.url", URL)
                .setProperty("hibernate.connection.username", LOGIN)
                .setProperty("hibernate.connection.password", PASSWORD)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.show_sql", "true");
        return configuration;
    }

    private static SessionFactory buildSessionFactory() {
        configuration = hibernateConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.addAnnotatedClass(User.class).buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }


// ******************* JDBC version *************************
    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void disconnect() {
        try {
            if (connection != null)
                if (!connection.isClosed())
                    connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}