package combat.commun.valeurs;

import ca.ntro.app.models.ModelValue;
import combat.commun.valeurs.Joueur;

public class Couleur implements ModelValue {

	private String id;
	private String nom;
	private String codeHex;
	private boolean debloque;
	private long prix;
	private boolean tankCache = false; // Default to false
	private boolean balleCache = false; // Default to false
	private String couleurSelection = ""; // Default to empty

	public Couleur() {
		// Default initialization
		resetProperties();
	}

	// Resets properties to their default values
	private void resetProperties() {
		this.tankCache = false;
		this.balleCache = false;
		this.couleurSelection = "";
	}

	// Standard getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodeHex() {
		return codeHex;
	}

	public void setCodeHex(String codeHex) {
		this.codeHex = codeHex;
	}

	public boolean isDebloque() {
		return debloque;
	}

	public void setDebloque(boolean debloque) {
		this.debloque = debloque;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public boolean isTankCache() {
		return tankCache;
	}

	public void setTankCache(boolean tankCache) {
		this.tankCache = tankCache;
	}

	public boolean isBalleCache() {
		return balleCache;
	}

	public void setBalleCache(boolean balleCache) {
		this.balleCache = balleCache;
	}

	public String getCouleurSelection() {
		return couleurSelection;
	}

	public void setCouleurSelection(String couleurSelection) {
		this.couleurSelection = couleurSelection;
	}
}