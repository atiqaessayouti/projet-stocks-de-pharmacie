<%-- 
    Document   : statistiques
    Created on : 27 avr. 2025, 17:27:35
    Author     : HP
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Statistiques des Médicaments</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

    <h2>Statistiques des Médicaments par Catégorie</h2>
    
    <canvas id="myChart" width="400" height="200"></canvas>

    <script>
        // Récupérer les données JSON depuis le servlet
        fetch('StatistiqueController')
            .then(response => response.json())
            .then(data => {
                // Préparer les labels et les données pour Chart.js
                let categories = data.map(item => item.categorie);
                let counts = data.map(item => item.nbMedicaments);

                // Créer le graphique avec Chart.js
                var ctx = document.getElementById('myChart').getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'bar',  // Type de graphique : barres
                    data: {
                        labels: categories,  // Catégories (x-axis)
                        datasets: [{
                            label: 'Nombre de Médicaments',
                            data: counts,  // Nombre de médicaments (y-axis)
                            backgroundColor: 'rgba(75, 192, 192, 0.2)',
                            borderColor: 'rgba(75, 192, 192, 1)',
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
                });
            })
            .catch(error => console.error('Erreur lors de la récupération des données:', error));
    </script>

</body>
</html>
