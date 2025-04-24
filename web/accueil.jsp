<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page d'accueil - Gestion Pharmacie</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e6f7f1; /* Couleur de fond douce */
            color: #3f3f3f; /* Couleur de texte sombre */
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        header {
            background-color: #6fbf92; /* Vert doux */
            padding: 15px 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .logo img {
            height: 60px;
        }

        .nav-links a {
            color: #ffffff; /* Texte blanc */
            text-decoration: none;
            margin-left: 25px;
            font-weight: 600;
            transition: 0.3s;
        }

        .nav-links a:hover {
            text-decoration: underline;
            color: #f6e58d; /* Jaune doux pour le survol */
        }

        main {
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center;
            padding: 60px 20px;
        }

        main h1 {
            font-size: 42px;
            margin-bottom: 20px;
            color: #2f4f4f; /* Couleur sombre */
        }

        main p {
            font-size: 20px;
            max-width: 700px;
            margin-bottom: 40px;
            line-height: 1.6;
            color: #4b8b6b; /* Vert moyen */
        }

        .cta-button {
            background-color: #2c6e49; /* Vert foncé */
            color: white;
            border: none;
            padding: 15px 30px;
            font-size: 18px;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            transition: 0.3s ease;
        }

        .cta-button:hover {
            background-color: #1e4d3b; /* Vert très foncé pour le survol */
        }

        .catalogue {
            display: flex;
            justify-content: space-around;
            margin: 40px 0;
            max-width: 1200px;
            flex-wrap: wrap;
        }

        .catalogue-item {
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: 10px;
            flex: 1 1 250px;
            text-align: center;
            transition: transform 0.2s;
        }

        .catalogue-item:hover {
            transform: scale(1.05);
        }

        .catalogue-item img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
            margin-bottom: 10px;
        }

       .about {
    background-color: #cde6d8; /* Vert clair */
    padding: 40px 40px;  
      padding: 40px 40px;
    border-radius: 8px;
    width: 80%; /* Largeur de 80% */
    max-width: 800px; /* Limiter la largeur à 800px */
 
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Ombre légère */
}

        .about h2 {
            color: #2f4f4f; /* Couleur sombre pour le titre */
            margin-bottom: 10px; /* Espacement sous le titre */
        }

        .about p {
            margin: 0; /* Enlever la marge par défaut */
             /* Améliorer la lisibilité */
        }

        footer {
            background-color: #cde6d8; /* Vert clair */
            padding: 15px;
            text-align: center;
            font-size: 14px;
            color: #2f3640;
        }

        @media (max-width: 600px) {
            .nav-links a {
                margin-left: 15px;
                font-size: 14px;
            }

            main h1 {
                font-size: 32px;
            }

            .cta-button {
                padding: 12px 24px;
                font-size: 16px;
            }

            .catalogue {
                flex-direction: column;
                align-items: center;
            }
        }
    </style>
</head>
<body>

<header>
    <div class="logo">
        <img src="images/logo.png" alt="Logo Pharmacie">
    </div>
    <div class="nav-links">
        <a href="login.jsp">Connexion</a>
    </div>
</header>

<main>
    <h1>Bienvenue sur la gestion de pharmacie</h1>
   

    <div class="catalogue">
        <div class="catalogue-item">
            <img src="images/medicament.png" alt="Paracetamol">
            <h3>Paracétamol</h3>
            <p>Médicament utilisé pour soulager la douleur et réduire la fièvre.</p>
        </div>
        <div class="catalogue-item">
            <img src="images/cetr.png" alt="Cétirizine">
            <h3>Cétirizine</h3>
            <p>Antihistaminique pour le traitement des allergies.</p>
        </div>
        <div class="catalogue-item">
            <img src="images/asp.png" alt="Aspirine">
            <h3>Aspirine</h3>
            <p>Utilisée pour soulager la douleur, réduire l'inflammation et la fièvre.</p>
        </div>
        <div class="catalogue-item">
            <img src="images/asp.png" alt="Aspirine">
            
        </div>
    </div>
</main>


</body>
</html>