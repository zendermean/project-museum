package servlets;

import entity.Exhibit;
import repository.ExhibitRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/findByWorker")
public class FindByNameServlet extends HttpServlet {
    private ExhibitRepo exhibitRepo;

    @Override
    public void init() throws ServletException {
        exhibitRepo = new ExhibitRepo();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String workerName = request.getParameter("workerName");
        Set<Exhibit> exhibitList = exhibitRepo.exhibitsByWorkerName(workerName);
        request.setAttribute("exhibitList", exhibitList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/find.jsp");
        dispatcher.forward(request, response);
    }


}