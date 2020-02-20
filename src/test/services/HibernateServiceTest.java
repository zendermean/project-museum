package services;

import entity.Material;
import entity.Worker;
import entity.enums.Positions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class HibernateServiceTest {
    @Test
    public void testSessionBuilder() {
        SessionFactory sessionFactory = HibernateService.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }

    @Test
    public void testMaterials(){
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Material material = new Material((long) 1, "Carbon");
        System.out.println(material.toString());
        session.save(material);
        session.delete(material);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testWorker() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Worker worker = new Worker((long)1, Positions.TOURGUIDE, "Taras", "Kovaliv");
        System.out.println(worker.toString());
        session.save(worker);
        session.delete(worker);
        session.getTransaction().commit();
        session.close();
    }
}