
public class Livre {
	
	private String titre;
    private String auteur;
    private int anneePublication;
    private String categories;
    private int quantites;

    public Livre() {
    	
    }
    
    public String getTitre() {
		return titre;
	}

	public void setTitre(String t) {
		this.titre = t;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String a) {
		this.auteur = a;
	}

	public int getAnneePublication() {
		return anneePublication;
	}

	public void setAnneePublication(int a) {
		this.anneePublication = a;
	}
	
	public int getQuantites() {
		return quantites;
	}

	public void setQuantites(int t) {
		this.quantites = t;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String a) {
		this.categories = a;
	}


}
