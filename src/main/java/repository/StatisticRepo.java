package repository;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StatisticRepo extends Repo {

    public List<Object[]> exhibitByTechnique() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT count(e.id), t.name FROM Exhibit e INNER JOIN Technique t on e.technique = t.id GROUP BY t.name";
        Query query = session.createQuery(hql);

        List<Object[]> results = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return results;
    }

}
