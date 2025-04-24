<%@ page import="java.util.List" %>
<%@ page import="entities.Medicament" %>
<%@ page import="services.MedicamentService" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%
    // On récupère la liste des médicaments disponibles
    MedicamentService ms = new MedicamentService();
    List<Medicament> medicamentsDisponibles = ms.findAll(); // Utiliser une méthode pour récupérer les médicaments disponibles
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Médicaments Disponibles</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .sidebar {
            width: 250px;
            background-color: #007BFF;
            color: white;
            height: 100vh;
            position: fixed;
            padding: 20px;
            top: 0;
            left: 0;
        }
        .sidebar h2 {
            text-align: center;
            font-size: 24px;
            margin-bottom: 30px;
        }
        .sidebar a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 12px 15px;
            border-radius: 5px;
            margin: 5px 0;
            transition: background 0.3s;
        }
        .sidebar a:hover {
            background-color: #0056b3;
        }
        .container {
            margin-left: 270px;
            padding: 30px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .table {
            margin-top: 20px;
            width: 100%;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        th, td {
            text-align: center;
            padding: 12px;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        td {
            background-color: #f1f1f1;
        }
        .btn {
            background-color: #007BFF;
            color: white;
            padding: 8px 15px;
            border-radius: 5px;
            text-decoration: none;
            font-size: 14px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .dashboard-stats {
            display: flex;
            justify-content: space-between;
            gap: 20px;
            margin-bottom: 30px;
        }
        .stat-item {
            background-color: #28a745;
            color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            text-align: center;
            flex: 1;
        }
        .stat-item h3 {
            margin: 0;
        }
        .stat-item p {
            font-size: 24px;
            margin: 10px 0;
        }
    </style>
</head>
<body>

    <!-- Sidebar -->
    <div class="sidebar">
        <h2>💊 Mon Pharmacie</h2>
        <a href="client_dashboard.jsp">Tableau de Bord</a>
        <a href="medicaments_dispo.jsp">Médicaments Disponibles</a>
        
      
        <a href="login.jsp">Déconnexion</a>
    </div>

    <!-- Main Content -->
    <div class="container">
        <h2>Liste des Médicaments Disponibles</h2>

       
        
        <!-- Médicaments Table -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Quantité Disponible</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% for (Medicament m : medicamentsDisponibles) { %>
                    <tr>
                        <td><%= m.getNom() %></td>
                        <td><%= m.getQuantite() %></td>
                        <td>
                            <a href="details_medicament.jsp?id=<%= m.getId() %>" class="btn">Détails</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

</body>
</html>
