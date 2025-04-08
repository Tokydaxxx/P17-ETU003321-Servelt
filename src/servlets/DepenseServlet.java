package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.List;
import dao.*;
import models.*;
import java.sql.SQLException;


public class DepenseServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    int userId = (int) session.getAttribute("userId");
    int id_prevision = Integer.parseInt(request.getParameter("id_prevision"));
    double montant = Double.parseDouble(request.getParameter("montant"));

    DAODepense dd = new DAODepense();

    try {
            dd.addDepense(userId,id_prevision,montant);
            request.setAttribute("succes", "depense inserer avec succes");
            response.sendRedirect("formDepense");
        
    } catch (Exception e) {
        request.setAttribute("erreur", "Erreur de base de données : " + e.getMessage());
        response.sendRedirect("formDepense?erreur = "+e.getMessage()+"");

    }
}

}