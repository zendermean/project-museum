package servlets;

import repository.StatisticRepo;
import services.TimeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet({"/stat", "/statByTechnique", "/statByMaterial",
        "/statByCountOfExcursions", "/statByTourguides",
        "/statTotalWorkingTimeByEachWorker"})
public class StatisticServlet extends HttpServlet {
    private StatisticRepo statisticRepo;

    @Override
    public void init() throws ServletException {
        statisticRepo = new StatisticRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/statByTechnique":
                doGetExhibitStatByTechnique(req, resp);
                break;
            case "/statByMaterial":
                doGetExhibitStatByMaterial(req, resp);
                break;
            case "/statByCountOfExcursions":
                req.getRequestDispatcher("pages/countExcursionsByPeriod.jsp").forward(req, resp);
                break;
            case "/statTotalWorkingTimeByEachWorker":
                doGetTotalWorkingTimeByEachWorker(req, resp);
                break;
            case "/statByTourguides":
                doGetTourguideStatisticsByNumberOfExcursions(req, resp);
                break;
            default:
                req.getRequestDispatcher("pages/AllStat.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Timestamp from = TimeService.convert(req.getParameter("from"));
        Timestamp to = TimeService.convert(req.getParameter("to"));

        if (!TimeService.isCorrect(from, to)) {
            req.setAttribute("message", "Please input correct date");
            req.getRequestDispatcher("pages/countExcursionsByPeriod.jsp").forward(req, resp);
        }

        Long countExcursions = statisticRepo.countExcursions(from, to);
        req.setAttribute("countExcursions", countExcursions);
        req.getRequestDispatcher("pages/countExcursionsByPeriod.jsp").forward(req, resp);
    }

    protected void doGetExhibitStatByTechnique(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object[]> list = statisticRepo.exhibitByTechnique();
        req.getSession().setAttribute("list", list);
        req.getSession().setAttribute("name", "Technique");
        req.getRequestDispatcher("pages/statBy.jsp").forward(req, resp);
    }

    protected void doGetExhibitStatByMaterial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object[]> list = statisticRepo.exhibitByMaterial();
        req.getSession().setAttribute("list", list);
        req.getSession().setAttribute("name", "Material");
        req.getRequestDispatcher("pages/statBy.jsp").forward(req, resp);
    }

    protected void doGetTourguideStatisticsByNumberOfExcursions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object[]> list = statisticRepo.tourGuideStatisticsByNumberOfExcursions();
        req.getSession().setAttribute("list", list);
        req.getSession().setAttribute("name", "Excursion");
        req.getRequestDispatcher("pages/statBy.jsp").forward(req, resp);
    }

    protected void doGetTotalWorkingTimeByEachWorker(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Timestamp from = TimeService.convert(req.getParameter("from"));
        Timestamp to = TimeService.convert(req.getParameter("to"));

        if (!TimeService.isCorrect(from, to)) {
            req.setAttribute("message", "Please input correct date");
            req.getRequestDispatcher("pages/totalWorkingTimeTourguide.jsp").forward(req, resp);
        }

        List<Object[]> list = statisticRepo.totalWorkingTimeByEachWorker(from, to);
        req.setAttribute("list", list);
        req.getSession().setAttribute("name", "Tourguide");
        req.getRequestDispatcher("pages/statBy.jsp").forward(req, resp);
    }
}
