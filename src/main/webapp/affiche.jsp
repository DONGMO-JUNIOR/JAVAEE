<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Annonces</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .nav-bar {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: sticky;
            top: 0;
            z-index: 1000;
            height: 70px;
        }
        .nav-bar a {
            color: white;
            text-decoration: none;
            font-size: 1.2rem;
            margin-right: 20px;
        }
        .nav-bar input[type="text"] {
            padding: 7px;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            width: 300px;
        }
        h1 {
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
            padding-top: 20px;
        }
        .card-container {
            display: block;
            max-width: 800px;
            margin: 0 auto;
        }
        .card {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 100%;
            margin-bottom: 20px;
            overflow: hidden;
            display: block;
        }
       
        .card-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: relative;
        }
        .card-header span {
            font-weight: bold;
            font-size: 30px;
            cursor: pointer;
        }
        .card-header, .card-body, .card-footer {
            padding: 20px;
        }
        .card-header h4 {
            margin: 0;
            font-size: 1.25rem;
            color: #007bff;
        }
        .card-header h4 a {
            text-decoration: none;
            color: inherit;
        }
        .card-header h4 a:hover {
            text-decoration: underline;
        }
        .card-body {
            flex-grow: 1;
        }
        .card-body p {
            margin: 0;
        }
        .card-footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .card-footer .stats {
            display: flex;
            justify-content: space-between;
            width: 100%;
        }
        .card-footer .stats i {
            margin-right: 5px;
        }
        .menu-content {
            display: none;
            position: absolute;
            right: 20px;
            top: 40px;
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.15);
            z-index: 1;
            width: 150px;
        }
        .menu-content a {
            padding: 10px;
            display: block;
            text-decoration: none;
            color: #007bff;
        }
        .menu-content a:hover {
            background-color: #f1f1f1;
        }
        .card-categorie {
            font-weight: bold;
            text-decoration: underline;
        }
        .date-info {
            font-size: 0.9rem;
            color: #6c757d;
            display: flex;
            align-items: center;
        }
        .date-info i {
            margin-right: 5px;
        }
        .no-results {
            text-align: center;
            color: red;
            font-size: 1.2rem;
            display: none;
        }
       img {
            
            border-radius: 50%;
        
        }
       .image {
            display: flex;
            flex-direction: row;
       }
    </style>
    <script>
        function toggleMenu(event) {
            var menu = event.currentTarget.nextElementSibling;
            menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
            event.stopPropagation();
        }

        window.onclick = function(event) {
            var menus = document.getElementsByClassName("menu-content");
            for (var i = 0; i < menus.length; i++) {
                var openMenu = menus[i];
                if (openMenu.style.display === 'block') {
                    openMenu.style.display = 'none';
                }
            }
        }

        function filterAnnonces() {
            var input = document.getElementById("searchInput");
            var filter = input.value.toLowerCase();
            var cards = document.getElementsByClassName("card");
            var noResults = true;
            for (var i = 0; i < cards.length; i++) {
                var card = cards[i];
                var title = card.getElementsByClassName("card-caption")[0].textContent.toLowerCase();
                if (title.indexOf(filter) > -1) {
                    card.style.display = "";
                    noResults = false;
                } else {
                    card.style.display = "none";
                }
            }
            document.getElementById("noResults").style.display = noResults ? "block" : "none";
        }
    </script>
</head>
<body>
    <header class="nav-bar">
        <a href="index.jsp">Accueil</a>
        <input type="text" id="searchInput" onkeyup="filterAnnonces()" placeholder="Rechercher par titre...">
    </header>
    
    <h1>Liste des Annonces</h1>
    <div class="card-container">
        <p id="noResults" class="no-results">CETTE ANNONCE N'EXISTE PAS</p>
        <c:forEach var="annonce" items="${annonces}" varStatus="status">
            <div class="card">
                <div class="card-header">
                    <div class="image">
                        <div class="img">
                            <img src="assets/img/hero/hero-5/${status.index + 1}.jpg" width="40" height="40">
                        </div>
                        
                        <h4 class="card-caption">
                            ${annonce.titre}
                        </h4>
                    </div>
                    
                    <span class="menu-left" onclick="toggleMenu(event)">⋮</span>
                    <div class="menu-content">
                        <a href="editAnnonce?id=${annonce.id}">Modifier</a>
                        <a href="deleteAnnonce?id=${annonce.id}">Supprimer</a>
                    </div>
                </div>
                <div class="card-body">
                    <p class="card-categorie">${annonce.categorie}</p>
                </div>
                <div class="card-body">
                    <p class="card-description">${annonce.contenu}</p>
                </div>
                <div class="card-footer">
                    <div class="stats">
                        <div class="date-info">
                            <i class="fa fa-clock-o"></i> <span class="text-success">Début de l'annonce: ${annonce.startDate}</span>
                        </div>
                        <div class="date-info">
                            <i class="fa fa-clock-o"></i> <span class="text-danger">Fin de l'annonce: ${annonce.endDate}</span>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
