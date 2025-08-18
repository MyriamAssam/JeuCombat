package combat.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import combat.commun.messages.MsgCouleur;
import combat.commun.messages.MsgRetirerCouleur;
import combat.commun.modeles.ModeleAchat;

public class ModifierCombat {

	public static void creerTaches(BackendTasks tasks) {

		tasks.taskGroup("ModifierCombat")

				.waitsFor(model(ModeleAchat.class))

				.waitsFor(model(ModeleAchat.class))

				.contains(subTasks -> {

					ajouterAchat(subTasks);
					retirerAchat(subTasks);

				});
	}

	private static void ajouterAchat(BackendTasks subTasks) {
		subTasks.task("ajouterAchat")

				.waitsFor(model(ModeleAchat.class))

				.waitsFor(message(MsgCouleur.class))

				.executes(inputs -> {

					MsgCouleur msgCouleur = inputs.get(message(MsgCouleur.class));
					ModeleAchat achats = inputs.get(model(ModeleAchat.class));

					msgCouleur.ajouterA(achats);

				});
	}

	private static void retirerAchat(BackendTasks subTasks) {
		subTasks.task("retirerAchat")

				.waitsFor(model(ModeleAchat.class))

				.waitsFor(message(MsgRetirerCouleur.class))

				.executes(inputs -> {

					MsgRetirerCouleur msgRetirerCouleur = inputs.get(message(MsgRetirerCouleur.class));
					ModeleAchat achats = inputs.get(model(ModeleAchat.class));

					msgRetirerCouleur.retirerCouleur(achats);
				});
	}
}