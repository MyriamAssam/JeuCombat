package combat.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.event;

import ca.ntro.app.Ntro;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import combat.frontal.SessionCombat;
import combat.frontal.evenements.EvtAfficherAchat;
import combat.frontal.evenements.EvtAfficherAcceuil;
import combat.frontal.vues.VueAcceuil;
import combat.frontal.vues.VueAchat;
import combat.frontal.vues.VueRacine;

public class Navigation {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Navigation")

				.waitsFor("PremierAffichage")

				.contains(subTasks -> {

					afficherVueAchat(subTasks);

					afficherVueAcceuil(subTasks);

				});
	}

	private static void afficherVueAchat(FrontendTasks subTasks) {

		subTasks.task("afficherVueAchat").waitsFor(event(EvtAfficherAchat.class))

				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VueAchat.class))

				.executes(inputs -> {
					SessionCombat session = Ntro.session();
					EvtAfficherAchat evtAfficherAchat = inputs.get(event(EvtAfficherAchat.class));
					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					VueAchat vueAchat = inputs.get(created(VueAchat.class));

					evtAfficherAchat.appliquerA(session).appliquerA(vueRacine, vueAchat);

				});
	}

	private static void afficherVueAcceuil(FrontendTasks tasks) {

		tasks.task("afficherVueAcceuil")

				.waitsFor(event(EvtAfficherAcceuil.class))

				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VueAcceuil.class))

				.executes(inputs -> {

					SessionCombat session = Ntro.session();
					EvtAfficherAcceuil evtAfficherAcceuil = inputs.get(event(EvtAfficherAcceuil.class));
					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					VueAcceuil vueAcceuil = inputs.get(created(VueAcceuil.class));

					evtAfficherAcceuil.appliquerA(session).appliquerA(vueRacine, vueAcceuil);

				});
	}
}