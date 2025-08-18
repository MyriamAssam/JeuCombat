package pong.frontal.vues;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import pong.commun.Action;
import pong.commun.Position;
import pong.commun.monde2d.MondePong2d;
import pong.frontal.controles.CanvasPartie;
import pong.frontal.evenements.EvtAfficherFileAttente;
import pong.frontal.utils.ActionsActivesParPosition;

public class VuePartie extends ViewFx {

	@FXML
	private Button boutonQuitterPartie;

	@FXML
	private CanvasPartie canvasPartie;
	@FXML
	private Pane conteneurVuePartie;

	@FXML
	private ActionsActivesParPosition actionsActives = new ActionsActivesParPosition();

	@Override
	public void initialize() {

		Ntro.assertNotNull(boutonQuitterPartie);
		Ntro.assertNotNull(canvasPartie);
		Ntro.assertNotNull(conteneurVuePartie);
		installerEvtAfficherFileAttente();
		installerEvtActionJoueur();
	}

	private void installerEvtAfficherFileAttente() {
		boutonQuitterPartie.setOnAction(evtFx -> {

			Ntro.logger().info("[VueFileAttente] clic:" + evtFx.getEventType());
			Ntro.newEvent(EvtAfficherFileAttente.class).trigger();
		});
	}

	private void installerEvtActionJoueur() {
		conteneurVuePartie.addEventFilter(KeyEvent.KEY_PRESSED, evtFx -> {

			Position position = positionPourTouche(evtFx.getCode());
			Action action = actionPourTouche(evtFx.getCode());

			actionsActives.activer(position, action);
		});

		conteneurVuePartie.addEventFilter(KeyEvent.KEY_RELEASED, evtFx -> {

			Position position = positionPourTouche(evtFx.getCode());
			Action action = actionPourTouche(evtFx.getCode());

			actionsActives.desactiver(position, action);
		});
	}

	private Position positionPourTouche(KeyCode code) {
		Position position = null;

		if (code.equals(KeyCode.W) || code.equals(KeyCode.S)) {

			position = Position.GAUCHE;

		} else if (code.equals(KeyCode.UP) || code.equals(KeyCode.DOWN)) {

			position = Position.DROITE;

		}

		return position;
	}

	private Action actionPourTouche(KeyCode code) {
		Action action = null;

		if (code.equals(KeyCode.W) || code.equals(KeyCode.UP)) {

			action = Action.MONTER;

		} else if (code.equals(KeyCode.S) || code.equals(KeyCode.DOWN)) {

			action = Action.DESCENDRE;

		}

		return action;
	}

	public void viderCanvas() {
		canvasPartie.clearCanvas();
	}

	public void afficherImagesParSeconde(String fps) {
		canvasPartie.afficherFps(fps);
	}

	public void afficherPong2d(MondePong2d mondePong2d) {
		mondePong2d.drawOn(canvasPartie);
	}
}