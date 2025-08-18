package combat.frontal.evenements;

import ca.ntro.app.Ntro;
import ca.ntro.app.events.Event;
import combat.commun.Action;
import combat.commun.Position;
import combat.commun.messages.MsgActionAutreJoueur;
import combat.frontal.donnees.DonneesVueAchat;
import combat.frontal.evenements.EvtActionJoueur;

public class EvtActionJoueur extends Event {

	private Position position;
	private Action action;

	public EvtActionJoueur setPosition(Position position) {
		this.position = position;

		return this;
	}

	public EvtActionJoueur setAction(Action action) {
		this.action = action;

		return this;
	}

	public void appliquerA(DonneesVueAchat donneesVueAchat) {
		donneesVueAchat.appliquerActionJoueur(position, action);
	}

	

}
