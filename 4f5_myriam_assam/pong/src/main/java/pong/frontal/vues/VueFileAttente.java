package pong.frontal.vues;

import java.util.HashMap;
import java.util.Map;

import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import ca.ntro.app.frontend.ViewLoader;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pong.commun.enums.Region;
import pong.commun.valeurs.RendezVous;
import pong.frontal.SessionPong;
import pong.frontal.evenements.EvtChangerRegion;
import pong.frontal.fragments.FragmentRendezVous;
import pong.frontal.fragments.FragmentRendezVousComplet;

public class VueFileAttente extends ViewFx {

	@FXML
	private Button boutonSInscrire;

	@FXML
	private VBox conteneurRendezVous;
	private ViewLoader<FragmentRendezVous> viewLoaderRendezVous;
	private ViewLoader<FragmentRendezVousComplet> viewLoaderRendezVousComplet;
	@FXML
	private ComboBox<String> comboRegion; // ajouter

	// ajouter
	private Map<Region, String> nomRegionParRegion = new HashMap<>();
	private Map<String, Region> regionParNomRegion = new HashMap<>();

	@Override
	public void initialize() {
		Ntro.assertNotNull(boutonSInscrire);
		Ntro.assertNotNull(conteneurRendezVous);
		initialiserBoutonSInscrire();
		Ntro.assertNotNull(comboRegion);

		initialiserRegions();

		initialiserComboRegion();
	}

	private void initialiserRegions() {
		for (Region region : Region.values()) {
			String nomRegion = resources().getString(region.name());
			nomRegionParRegion.put(region, nomRegion);
			regionParNomRegion.put(nomRegion, region);
		}
	}

	// ajouter
	private void initialiserComboRegion() {
		comboRegion.setFocusTraversable(false);

		for (Region region : Region.values()) {
			comboRegion.getItems().add(nomRegionParRegion.get(region));
		}

		comboRegion.setOnAction(evtFx -> actionComboRegion());

	}

	// ajouter
	private void actionComboRegion() {

		String nomRegion = comboRegion.getSelectionModel().getSelectedItem();

		Region region = regionParNomRegion.get(nomRegion);

		if (region != null) {

			Ntro.newEvent(EvtChangerRegion.class).setRegion(region).trigger();
		}
	}

	public void afficherRendezVousEnTexte(String string) {

	}

	public void ajouterRendezVous(RendezVous rendezVous) {
		FragmentRendezVous fragment = rendezVous.creerFragment(viewLoaderRendezVous, viewLoaderRendezVousComplet);
		rendezVous.afficherSur(fragment);

		conteneurRendezVous.getChildren().add(fragment.rootNode());
	}

	public void afficherRegionCourante(String idRegion) {
		Region region = null;

		if (idRegion != null) {
			region = Region.valueOf(idRegion);
		}

		if (region == null) {

			comboRegion.getSelectionModel().clearSelection();

		} else {

			comboRegion.getSelectionModel().select(nomRegionParRegion.get(region));

		}
	}

	public void viderListeRendezVous() {
		conteneurRendezVous.getChildren().clear();
	}

	private void initialiserBoutonSInscrire() {
		SessionPong session = Ntro.session();

		boutonSInscrire.setOnAction(evtFx -> {

			session.envoyerMsgAjouterRendezVous();

		});
	}

	public ViewLoader<FragmentRendezVous> getViewLoaderRendezVous() {
		return viewLoaderRendezVous;
	}

	public void setViewLoaderRendezVous(ViewLoader<FragmentRendezVous> viewLoaderRendezVous) {
		this.viewLoaderRendezVous = viewLoaderRendezVous;
	}

	public ViewLoader<FragmentRendezVousComplet> getViewLoaderRendezVousComplet() {
		return viewLoaderRendezVousComplet;
	}

	public void setViewLoaderRendezVousComplet(ViewLoader<FragmentRendezVousComplet> viewLoaderRendezVousComplet) {
		this.viewLoaderRendezVousComplet = viewLoaderRendezVousComplet;
	}

}