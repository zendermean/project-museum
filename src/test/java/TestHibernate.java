import entity.*;
import entity.enums.Positions;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import repository.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestHibernate {
    private Repo repo = new Repo();

    final static Logger logger = Logger.getLogger(TestHibernate.class);

    @Test
    public void testMaterials() {
        Material material = getMaterial();
        logger.info(material.toString());

        repo.save(material);
        repo.delete(material);
    }

    @Test
    public void testWorker() {
        Worker worker = getWorker();
        logger.info(worker.toString());

        repo.save(worker);

        WorkerRepo workerRepo = new WorkerRepo();
        logger.info(workerRepo.getTourguides().toString());

        repo.delete(worker);
    }

    @Test
    public void testAuthor() {
        AuthorRepo authorRepo = new AuthorRepo();
        Author author = getAuthor();
        logger.info(author.toString());

        repo.save(author);

        try {
            Author author1 = authorRepo.getByNameAndSurname(author.getName(), author.getSurname());
            logger.info(author1.toString());
            author1 = authorRepo.getById(author1.getId());
            logger.info(author1.toString());
        } finally {
            repo.delete(author);
        }
    }

    @Test
    public void testRoom() {
        Room room = getRoom();
        logger.info(room.toString());

        repo.save(room);
        room.setFloor(2);
        repo.update(room);
        repo.delete(room);
    }

    @Test
    public void testExhibit() {
        ExhibitRepo exhibitRepo = new ExhibitRepo();
        List<Material> list = new ArrayList<>();
        List<Author> authors = new ArrayList<>();

        Technique technique = getTechnique();
        authors.add(getAuthor());
        list.add(getMaterial());
        Room room = getRoom();

        Exhibit exhibit = new Exhibit((long) 1, "Екпонат", list, authors, room, technique);

        logger.info(exhibit.toString());

        repo.save(authors.get(0));
        repo.save(list.get(0));
        repo.save(technique);
        repo.save(room);
        repo.save(exhibit);
        try {
            StatisticRepo statisticRepo = new StatisticRepo();
            List<Object[]> results = statisticRepo.exhibitByTechnique();
            for (Object[] arr : results) {
                logger.info(Arrays.toString(arr));
            }

            results = statisticRepo.exhibitByMaterial();
            for (Object[] arr : results) {
                logger.info(Arrays.toString(arr));
            }

            results = exhibitRepo.exhibitsByRoom();
            for (Object[] arr : results) {
                logger.info(Arrays.toString(arr));
            }

//            AuthorRepo authorRepo = new AuthorRepo();
//            Author author = authorRepo.getByNameAndSurname(authors.get(0).getName(), authors.get(0).getSurname());
//            results = exhibitRepo.exhibitsByAuthor(author);
//            for (Object[] arr : results) {
//                logger.info(Arrays.toString(arr));
//            }

//            Exhibit exhibit1 = exhibitRepo.getByName(exhibit.getName());
//            logger.info(exhibit1.toString());
//            logger.info(exhibitRepo.getById(exhibit1.getId()));

        } finally {
            repo.delete(exhibit);
            repo.delete(authors.get(0));
            repo.delete(list.get(0));
            repo.delete(technique);
            repo.delete(room);
        }
    }

    @Test
    public void testExcursion() {

        List<Room> rooms = new ArrayList<>();
        Worker worker = getWorker();
        rooms.add(getRoom());

        Excursion excursion = new Excursion((long) 1, "Екскурсія", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), worker, rooms);
        logger.info(excursion.toString());

        repo.save(rooms.get(0));
        repo.save(worker);
        repo.save(excursion);

        repo.delete(excursion);
        repo.delete(rooms.get(0));
        repo.delete(worker);
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

    public static Technique getTechnique() {
        return new Technique((long) 1, "Gotic", new ArrayList<Exhibit>());
    }

}
