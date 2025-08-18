package combat.dorsal;

import ca.ntro.app.backend.RemoteBackendNtro;
import ca.ntro.app.common.ServerRegistrar;
import combat.commun.Declarations;

public class DorsalCombatDistant extends RemoteBackendNtro {

	@Override
	public void registerServer(ServerRegistrar registrar) {
		Declarations.declarerServeur(registrar);

	}
}