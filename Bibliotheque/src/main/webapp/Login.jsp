<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="Register.css">
</head>
<body>

	<center><h1>Login</h1></center>

	<div class="container_add">
        <div class="centered_content">
            <div class="container">

				<form action="Authentification" method="post">
					<div class="input_box">
						<label>Nom d'utilisateur: </label>
						<input type="text" name="nomUtilisateur" placeholder="Nom d'utilisateur" required>
					</div>
				    <div class="input_box">
				    	<label>Mot de passe: </label>
				    	<input type="password" name="motDePasse" placeholder="Mot de passe" required>
				    </div>
				    
				    
				    <p>Si vous n'avez pas encore de compte. <a href='http://localhost:8080/Bibliotheque/Register.jsp'>Inscrivez-vous ! </a></p>
				
				
						<center >
                            <input type="submit" value="Submit" class="boutton color_buttonBlack" >
                        </center>
                    
                </form>
            </div>
        </div>
    
	
	<%
        String erreur = request.getParameter("erreur");
        if ("motDePasseIncorrect".equals(erreur)) {
    %>
            <p style="color: red;">Mot de passe incorrect.</p>
    <%
        } else if ("utilisateurNonTrouve".equals(erreur)) {
    %>
            <p style="color: red;">Nom d'utilisateur incorrect.</p>
    <%
        }
    %>
	
</body>
</html>