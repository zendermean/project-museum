package servlets;

import entity.Worker;
import repository.WorkerRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/tourguides", "/freeTourguides"})
public class TourguideServlet extends HttpServlet {
    private WorkerRepo workerRepo;

    @Override
    public void init() throws ServletException {
        workerRepo = new WorkerRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Worker> workerList = workerRepo.getTourguides();
        req.setAttribute("workerList", workerList);
        req.getRequestDispatcher("pages/tourguides.jsp").forward(req, resp);
    }
}
