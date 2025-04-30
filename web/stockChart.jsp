<%-- 
    Document   : stockChart
    Created on : 27 avr. 2025, 16:41:39
    Author     : HP
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Statistiques de Stock</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <h2>Statistiques de Stock par Médicament</h2>

    <canvas id="stockChart" width="800" height="400"></canvas>

    <script>
      fetch('stockChart')
    .then(response => response.json())  // Récupère les données au format JSON
    .then(data => {
        console.log(data);  // Vérifie que les données sont reçues correctement

        // Vérifie si les données sont vides ou non définies
        if (!data || data.length === 0) {
            console.error('Aucune donnée reçue');
            return;  // Ne pas continuer si les données sont vides
        }

        // Processus de création du graphique
        const labels = data.map(item => item.nomMedicament);  // Noms des médicaments
        const dataValues = data.map(item => item.quantiteTotale);  // Quantités des médicaments

        const bgColors = dataValues.map(qty => {
            if (qty > 20) return 'rgba(40, 167, 69, 0.6)';  // Vert
            else if (qty >= 10) return 'rgba(253, 126, 20, 0.6)';  // Orange
            else return 'rgba(220, 53, 69, 0.6)';  // Rouge
        });

        const borderColors = bgColors.map(c => c.replace('0.6', '1'));

        const ctx = document.getElementById('stockChart').getContext('2d');
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
    })
    .catch(error => {
        console.error('Erreur lors de la récupération des données:', error);
    });

    </script>
</body>
</html>
