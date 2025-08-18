package pong.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.SessionPong;
import pong.frontal.evenements.EvtAfficherFileAttente;
import pong.frontal.evenements.EvtAfficherPartie;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VuePartie;
import pong.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.Ntro;

public class Navigation {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Navigation")

				.waitsFor("PremierAffichage")

				.contains(subTasks -> {

					afficherVueFileAttente(subTasks);

					afficherVuePartie(subTasks);

				});
	}

	private static void afficherVuePartie(FrontendTasks subTasks) {

		subTasks.task("afficherVuePartie").waitsFor(event(EvtAfficherPartie.class))

				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VuePartie.class))

				.executes(inputs -> {
					SessionPong session = Ntro.session();
					EvtAfficherPartie evtAfficherPartie = inputs.get(event(EvtAfficherPartie.class));
					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					VuePartie vuePartie = inputs.get(created(VuePartie.class));

					evtAfficherPartie.appliquerA(session).appliquerA(vueRacine, vuePartie);

				});
	}

	private static void afficherVueFileAttente(FrontendTasks tasks) {

		tasks.task("afficherVueFileAttente")

				.waitsFor(event(EvtAfficherFileAttente.class))

				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VueFileAttente.class))

				.executes(inputs -> {

					SessionPong session = Ntro.session();
					EvtAfficherFileAttente evtAfficherFileAttente = inputs.get(event(EvtAfficherFileAttente.class));
					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));

					evtAfficherFileAttente.appliquerA(session).appliquerA(vueRacine, vueFileAttente);

				});
	}
}
