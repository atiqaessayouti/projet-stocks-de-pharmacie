<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Achat de Médicaments</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #999;
            padding: 10px;
            text-align: center;
        }

        h2 {
            text-align: center;
        }

        .message {
            text-align: center;
            color: green;
            font-weight: bold;
        }

        .error {
            text-align: center;
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h2>Liste des Médicaments disponibles</h2>

<c:if test="${not empty message}">
    <p class="message">${message}</p>
</c:if>

<table>
    <tr>
        <th>Nom</th>
        <th>Quantité disponible</th>
        <th>Date de péremption</th>
        <th>Quantité à acheter</th>
        <th>Action</th>
    </tr>

    <c:forEach var="medicament" items="${listeMedicaments}">
        <tr>
            <form method="post" action="MedicamentAchatController">
                <td>${medicament.nom}</td>
                <td>${medicament.quantite}</td>
                <td>${medicament.datePeremption}</td>
                <td>
                    <input type="hidden" name="medicamentId" value="${medicament.id}" />
                    <input type="number" name="quantite" min="1" max="${medicament.quantite}" required />
                </td>
                <td>
                    <input type="submit" value="Acheter" />
                </td>
            </form>
        </tr>
    </c:forEach>
</table>

</body>
</html>
