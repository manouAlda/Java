package Membre;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Membre {
	private String nom;
	private String prenom;
	private String naissance;
	private String mail;
	private String tel;
	private String adresse;
	private String nomUtilisateur;
	private String statut;
	private String mdp;
	
	
	public Membre() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getNaissance() {
		return naissance;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nom) {
		this.nomUtilisateur = nom;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public void enregistrementMembre( HttpServletRequest request,HttpServletResponse response ) throws IOException, ServletException, ClassNotFoundException {
		
		String url = "jdbc:mysql://localhost:3306/bibliotheque";
        String utilisateur = "mit";
        String motDePasse = "123456";
        Connection connexion = null;
		
		try  {
			Class.forName("com.mysql.cj.jdbc.Driver");
            
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Personne WHERE Nom = ? and Nom_utilisateur = ? and Email = ?");
            statement.setString(1, this.nom);
            statement.setString(2, this.nomUtilisateur);
            statement.setString(3, this.mail);
            ResultSet resultat = statement.executeQuery();

            if (resultat.next()) {        // Utilisateur déjà existant
            	System.out.println("Utilisateur déja existant");
                response.sendRedirect("Register.jsp?erreur=utilisateurExistant");
            } else {
                
                PreparedStatement insertStatement = connexion.prepareStatement("INSERT INTO Personne (Nom, Prenom, Nom_utilisateur, Date_naissance, Email, Telephone, Adresse, Statut) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                insertStatement.setString(1, this.nom);
                insertStatement.setString(2, this.prenom);
                insertStatement.setString(3, this.nomUtilisateur);
                insertStatement.setString(4, this.naissance);
                insertStatement.setString(5, this.mail);
                insertStatement.setString(6, this.tel);
                insertStatement.setString(7, this.adresse);
                insertStatement.setString(8, this.statut);
                
                insertStatement.executeUpdate();
                
                PreparedStatement insertState = connexion.prepareStatement("INSERT INTO Utilisateur (Nom_utilisateur, Mot_de_passe) VALUES (?, ?)");
                insertState.setString(1, this.nomUtilisateur);
                insertState.setString(2, this.mdp);
                
                insertState.executeUpdate();

                //response.sendRedirect("Login.jsp?succes=inscriptionReussie");
                System.out.println("Inscription reussie");
                
                request.getSession().setAttribute("utilisateur", this.nomUtilisateur);
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
        	System.out.println("NON ");
            throw new ServletException("Erreur lors de la connexion à la base de données", e);
        } 
		
	}
}