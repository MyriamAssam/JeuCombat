package combat.frontal;

import ca.ntro.app.Ntro;
import ca.ntro.app.session.AfterSessionFirstCreated;
import ca.ntro.app.session.Session;
import combat.commun.messages.MsgCouleur;
import combat.frontal.evenements.EvtAfficherAchat;
import combat.frontal.evenements.EvtAfficherAcceuil;
import combat.frontal.vues.VueAcceuil;
import combat.frontal.vues.VueAchat;
import combat.maquettes.maquettesCouleurs;

public class SessionCombat extends Session<SessionCombat> implements AfterSessionFirstCreated {
	private Class<?> vueCourante = VueAcceuil.class;

	public SessionCombat() {
		super();
	}

	public SessionCombat memoriserVueCourante(Class<?> vueCourante) {

		this.vueCourante = vueCourante;

		return this;
	}

	public void envoyerEvtPourAfficherVueCourante() {

		if (vueCourante.equals(VueAcceuil.class)) {

			Ntro.newEvent(EvtAfficherAchat.class).trigger();

		} else {

			Ntro.newEvent(EvtAfficherAcceuil.class).trigger();
		}
	}

	public void envoyerMsgCouleur() {
		Ntro.newMessage(MsgCouleur.class).setPremiereCouleur(maquettesCouleurs.couleurAleatoire(this.sessionId()))
				.send();
	}

	@Override
	public void afterSessionFirstCreated() {
		// TODO Auto-generated method stub

	}
}