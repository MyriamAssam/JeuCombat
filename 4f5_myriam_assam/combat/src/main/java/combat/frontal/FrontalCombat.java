package combat.frontal;

import ca.ntro.app.Ntro;
import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import combat.frontal.taches.PremierAffichage;
import combat.frontal.vues.VueAcceuil;
import combat.frontal.vues.VueAchat;
import combat.frontal.vues.VueRacine;
import combat.frontal.evenements.EvtAfficherAchat;
import combat.frontal.evenements.EvtChangerCouleurBalle;
import combat.frontal.fragments.FragmentCouleur;
import combat.frontal.donnees.DonneesVueAchat;
import combat.frontal.evenements.EvtAfficherAcceuil;
import combat.frontal.taches.AfficherAchat;
import combat.frontal.taches.CreerVues;
import combat.frontal.taches.Navigation;

public class FrontalCombat implements FrontendFx {

	@Override
	public void createTasks(FrontendTasks tasks) {
		CreerVues.creerTaches(tasks);
		PremierAffichage.creerTaches(tasks);
		Navigation.creerTaches(tasks);
		AfficherAchat.creerTaches(tasks);

	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		registrar.registerEvent(EvtAfficherAchat.class);
		registrar.registerEvent(EvtAfficherAcceuil.class);
		registrar.registerEvent(EvtChangerCouleurBalle.class);
	}

	@Override
	public void registerSessionClass(SessionRegistrar registrar) {
		registrar.registerSessionClass(SessionCombat.class);

	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		registrar.registerView(VueAcceuil.class, "/vues/acceuil.xml");
		registrar.registerView(VueRacine.class, "/vues/racine.xml");
		registrar.registerView(VueAchat.class, "/vues/achat.xml");
		// registrar.registerStylesheet("/style/dev.css");
		registrar.registerStylesheet("/style/prod.css");
		registrar.registerDefaultLocale(Ntro.buildLocale("fr"));
		registrar.registerTranslations(Ntro.buildLocale("fr"), "/traductions/fr.properties");
		registrar.registerTranslations(Ntro.buildLocale("en"), "/traductions/en.properties");
		registrar.registerFragment(FragmentCouleur.class, "/fragments/achat.xml");
		registrar.registerViewData(DonneesVueAchat.class);
	}

}
