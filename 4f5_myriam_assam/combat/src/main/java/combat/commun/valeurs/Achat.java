package combat.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;
import combat.frontal.fragments.FragmentCouleur;

public class Achat implements ModelValue {
	private String idAchat;
	private Couleur premiereCouleur;

	public FragmentCouleur creerFragment(ViewLoader<FragmentCouleur> viewLoaderCouleur) {
		return viewLoaderCouleur.createView();
	}

	public void afficherSur(FragmentCouleur fragmentCouleur) {
		fragmentCouleur.memoriserIdCouleur(idAchat);
		
		fragmentCouleur.afficherCouleurEnTexte(premiereCouleur.getNom());
		fragmentCouleur.afficherCouleur(premiereCouleur.getCodeHex());
	}

	public Achat() {
	}

	public Achat(String idAchat, Couleur premiereCouleur) {
		this.idAchat = idAchat;
		this.premiereCouleur = premiereCouleur;
	}
	public boolean siIdEst(String idAchat) {
        return this.idAchat.equals(idAchat);
    }
	protected Couleur premiereCouleur() {
		return premiereCouleur;
	}

	@Override
	public String toString() {
		return premiereCouleur().getNom();
	}
}
