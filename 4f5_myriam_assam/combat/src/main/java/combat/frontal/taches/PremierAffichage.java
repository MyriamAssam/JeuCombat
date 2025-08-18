package combat.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import combat.frontal.SessionCombat;
import combat.frontal.vues.VueAcceuil;
import combat.frontal.vues.VueRacine;
import combat.frontal.vues.VueAchat;

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

					window.setTitle("Combat");

					window.show();

				});
	}

	private static void choisirPremiereVue(FrontendTasks subTasks) {

		subTasks.task("choisirPremiereVue")

				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VueAcceuil.class))

				.waitsFor(created(VueAchat.class))

				.waitsFor(session(SessionCombat.class))

				.executes(inputs -> {

					SessionCombat session = inputs.get(session(SessionCombat.class));

					session.envoyerEvtPourAfficherVueCourante();

				});
	}
}