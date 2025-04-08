<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>depense</title>

</head>
<body>
    <h2>depense</h2>
    <% String erreur = (String) request.getParameter("erreur"); %>
<% if (erreur != null) { %>
    <p style="color:red;"><%= erreur %></p>
<% } %>

<% String succes = (String) request.getParameter("succes"); %>
<% if (succes != null) { %>
    <p style="color:green;"><%= succes %></p>
<% } %>

<% 
List<Prevision> allPrevision = (List<Prevision>) request.getAttribute("listPrevision"); 

%>

    <form method="post" action="insertDepense">
        <div class="form-group">
            <select name="id_prevision" id="idDept" required>
                <option value="">Sélectionnez un libelle</option>
                <% for (Prevision d : allPrevision) { %>
                    <option value="<%= d.getId() %>"><%= d.getLibelle() %></option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label>montant :</label>
            <input type="text" name="montant" required><br>
        </div>
        <div class="flex justify-between items-center">
            <input type="submit" value="valider">
            <div class="nav-links">
                <a href="dashboard">aller dashboard</a>
            </div>
        </div>

    </form>



</body>
</html>
