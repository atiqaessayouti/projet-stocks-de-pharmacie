<%@page import="java.util.List"%>
<%@page import="entities.Medicament"%>
<%@page import="services.MedicamentService"%>
<%@page import="entities.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Admin admin = (Admin) session.getAttribute("user");
    if (admin == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    MedicamentService ms = new MedicamentService();
    List<Medicament> medicaments = ms.findAll();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tableau de Bord</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            display: flex;
            margin: 0;
            background-color: #f8f9fa;
            font-family: 'Segoe UI', sans-serif;
        }
        .sidebar {
            width: 250px;
            background-color: #007BFF;
            color: white;
            padding: 20px;
            height: 100vh;
            position: fixed;
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
            transition: background 0.3s;
        }
        .sidebar a:hover {
            background-color: #0056b3;
        }
        .container {
            margin-left: 250px;
            padding: 30px;
            width: 100%;
        }
        .stats {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .stat-item {
            border-radius: 10px;
            padding: 20px;
            flex: 1;
            min-width: 250px;
            color: white;
            text-align: center;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        .bg-green { background-color: #28a745; }
        .bg-orange { background-color: #fd7e14; }
        .bg-red { background-color: #dc3545; }
        .bg-blue { background-color: #007BFF; }
        canvas {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            margin-top: 30px;
        }
    </style>
</head>
<body>

    <div class="sidebar">
        <h2>💊 Mon Pharmacie</h2>
        <a href="dashboard.jsp">Tableau de Bord</a>
        <a href="medicaments.jsp">Médicaments</a>
        <a href="clients.jsp">Clients</a>
        <a href="fournisseurs.jsp">Fournisseurs</a>
        <a href="login.jsp">Déconnexion</a>
    </div>

    <div class="container">
        <h2 class="text-center mb-4">📊 Tableau de Bord</h2>

        <div class="stats">
            <div class="stat-item bg-blue">
                <h3>Total Médicaments</h3>
                <p><%= medicaments.size() %></p>
            </div>
            <div class="stat-item bg-orange">
                <h3>Total Catégories</h3>
                <p>5</p> <!-- À remplacer dynamiquement si besoin -->
            </div>
            <div class="stat-item bg-green">
                <h3>Total Fournisseurs</h3>
                <p>3</p> <!-- À remplacer dynamiquement si besoin -->
            </div>
        </div>

        <h3 class="mt-5">📈 Graphique du Stock</h3>
        <canvas id="stockChart" height="120"></canvas>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>
            const ctx = document.getElementById('stockChart').getContext('2d');
            const labels = [
                <% for (Medicament m : medicaments) { %>'<%= m.getNom() %>',<% } %>
            ];
            const dataValues = [
                <% for (Medicament m : medicaments) { %><%= m.getQuantite() %>,<% } %>
            ];
            const bgColors = dataValues.map(qty => {
                if (qty > 20) return 'rgba(40, 167, 69, 0.6)';       // green
                else if (qty >= 10) return 'rgba(253, 126, 20, 0.6)'; // orange
                else return 'rgba(220, 53, 69, 0.6)';                 // red
            });
            const borderColors = bgColors.map(c => c.replace('0.6', '1'));

            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: 'Quantité Disponible',
                        data: dataValues,
                        backgroundColor: bgColors,
                        borderColor: borderColors,
                        borderWidth: 1
                    }]
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: { display: false },
                        title: {
                            display: true,
                            text: 'Niveau de Stock des Médicaments'
                        }
                    },
                    scales: {
                        y: { beginAtZero: true }
                    }
                }
            });
        </script>
    </div>

</body>
</html>
