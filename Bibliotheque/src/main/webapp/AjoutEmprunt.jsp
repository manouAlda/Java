<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bibliotheque-Ajouter un Emprunt</title>
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

	<center><h1>Ajout d'emprunts</h1></center>
	<div class="container_add">
        <div class="centered_content">
            <div class="container">

				<form action="AjouterEmprunt" method="post">
					<div class="input_box">
						<label for="id_utilisateur">ID Utilisateur:</label>
        				<input type="number" id="id_utilisateur" name="id_utilisateur" required>
					</div>
					<div class="input_box">
						<label for="id_livre">ID Livre:</label>
      					  <input type="number" id="id_livre" name="id_livre" required>
					</div>
					<div class="input_box">
						<label for="date_emprunt">Date d'Emprunt:</label>
        				<input type="date" id="date_emprunt" name="date_emprunt" required>
					</div>
					<div class="input_box">
						<label for="date_retour">Date de Retour:</label>
      					  <input type="date" id="date_retour" name="date_retour" required>
					</div>
				    
				    <div class="input_box">
				    	<input type="submit" value="Ajouter">
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
