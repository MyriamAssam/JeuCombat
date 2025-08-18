package combat;

import ca.ntro.app.NtroAppFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import combat.frontal.FrontalCombat;



public class AppCombat implements NtroAppFx {

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		registrar.registerFrontend(FrontalCombat.class);
		
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {
        NtroAppFx.launch(args);
    }
}
