<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>login</title>
</head>
<body>
    <h2>Login</h2>
    <% String erreur = (String) request.getAttribute("erreur"); %>
<% if (erreur != null) { %>
    <p style="color:red;"><%= erreur %></p>
<% } %>
    <h1>Username : 3321 Password: 3321</h1>
    <form method="post" action="login">
        <div class="form-group">
            <label>Nom d'utilisateur :</label>
            <input type="text" name="username" value = "3321" required><br>
        </div>
        <div class="form-group">
            <label>Mot de passe :</label>
            <input type="password" name="password" value = "3321" required><br>
        </div>
        <div class="flex justify-between items-center">
            <input type="submit" value="Se connecter">
        </div>
    </form>
</body>
</html>
