package combat.commun.messages;



import ca.ntro.app.messages.Message;
import combat.commun.Action;
import combat.commun.Position;
import combat.frontal.donnees.DonneesVueAchat;
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

	public void appliquerA(DonneesVueAchat donneesVueAchat) {
		donneesVueAchat.appliquerActionJoueur(position, action);
	}
}
