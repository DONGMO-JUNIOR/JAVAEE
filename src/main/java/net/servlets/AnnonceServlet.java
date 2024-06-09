package net.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.annonceDao.AnnoncesDao;
import net.annonces.Annonces;

@WebServlet("/AnnonceServlet")
public class AnnonceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AnnoncesDao annoncesDao;

    public AnnonceServlet() {
        super();
        this.annoncesDao = new AnnoncesDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String categorie = request.getParameter("categorie");
        String contenu = request.getParameter("contenu");

        Annonces annonce = new Annonces(titre, categorie, contenu);

        annoncesDao.insertAnnonce(annonce);
        response.sendRedirect("affiche.jsp");
    }
}
