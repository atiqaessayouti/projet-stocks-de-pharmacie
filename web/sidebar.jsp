<%-- 
    Document   : sidebar
    Created on : 19 avr. 2025, 16:07:54
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        .sidebar {
            width: 250px;
            background-color: #007BFF;
            color: white;
            padding: 20px;
            height: 100vh;
            position: fixed;
        }
        .sidebar h2 {
            color: white;
            font-size: 20px;
        }
        .sidebar a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 10px 5px;
            transition: background 0.3s;
        }
        .sidebar a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <h2>Menu</h2>
        <a href="dashboard.jsp">Tableau de Bord</a>
        <a href="medicaments.jsp">Médicaments</a>
        <a href="clients.jsp">Clients</a>
        <a href="fournisseurs.jsp">Fournisseurs</a>
        <a href="logout.jsp">Déconnexion</a>
    </div>
</body>
</html>