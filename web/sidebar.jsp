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
            top: 0;
            left: 0;
        }
        .sidebar h2 {
            text-align: center;
            font-size: 22px;
            margin-bottom: 30px;
        }
        .sidebar a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 12px 15px;
            border-radius: 5px;
            margin: 5px 0;
            transition: background-color 0.3s ease;
        }
        .sidebar a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <h2>💊 Mon Pharmacie</h2>
        <a href="dashboard.jsp">📊 Tableau de Bord</a>
        <a href="medicaments.jsp">💼 Médicaments</a>
        <a href="clients.jsp">👥 Clients</a>
        <a href="fournisseurs.jsp">🚚 Fournisseurs</a>
        <a href="stock.html">📈 Stock Statique</a>
        <a href="logout.jsp">🚪 Déconnexion</a>
    </div>
</body>
</html>
