package servlets;

import entity.Worker;
import org.jboss.logging.Logger;
import repository.WorkerRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@WebServlet({"/tourguides", "/freeTourguides"})
public class TourguideServlet extends HttpServlet {
    private WorkerRepo workerRepo;

    final static Logger logger = Logger.getLogger(TourguideServlet.class);

    @Override
    public void init() throws ServletException {
        workerRepo = new WorkerRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/freeTourguides":
                req.getRequestDispatcher("pages/freeTourguides.jsp").forward(req, resp);
                break;
            default:
                List<Worker> workerList = workerRepo.getTourguides();
                req.setAttribute("workerList", workerList);
                req.getRequestDispatcher("pages/tourguides.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Timestamp from = convert(req.getParameter("from"));
        Timestamp to = convert(req.getParameter("to"));

        logger.info(from.toString() + "      " + to.toString());

        Set<Worker> workerList = workerRepo.getFreeTourguides(from, to);
        req.setAttribute("workerList", workerList);
        req.getRequestDispatcher("pages/tourguides.jsp").forward(req, resp);
    }

    private static Timestamp convert(String time) {
        time += ":00";
        time = time.replace("T", " ");
        logger.info(time);
        return Timestamp.valueOf(time);
    }
}
