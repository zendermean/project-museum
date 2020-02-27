package servlets;

import repository.StatisticRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/stat", "/statByTechnique", "/statByMaterial"})
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
            default:
                req.getRequestDispatcher("pages/AllStat.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
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

}
