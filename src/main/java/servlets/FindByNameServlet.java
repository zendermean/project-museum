package servlets;

import entity.Exhibit;
import repository.ExhibitRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/findByWorker")
public class FindByNameServlet extends HttpServlet {
    private ExhibitRepo exhibitRepo;

    @Override
    public void init() throws ServletException {
        exhibitRepo = new ExhibitRepo();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FindExhibitByWorker(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FindExhibitByWorker(request, response);
    }

    protected void FindExhibitByWorker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String workerName = request.getParameter("workerName");
        //List<Exhibit> exhibitList = exhibitRepo.exhibitsByWorkerName(workerName);
        PrintWriter pw = response.getWriter();
        pw.println(workerName);
    }


}