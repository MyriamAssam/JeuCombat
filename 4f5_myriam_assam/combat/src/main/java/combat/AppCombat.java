package combat;

import ca.ntro.app.NtroAppFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import combat.commun.Declarations;
import combat.frontal.FrontalCombat;
import combat.dorsal.DorsalCombat;

public class AppCombat implements NtroAppFx {

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		registrar.registerFrontend(FrontalCombat.class);

	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		registrar.registerBackend(DorsalCombat.class);
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		Declarations.declarerMessages(registrar);

	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		Declarations.declarerModeles(registrar);
	}

	public static void main(String[] args) {
		NtroAppFx.launch(args);
	}
}
