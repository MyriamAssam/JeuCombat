package combat.frontal.taches;

import combat.frontal.vues.VueRacine;
import combat.frontal.fragments.FragmentCouleur;
import combat.frontal.vues.VueAcceuil;
import combat.frontal.vues.VueAchat;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class CreerVues {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("CreerVues")

				.waitsFor("ViewLoaders")

				.contains(subTasks -> {
					creerVueRacine(subTasks);
					creerVueAcceuil(subTasks);
					creerVueAchat(subTasks);

				});
	}

	private static void creerVueAcceuil(FrontendTasks subTasks) {
		subTasks.task(create(VueAcceuil.class))

				.waitsFor(viewLoader(VueAcceuil.class))

				.executesAndReturnsValue(inputs -> {

					ViewLoader<VueAcceuil> viewLoader = inputs.get(viewLoader(VueAcceuil.class));

					VueAcceuil vueAcceuil = viewLoader.createView();

					return vueAcceuil;
				});
	}

	private static void creerVueRacine(FrontendTasks subTasks) {

		subTasks.task(create(VueRacine.class))

				.waitsFor(viewLoader(VueRacine.class))

				.executesAndReturnsValue(inputs -> {

					ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));

					VueRacine vueRacine = viewLoader.createView();

					return vueRacine;
				});
	}

	private static void creerVueAchat(FrontendTasks subTasks) {

		subTasks.task(create(VueAchat.class))

				.waitsFor(viewLoader(VueAchat.class))

				.waitsFor(viewLoader(FragmentCouleur.class))

				.executesAndReturnsValue(inputs -> {

					ViewLoader<VueAchat> viewLoaderAchat = inputs.get(viewLoader(VueAchat.class));

					ViewLoader<FragmentCouleur> viewLoaderCouleur = inputs.get(viewLoader(FragmentCouleur.class));

					VueAchat vueAchat = viewLoaderAchat.createView();

					vueAchat.setViewLoaderCouleur(viewLoaderCouleur);

					return vueAchat;
				});
	}
}