package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import dao.*;
import java.util.List;
import models.*;

public class formulaireDepenseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOPrevision pd = new DAOPrevision();
        List<Prevision> listPrevision = pd.getAllPrevisions();
        try{   
            request.setAttribute("listPrevision",listPrevision);
            request.getRequestDispatcher("depense.jsp").forward(request, response);

        }catch (Exception e) {
            request.setAttribute("erreur", "Erreur : " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("prevision.jsp");
            dispatcher.forward(request, response);
        }
    }
}