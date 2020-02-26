package repository;

import entity.Author;
import entity.Exhibit;
import entity.Worker;
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

        String hql = "SELECT e FROM Exhibit e WHERE e.id > 0";
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

    public List<Exhibit> exhibitsByAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT e FROM Exhibit e JOIN e.authors a WHERE a.id = :id ";
        Query query = session.createQuery(hql, Exhibit.class);
        query.setParameter("id", author.getId());

        List<Exhibit> results = query.getResultList();
        logger.info("Name of Exhibit\t floor and\tnumber of room");
        for (Exhibit exhibit : results) {
            logger.info(exhibit.toString());
        }
        session.getTransaction().commit();
        session.close();

        return results;
    }

    public List<Exhibit> exhibitsByWorkerName(String workerName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql2 = "SELECT e.id,e.name,r.number as room_number,w.name FROM exhibits e\n" +
                "INNER JOIN rooms r on e.room_id = r.id\n" +
                "INNER JOIN excursion_room er on r.id = er.room_id\n" +
                "INNER JOIN excursions ex on er.excursion_id = ex.id\n" +
                "INNER JOIN workers w on ex.worker_id = w.id WHERE w.name = '" + workerName + "'";

        String hql = "SELECT e.id,e.name,w.name FROM Exhibit e " +
                "INNER JOIN rooms r on e.room = r.id " +
                "INNER JOIN r.excursions ex on ex.room_id = r.id " +
                "INNER JOIN Worker w on w.id = :id WHERE w.name = '" + workerName + "'";
        Query query = session.createQuery(hql, Exhibit.class);
        //query.setParameter("name", worker.getName());

        List<Exhibit> results = query.getResultList();

        logger.info("Getted - " + results.toString());

        session.getTransaction().commit();
        session.close();

        return results;
    }
}
