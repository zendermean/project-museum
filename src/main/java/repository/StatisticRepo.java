package repository;

import entity.enums.Positions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class StatisticRepo extends Repo {

    final static Logger logger = Logger.getLogger(StatisticRepo.class);

    public List<Object[]> exhibitByTechnique() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT count(e.id), t.name FROM Exhibit e " +
                "JOIN e.technique t GROUP BY t.name ORDER BY count(e.id) DESC";
        Query query = session.createQuery(hql);

        List<Object[]> results = query.getResultList();
        logger.info("Count of Exhibit \tName of Technique");
        for (Object[] arr : results) {
            logger.info(Arrays.toString(arr));
        }

        session.getTransaction().commit();
        session.close();

        return results;
    }

    public List<Object[]> exhibitByMaterial() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT count(e.id), m.name FROM Exhibit e " +
                "JOIN e.materials m GROUP BY m.name ORDER BY count(e.id) DESC";
        Query query = session.createQuery(hql);

        List<Object[]> results = query.getResultList();
        logger.info("Count of Exhibit \tName of Material");
        for (Object[] arr : results) {
            logger.info(Arrays.toString(arr));
        }

        session.getTransaction().commit();
        session.close();

        return results;
    }

    public List<Object[]> tourGuideStatisticsByNumberOfExcursions() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT count(e.id), w.name FROM Excursion e " +
                "JOIN e.worker w WHERE w.position = :position" +
                " GROUP BY w.id ORDER BY count(e.id) DESC";

        Query query = session.createQuery(hql);
        query.setParameter("position", Positions.TOURGUIDE);

        List<Object[]> results = query.getResultList();

        logger.info("Count of Excursion\tWorker name");
        for (Object[] arr : results) {
            logger.info(Arrays.toString(arr));
        }

        session.getTransaction().commit();
        session.close();

        return results;
    }

    public List<Object[]> totalWorkingTimeByEachWorker(Timestamp from, Timestamp to) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(e.time_end)) " +
                "- SUM(TIME_TO_SEC(e.time_start))), " +
                "w.name FROM Excursion e " +
                "JOIN e.worker w WHERE w.position = :position AND " +
                "e.time_start >= :from AND e.time_end <= :to GROUP BY w.id";

        Query query = session.createQuery(hql);
        query.setParameter("position", Positions.TOURGUIDE);
        query.setParameter("from", from);
        query.setParameter("to", to);

        List<Object[]> results = query.getResultList();

        logger.info("Total time of work\tWorker name");
        for (Object[] arr : results) {
            logger.info(Arrays.toString(arr));
        }

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
