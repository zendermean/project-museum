package servlets;

import entity.*;
import repository.ExhibitRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private ExhibitRepo exhibitRepo;

    @Override
    public void init() throws ServletException {
        exhibitRepo = new ExhibitRepo();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Material> list = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        Technique technique = new Technique((long) 1, "Gotic", new ArrayList<Exhibit>());
        list.add(new Material((long) 1, "Carbon", new ArrayList<Exhibit>()));
        technique.equals(new Technique((long) 1, "Gotic", new ArrayList<Exhibit>()));
        authors.add(new Author((long) 1, "Taras", "Kovaliv", new ArrayList<Exhibit>()));
        Room room = new Room((long) 1, 305, 3, new ArrayList<Exhibit>(), new ArrayList<Excursion>());

        Exhibit exhibit = new Exhibit((long) 1, "Екпонат", list, authors, room, technique);
        //List<Exhibit> exhibitList =  exhibitRepo.getAll();
        List<Exhibit> exhibitList = new ArrayList<>();
        exhibitList.add(exhibit);
        req.setAttribute("exhibitList", exhibitList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}
