package combat.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import combat.commun.monde2d.MondeCombat2d;

public class CanvasAchat extends ResizableWorld2dCanvasFx {

	@Override
	protected void initialize() {
		setInitialWorldSize(MondeCombat2d.LARGEUR_MONDE, MondeCombat2d.HAUTEUR_MONDE);
	}

	public void afficherFps(String fps) {
		drawOnCanvas(gc -> {

			gc.fillText(fps, 0, 12);

		});
	}

}