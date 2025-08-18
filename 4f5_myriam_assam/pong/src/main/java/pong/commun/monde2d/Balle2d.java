package pong.commun.monde2d;

import ca.ntro.app.Ntro;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Balle2d extends Objet2d {
	private static final double EPSILON = 1;
	private Palette2d paletteGauche;
	private Palette2d paletteDroite;

	public Balle2d(Palette2d paletteGauche, Palette2d paletteDroite) {
		super();

		this.paletteGauche = paletteGauche;
		this.paletteDroite = paletteDroite;
	}

	@Override
	public void initialize() {
		setTopLeftX(100);
		setTopLeftY(100);
		setWidth(10);
		setHeight(10);

		setSpeedX(100 + Ntro.random().nextInt(100));
		setSpeedY(100 + Ntro.random().nextInt(100));

	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (balleFrappeMurGauche()) {

			balleRebondiSurMurGauche();

		} else if (balleFrappeMurDroit()) {

			balleRebondiSurMurDroit();

			// ajouter
		} else if (balleFrappePalette(paletteGauche)) {

			// ajouter
			balleRebondiSurPalette(paletteGauche);

			// ajouter
		} else if (balleFrappePalette(paletteDroite)) {

			// ajouter
			balleRebondiSurPalette(paletteDroite);

		} else if (balleFrappePlafond()) {

			balleRebondiSurPlafond();

		} else if (balleFrappePlancher()) {

			balleRebondiSurPlancher();
		}
	}

	private boolean balleFrappePalette(Palette2d palette) {
		return collidesWith(palette);
	}

	// ajouter
	private void balleRebondiSurPalette(Palette2d palette) {

		if (getTopLeftX() < palette.getTopLeftX()) {

			setTopLeftX(palette.getTopLeftX() - getWidth() - EPSILON);

		} else {

			setTopLeftX(palette.getTopLeftX() + palette.getWidth() + EPSILON);

		}

		setSpeedX(-getSpeedX());
	}

	private boolean balleFrappePlancher() {
		return getTopLeftY() + getHeight() >= getWorld2d().getHeight();
	}

	// implanter la méthode
	private boolean balleFrappePlafond() {
		return getTopLeftY() <= 0;
	}

	// implanter la méthode
	private boolean balleFrappeMurDroit() {
		return getTopLeftX() + getWidth() >= getWorld2d().getWidth();
	}

	// implanter la méthode
	private boolean balleFrappeMurGauche() {
		return getTopLeftX() <= 0;
	}

	// implanter la méthode
	private void balleRebondiSurPlancher() {
		setTopLeftY(getWorld2d().getHeight() - this.getHeight() - EPSILON);
		setSpeedY(-getSpeedY());
	}

	// implanter la méthode
	private void balleRebondiSurPlafond() {
		setTopLeftY(0 + EPSILON);
		setSpeedY(-getSpeedY());
	}

	// implanter la méthode
	private void balleRebondiSurMurDroit() {
		setTopLeftX(getWorld2d().getWidth() - this.getWidth() - EPSILON);
		setSpeedX(-getSpeedX());
	}

	// implanter la méthode
	private void balleRebondiSurMurGauche() {
		setTopLeftX(0 + EPSILON);
		setSpeedX(-getSpeedX());
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.fillArc(getTopLeftX(), getTopLeftY(), getWidth(), getHeight(), 0, 360, ArcType.CHORD);
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	@Override
	public String id() {
		return "balle";
	}
}
