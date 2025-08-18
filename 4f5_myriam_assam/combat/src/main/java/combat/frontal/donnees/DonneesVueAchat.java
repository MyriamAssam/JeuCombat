package combat.frontal.donnees;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.NtroCore;
import combat.commun.monde2d.MondeCombat2d;
import combat.frontal.vues.VueAchat;
import combat.commun.Action;
import combat.commun.Position;

public class DonneesVueAchat implements ViewData {

	private MondeCombat2d mondeCombat2d = new MondeCombat2d();
	private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;

	private long horodatageDernierCalculFps = NtroCore.time().nowMilliseconds();
	private long imagesAfficheesDepuisDernierCalculFps = 0;

	public void afficherSur(VueAchat vueAchat) {
		calculerFpsSiNecessaire();
		vueAchat.viderCanvas();

		vueAchat.afficherCombat2d(mondeCombat2d);

		imagesAfficheesDepuisDernierCalculFps++;

	}

	private void calculerFpsSiNecessaire() {
		long horodatageMaintenant = NtroCore.time().nowMilliseconds();
		long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;

		if (millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
			calculerFpsMaintenant(millisecondesEcoulees);

			imagesAfficheesDepuisDernierCalculFps = 0;
			horodatageDernierCalculFps = horodatageMaintenant;
		}
	}

	private void calculerFpsMaintenant(long millisecondesEcoulees) {
		double secondesEcoulees = millisecondesEcoulees / 1E3;
		double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;

	}

	public void reagirTempsQuiPasse(double elapsedTime) {
		mondeCombat2d.onTimePasses(elapsedTime);
	}

	public void appliquerActionJoueur(Position position, Action action) {
		// TODO Auto-generated method stub

	}

	public void changerCouleurBalle(String color) {
		mondeCombat2d.changerCouleurBalle(color);
		
	}

}