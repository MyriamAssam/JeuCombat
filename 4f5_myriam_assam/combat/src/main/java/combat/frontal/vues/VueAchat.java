
package combat.frontal.vues;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import ca.ntro.app.Ntro;
import ca.ntro.app.frontend.ViewFx;
import ca.ntro.app.frontend.ViewLoader;
import combat.commun.monde2d.MondeCombat2d;
import combat.commun.valeurs.Achat;
import combat.commun.valeurs.Couleur;
import combat.frontal.SessionCombat;
import combat.frontal.controles.CanvasAchat;
import combat.frontal.evenements.EvtAfficherAcceuil;
import combat.frontal.fragments.FragmentCouleur;
import combat.maquettes.maquettesCouleurs;

import combat.frontal.controles.CanvasAchat;
import combat.frontal.evenements.EvtAfficherAcceuil;
import combat.frontal.fragments.FragmentCouleur;
import combat.maquettes.maquettesCouleurs;

public class VueAchat extends ViewFx {
	public void ajouterAchat(Achat achat) {
		FragmentCouleur fragment = achat.creerFragment(viewLoaderCouleur);
		achat.afficherSur(fragment);

		conteneurAchat.getChildren().add(fragment.rootNode());
	}

	public void viderListeAchat() {
		conteneurAchat.getChildren().clear();
	}

	@FXML
	private ViewLoader<FragmentCouleur> viewLoaderCouleur;
	@FXML
	private Button boutonQuitterAchat;
	@FXML
	private Button boutonCouleur;
	@FXML
	private Button boutonImage;
	@FXML
	private Button boutonBalle;
	@FXML
	private CanvasAchat canvasAchat;
	@FXML
	private Label labelScore;
	@FXML
	private ImageView tankImageView;
	@FXML
	private VBox conteneurAchat;
	private long scoreUtilisateur;
	private boolean tankCache = false;
    private boolean balleCache = false;
	@Override
	public void initialize() {

		Ntro.assertNotNull(canvasAchat);
		Ntro.assertNotNull(boutonCouleur);
		Ntro.assertNotNull(conteneurAchat);
		Ntro.assertNotNull(boutonImage);
		Ntro.assertNotNull(boutonBalle);

		initialiserBoutonCouleur();
		installerEvtAfficherAcceuil();
		boutonBalle.setOnAction(evt -> toggleVisibility(canvasAchat));
		boutonImage.setOnAction(evt -> toggleVisibility(tankImageView));

	}

	private void toggleVisibility(Node node) {
		if (node != null) {
			node.setVisible(!node.isVisible());
			balleCache = true;
		}
	}

	private void initialiserBoutonCouleur() {
		SessionCombat session = Ntro.session();
		boutonCouleur.setOnAction(evtFx -> {

			session.envoyerMsgCouleur();
		});
	}

	private void installerEvtAfficherAcceuil() {
		boutonQuitterAchat.setOnAction(evtFx -> {

			Ntro.logger().info("[VueAcceuil] clic:" + evtFx.getEventType());
			Ntro.newEvent(EvtAfficherAcceuil.class).trigger();
		});
	}

	public void viderCanvas() {
		canvasAchat.clearCanvas();
	}

	public void afficherImagesParSeconde(String fps) {
		canvasAchat.afficherFps(fps);
	}

	public void afficherCombat2d(MondeCombat2d mondeCombat2d) {
		mondeCombat2d.drawOn(canvasAchat);
	}

	public ViewLoader<FragmentCouleur> getViewLoaderCouleur() {
		return viewLoaderCouleur;
	}

	public void setViewLoaderCouleur(ViewLoader<FragmentCouleur> viewLoaderCouleur) {
		this.viewLoaderCouleur = viewLoaderCouleur;
	}

}
