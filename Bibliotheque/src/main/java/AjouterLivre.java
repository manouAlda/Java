

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class AjouterLivre
 */
public class AjouterLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        int anneePublication = Integer.parseInt(request.getParameter("anneePublication"));
        String categories = request.getParameter("categories");
        int quantites = Integer.parseInt(request.getParameter("quantites"));

        String url = "jdbc:mysql://localhost:3306/bibliotheque";
        String utilisateur = "mit";
        String motDePasse = "123456";
        Connection connexion = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            PreparedStatement statement = connexion.prepareStatement("INSERT INTO Livre (Titre, Auteur, Annee_publication, Categorie, Quantite) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, titre);
            statement.setString(2, auteur);
            statement.setInt(3, anneePublication);
            statement.setString(4, categories);
            statement.setInt(5, quantites);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Erreur lors de l'ajout du livre", e);
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        response.sendRedirect("ChargerLivre");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
