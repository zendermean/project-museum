package servlets;

import repository.StatisticRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/stat")
public class StatisticServlet extends HttpServlet {
    private StatisticRepo statisticRepo;

    @Override
    public void init() throws ServletException {
        statisticRepo = new StatisticRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object[]> list = statisticRepo.exhibitByTechnique();
        req.getSession().setAttribute("list", list);
        req.getRequestDispatcher("statistic.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
