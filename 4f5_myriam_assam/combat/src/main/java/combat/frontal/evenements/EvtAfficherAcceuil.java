package combat.frontal.evenements;

import ca.ntro.app.events.Event;
import combat.frontal.SessionCombat;
import combat.frontal.vues.VueAcceuil;
import combat.frontal.vues.VueAchat;
import combat.frontal.vues.VueRacine;

public class EvtAfficherAcceuil extends Event {
	public EvtAfficherAcceuil appliquerA(VueRacine vueRacine, VueAcceuil vueAcceuil) {

		vueRacine.afficherSousVue(vueAcceuil);

		return this;
	}

	public EvtAfficherAcceuil appliquerA(SessionCombat session) {

		session.memoriserVueCourante(VueAcceuil.class);

		return this;
	}

}
