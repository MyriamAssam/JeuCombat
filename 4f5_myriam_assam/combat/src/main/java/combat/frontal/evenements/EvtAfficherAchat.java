package combat.frontal.evenements;

import ca.ntro.app.events.Event;
import combat.frontal.SessionCombat;
import combat.frontal.vues.VueAcceuil;
import combat.frontal.vues.VueAchat;
import combat.frontal.vues.VueRacine;

public class EvtAfficherAchat extends Event {
	public EvtAfficherAchat appliquerA(VueRacine vueRacine, VueAchat vueAchat) {

		vueRacine.afficherSousVue(vueAchat);

		return this;

	}

	public EvtAfficherAchat appliquerA(SessionCombat session) {

		session.memoriserVueCourante(VueAchat.class);

		return this;

	}
}