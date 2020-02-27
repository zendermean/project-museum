package servlets;

import entity.Exhibit;
import repository.ExhibitRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exhibit")
public class ExhibitServlet extends HttpServlet {
    private ExhibitRepo exhibitRepo;
    private String id;

    @Override
    public void init() throws ServletException {
        exhibitRepo = new ExhibitRepo();
    }

    @Override
    public String getServletName() {
        return super.getServletName();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        id = req.getParameter("id");
        Exhibit exhibit = exhibitRepo.getById(Long.parseLong(id));
        req.getSession().setAttribute("exhibit", exhibit);
        req.getRequestDispatcher("pages/exhibit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
