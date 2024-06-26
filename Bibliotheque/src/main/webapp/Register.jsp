<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link rel="stylesheet" href="Register.css">
</head>
<body>

	<center><h1>Inscription</h1></center>

	<div class="container_add">
        <div class="centered_content">
            <div class="container">
                <form action="Inscription" method="post">
                    <h2>Inscription</h2>
                    <div class="content">
                        <div class="input_box">
	    					<input type="text" name="nom" placeholder="Nom" required>
	    				</div>
	    				<div class="input_box">
	    					<input type="text" name="prenom" placeholder="Prenom" required>
	    				</div>
	    				<div class="input_box">
					    <input type="date" name="dateNaissance" placeholder="Naissance" required>
					    </div>
					    <div class="input_box">
					    <input type="email" name="mail" placeholder="Email" required>
					    </div>
					    <div class="input_box">
					    <input type="tel" name="tel" placeholder="Telephone" required>
					    </div>
					    <div class="input_box">
					    <input type="text" name="adresse" placeholder="Adresse" required>
					    </div>
					    <div class="input_box">
					    <input type="text" name="nomUtilisateur" placeholder="Nom d'utilisateur" required>
					    </div>
					    <div class="box">
					    
						    <input type="radio" name="statut" value="Administrateur" required>Administrateur
						    <input type="radio" name="statut" value="Etudiant" required>Etudiant(e)
						    <input type="radio" name="statut" value="Personne" required>Personne
	    
					    </div>
					    <div class="input_box">
					    <input type="password" name="motDePasse" placeholder="Mot de passe" required>
					    </div>
					    <div class="input_box">
					    <input type="password" name="confirmationMotDePasse" placeholder="Confirmer le mot de passe" required>
					    </div>
	   
						<center >
                            <input type="submit" value="Submit" class="boutton color_buttonBlack" >
                        </center>
                    </div>
                </form>
            </div>
        </div>
    </div>
	
	<%
        String erreur = request.getParameter("erreur");
        if ("motsDePasseNonIdentiques".equals(erreur)) {
    %>
            <p style="color: red;">Les mots de passe ne correspondent pas.</p>
    <%
        } else if ("utilisateurExistant".equals(erreur)) {
    %>
            <p style="color: red;">Le nom d'utilisateur que vous avez choisi existe déjà. Veuillez en choisir un autre.</p>
    <%
        }
    %>

</body>
</html>