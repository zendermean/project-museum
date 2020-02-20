package services;

import entity.Author;
import entity.Material;
import entity.Room;
import entity.Worker;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateService {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(Material.class);
            configuration.addAnnotatedClass(Worker.class);
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Room.class);

            Properties properties = new Properties();
            properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

            properties.put("hibernate.connection.url", "jdbc:mysql://db4free.net:3306/museum5");
            properties.put("hibernate.connection.username", "taras1111");
            properties.put("hibernate.connection.password", "taras1111");
            properties.put("hibernate.current_session_context_class", "thread");

            configuration.setProperties(properties);

            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}
