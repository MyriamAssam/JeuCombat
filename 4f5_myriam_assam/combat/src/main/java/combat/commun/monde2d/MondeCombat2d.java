package combat.commun.monde2d;

import javax.swing.Action;
import javax.swing.text.Position;

import ca.ntro.app.Ntro;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.world2d.World2dFx;
import combat.frontal.evenements.EvtChangerCouleurBalle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MondeCombat2d extends World2dFx {

	public static final double LARGEUR_MONDE = 640;
	public static final double HAUTEUR_MONDE = 360;

	private Balle2d balle;

	@Override
	protected void initialize() {

		setWidth(LARGEUR_MONDE);
		setHeight(HAUTEUR_MONDE);

		balle = new Balle2d();
		addObject2d(balle);

	}

	@Override
	protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {

	}

	public void changerCouleurBalle(String color) {
		balle.changerCouleur(color);
		
	}
}
