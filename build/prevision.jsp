<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Prevision</title>
</head>
<body>
    <h2>Prevision</h2>
    <% String erreur = (String) request.getAttribute("erreur"); %>
<% if (erreur != null) { %>
    <p style="color:red;"><%= erreur %></p>
<% } %>

<% String succes = (String) request.getAttribute("succes"); %>
<% if (succes != null) { %>
    <p style="color:green;"><%= succes %></p>
<% } %>

    <form method="post" action="insertCredit">
        <div class="form-group">
            <label>libelle :</label>
            <input type="text" name="libelle" required><br>
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
