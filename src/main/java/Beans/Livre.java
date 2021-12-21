package Beans;

public class Livre {
	
	String isbn, titre, auteur;
	float prix;
	int nbrpages, annee_edition;
	
	
	public Livre() {
		// TODO Auto-generated constructor stub
		String a = "tata";
		String b = "ttata";
	}
	
	public Livre(String isbn, String titre, String auteur, float prix, int nbrpages, int annee_edition) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.auteur = auteur;
		this.nbrpages = nbrpages;
		this.annee_edition = annee_edition;
		this.prix = prix;
	}
	
	public Livre(String isbn) {
		this.isbn = isbn;
    }
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getNbrpages() {
		return nbrpages;
	}
	public void setNbrpages(int nbrpages) {
		this.nbrpages = nbrpages;
	}
	public int getAnnee_edition() {
		return annee_edition;
	}
	public void setAnnee_edition(int annee_edition) {
		this.annee_edition = annee_edition;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	
	
}
