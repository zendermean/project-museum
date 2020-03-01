package servlets;

import entity.Excursion;
import repository.ExcursionRepo;
import services.TimeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet({"/excursions", "/dateExcursions"})
public class ExcursionServlet extends HttpServlet {
    private ExcursionRepo excursionRepo;

    @Override
    public void init() throws ServletException {
        excursionRepo = new ExcursionRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/dateExcursions":
                req.getRequestDispatcher("pages/dateExcursions.jsp").forward(req, resp);
                break;
            default:
                List<Excursion> excursionList = excursionRepo.getAll();
                req.setAttribute("excursionList", excursionList);
                req.getRequestDispatcher("pages/excursions.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Timestamp from = TimeService.convert(req.getParameter("from"));
        Timestamp to = TimeService.convert(req.getParameter("to"));

        if (!TimeService.isCorrect(from, to)) {
            req.setAttribute("message", "Please input correct date");
            req.getRequestDispatcher("pages/dateExcursions.jsp").forward(req, resp);
        }

        List<Excursion> excursionList = excursionRepo.getExcursions(from, to);
        req.setAttribute("excursionList", excursionList);
        req.getRequestDispatcher("pages/excursions.jsp").forward(req, resp);
    }
}
