package net.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.annonceDao.AnnoncesDao;
import net.annonces.Annonces;

@WebServlet("/ListeAnnoncesServlet")
public class ListeAnnoncesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AnnoncesDao annoncesDao;

    public ListeAnnoncesServlet() {
        super();
        this.annoncesDao = new AnnoncesDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer toutes les annonces de la base de données
        List<Annonces> annonces = annoncesDao.getAllAnnonces();
        
        // Ajouter la liste des annonces à la requête
        request.setAttribute("annonces", annonces);
        
        // Transférer le contrôle à la page JSP qui affichera les annonces
        request.getRequestDispatcher("affiche.jsp").forward(request, response);
    }
}
