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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //StatisticRepo statisticRepo = new StatisticRepo();
        List<Object[]> list = new ArrayList<>();
        Object[] obj1 = new Object[2];
        Object[] obj2 = new Object[2];
        Object[] obj3 = new Object[2];
        obj1[0] = 5;
        obj2[0] = 1;
        obj3[0] = 3;
        obj1[1] = "sdxzfc";
        obj2[1] = "trfdhg";
        obj3[1] = "yhdfg";
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        req.getSession().setAttribute("list", list);
        req.getRequestDispatcher("statistic.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
