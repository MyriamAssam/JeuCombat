package pong.frontal.fragments;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import pong.frontal.evenements.EvtAfficherPartie;

public class FragmentRendezVous extends ViewFx {
	public void afficherNomPremierJoueur(String nomPremierJoueur) {
		labelNomPremierJoueur.setText(nomPremierJoueur);
	}

	@FXML
	private Button boutonDebuterPartie;

	@FXML
	private Pane conteneurPrincipal;

	@FXML
	private Button boutonRetirerRendezVous;

	@FXML
	private Label labelNomPremierJoueur;

	protected Button getBoutonDebuterPartie() {
        return boutonDebuterPartie;
    }


	@Override
	public void initialize() {
		Ntro.assertNotNull(boutonDebuterPartie);
		Ntro.assertNotNull(boutonRetirerRendezVous);
		Ntro.assertNotNull(labelNomPremierJoueur);
		
		conteneurPrincipal.setStyle("-fx-background-color:blue;");
		installerEvtAfficherPartie();
    }

    
    protected void installerEvtAfficherPartie() {

        getBoutonDebuterPartie().setOnAction(evtFx -> {

            Ntro.newEvent(EvtAfficherPartie.class)
                .trigger();

        });
    }
}