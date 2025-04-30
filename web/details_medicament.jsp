<%@ page import="entities.Medicament" %>
<%@ page import="services.MedicamentService" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%
    // Récupérer l'ID du médicament passé en paramètre
    String medicamentIdStr = request.getParameter("id");
    Medicament medicament = null;

    // Si l'ID est valide, récupérer les détails du médicament
    if (medicamentIdStr != null && !medicamentIdStr.isEmpty()) {
        try {
            int medicamentId = Integer.parseInt(medicamentIdStr);
            MedicamentService medicamentService = new MedicamentService();
            medicament = medicamentService.findById(medicamentId); // Récupérer les détails du médicament
        } catch (NumberFormatException e) {
            // Si l'ID n'est pas valide, rediriger ou afficher un message d'erreur
            medicament = null;
        }
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Détails du Médicament</title>
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
        .medicament-details {
            background-color: #ffffff;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        .medicament-details h2 {
            text-align: center;
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
        <h2>Détails du Médicament</h2>

        <div class="medicament-details">
            <% if (medicament != null) { %>
                <h3><%= medicament.getNom() %></h3>
                
                <!-- Affichage du prix dynamique -->
                <p><strong>Prix: DH</p>
                
                <!-- Affichage du prix statique supplémentaire -->
                <p><strong>Prix Promotionnel:</strong> 100 DH</p> <!-- Prix statique ajouté ici -->

                <p><strong>Quantité Disponible:</strong> <%= medicament.getQuantite() %></p>

                <!-- Formulaire d'achat -->
                <form method="post" action="MedicamentAchatController">
                    <input type="hidden" name="medicamentId" value="<%= medicament.getId() %>" />
                    <div class="form-group">
                        <label for="quantite">Quantité à Acheter</label>
                        <input type="number" name="quantite" min="1" max="<%= medicament.getQuantite() %>" class="form-control" required />
                    </div>
                    <input type="submit" value="Acheter" class="btn" />
                </form>
            <% } else { %>
                <p class="text-danger">Désolé, ce médicament n'existe pas ou une erreur est survenue.</p>
            <% } %>
        </div>
    </div>

</body>
</html>
