package repository;

import entity.Author;
import entity.Exhibit;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.util.Arrays;
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

    public List<Exhibit> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT E FROM Exhibit E";
        Query query = session.createQuery(hql, Exhibit.class);

        List<Exhibit> list = query.getResultList();
        logger.info("Getted - " + list.toString());

        session.getTransaction().commit();
        session.close();

        return list;
    }

    public List<Object[]> exhibitsByRoom() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT e.name, r.floor, r.number FROM Exhibit e " +
                "INNER JOIN Room r on e.room = r.id ORDER BY r.id DESC";
        Query query = session.createQuery(hql);

        List<Object[]> results = query.getResultList();
        logger.info("Name of Exhibit\t floor and\tnumber of room");
        for (Object[] arr : results) {
            logger.info(Arrays.toString(arr));
        }
        session.getTransaction().commit();
        session.close();

        return results;
    }

    public List<Object[]> exhibitsByAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT e.name, r.floor, r.number " +
                "FROM (SELECT ex.name as name, ex.room as room FROM Exhibit ex JOIN ex.authors a WHERE a.id = :id) e " +
                "INNER JOIN Room r on e.room = r.id ";
        Query query = session.createQuery(hql);
        query.setParameter("id", author.getId());

        List<Object[]> results = query.getResultList();
        logger.info("Name of Exhibit\t floor and\tnumber of room");
        for (Object[] arr : results) {
            logger.info(Arrays.toString(arr));
        }
        session.getTransaction().commit();
        session.close();

        return results;
    }
}
