package combat;

import ca.ntro.app.NtroServerFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.common.ServerRegistrarJdk;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import combat.commun.Declarations;
import combat.dorsal.DorsalCombat;

public class ServeurCombat implements NtroServerFx {

	public static void main(String[] args) {
		NtroServerFx.launch(args);
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		Declarations.declarerMessages(registrar);
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		Declarations.declarerModeles(registrar);
	}

	@Override
	public void registerServer(ServerRegistrarJdk registrar) {
		Declarations.declarerServeur(registrar);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		registrar.registerBackend(DorsalCombat.class);
	}

}
