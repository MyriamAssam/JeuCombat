package pong.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;

public class Palette2d extends Objet2d {
	private static final double VITESSE_PALETTE = 200;

	private String id;

	public Palette2d() {
		super();
	}

	public Palette2d(String id, double topLeftX) {
		super();

		this.id = id;

		setTopLeftX(topLeftX);
	}

	public void monter() {
		setSpeedY(-VITESSE_PALETTE);
	}

	public void descendre() {
		setSpeedY(+VITESSE_PALETTE);
	}

	public void arreter() {
		setSpeedY(0);
	}

	@Override
	public String id() {
		return id;
	}

	@Override
	public void initialize() {
		setWidth(10);
		setHeight(100);

		setTopLeftY(getWorld2d().getHeight() / 2 - getHeight() / 2);
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());

	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub
		return false;
	}
}
