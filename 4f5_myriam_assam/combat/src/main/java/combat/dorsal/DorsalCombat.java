package combat.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import combat.dorsal.taches.ModifierCombat;

public class DorsalCombat extends LocalBackendNtro {
	@Override
	public void createTasks(BackendTasks tasks) {

		ModifierCombat.creerTaches(tasks);

	}
}