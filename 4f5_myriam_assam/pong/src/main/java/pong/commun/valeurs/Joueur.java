package pong.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue {

	private String id;
	private String prenom;
	private String nom;

	public void setId(String id) {
		this.id = id;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Joueur() {

	}

	public String nomComplet() {
		return prenom + " " + nom;
	}

	public String nomCourt() {
		return prenom;
	}
}