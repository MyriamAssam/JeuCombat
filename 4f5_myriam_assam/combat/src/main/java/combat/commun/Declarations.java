package combat.commun;

import ca.ntro.app.common.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import combat.commun.messages.MsgActionAutreJoueur;
import combat.commun.messages.MsgCouleur;
import combat.commun.messages.MsgRetirerCouleur;
import combat.commun.modeles.ModeleAchat;
import combat.commun.valeurs.Achat;
import combat.commun.valeurs.Couleur;
import combat.commun.valeurs.Joueur;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgCouleur.class);
		registrar.registerMessage(MsgRetirerCouleur.class);
		registrar.registerMessage(MsgActionAutreJoueur.class);
	}

	public static void declarerServeur(ServerRegistrar registrar) {

		registrar.registerName("localhost");

		registrar.registerPort(8002);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		registrar.registerModel(ModeleAchat.class);
		registrar.registerValue(Couleur.class);
		registrar.registerValue(Joueur.class);
		registrar.registerValue(Achat.class);
	}

}
