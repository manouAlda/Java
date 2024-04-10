

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Authentification
 */
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String nomUtilisateur = request.getParameter("nomUtilisateur");
        String motDePasse = request.getParameter("motDePasse");

        String url = "jdbc:mysql://localhost:3306/bibliotheque";
        String utilisateur = "mit";
        String mdp = "123456";
        Connection connexion = null;
        
        try  {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connexion = DriverManager.getConnection(url, utilisateur, mdp);
            
            PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Utilisateur WHERE Nom_utilisateur = ?");
            statement.setString(1, nomUtilisateur);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                
                if (motDePasse.equals(resultSet.getString("Mot_de_passe"))) {
                    
                    request.getSession().setAttribute("utilisateur", nomUtilisateur);
                    response.sendRedirect("index.jsp");
                } else {
                    // Mot de passe incorrect
                    response.sendRedirect("Login.jsp?erreur=motDePasseIncorrect");
                }
            } else {
                // Utilisateur non trouvé
                response.sendRedirect("Login.jsp?erreur=utilisateurNonTrouve");
            }
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de la connexion à la base de données", e);
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
