package repository;

import entity.Worker;
import entity.enums.Positions;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class WorkerRepo extends Repo {

    public List<Worker> getTourguides() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Worker w WHERE w.position ='" + Positions.TOURGUIDE.ordinal() + "'";
        Query query = session.createQuery(hql);
        List<Worker> results = query.list();
        System.out.println(results.toString());
        session.getTransaction().commit();
        session.close();
        return results;
    }
}
