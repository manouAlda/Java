
public class Emprunt {
	private String id_u;
    private String id_l;
    private String emprunt;
    private String retour;
    
    public Emprunt() {
    	
    }
    
    public String getId_u() {
		return id_u;
	}

	public void setId_u(String t) {
		this.id_u = t;
	}

	public String getId_l() {
		return id_l;
	}

	public void setId_l(String a) {
		this.id_l = a;
	}

	public String getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(String i) {
		this.emprunt = i;
	}
	
	public String getRetour() {
		return retour;
	}

	public void setRetour(String t) {
		this.retour = t;
	}
}
