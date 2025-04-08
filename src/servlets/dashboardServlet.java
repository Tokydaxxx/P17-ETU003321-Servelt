package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.*;
import dao.*;
import java.util.*;

public class dashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            DAOPrevision pd = new DAOPrevision();
            DAODepense dd = new DAODepense();
            List<Dashboard> listD = new ArrayList<>();
            
            List<Prevision> listPrevision = pd.getAllPrevisions();

            for(Prevision p : listPrevision){
                double depense = dd.getTotalDepense(userId,p.getId());
                double reste = pd.calculateRemainingAmount(userId,p.getId());
                Dashboard db = new Dashboard(p.getLibelle(),depense,reste);
                listD.add(db);
            }

        try{
            request.setAttribute("listDash",listD);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }catch (Exception e) {
        request.setAttribute("erreur", "Erreur : " + e.getMessage());
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
    }
}