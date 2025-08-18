package combat.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.Tick;
import ca.ntro.app.modified.Modified;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import combat.commun.messages.MsgActionAutreJoueur;
import combat.commun.modeles.ModeleAchat;
import combat.commun.valeurs.Achat;
import combat.commun.valeurs.Couleur;
import combat.frontal.donnees.DonneesVueAchat;
import combat.frontal.evenements.EvtAfficherAchat;
import combat.frontal.evenements.EvtChangerCouleurBalle;
import combat.frontal.vues.VueAcceuil;
import combat.frontal.vues.VueAchat;

import combat.frontal.donnees.DonneesVueAchat;

public class AfficherAchat {

	public static void creerTaches(FrontendTasks tasks) {
		creerDonneesVueAchat(tasks);
		tasks.taskGroup("AfficherAchat").waitsFor(created(DonneesVueAchat.class))

				.waitsFor("afficherVueAchat")

				.contains(subTasks -> {

					afficherAchat(subTasks);
					prochaineImagePartie(subTasks);
					changerCouleurBalle(subTasks);

				});
	}

	private static void prochaineImagePartie(FrontendTasks subTasks) {
		subTasks.task("prochaineImagePartie")

				.waitsFor("afficherVueAchat")

				.waitsFor(created(DonneesVueAchat.class))

				.waitsFor(created(VueAchat.class))

				.waitsFor(clock().nextTick())

				.executes(inputs -> {

					DonneesVueAchat donneesVueAchat = inputs.get(created(DonneesVueAchat.class));
					VueAchat vueAchat = inputs.get(created(VueAchat.class));
					Tick tick = inputs.get(clock().nextTick());
					donneesVueAchat.reagirTempsQuiPasse(tick.elapsedTime());
					donneesVueAchat.afficherSur(vueAchat);

				});
	}

	private static void changerCouleurBalle(FrontendTasks subTasks) {
		subTasks.task("changerCouleurBalle")

				.waitsFor(event(EvtChangerCouleurBalle.class))

				.waitsFor(created(DonneesVueAchat.class))

				.executes(inputs -> {

					DonneesVueAchat donneesVueAchat = inputs.get(created(DonneesVueAchat.class));

					EvtChangerCouleurBalle evtChangerCouleurBalle = inputs.get(event(EvtChangerCouleurBalle.class));
					evtChangerCouleurBalle.appliquerA(donneesVueAchat);
				});
	}

	private static void creerDonneesVueAchat(FrontendTasks tasks) {

		tasks.task(create(DonneesVueAchat.class))

				.executesAndReturnsValue(inputs -> {

					return new DonneesVueAchat();
				});
	}

	private static void afficherAchat(FrontendTasks subTasks) {

		subTasks.task("afficherAchat")

				.waitsFor(created(VueAchat.class))

				.waitsFor(modified(ModeleAchat.class))

				.executes(inputs -> {

					VueAchat vueAchat = inputs.get(created(VueAchat.class));
					Modified<ModeleAchat> achats = inputs.get(modified(ModeleAchat.class));

					ModeleAchat ancienAchat = achats.previousValue();
					ModeleAchat achatCourant = achats.currentValue();
					achatCourant.afficherSur(vueAchat);

				});
	}
}
