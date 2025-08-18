package combat.frontal.fragments;

import java.util.HashMap;
import java.util.Map;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import combat.commun.messages.MsgChangerCouleurBalle;
import combat.commun.messages.MsgRetirerCouleur;
import combat.commun.monde2d.Balle2d;
import combat.commun.monde2d.MondeCombat2d;
import combat.commun.valeurs.Couleur;
import combat.frontal.evenements.EvtAfficherAchat;
import combat.frontal.evenements.EvtChangerCouleurBalle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import combat.maquettes.maquettesCouleurs;

public class FragmentCouleur extends ViewFx {

	public void afficherNomCouleur(String nomCouleur) {
		labelCouleur.setText(nomCouleur);
	}

	@FXML
	private Pane conteneurPrincipal;

	@FXML
	private Button boutonRetirer;

	@FXML
	private Label labelCouleur;
	@FXML
	private Label labelScore;
	@FXML
	private ImageView imageCadenas;
	@FXML
	private Button boutonSelection;
	private String codeCouleur;
	private long scoreUtilisateur;
	private boolean tankCache = false;
	private boolean balleCache = false;
	private String couleurSelection = "";
	private Couleur currentCouleur;

	@Override
	public void initialize() {

		Ntro.assertNotNull(boutonRetirer);
		Ntro.assertNotNull(boutonSelection);
		Ntro.assertNotNull(labelCouleur);
		boutonSelectionAction();

	}

	public void afficherCouleurEnTexte(String texteCouleur) {
		labelCouleur.setText(texteCouleur);
	}

	public void boutonSelectionAction() {
		boutonSelection.setOnAction(evtFx -> {
			Ntro.newEvent(EvtChangerCouleurBalle.class).setColor(codeCouleur).trigger();

		});
	}

	public void afficherCouleur(String codeCouleur) {
		conteneurPrincipal.setStyle("-fx-background-color: " + codeCouleur + ";");
		this.codeCouleur = codeCouleur;

	}

	public void memoriserIdCouleur(String idAchat) {
		installerMsgRetirerCouleur(idAchat);
	}

	protected void installerMsgRetirerCouleur(String idAchat) {
		boutonRetirer.setOnAction(evtFx -> {
			Ntro.newMessage(MsgRetirerCouleur.class).setIdCouleur(idAchat).send();
		});
	}
}