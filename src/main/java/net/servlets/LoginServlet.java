package net.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.annonceDao.AnnoncesDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AnnoncesDao annoncesDao;

    public void init() {
        annoncesDao = new AnnoncesDao();
    }

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean isValid = false;

        try {
            isValid = annoncesDao.validateUser(email, password);
            System.out.println("Validation result for email " + email + ": " + isValid);
            if (isValid) {
                HttpSession session = request.getSession();
                
                session.setAttribute("user", email); // Stocke l'email de l'utilisateur dans la session
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=Unable%20to%20register%20user");
        }
    }
}
