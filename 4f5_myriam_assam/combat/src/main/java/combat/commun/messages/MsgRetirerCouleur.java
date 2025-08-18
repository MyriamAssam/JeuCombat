package combat.commun.messages;

import ca.ntro.app.messages.Message;
import combat.commun.modeles.ModeleAchat;

public class MsgRetirerCouleur extends Message<MsgRetirerCouleur> {
	private String idAchat;

	public MsgRetirerCouleur setIdCouleur(String idAchat) {

		this.idAchat = idAchat;

		return this;
	}

	public void retirerCouleur(ModeleAchat achats) {

		achats.retirerAchat(idAchat);

	}
}
