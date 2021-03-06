import entity.*;
import entity.enums.Positions;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import repository.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TestHibernate {
    private Repo repo = new Repo();

    final static Logger logger = Logger.getLogger(TestHibernate.class);

    @Test
    public void testMaterials() {
        Material material = getMaterial();
        material.equals(getMaterial());
        logger.info(material.toString() + material.hashCode());

        repo.save(material);
        repo.delete(material);
    }

    @Test
    public void testWorker() {
        Worker worker = getWorker();
        worker.equals(getWorker());
        logger.info(worker.toString() + hashCode());

        repo.save(worker);

        WorkerRepo workerRepo = new WorkerRepo();
        Worker worker1 = workerRepo.getByNameAndSurname(worker.getName(), worker.getSurname());
        logger.info(worker1);
        logger.info(workerRepo.getById(worker1.getId()));
        logger.info(workerRepo.getTourguides().toString());

        repo.delete(worker);
    }

    @Test
    public void testAuthor() {
        AuthorRepo authorRepo = new AuthorRepo();
        Author author = getAuthor();
        author.equals(getAuthor());
        logger.info(author.toString() + author.hashCode());

        repo.save(author);

        try {
            Author author1 = authorRepo.getByNameAndSurname(author.getName(), author.getSurname());
            logger.info(author1.toString());
            Author author2 = authorRepo.getById(author.getId());
            logger.info(author2.toString());
        } finally {
            repo.delete(author);
        }
    }

    @Test
    public void testRoom() {
        Room room = getRoom();
        room.equals(getRoom());
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
        technique.equals(getTechnique());
        technique.hashCode();
        authors.add(getAuthor());
        list.add(getMaterial());
        Room room = getRoom();

        Exhibit exhibit = new Exhibit((long) 1, "Екпонат", list, authors, room, technique);
        exhibit.equals(new Exhibit((long) 1, "Екпонат", list, authors, room, technique));

        logger.info(exhibit.toString() + exhibit.hashCode());

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

            AuthorRepo authorRepo = new AuthorRepo();
            Object author = authorRepo.getByNameAndSurname(authors.get(0).getName(), authors.get(0).getSurname());
            List<Exhibit> exhibits = exhibitRepo.exhibitsByAuthor((Author) author);
            for (Exhibit exhibit2 : exhibits) {
                logger.info(exhibit2.toString());
            }
            Exhibit exhibit1 = exhibitRepo.getByName(exhibit.getName());
            logger.info(exhibit1.toString());
            logger.info(exhibitRepo.getById(exhibit1.getId()));
            logger.info(exhibitRepo.getAll().toString());

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
        Worker worker2 = getWorker();
        worker2.setName("Igor");
        rooms.add(getRoom());

        Timestamp timeStart = new Timestamp(System.currentTimeMillis());

        repo.save(rooms.get(0));
        repo.save(worker);
        repo.save(worker2);

        Excursion excursion = new Excursion((long) 1, "Екскурсія", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), worker, rooms);
        excursion.equals(new Excursion((long) 1, "Екскурсія", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), worker, rooms));
        logger.info(excursion.toString() + excursion.hashCode());

        repo.save(excursion);

        Excursion excursion2 = null;
        try {
            WorkerRepo workerRepo = new WorkerRepo();
            ExcursionRepo excursionRepo = new ExcursionRepo();
            StatisticRepo statisticRepo = new StatisticRepo();
            Timestamp timeEnd = new Timestamp(System.currentTimeMillis());
            logger.info("Count " + statisticRepo.countExcursions(timeStart, timeEnd));
            logger.info("Excursions " + excursionRepo.getExcursions(timeStart, timeEnd));

            excursion2 = new Excursion((long) 1, "Екскурсія2", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), worker2, rooms);
            repo.save(excursion2);
            logger.info("All excursions - " + excursionRepo.getAll().toString());

            logger.info("Free worker - " + workerRepo.getFreeTourguides(timeStart, timeEnd));

        } finally {
            repo.delete(excursion);
            repo.delete(excursion2);
            repo.delete(rooms.get(0));
            repo.delete(worker);
            repo.delete(worker2);
        }
    }

    @Test
    public void testFindExhibitByWorkerName() {
        ExhibitRepo exhibitRepo = new ExhibitRepo();
        String name = "Oleh";
        Set<Exhibit> results = exhibitRepo.exhibitsByWorkerName(name);
        logger.info(results.toString());
    }

    @Test
    public void testTourGuideStatisticsByNumberOfExcursions() {
        StatisticRepo statisticRepo = new StatisticRepo();
        List<Object[]> results = statisticRepo.tourGuideStatisticsByNumberOfExcursions();
        for (Object[] arr : results) {
            logger.info(Arrays.toString(arr));
        }
    }

    @Test
    public void testTotalWorkingTimeByEachWorker() {
        StatisticRepo statisticRepo = new StatisticRepo();
        List<Object[]> results = statisticRepo.totalWorkingTimeByEachWorker(Timestamp.valueOf("2020-02-01 10:00:00"),
                Timestamp.valueOf("2020-02-26 12:00:00"));
        for (Object[] arr : results) {
            logger.info(Arrays.toString(arr));
        }
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
