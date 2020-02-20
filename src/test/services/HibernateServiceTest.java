package services;

import entity.*;
import entity.enums.Positions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HibernateServiceTest {
    @Test
    public void testSessionBuilder() {
        SessionFactory sessionFactory = HibernateService.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }

    @Test
    public void testMaterials() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Material material = new Material((long) 1, "Carbon", new ArrayList<Exhibit>());
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
        Worker worker = new Worker((long) 1, Positions.TOURGUIDE, "Taras", "Kovaliv");
        System.out.println(worker.toString());
        session.save(worker);
        session.delete(worker);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testAuthor() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Author author = new Author((long) 1, "Taras", "Kovaliv", new ArrayList<Exhibit>());
        System.out.println(author.toString());
        session.save(author);
        session.delete(author);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testRoom() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Room room = new Room((long) 1, 305, 3, new ArrayList<Exhibit>());
        System.out.println(room.toString());
        session.save(room);
        session.delete(room);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testExhibit() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Material material = new Material((long) 1, "Carbon", new ArrayList<Exhibit>());
        Author author = new Author((long) 1, "Taras", "Kovaliv", new ArrayList<Exhibit>());
        Room room = new Room((long) 1, 305, 3, new ArrayList<Exhibit>());
        Exhibit exhibit = new Exhibit((long) 1, "Екпонат", material, author, room);
        System.out.println(material.toString());
        System.out.println(author.toString());
        System.out.println(room.toString());
        System.out.println(exhibit.toString());
        session.save(material);
        session.save(author);
        session.save(room);
        session.save(exhibit);
        session.delete(exhibit);
        session.delete(material);
        session.delete(author);
        session.delete(room);
        session.getTransaction().commit();
        session.close();
    }
}