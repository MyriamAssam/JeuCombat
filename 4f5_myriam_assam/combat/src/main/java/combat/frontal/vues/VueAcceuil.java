package combat.frontal.vues;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import combat.frontal.SessionCombat;
import combat.frontal.evenements.EvtAfficherAchat;
import combat.frontal.evenements.EvtAfficherAcceuil;

public class VueAcceuil extends ViewFx {

	@FXML
	private Button boutonAcheter;

	@Override
	public void initialize() {

		Ntro.assertNotNull(boutonAcheter);

		installerEvtAfficherAchat();

	}

	private void installerEvtAfficherAchat() {
		boutonAcheter.setOnAction(evtFx -> {

			Ntro.logger().info("[VueAchat] clic:" + evtFx.getEventType());
			Ntro.newEvent(EvtAfficherAchat.class).trigger();

		});
	}

}