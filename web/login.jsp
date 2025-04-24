<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <style>
        /* Style général du body */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #3498db, #8e44ad);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: white;
        }

        /* Style du formulaire */
        form {
            background-color: rgba(255, 255, 255, 0.9); /* Fond légèrement transparent */
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
            transition: transform 0.3s ease-in-out;
        }

        form:hover {
            transform: scale(1.05); /* Agrandissement du formulaire au survol */
        }

        /* Titre du formulaire */
        h2 {
            margin-bottom: 20px;
            color: #333;
            font-size: 24px;
        }

        /* Styles des champs de saisie */
        input[type="email"],
        input[type="password"],
        input[type="submit"] {
            width: 100%;
            padding: 14px;
            margin-top: 15px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        /* Changement de couleur des champs lorsqu'on les sélectionne */
        input[type="email"]:focus,
        input[type="password"]:focus {
            border-color: #3498db;
            outline: none;
        }

        /* Style du bouton de soumission */
        input[type="submit"] {
            background-color: #3498db;
            color: white;
            font-weight: bold;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.3s;
        }

        /* Effet au survol du bouton */
        input[type="submit"]:hover {
            background-color: #2980b9;
            transform: scale(1.05);
        }

        /* Message d'erreur */
        .error {
            color: red;
            margin-bottom: 10px;
            font-size: 14px;
        }

        /* Lien d'inscription */
        .register-link {
            margin-top: 20px;
            font-size: 14px;
        }

        .register-link a {
            color: #3498db;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .register-link a:hover {
            color: #2980b9;
            text-decoration: underline;
        }

        /* Animation pour le fond */
        @keyframes backgroundAnimation {
            0% { background-position: 0 0; }
            100% { background-position: 100% 100%; }
        }
        
        /* Application de l'animation sur le body */
        body {
            animation: backgroundAnimation 5s infinite linear;
        }
    </style>
</head>

<body>
    <form method="POST" action="UserController">
        <h2>Connexion</h2>

        <!-- Affichage des erreurs de connexion -->
        <div class="error">
            <% if (request.getAttribute("errorMessage") != null) { %>
                <%= request.getAttribute("errorMessage") %>
            <% } %>
        </div>

        <!-- Formulaire de connexion -->
        <input type="hidden" name="op" value="login" />
        
        <input type="email" id="email" name="email" placeholder="Entrez votre email" required />
        <input type="password" id="mdp" name="mdp" placeholder="Entrez votre mot de passe" required />
        
        <input type="submit" value="Se connecter" />

        <!-- Lien d'inscription -->
        <div class="register-link">
            <p>Pas encore de compte ? <a href="inscription.jsp">Inscrivez-vous ici</a></p>
        </div>
    </form>
</body>
</html>
