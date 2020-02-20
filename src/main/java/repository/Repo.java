package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import services.HibernateService;

public class Repo {

    private SessionFactory sessionFactory;

    public Repo() {
        sessionFactory = HibernateService.getSessionFactory();
    }

    public void save(Object obj) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object obj) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Object obj) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
        session.close();
    }

}