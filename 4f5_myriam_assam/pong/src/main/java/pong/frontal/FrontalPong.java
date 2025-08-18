package pong.frontal;

import ca.ntro.app.Ntro;
import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.donnes.DonneesVuePartie;
import pong.frontal.evenements.EvtActionJoueur;
import pong.frontal.evenements.EvtAfficherFileAttente;
import pong.frontal.evenements.EvtAfficherPartie;
import pong.frontal.evenements.EvtChangerRegion;
import pong.frontal.fragments.FragmentRendezVous;
import pong.frontal.fragments.FragmentRendezVousComplet;
import pong.frontal.taches.AfficherFileAttente;
import pong.frontal.taches.AfficherPartie;
import pong.frontal.taches.CreerVues;
import pong.frontal.taches.Navigation;
import pong.frontal.taches.PremierAffichage;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VuePartie;
import pong.frontal.vues.VueRacine;

public class FrontalPong implements FrontendFx {

	@Override
	public void createTasks(FrontendTasks tasks) {

		CreerVues.creerTaches(tasks);
		PremierAffichage.creerTaches(tasks);
		Navigation.creerTaches(tasks);
		AfficherFileAttente.creerTaches(tasks);
		AfficherPartie.creerTaches(tasks);
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		registrar.registerEvent(EvtAfficherFileAttente.class);

		registrar.registerEvent(EvtAfficherPartie.class);
		registrar.registerEvent(EvtActionJoueur.class);
		registrar.registerEvent(EvtChangerRegion.class);

	}

	@Override
	public void registerSessionClass(SessionRegistrar registrar) {
		registrar.registerSessionClass(SessionPong.class);
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		registrar.registerView(VueFileAttente.class, "/vues/file_attente.xml");
		registrar.registerFragment(FragmentRendezVous.class, "/fragments/rendez_vous.xml");
		registrar.registerFragment(FragmentRendezVousComplet.class, "/fragments/rendez_vous_complet.xml");
		registrar.registerView(VueRacine.class, "/vues/racine.xml");
		registrar.registerView(VuePartie.class, "/vues/partie.xml");
		registrar.registerStylesheet("/style/dev.css");
		// registrar.registerStylesheet("/style/prod.css");
		registrar.registerDefaultLocale(Ntro.buildLocale("fr"));
		registrar.registerTranslations(Ntro.buildLocale("fr"), "/traductions/fr.properties");
		registrar.registerTranslations(Ntro.buildLocale("en"), "/traductions/en.properties");
		registrar.registerViewData(DonneesVuePartie.class);

	}

}
