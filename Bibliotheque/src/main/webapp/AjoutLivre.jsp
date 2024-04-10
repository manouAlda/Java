<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bibliotheque-Ajout</title>
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

	<center><h1>Ajout</h1></center>

	<div class="container_add">
        <div class="centered_content">
            <div class="container">

				<form action="AjouterLivre" method="post">
					<div class="input_box">
						<label for="titre">Titre:</label>
				    	<input type="text" id="titre" name="titre" required>
					</div>
					<div class="input_box">
						<label for="auteur">Auteur:</label>
				    	<input type="text" id="auteur" name="auteur" required>
					</div>
					<div class="input_box">
						<label for="anneePublication">Année de Publication:</label>
				    	<input type="number" id="anneePublication" name="anneePublication" required>
					</div>
					<div class="input_box">
						<label for="categories">Catégories:</label>
				    	<input type="text" id="categories" name="categories" required>
					</div>
					<div class="input_box">
						<label for="quantites">Quantités:</label>
				    	<input type="number" id="quantites" name="quantites" required>
					</div>
				    
				    <div class="input_box">
				    	<input type="submit" value="Ajouter Livre">
				    </div>
				</form>

            </div>
        </div>
        
    </main>
    
    <footer>
        <p>&copy; 2024 Bibliothèque</p>
    </footer>

</body>
</html>