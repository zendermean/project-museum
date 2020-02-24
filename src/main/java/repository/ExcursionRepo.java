package repository;

import entity.Excursion;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.List;

public class ExcursionRepo extends Repo {

    public List<Excursion> getExcursions(Timestamp from, Timestamp to) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT e FROM Excursion e " +
                "WHERE e.time_start >= :from AND e.time_end <= :to";
        Query query = session.createQuery(hql, Excursion.class);
        query.setParameter("from", from);
        query.setParameter("to", to);

        List<Excursion> results = query.getResultList();
        logger.info("Excursions from " + from.toString() + " to " + to.toString() + " \nIs " + results.toString());
        session.getTransaction().commit();
        session.close();

        return results;
    }

    public Long countExcursions(Timestamp from, Timestamp to) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT count(e.id) FROM Excursion e " +
                "WHERE e.time_start >= :from AND e.time_end <= :to";
        Query query = session.createQuery(hql);
        query.setParameter("from", from);
        query.setParameter("to", to);

        Long result = (Long) query.uniqueResult();
        logger.info("Count excursions from " + from.toString() + " to " + to.toString() + " is " + result.toString());
        session.getTransaction().commit();
        session.close();

        return result;
    }
}
