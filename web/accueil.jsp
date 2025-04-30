<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil - Gestion Pharmacie</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #3498db, #8e44ad);
            margin: 0;
            color: white;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        header {
            background-color: rgba(0, 0, 0, 0.2);
            padding: 20px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
        }

        .logo img {
            height: 60px;
        }

        .nav-links a {
            color: white;
            text-decoration: none;
            margin-left: 30px;
            font-weight: 600;
            font-size: 16px;
            transition: color 0.3s ease;
        }

        .nav-links a:hover {
            color: #f1c40f;
        }

        main {
            text-align: center;
            padding: 60px 20px;
            flex: 1;
        }

        main h1 {
            font-size: 42px;
            margin-bottom: 20px;
            color: #ffffff;
        }

        main p {
            font-size: 20px;
            max-width: 800px;
            margin: 0 auto 40px;
            line-height: 1.6;
            color: #ecf0f1;
        }

        .catalogue {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 30px;
            padding: 40px 20px;
        }

        .catalogue-item {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
            padding: 20px;
            max-width: 250px;
            transition: transform 0.3s ease;
            text-align: center;
            color: #2c3e50;
        }

        .catalogue-item:hover {
            transform: translateY(-8px);
        }

        .catalogue-item img {
            width: 100%;
            height: 160px;
            object-fit: contain;
            border-radius: 8px;
            margin-bottom: 15px;
        }

        .catalogue-item h3 {
            font-size: 20px;
            margin-bottom: 10px;
        }

        .catalogue-item p {
            font-size: 15px;
            color: #34495e;
        }

        footer {
            background-color: rgba(255, 255, 255, 0.1);
            padding: 15px;
            text-align: center;
            color: #ecf0f1;
            font-size: 14px;
        }

        @media (max-width: 768px) {
            .nav-links a {
                margin-left: 15px;
                font-size: 14px;
            }

            main h1 {
                font-size: 32px;
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
    <h1>Bienvenue sur notre plateforme de gestion de pharmacie</h1>
    <p>Découvrez nos médicaments les plus utilisés pour soulager les douleurs, traiter les allergies, et bien plus encore.</p>

    <div class="catalogue">
        <div class="catalogue-item">
            <img src="images/medicament.png" alt="Paracétamol">
            <h3>Paracétamol</h3>
            <p>Utilisé pour soulager la douleur et réduire la fièvre.</p>
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
            <img src="images/medicament.png" alt="Paracétamol">
            <h3>Paracétamol</h3>
            <p>Utilisé pour soulager la douleur et réduire la fièvre.</p>
        </div>
        <div class="catalogue-item">
            <img src="images/cetr.png" alt="Cétirizine">
            <h3>Cétirizine</h3>
            <p>Antihistaminique pour le traitement des allergies.</p>
        </div>
        
    </div>
</main>



</body>
</html>
