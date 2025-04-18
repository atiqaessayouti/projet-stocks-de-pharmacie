<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.Medicament"%>
<%@page import="services.MedicamentService"%>
<%@page import="entities.Admin" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Admin admin = (Admin) session.getAttribute("user");
    if (admin == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    MedicamentService ms = new MedicamentService();
    java.util.List<Medicament> medicaments = ms.findAll();
    Medicament medToEdit = (Medicament) request.getAttribute("medicament");
    boolean isUpdate = medToEdit != null;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Médicaments</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        /* same styles as before */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        body {
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            min-height: 100vh;
            padding: 40px 20px;
        }
        fieldset {
            background-color: #fff;
            border: none;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 1000px;
            position: relative;
        }
        legend {
            font-size: 26px;
            font-weight: bold;
            color: #2c3e50;
            margin-bottom: 20px;
            border-bottom: 2px solid #4a6fdc;
            padding-bottom: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 15px;
            border-bottom: 1px solid #eee;
            text-align: left;
        }
        th {
            background-color: #f4f6f8;
            color: #333;
            font-weight: 600;
        }
        tbody tr:hover {
            background-color: #fafafa;
        }
        a {
            padding: 8px 12px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 14px;
            transition: 0.3s;
            margin-right: 5px;
            display: inline-block;
        }
        a[href*="delete"] {
            background-color: #e74c3c;
            color: white;
        }
        a[href*="delete"]:hover {
            background-color: #c0392b;
        }
        a[href*="update"] {
            background-color: #2980b9;
            color: white;
        }
        a[href*="update"]:hover {
            background-color: #216a94;
        }
        .logout-button {
            position: absolute;
            top: 30px;
            right: 30px;
            background-color: #e67e22;
            color: white;
            padding: 8px 14px;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
        }
        .logout-button:hover {
            background-color: #ca6f1e;
        }
        .empty-message {
            text-align: center;
            font-style: italic;
            color: #888;
            padding: 20px;
        }
        form {
            margin-bottom: 30px;
        }
        form input {
            padding: 10px;
            margin: 8px 0;
            width: 100%;
            max-width: 400px;
        }
        form button {
            padding: 10px 20px;
            background-color: #27ae60;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        form button.update {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <fieldset>
        <legend>Gestion des Médicaments</legend>
        <a class="logout-button" href="login.jsp">🔓 Déconnexion</a>

        <!-- Formulaire d'ajout / modification -->
        <form action="<%= request.getContextPath() %>/MedicamentController" method="post">
            <input type="hidden" name="id" value="<%= isUpdate ? medToEdit.getId() : "" %>" />

            <label>Nom:</label><br>
            <input type="text" name="nom" required value="<%= isUpdate ? medToEdit.getNom() : "" %>"><br>

            <label>Quantité:</label><br>
            <input type="number" name="quantite" required value="<%= isUpdate ? medToEdit.getQuantite() : "" %>"><br>

            <label>Date de péremption:</label><br>
            <input type="date" name="datePeremption" required value="<%= isUpdate ? new SimpleDateFormat("yyyy-MM-dd").format(medToEdit.getDatePeremption()) : "" %>"><br><br>

            <button type="submit" class="<%= isUpdate ? "update" : "" %>">
                <%= isUpdate ? "Modifier" : "Ajouter" %> le médicament
            </button>
        </form>

        <!-- Tableau des médicaments -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Quantité</th>
                    <th>Date de Péremption</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% if(medicaments != null && !medicaments.isEmpty()) {
                    for(Medicament m : medicaments) { %>
                        <tr>
                            <td><%= m.getId() %></td>
                            <td><%= m.getNom() %></td>
                            <td><%= m.getQuantite() %></td>
                            <td><%= m.getDatePeremption() %></td>
                            <td>
                                <a href="<%= request.getContextPath() %>/MedicamentController?id=<%= m.getId() %>&op=delete">Supprimer</a>
                                <a href="<%= request.getContextPath() %>/MedicamentController?id=<%= m.getId() %>&op=update">Modifier</a>
                            </td>
                        </tr>
                <%  }
                } else { %>
                    <tr>
                        <td colspan="5" class="empty-message">Aucun médicament trouvé</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </fieldset>
</body>
</html>
