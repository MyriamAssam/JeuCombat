package combat.commun.valeurs;

import combat.commun.valeurs.Joueur;

public class AchatComplet extends Achat {
	private Couleur deuxiemeCouleur;

	public AchatComplet() {
		super();
	}

	@Override
	public String toString() {
		return premiereCouleur().getNom() + " Vs " + deuxiemeCouleur.getNom();
	}
}
