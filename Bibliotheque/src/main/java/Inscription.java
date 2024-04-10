

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Membre.Membre;

/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Membre pers = new Membre(); 
		
		pers.setNom(request.getParameter("nom")) ;
		pers.setPrenom(request.getParameter("prenom")) ;
		pers.setNaissance(request.getParameter("dateNaissance")) ;
		pers.setMail(request.getParameter("mail")) ;
		pers.setTel(request.getParameter("tel")) ;
		pers.setAdresse(request.getParameter("adresse")) ;
		pers.setNomUtilisateur(request.getParameter("nomUtilisateur")) ;
		pers.setStatut(request.getParameter("statut")) ;
		pers.setMdp(request.getParameter("motDePasse")) ;
		
        String motDePasse = request.getParameter("motDePasse");
        String confirmationMotDePasse = request.getParameter("confirmationMotDePasse");

        if (!motDePasse.equals(confirmationMotDePasse)) {
        	System.out.println("Mot de passe incorrect");
            response.sendRedirect("Register.jsp?erreur=motsDePasseNonIdentiques");
            return;
        }else {
        	try {
				pers.enregistrementMembre(request, response);
				
				
			} catch (ClassNotFoundException | IOException | ServletException e) {
				System.out.println("Erreur d'enregistrement");
				e.printStackTrace();
			}
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
