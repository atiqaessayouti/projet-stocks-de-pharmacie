<%-- 
    Document   : fournisseurs
    Created on : 20 avr. 2025, 00:41:31
    Author     : HP
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.Fournisseur"%>
<%@page import="services.FournisseurService"%>
<%@page import="entities.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Admin admin = (Admin) session.getAttribute("user");
    if (admin == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    FournisseurService fs = new FournisseurService();
    java.util.List<Fournisseur> fournisseurs = fs.findAll();
    Fournisseur fournisseurToEdit = (Fournisseur) request.getAttribute("fournisseur");
    boolean isUpdate = fournisseurToEdit != null;
%>

<%@ include file="header.jsp" %>

<fieldset style="background-color: #fff; border: none; padding: 30px; border-radius: 10px; box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1); position: relative;">
    <legend style="font-size: 26px; font-weight: bold; color: #2c3e50; margin-bottom: 20px; border-bottom: 2px solid #4a6fdc; padding-bottom: 10px;">Gestion des Fournisseurs</legend>

    <!-- Formulaire d'ajout / modification -->
    <form action="<%= request.getContextPath() %>/FournisseurController" method="post" style="margin-bottom: 30px;">
        <input type="hidden" name="id" value="<%= isUpdate ? fournisseurToEdit.getId() : "" %>" />

        <label>Nom:</label><br>
        <input type="text" name="nom" required value="<%= isUpdate ? fournisseurToEdit.getNom() : "" %>" style="padding: 10px; margin: 8px 0; width: 100%; max-width: 400px;"><br>

        <label>Contact:</label><br>
        <input type="text" name="contact" required value="<%= isUpdate ? fournisseurToEdit.getContact() : "" %>" style="padding: 10px; margin: 8px 0; width: 100%; max-width: 400px;"><br><br>

        <button type="submit" class="<%= isUpdate ? "update" : "" %>" style="padding: 10px 20px; background-color: <%= isUpdate ? "#2980b9" : "#27ae60" %>; color: white; border: none; border-radius: 5px; cursor: pointer;">
            <%= isUpdate ? "Modifier" : "Ajouter" %> le fournisseur
        </button>
    </form>

    <!-- Tableau des fournisseurs -->
    <table style="width: 100%; border-collapse: collapse; margin-top: 20px;">
        <thead>
            <tr style="background-color: #f4f6f8; color: #333; font-weight: 600;">
                <th style="padding: 15px;">ID</th>
                <th style="padding: 15px;">Nom</th>
                <th style="padding: 15px;">Contact</th>
                <th style="padding: 15px;">Actions</th>
            </tr>
        </thead>
        <tbody>
            <% if (fournisseurs != null && !fournisseurs.isEmpty()) {
                for (Fournisseur f : fournisseurs) { %>
                    <tr style="border-bottom: 1px solid #eee;">
                        <td style="padding: 15px;"><%= f.getId() %></td>
                        <td style="padding: 15px;"><%= f.getNom() %></td>
                        <td style="padding: 15px;"><%= f.getContact() %></td>
                        <td style="padding: 15px;">
                            <a href="<%= request.getContextPath() %>/FournisseurController?id=<%= f.getId() %>&op=delete"
                               style="background-color: #e74c3c; color: white; padding: 8px 12px; border-radius: 5px; text-decoration: none;">
                               Supprimer
                            </a>
                            <a href="<%= request.getContextPath() %>/FournisseurController?id=<%= f.getId() %>&op=update"
                               style="background-color: #2980b9; color: white; padding: 8px 12px; border-radius: 5px; text-decoration: none;">
                               Modifier
                            </a>
                        </td>
                    </tr>
            <%  }
            } else { %>
                <tr>
                    <td colspan="4" style="text-align: center; font-style: italic; color: #888; padding: 20px;">
                        Aucun fournisseur trouvé
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
</fieldset>

<%@ include file="footer.jsp" %>
