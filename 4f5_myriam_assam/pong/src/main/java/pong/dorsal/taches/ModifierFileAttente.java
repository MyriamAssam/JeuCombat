package pong.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.messages.MsgInitialiserFileAttente;
import pong.commun.modeles.ModeleFileAttente;

public class ModifierFileAttente {

	public static void creerTaches(BackendTasks tasks) {

		tasks.taskGroup("ModifierFileAttente")

				.waitsFor(model(ModeleFileAttente.class))

				.waitsFor(model(ModeleFileAttente.class))

				.contains(subTasks -> {
					initialiser(subTasks);

					ajouterRendezVous(subTasks);

				});
	}

	private static void initialiser(BackendTasks subTasks) {
		subTasks.task("initialiser")

				.waitsFor(model(ModeleFileAttente.class))

				.waitsFor(message(MsgInitialiserFileAttente.class))

				.executes(inputs -> {

					MsgInitialiserFileAttente msgInitialiserFileAttente = inputs
							.get(message(MsgInitialiserFileAttente.class));
					ModeleFileAttente fileAttente = inputs.get(model(ModeleFileAttente.class));

					msgInitialiserFileAttente.appliquerA(fileAttente);
				});
	}

	private static void ajouterRendezVous(BackendTasks subTasks) {
		subTasks.task("ajouterRendezVous")

				.waitsFor(model(ModeleFileAttente.class))

				.waitsFor(message(MsgAjouterRendezVous.class))

				.executes(inputs -> {

					MsgAjouterRendezVous msgAjouterRendezVous = inputs.get(message(MsgAjouterRendezVous.class));
					ModeleFileAttente fileAttente = inputs.get(model(ModeleFileAttente.class));

					msgAjouterRendezVous.ajouterA(fileAttente);

				});
	}
}