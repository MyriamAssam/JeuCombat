package pong.frontal.fragments;

import ca.ntro.app.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FragmentRendezVousComplet extends FragmentRendezVous {
	public void afficherNomDeuxiemeJoueur(String nomDeuxiemeJoueur) {
		labelNomDeuxiemeJoueur.setText(nomDeuxiemeJoueur);
	}

	@FXML
	private Label labelNomDeuxiemeJoueur;

	@Override
	public void initialize() {
		super.initialize();

		Ntro.assertNotNull(labelNomDeuxiemeJoueur);
	}

}
