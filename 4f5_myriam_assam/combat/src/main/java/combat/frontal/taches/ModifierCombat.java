package combat.frontal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.model;

import ca.ntro.app.tasks.backend.BackendTasks;
import combat.commun.modeles.ModeleAchat;

public class ModifierCombat {
	public static void creerTaches(BackendTasks tasks) {

		tasks.taskGroup("ModifierCombat")

				.waitsFor(model(ModeleAchat.class))

				.waitsFor(model(ModeleAchat.class))

				.contains(subTasks -> {

				});
	}
}
