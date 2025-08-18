package pong.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.commun.messages.MsgActionAutreJoueur;
import pong.frontal.donnes.DonneesVuePartie;
import pong.frontal.fragments.FragmentRendezVous;
import pong.frontal.fragments.FragmentRendezVousComplet;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VuePartie;
import pong.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;

public class CreerVues {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("CreerVues")

				.waitsFor("ViewLoaders")

				.contains(subTasks -> {

					creerVueRacine(subTasks);
					creerVueFileAttente(subTasks);
					creerVuePartie(subTasks);
					
					
				});
	}

	
	private static void creerVuePartie(FrontendTasks subTasks) {
		subTasks.task(create(VuePartie.class))

				.waitsFor(viewLoader(VuePartie.class))

				.executesAndReturnsValue(inputs -> {

					ViewLoader<VuePartie> viewLoader = inputs.get(viewLoader(VuePartie.class));

					VuePartie vuePartie = viewLoader.createView();

					return vuePartie;
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

	private static void creerVueFileAttente(FrontendTasks tasks) {

		tasks.task(create(VueFileAttente.class))

				.waitsFor(viewLoader(VueFileAttente.class))

				.waitsFor(viewLoader(FragmentRendezVous.class))

				.waitsFor(viewLoader(FragmentRendezVousComplet.class))

				.executesAndReturnsValue(inputs -> {

					ViewLoader<VueFileAttente> viewLoaderFileAttente = inputs.get(viewLoader(VueFileAttente.class));

					ViewLoader<FragmentRendezVous> viewLoaderRendezVous = inputs
							.get(viewLoader(FragmentRendezVous.class));
					ViewLoader<FragmentRendezVousComplet> viewLoaderRendezVousComplet = inputs
							.get(viewLoader(FragmentRendezVousComplet.class));

					VueFileAttente vueFileAttente = viewLoaderFileAttente.createView();

					vueFileAttente.setViewLoaderRendezVous(viewLoaderRendezVous);
					vueFileAttente.setViewLoaderRendezVousComplet(viewLoaderRendezVousComplet);

					return vueFileAttente;
				});
	}
}