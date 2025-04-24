<%@page import="java.util.List"%>
<%@page import="entities.Client"%>
<%@page import="services.ClientService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ClientService cs = new ClientService();
    List<Client> clients = cs.findAll();
%>

<!DOCTYPE html>
<html lang="fr">
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Gestion des Clients</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script> <!-- Pour les icônes -->
    <style>
        /* Global styles */
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f8;
        }
        header {
            background-color: #007BFF;
            color: white;
            padding: 20px 40px;
            display: flex;
            flex-direction: column;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        header h1 {
            margin: 0;
            font-size: 26px;
        }
        nav {
            margin-top: 10px;
            display: flex;
            align-items: center;
            flex-wrap: wrap;
        }
        nav a {
            margin-right: 20px;
            color: white;
            text-decoration: none;
            font-weight: 500;
            transition: color 0.3s;
        }
        nav a:hover {
            color: #ffd700;
        }
        .logout-link {
            margin-left: auto;
            background-color: #dc3545;
            padding: 8px 14px;
            border-radius: 5px;
            color: white;
            text-decoration: none;
            transition: background 0.3s;
        }
        .logout-link:hover {
            background-color: #c82333;
        }
        main {
            padding: 30px 40px;
        }

        /* Client table style */
        .container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-top: 20px;
        }
        .table th, .table td {
            vertical-align: middle;
        }
        .btn {
            font-weight: bold;
        }
        .btn-primary, .btn-danger {
            transition: all 0.3s ease;
        }
        .btn-primary:hover, .btn-danger:hover {
            opacity: 0.8;
        }
        .header-title {
            color: #2c3e50;
            font-size: 26px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        /* Footer styles */
        .footer {
            background-color: #2c3e50;
            color: white;
            padding: 10px 0;
            text-align: center;
            font-size: 14px;
            margin-top: 20px;
        }
        
        @media (max-width: 768px) {
            nav {
                flex-direction: column;
                align-items: flex-start;
                gap: 10px;
            }
            .logout-link {
                margin-left: 0;
            }
        }
    </style>
</head>
<body>
    <header>
        <h1>💊 Système de Gestion de Stock</h1>
        <nav>
            <a href="index.jsp">Accueil</a>
            <a href="medicaments.jsp">Médicaments</a>
            <a href="clients.jsp">Clients</a>
            <a href="fournisseurs.jsp">Fournisseurs</a>
            <a href="login.jsp" class="logout-link">Déconnexion</a>
        </nav>
    </header>

    <main>
        <div class="container mt-5">
            <h2 class="mb-4 text-center">Gestion des Clients</h2>

            <!-- Formulaire d'ajout de client -->
            <form action="ClientController" method="post" class="mb-4">
                <input type="hidden" name="action" value="create">
                <div class="row g-3">
                    <div class="col-md-4">
                        <input type="text" name="nom" class="form-control" placeholder="Nom" required>
                    </div>
                    <div class="col-md-4">
                        <input type="email" name="email" class="form-control" placeholder="Email" required>
                    </div>
                    <div class="col-md-12 text-center">
                        <button type="submit" class="btn btn-success mt-3">Ajouter le Client</button>
                    </div>
                </div>
            </form>

            <!-- Tableau des clients -->
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                <tr>
                    
                    <th>id</th>
                    <th>Nom</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                    <% for (Client c : clients) { %>
                    <tr>
                        <td><%= c.getId() %></td>
                        <td><%= c.getNom() %></td>
                        <td><%= c.getEmail() %></td>
                        <td>
                            <!-- Formulaire pour supprimer un client -->
                            <form action="ClientController" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="id" value="<%= c.getId() %>">
                                <button class="btn btn-danger btn-sm">
                                    <i class="fas fa-trash"></i> Supprimer
                                </button>
                            </form>
                            <!-- Formulaire pour modifier un client -->
                            <a href="ClientController?id=<%= c.getId() %>&action=edit" class="btn btn-primary btn-sm ms-2">
                                <i class="fas fa-edit"></i> Modifier
                            </a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <!-- Footer -->
        <div class="footer">
            <p>&copy; 2025 Gestion des Clients. Tous droits réservés.</p>
        </div>
    </main>

    <!-- JS de Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
