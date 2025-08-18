package pong.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.session;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.SessionPong;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VuePartie;
import pong.frontal.vues.VueRacine;

public class PremierAffichage {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("PremierAffichage")

				.waitsFor("CreerVues")

				.contains(subTasks -> {

					afficherFenetre(subTasks);

					choisirPremiereVue(subTasks);

					installerVueRacine(subTasks);

				});
	}

	private static void installerVueRacine(FrontendTasks subTasks) {

		subTasks.task("installerVueRacine")

				.waitsFor(window())

				.waitsFor(created(VueRacine.class))

				.executes(inputs -> {

					Window window = inputs.get(window());
					VueRacine vueRacine = inputs.get(created(VueRacine.class));

					window.installRootView(vueRacine);

				});
	}

	private static void afficherFenetre(FrontendTasks subTasks) {

		subTasks.task("afficherFenetre").waitsFor(window())

				.executes(inputs -> {

					Window window = inputs.get(window());

					window.setTitle("Pong");

					window.show();

				});
	}

	private static void choisirPremiereVue(FrontendTasks subTasks) {

		subTasks.task("choisirPremiereVue")

				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VueFileAttente.class))

				.waitsFor(created(VuePartie.class))

				.waitsFor(session(SessionPong.class))

				.executes(inputs -> {

					SessionPong session = inputs.get(session(SessionPong.class));

					session.envoyerEvtPourAfficherVueCourante();

				});
	}
}