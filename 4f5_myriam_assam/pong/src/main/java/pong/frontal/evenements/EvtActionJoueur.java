package pong.frontal.evenements;

import ca.ntro.app.Ntro;
import ca.ntro.app.events.Event;
import pong.commun.Action;
import pong.commun.Position;
import pong.commun.messages.MsgActionAutreJoueur;
import pong.frontal.donnes.DonneesVuePartie;

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

	public void appliquerA(DonneesVuePartie donneesVuePartie) {
		donneesVuePartie.appliquerActionJoueur(position, action);
	}

	public void diffuserMsgActionAutreJoueur() {
		Ntro.newMessage(MsgActionAutreJoueur.class).setPosition(position).setAction(action).broadcast();
	}

}