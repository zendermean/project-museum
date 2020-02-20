import entity.*;
import entity.enums.Positions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import services.HibernateService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TestHibernate {

    @Test
    public void testSesionBuilder() {
        SessionFactory sessionFactory = HibernateService.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }

    @Test
    public void testMaterials() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Material material = getMaterial();
        System.out.println(material.toString());
        session.save(material);
        session.delete(material);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testWorker() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Worker worker = getWorker();
        System.out.println(worker.toString());
        session.save(worker);
        session.delete(worker);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testAuthor() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Author author = getAuthor();
        System.out.println(author.toString());
        session.save(author);
        session.delete(author);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testRoom() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Room room = getRoom();
        System.out.println(room.toString());
        session.save(room);
        session.delete(room);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testExhibit() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Material material = getMaterial();
        Author author = getAuthor();
        Room room = getRoom();
        Technique technique = getTechnique();
        List<Material> list = new ArrayList<>();
        list.add(material);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Exhibit exhibit = new Exhibit((long) 1, "Екпонат", list, authors, room, technique);
        System.out.println(material.toString());
        System.out.println(technique.toString());
        System.out.println(author.toString());
        System.out.println(room.toString());
        System.out.println(exhibit.toString());
        session.save(material);
        session.save(author);
        session.save(technique);
        session.save(room);
        session.save(exhibit);
        session.delete(exhibit);
        session.delete(material);
        session.delete(author);
        session.delete(technique);
        session.delete(room);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testExcursion() {
        Session session = HibernateService.getSessionFactory().openSession();
        session.beginTransaction();
        Worker worker = getWorker();
        Room room = getRoom();
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        Excursion excursion = new Excursion((long) 1, "Екскурсія", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), worker, rooms);
        System.out.println(excursion.toString());
        session.save(room);
        session.save(worker);
        session.save(excursion);
        session.delete(excursion);
        session.delete(worker);
        session.delete(room);
        session.getTransaction().commit();
        session.close();
    }

    public static Worker getWorker() {
        return new Worker((long) 1, Positions.TOURGUIDE, "Taras", "Kovaliv", new ArrayList<Excursion>());
    }

    public static Room getRoom() {
        return new Room((long) 1, 305, 3, new ArrayList<Exhibit>(), new ArrayList<Excursion>());
    }

    public static Author getAuthor() {
        return new Author((long) 1, "Taras", "Kovaliv", new ArrayList<Exhibit>());
    }

    public static Material getMaterial() {
        return new Material((long) 1, "Carbon", new ArrayList<Exhibit>());
    }

    public static Technique getTechnique(){
        return new Technique((long)1, "Gotic", new ArrayList<Exhibit>());
    }

}
