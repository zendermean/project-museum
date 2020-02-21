package repository;

import entity.Worker;
import entity.enums.Positions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.util.List;

public class WorkerRepo extends Repo {

    final static Logger logger = Logger.getLogger(WorkerRepo.class);

    public List<Worker> getTourguides() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "FROM Worker w WHERE w.position = '" + Positions.TOURGUIDE.ordinal() + "'";
        Query query = session.createQuery(hql, Worker.class);

        List<Worker> results = query.getResultList();
        logger.info(results.toString());

        session.getTransaction().commit();
        session.close();

        return results;
    }
}
