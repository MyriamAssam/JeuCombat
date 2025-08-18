package combat.frontal.vues;

import ca.ntro.app.frontend.ViewFx;
import javafx.scene.layout.Pane;

public class VueRacine extends ViewFx{

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

public void afficherSousVue(ViewFx sousVue) {

	Pane racineSousVue = sousVue.rootNode();

	rootNode().getChildren().clear();
	rootNode().getChildren().add(racineSousVue);
}
}