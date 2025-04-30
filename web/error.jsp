<!-- error.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Erreur</title>
</head>
<body>
    <h2>Erreur</h2>
    <p><%= request.getParameter("error") %></p>
    <a href="medicaments.jsp">Retour à la gestion des médicaments</a>
</body>
</html>
