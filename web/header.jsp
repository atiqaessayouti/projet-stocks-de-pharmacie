<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion de Stock</title>
    <link rel="stylesheet" href="styles.css">
    <style>
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
            <a href="dashboard.jsp">Accueil</a>
            <a href="medicaments.jsp">Médicaments</a>
            <a href="clients.jsp">Clients</a>
            <a href="fournisseurs.jsp">Fournisseurs</a>
            <a href="login.jsp" class="logout-link">Déconnexion</a>
        </nav>
    </header>
    <main>
