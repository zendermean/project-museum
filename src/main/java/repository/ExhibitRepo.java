package repository;

import entity.Author;
import entity.Exhibit;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExhibitRepo extends Repo {

    final static Logger logger = Logger.getLogger(ExhibitRepo.class);

    public Exhibit getByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT E FROM Exhibit E WHERE E.name = :name";
        Query query = session.createQuery(hql, Exhibit.class);
        query.setParameter("name", name);

        Exhibit exhibit = (Exhibit) query.uniqueResult();
        logger.info("Getted - " + exhibit.toString());

        session.getTransaction().commit();
        session.close();

        return exhibit;
    }

    public Exhibit getById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT E FROM Exhibit E WHERE E.id = :id";
        Query query = session.createQuery(hql, Exhibit.class);
        query.setParameter("id", id);

        Exhibit exhibit = (Exhibit) query.uniqueResult();
        logger.info("Getted - " + exhibit.toString());

        session.getTransaction().commit();
        session.close();

        return exhibit;
    }

    public List<Exhibit> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT e FROM Exhibit e";
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
                "JOIN e.room r ORDER BY r.id DESC";
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

    public List<Exhibit> exhibitsByAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT e FROM Exhibit e JOIN e.authors a WHERE a.id = :id ";
        Query query = session.createQuery(hql, Exhibit.class);
        query.setParameter("id", author.getId());

        List<Exhibit> results = query.getResultList();
        for (Exhibit exhibit : results) {
            logger.info(exhibit.toString());
        }
        session.getTransaction().commit();
        session.close();

        return results;
    }

    public Set<Exhibit> exhibitsByWorkerName(String workerName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT e FROM Exhibit e " +
                "JOIN e.room r JOIN r.excursions ex " +
                "JOIN ex.worker w WHERE w.name = :name";
        Query query = session.createQuery(hql, Exhibit.class);
        query.setParameter("name", workerName);

        Set<Exhibit> results = new HashSet<>(query.getResultList());

        logger.info("Getted - " + results.toString());

        session.getTransaction().commit();
        session.close();

        return results;
    }
}
