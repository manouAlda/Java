

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ListeMembre
 */
public class ListeMembre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeMembre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Personne> pers = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/bibliotheque";
        String utilisateur = "mit";
        String motDePasse = "123456";
        Connection connexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            
            String recherche = request.getParameter("recherche");
            String query = "SELECT * FROM Personne";
            if (recherche != null && !recherche.isEmpty()) {
                query += " WHERE Nom LIKE ? OR Prenom LIKE ? OR Nom_utilisateur LIKE ? OR Date_naissance LIKE ? OR Email LIKE ? OR Telephone LIKE ? OR Adresse LIKE ? OR Statut LIKE ?";
           
            }

            PreparedStatement statement = connexion.prepareStatement(query);
            
            if (recherche != null && !recherche.isEmpty()) {
            	statement.setString(1, "%" + recherche + "%");
                statement.setString(2, "%" + recherche + "%");
                statement.setString(3, "%" + recherche + "%");
                statement.setString(4, "%" + recherche + "%");
                statement.setString(5, "%" + recherche + "%");
                statement.setString(6, "%" + recherche + "%");
                statement.setString(7, "%" + recherche + "%");
                statement.setString(8, "%" + recherche + "%");
            }

            
           
            ResultSet resultat = statement.executeQuery();

            while (resultat.next()) {
                Personne Personne = new Personne();
                Personne.setNom(resultat.getString("Nom"));
                Personne.setPrenom(resultat.getString("Prenom"));
                Personne.setNomUtilisateur(resultat.getString("Nom_utilisateur"));
                Personne.setDateNaissance(resultat.getString("Date_naissance"));
                Personne.setEmail(resultat.getString("Email"));
                Personne.setTelephone(resultat.getString("Telephone"));
                Personne.setAdresse(resultat.getString("Adresse"));
                Personne.setStatut(resultat.getString("Statut"));
                pers.add(Personne);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Erreur lors de la connexion à la base de données", e);
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

//        request.setAttribute("pers", pers);
//        request.getRequestDispatcher("listepers.jsp").forward(request, response);
        
        PrintWriter p = response.getWriter();
        p.println("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Bibliothèque - Liste des pers</title>\n"
                + "    <link rel=\"stylesheet\" href=\"Biblio.css\"> \n"
                + "    <link rel=\"stylesheet\" href=\"Livre.css\"> \n"
                + "</head>\n"
                + "<body>\n"
                + "    <header>\n"
                + "        <h1>Bibliothèque</h1>\n"
                + "        <nav>\n"
                + "            <ul class=\"menu\">\n"
                + "                <li><a href=\"index.jsp\">Accueil</a></li>\n"
                + "                <li><a href=\"ChargerLivre\">Livres</a></li>\n"
                + "                <li><a href=\"Emprunt.jsp\">Emprunts</a></li>\n"
                + "                <li><a href=\"Register.jsp\">Inscription</a></li>\n"
                + "                <li><a href=\"Login.jsp\">Connexion</a></li>\n"
                + "            </ul>\n"
                + "        </nav>\n"
                + "    </header>\n"
                + "    <main>\n"
                + "			<div class=\"listeL\">"
                + "        		<h2>Liste des pers</h2>\n"
                + "				<div>"
                + "					<div>"
                + "						<form action='ListeMembre' method='get'> "
                + "						<input type=\"search\" name=\"recherche\">"
                + "						<input type=\"submit\">"
                + "						</form>"			
                + "					</div>"
                + "					<div>"
                + "					<a href='AjoutEtudiant.jsp'> <button class=\"boutton color_buttonBlack\" > Ajouter </button> </a>"
                + "					</div>"
                + "				</div>"
                + "			</div>"
                + "        <div class=\"container_add\">\n"
                + "            <div class=\"centered_content\">\n"
                + "                <div class=\"container\">\n"
                + "                    <table>\n"
                + "                        <tr>\n"
                + "                            <th>Nom</th>\n"
                + "                            <th>Prenom</th>\n"
                + "                            <th>Nom utilisateur</th>\n"
                + "                            <th>Date de naissance</th>\n"
                + "                            <th>Email</th>\n"
                + "                            <th>Telephone</th>\n"
                + "                            <th>Adresse</th>\n"
                + "                            <th>Statut</th>\n"
                + "                        </tr>");

        for (Personne Personne : pers) {
            p.println("<tr>\n"
                    + "    <td>" + Personne.getNom() + "</td>\n"
                    + "    <td>" + Personne.getPrenom() + "</td>\n"
                    + "    <td>" + Personne.getNomUtilisateur() + "</td>\n"
                    + "    <td>" + Personne.getDateNaissance() + "</td>\n"
                    + "    <td>" + Personne.getEmail() + "</td>\n"
                    		 + "    <td>" + Personne.getTelephone() + "</td>\n"
                             + "    <td>" + Personne.getAdresse() + "</td>\n"
                             + "    <td>" + Personne.getStatut() + "</td>\n"
                    + "</tr>");
        }

        p.println("                    </table>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </main>\n"
                + "    <footer>\n"
                + "        <p>&copy; 2024 Bibliothèque</p>\n"
                + "    </footer>\n"
                + "</body>\n"
                + "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
