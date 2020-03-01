package servlets;

import entity.Worker;
import repository.WorkerRepo;
import services.TimeService;

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
        Timestamp from = TimeService.convert(req.getParameter("from"));
        Timestamp to = TimeService.convert(req.getParameter("to"));

        if (!TimeService.isCorrect(from, to)) {
            req.setAttribute("message", "Please input correct date");
            req.getRequestDispatcher("pages/freeTourguides.jsp").forward(req, resp);
        }

        Set<Worker> workerList = workerRepo.getFreeTourguides(from, to);
        req.setAttribute("workerList", workerList);
        req.getRequestDispatcher("pages/tourguides.jsp").forward(req, resp);
    }
}
