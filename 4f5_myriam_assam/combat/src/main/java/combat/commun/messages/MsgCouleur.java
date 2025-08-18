package combat.commun.messages;

import ca.ntro.app.messages.Message;
import combat.commun.modeles.ModeleAchat;
import combat.commun.valeurs.Couleur;

public class MsgCouleur extends Message<MsgCouleur> {
	private Couleur premiereCouleur;

	public MsgCouleur setPremiereCouleur(Couleur premiereCouleur) {
		this.premiereCouleur = premiereCouleur;

		return this;
	}

	public void ajouterA(ModeleAchat achats) {

		achats.ajouterAchat(premiereCouleur);
	}

}