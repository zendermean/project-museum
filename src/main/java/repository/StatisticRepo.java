package repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.util.Arrays;
import java.util.List;

public class StatisticRepo extends Repo {

    final static Logger logger = Logger.getLogger(StatisticRepo.class);

    public List<Object[]> exhibitByTechnique() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT count(e.id), t.name FROM Exhibit e " +
                "INNER JOIN Technique t on e.technique = t.id " +
                "GROUP BY t.name ORDER BY count(e.id) DESC";
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

}
