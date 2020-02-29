package servlets;

import entity.Author;
import entity.Exhibit;
import repository.AuthorRepo;
import repository.ExhibitRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet({"/finder", "/findExhibitsByWorkerName", "/findExhibitsByRoom", "/findExhibitsByAuthor"})
public class FinderServlet extends HttpServlet {
    private ExhibitRepo exhibitRepo;
    private AuthorRepo authorRepo;

    @Override
    public void init() {
        exhibitRepo = new ExhibitRepo();
        authorRepo = new AuthorRepo();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/findExhibitsByWorkerName":
                doGetFindExhibitsByWorkerName(req, resp);
                break;
            case "/findExhibitsByRoom":
                doGetFindExhibitsByRoom(req, resp);
                break;
            case "/findExhibitsByAuthor":
                doGetFindExhibitsByAuthor(req, resp);
                break;
            default:
                req.getRequestDispatcher("pages/findByRoom.jsp").forward(req, resp);
                break;
        }
    }

    protected void doGetFindExhibitsByWorkerName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String workerName = req.getParameter("workerName");
        Set<Exhibit> exhibitList = exhibitRepo.exhibitsByWorkerName(workerName);

        req.setAttribute("exhibitList", exhibitList);
        req.getSession().setAttribute("name", workerName);
        req.getRequestDispatcher("pages/findByWorkerName.jsp").forward(req, resp);
    }

    protected void doGetFindExhibitsByRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object[]> exhibitList = exhibitRepo.exhibitsByRoom();

        req.getSession().setAttribute("exhibitList", exhibitList);
        req.getSession().setAttribute("name", "Room");
        req.getRequestDispatcher("pages/findByRoom.jsp").forward(req, resp);
    }

    protected void doGetFindExhibitsByAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authorName = req.getParameter("authorName");
        String authorSurname = req.getParameter("authorSurname");
        Author author;
        if (authorName == null && authorSurname == null) {
            req.getRequestDispatcher("pages/findByAuthor.jsp").forward(req, resp);
        } else {
            author = (Author) authorRepo.getByNameAndSurname(authorName, authorSurname);
            if (author != null) {
                List<Exhibit> exhibitList = exhibitRepo.exhibitsByAuthor(author);
                if (exhibitList != null) {
                    req.getSession().setAttribute("exhibitList", exhibitList);
                    req.getSession().setAttribute("name", authorName);
                    req.getSession().setAttribute("surname", authorSurname);
                    req.getRequestDispatcher("pages/findByAuthor.jsp").forward(req, resp);
                    exhibitList.clear();
                }
            }
        }
        req.getSession().setAttribute("name", authorName);
        req.getSession().setAttribute("surname", authorSurname);
        req.getRequestDispatcher("pages/findByAuthor.jsp").forward(req, resp);
    }
}