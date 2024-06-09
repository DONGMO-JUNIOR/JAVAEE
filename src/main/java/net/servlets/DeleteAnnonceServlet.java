package net.servlets;


import net.annonceDao.AnnoncesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAnnonce")
public class DeleteAnnonceServlet extends HttpServlet {
    private AnnoncesDao annoncesDao;

    public void init() {
        annoncesDao = new AnnoncesDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            annoncesDao.deleteAnnonce(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("affiche.jsp");  // redirect to the list page after deletion
    }
}
