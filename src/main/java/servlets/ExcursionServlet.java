package servlets;

import entity.Excursion;
import repository.ExcursionRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/excursions")
public class ExcursionServlet extends HttpServlet {
    private ExcursionRepo excursionRepo;

    @Override
    public void init() throws ServletException {
        excursionRepo = new ExcursionRepo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Excursion> excursionList = excursionRepo.getAll();
        req.setAttribute("excursionList", excursionList);
        req.getRequestDispatcher("pages/excursions.jsp").forward(req, resp);
    }

}
