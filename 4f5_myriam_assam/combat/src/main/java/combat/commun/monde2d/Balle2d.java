package combat.commun.monde2d;

import ca.ntro.app.Ntro;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import combat.frontal.evenements.EvtChangerCouleurBalle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Balle2d extends Objet2d {
	private static final double EPSILON = 1;
	private Color color = Color.BLACK;


	public Balle2d() {
		super();

	}

	@Override
	public void initialize() {
		setTopLeftX(10);
		setTopLeftY(300);
		setWidth(50);
		setHeight(50);

//		setSpeedX(100 + Ntro.random().nextInt(100));
		setSpeedY(-100 - Ntro.random().nextInt(100));

	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (balleFrappePlafond()) {

			balleRebondiSurPlafond();
		} else if (balleFrappePlancher()) {

			balleRebondiSurPlancher();
		}
	}

	private boolean balleFrappePlancher() {
		return getTopLeftY() + getHeight() >= getWorld2d().getHeight();
	}

	private void balleRebondiSurPlancher() {
		setTopLeftY(getWorld2d().getHeight() - this.getHeight() - EPSILON);
		setSpeedY(-getSpeedY());
	}

	private boolean balleFrappePlafond() {
		return getTopLeftY() <= 0;
	}

	private void balleRebondiSurPlafond() {
		setTopLeftY(0 + EPSILON);
		setSpeedY(-getSpeedY());
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.save();
		gc.setFill(color);
		System.out.println(color);
		gc.fillArc(getTopLeftX(), getTopLeftY(), getWidth(), getHeight(), 0, 360, ArcType.CHORD);
		gc.restore();
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	@Override
	public String id() {
		return "balle";
	}

	public void changerCouleur(String color2) {
		this.color = Color.web(color2);

	}
}
