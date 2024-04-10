<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bibliothèque - Accueil</title>
<link rel="stylesheet" href="Biblio.css">
</head>
<body>
	
	<header>
        <h1>Bibliothèque</h1>
        <nav>
            <ul class="menu">
                <li><a href="index.jsp">Accueil</a></li>
                <li><a href="ChargerLivre">Livres</a></li>
                <li><a href="Emprunt.jsp">Emprunts</a></li>
                <li><a href="Register.jsp">Inscription</a></li>
                <li><a href="Login.jsp">Connexion</a></li>
            </ul>
        </nav>
    </header>
    
    <main>
    	<h2>Bienvenue   	</h2>
	    	<%
	        String success = request.getParameter("success");
	        if ("user".equals(success)) {
	    %>
	    <p>Inscription réussie ! Bienvenue à la Bibliothèque.</p>
	    <%
	        }
	    %>
	    
        <div class="container_function">
	        <div class=text_center>
	            <h2 class="text_title"> Fonctionnalités </h2>
	        </div>
	        <ul class="container_list">
	            <li class="list">
	                <div>
	                    <strong>Check me !</strong><br><br>
	                    <a href="ListeMembre">Liste des adherants</a>
	                    <p>Vous pouvez voir les listes de tous les adherants consultant cette bibliotheque !</p>
	                    <a href="ListeMembre" class="boutton color_buttonBlack">Pick list</a>
	                </div>
	            </li>
	            <li class="list">
	                <div>
	                    <strong>Check me !</strong><br><br>
	                    <a href="ChargerLivre">Liste des livres</a>
	                    <p>Consulter tous les livres avec leurs categories et stock !</p>
	                    <a href="ChargerLivre" class="boutton color_buttonBlack">Pick list</a>
	                </div>
	            </li>
	            <li class="list">
	                <div>
	                    <strong>Check me !</strong><br><br>
	                    <a href="Emprunt.jsp">Emprunts</a>
	                    <p>Listes des emprunts de livres </p>
	                    <a href="Emprunt.jsp" class="boutton color_buttonBlack">Pick list</a>
	                </div>
	            </li>
	        </ul>
	    </div>
    
    </main>
    
    <footer>
        <p>&copy; 2024 Bibliothèque</p>
    </footer>

</body>
</html>