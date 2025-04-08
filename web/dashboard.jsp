<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="flex justify-between items-center">
            <h1>Dashboard</h1>
        </div>

        <% 
        List<Dashboard> dash = (List<Dashboard>) request.getAttribute("listDash"); 
        
        %>
        <table>
            <thead>
                <tr>
                    <th>ligne credit</th>
                    <th>Somme montant Depense</th>
                    <th>reste</th>
                </tr>
            </thead>
            <tbody>
            <% for (Dashboard db : dash) { %>
            <tr>
                <td><%= db.getCreditLibelle() %></td>
                <td><%= db.getMontantDepense() %></td>
                <td><%= db.getReste() %></td>
            </tr>
            <% } %>
            </tbody>

        </table>

        <div class="nav-links" style="margin-top: 2rem;">
            <a href="formPrevision">Inserer ligne prevision</a>
            <a href="formDepense">Inserer ligne depense</a> 
        </div>
</div>
</body>
</html>