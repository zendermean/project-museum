package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import services.HibernateService;

public class Repo {

    protected SessionFactory sessionFactory;

    final static Logger logger = Logger.getLogger(Repo.class);

    public Repo() {
        sessionFactory = HibernateService.getSessionFactory();
    }

    public void save(Object obj) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(obj);
        logger.info("Saved -" + obj.toString());

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object obj) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(obj);
        logger.info("Deleted -" + obj.toString());

        session.getTransaction().commit();
        session.close();
    }

    public void update(Object obj) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(obj);
        logger.info("Updated -" + obj.toString());

        session.getTransaction().commit();
        session.close();
    }

}