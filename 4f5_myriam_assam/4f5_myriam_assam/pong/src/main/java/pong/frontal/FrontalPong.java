package pong.frontal;

import ca.ntro.app.events.EventRegistrar;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.session.SessionRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.taches.PremierAffichage;

public class FrontalPong implements FrontendFx {

	@Override
	public void createTasks(FrontendTasks tasks) {
		PremierAffichage.creerTaches(tasks);
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerSessionClass(SessionRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		// TODO Auto-generated method stub
		
	}


}
