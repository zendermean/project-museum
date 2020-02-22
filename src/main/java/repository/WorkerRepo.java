package repository;

import entity.Worker;
import entity.enums.Positions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.util.List;

public class WorkerRepo extends Repo {

    final static Logger logger = Logger.getLogger(WorkerRepo.class);

    public Worker getById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT w FROM Worker w WHERE w.id = :id";
        Query query = session.createQuery(hql, Worker.class);
        query.setParameter("id", id);

        Worker worker = (Worker) query.uniqueResult();
        logger.info("Getted -" + worker.toString());

        session.getTransaction().commit();
        session.close();

        return worker;
    }

    public Worker getByNameAndSurname(String name, String surname) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT w FROM Worker w WHERE w.name = :name AND w.surname = :surname";
        Query query = session.createQuery(hql, Worker.class);
        query.setParameter("surname", surname);
        query.setParameter("name", name);

        Worker worker = (Worker) query.uniqueResult();
        logger.info("Getted -" + worker.toString());

        session.getTransaction().commit();
        session.close();

        return worker;
    }

    public List<Worker> getTourguides() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "FROM Worker w WHERE w.position = '" + Positions.TOURGUIDE.ordinal() + "'";
        Query query = session.createQuery(hql, Worker.class);

        List<Worker> results = query.getResultList();
        logger.info("Getted" + results.toString());

        session.getTransaction().commit();
        session.close();

        return results;
    }

}
