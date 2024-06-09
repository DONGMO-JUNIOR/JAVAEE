<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Annonces</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
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
         .card-header{
           display:flex;
           justify-content:space-between;  
          
        }
        .card-header span{
                 font-weight:bold;
                 font-size:30px;
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
            color: #6c757d;
        }
        .card-footer .stats i {
            margin-right: 5px;
        }
        .menu-button {
            cursor: pointer;
            color: #6c757d;
        }
        .menu-content {
            display: none;
            position: absolute;
            background-color: white;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.15);
            z-index: 1;
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
    </style>
    <script>
        function toggleMenu(event) {
            var menu = event.currentTarget.nextElementSibling;
            menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
        }

        window.onclick = function(event) {
            if (!event.target.matches('.menu-button')) {
                var menus = document.getElementsByClassName("menu-content");
                for (var i = 0; i < menus.length; i++) {
                    var openMenu = menus[i];
                    if (openMenu.style.display === 'block') {
                        openMenu.style.display = 'none';
                    }
                }
            }
        }
    </script>
</head>
<body>
    <h1>Liste des Annonces</h1>
    <div class="card-container">
        <c:forEach var="annonce" items="${annonces}">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-caption">
                        ${annonce.titre}
                    </h4>
                    <span class="menu-left " onclick="toggleMenu(event)">⋮</span>
                    
                </div>
                <div class="card-body">
                    <p class="card-description">${annonce.contenu}</p>
                </div>
                <div class="card-footer">
                    <div class="stats">
                        <i class="fa fa-clock-o"></i> Some Time
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
