package pong.frontal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import pong.commun.modeles.ModeleFileAttente;

public class ModifierFileAttente {

	public static void creerTaches(BackendTasks tasks) {

		tasks.taskGroup("ModifierFileAttente")

				.waitsFor(model(ModeleFileAttente.class))

				.waitsFor(model(ModeleFileAttente.class))

				.contains(subTasks -> {

				});
	}
}