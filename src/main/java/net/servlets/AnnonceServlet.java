package net.servlets;


import net.annonceDao.AnnoncesDao;
import net.annonces.Annonces;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AnnonceServlet")
public class AnnonceServlet extends HttpServlet {
    private AnnoncesDao annoncesDao;

    public void init() {
        annoncesDao = new AnnoncesDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");

        String titre = request.getParameter("titre");
        String categorie = request.getParameter("categorie");
        String contenu = request.getParameter("contenu");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));

        Annonces annonce = new Annonces();
        annonce.setTitre(titre);
        annonce.setCategorie(categorie);
        annonce.setContenu(contenu);
        annonce.setStartDate(startDate);
        annonce.setEndDate(endDate);

        if ("add".equals(operation)) {
            annoncesDao.insertAnnonce(annonce);
        } else if ("edit".equals(operation)) {
            int id = Integer.parseInt(request.getParameter("id"));
            annonce.setId(id);
            annoncesDao.updateAnnonce(annonce);
        }

        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Annonces existingAnnonce = annoncesDao.selectAnnonceById(id);
            request.setAttribute("annonce", existingAnnonce);
            request.getRequestDispatcher("ajoutAnnonce.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            annoncesDao.deleteAnnonce(id);
            response.sendRedirect("index.jsp");
        }
    }
}
