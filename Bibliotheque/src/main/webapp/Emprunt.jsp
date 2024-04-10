<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bibliotheque-Emprunt</title>
<link rel="stylesheet" href="Emprunt.css">
<link rel="stylesheet" href="Biblio.css">
<link rel="stylesheet" href="Livre.css">
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

	<center><h1>Emprunts</h1></center>

	<div class="container_function">
	        <ul class="container_list">
	            <li class="list">
	                <div>
	                    <strong>Check me !</strong><br><br>
	                    <a href="AjoutEmprunt.jsp">Ajouter un emprunt</a>
	                    <p>Ajouter un emprunt de livre !</p>
	                    <a href="AjoutEmprunt.jsp" class="boutton color_buttonBlack">Ajouter</a>
	                </div>
	            </li>
	            <li class="list">
	                <div>
	                    <strong>Check me !</strong><br><br>
	                    <a href="ListEmprunt">Liste des emprunts</a>
	                    <p>Consulter tous les emprunts !</p>
	                    <a href="ListEmprunt" class="boutton color_buttonBlack">Lister</a>
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