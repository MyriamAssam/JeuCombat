package pong.commun.messages;

import ca.ntro.app.messages.Message;
import pong.commun.Action;
import pong.commun.Position;
import pong.frontal.donnes.DonneesVuePartie;

public class MsgActionAutreJoueur extends Message<MsgActionAutreJoueur> {

	private Position position;
	private Action action;

	public MsgActionAutreJoueur setPosition(Position position) {
		this.position = position;

		return this;
	}

	public MsgActionAutreJoueur setAction(Action action) {
		this.action = action;

		return this;
	}

	public MsgActionAutreJoueur() {
	}

	public void appliquerA(DonneesVuePartie donneesVuePartie) {
		donneesVuePartie.appliquerActionJoueur(position, action);
	}
}
