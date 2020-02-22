package repository;

import entity.Exhibit;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.util.List;

public class ExhibitRepo extends Repo {

    final static Logger logger = Logger.getLogger(ExhibitRepo.class);

    public Exhibit getByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT E FROM Exhibit E WHERE E.name = '" + name + "'";
        Query query = session.createQuery(hql, Exhibit.class);

        Exhibit exhibit = (Exhibit) query.uniqueResult();
        logger.info("Getted - " + exhibit.toString());

        session.getTransaction().commit();
        session.close();

        return exhibit;
    }

    public Exhibit getById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT E FROM Exhibit E WHERE E.id = '" + id + "'";
        Query query = session.createQuery(hql, Exhibit.class);

        Exhibit exhibit = (Exhibit) query.uniqueResult();
        logger.info("Getted - " + exhibit.toString());

        session.getTransaction().commit();
        session.close();

        return exhibit;
    }

    public List<Object[]> exhibitsByRoom() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT e.name, r.floor, r.number FROM Exhibit e INNER JOIN Room r on e.room = r.id ORDER BY r.id DESC";
        Query query = session.createQuery(hql);

        List<Object[]> results = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return results;
    }
}
