package net.servlets;



import net.annonceDao.AnnoncesDao;
import net.annonces.Annonces;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editAnnonce")
public class EditAnnonceServlet extends HttpServlet {
    private AnnoncesDao annoncesDao;

    public void init() {
        annoncesDao = new AnnoncesDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Annonces existingAnnonce = annoncesDao.selectAnnonceById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("renomerAnnonce.jsp"); // Change to your actual JSP file name
        request.setAttribute("annonce", existingAnnonce);
        dispatcher.forward(request, response);
    }
}
