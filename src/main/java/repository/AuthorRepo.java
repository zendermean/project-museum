package repository;

import entity.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

public class AuthorRepo extends Repo {

    final static Logger logger = Logger.getLogger(AuthorRepo.class);

    public Author getById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT a FROM Author a WHERE a.id = :id";
        Query query = session.createQuery(hql, Author.class);
        query.setParameter("id", id);

        Author author = (Author) query.uniqueResult();
        logger.info("Getted -" + author.toString());

        session.getTransaction().commit();
        session.close();

        return author;
    }

    public Author getByNameAndSurname(String name, String surname) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = "SELECT a FROM Author a WHERE a.name = :name AND a.surname = :surname";
        Query query = session.createQuery(hql, Author.class);
        query.setParameter("surname", surname);
        query.setParameter("name", name);

        Author author = (Author) query.uniqueResult();
        logger.info("Getted -" + author.toString());

        session.getTransaction().commit();
        session.close();

        return author;
    }
}
