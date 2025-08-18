package pong.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.Tick;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.commun.messages.MsgActionAutreJoueur;
import pong.frontal.donnes.DonneesVuePartie;
import pong.frontal.evenements.EvtActionJoueur;
import pong.frontal.vues.VuePartie;

public class AfficherPartie {

	public static void creerTaches(FrontendTasks tasks) {

		creerDonneesVuePartie(tasks);
		tasks.taskGroup("AfficherPartie").waitsFor("afficherVuePartie")

				.waitsFor(created(DonneesVuePartie.class))

				.contains(subTasks -> {

					prochaineImagePartie(subTasks);
					reagirActionJoueur(subTasks);
					reagirActionAutreJoueur(subTasks);
				});

	}

	private static void reagirActionAutreJoueur(FrontendTasks subTasks) {
		subTasks.task("reagirActionAutreJoueur")

				.waitsFor(created(DonneesVuePartie.class))

				.waitsFor(message(MsgActionAutreJoueur.class))

				.executes(inputs -> {

					DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
					MsgActionAutreJoueur msgActionAutreJoueur = inputs.get(message(MsgActionAutreJoueur.class));

					msgActionAutreJoueur.appliquerA(donneesVuePartie);

				});
	}

	private static void reagirActionJoueur(FrontendTasks subTasks) {

		subTasks.task("reagirActionJoueur")

				.waitsFor(event(EvtActionJoueur.class))

				.waitsFor(created(DonneesVuePartie.class))

				.executes(inputs -> {

					DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
					EvtActionJoueur evtActionJoueur = inputs.get(event(EvtActionJoueur.class));

					evtActionJoueur.appliquerA(donneesVuePartie);
					evtActionJoueur.diffuserMsgActionAutreJoueur();

				});
	}

	private static void prochaineImagePartie(FrontendTasks subTasks) {

		subTasks.task("prochaineImagePartie")

				.waitsFor("afficherVuePartie")

				.waitsFor(created(DonneesVuePartie.class))

				.waitsFor(created(VuePartie.class))

				.waitsFor(clock().nextTick())

				.executes(inputs -> {

					DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
					VuePartie vuePartie = inputs.get(created(VuePartie.class));
					Tick tick = inputs.get(clock().nextTick());
					donneesVuePartie.reagirTempsQuiPasse(tick.elapsedTime());
					donneesVuePartie.afficherSur(vuePartie);

				});

	}

	private static void creerDonneesVuePartie(FrontendTasks tasks) {

		tasks.task(create(DonneesVuePartie.class))

				.executesAndReturnsValue(inputs -> {

					return new DonneesVuePartie();
				});
	}
}
