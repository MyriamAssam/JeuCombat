package combat.frontal.evenements;

import ca.ntro.app.events.Event;
import combat.frontal.SessionCombat;
import combat.frontal.donnees.DonneesVueAchat;
import combat.frontal.vues.VueAchat;
import combat.frontal.vues.VueRacine;

public class EvtChangerCouleurBalle extends Event {
	private String color;

	public EvtChangerCouleurBalle setColor(String color) {
		this.color = color;
		return this;
	}

	public String getColor() {
		return color;
	}

	public void appliquerA(DonneesVueAchat donneesVueAchat) {
		donneesVueAchat.changerCouleurBalle(color);
		
	}
}