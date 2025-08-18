package pong.commun;

import ca.ntro.app.common.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import pong.commun.messages.MsgActionAutreJoueur;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.messages.MsgInitialiserFileAttente;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.monde2d.Balle2d;
import pong.commun.monde2d.MondePong2d;
import pong.commun.monde2d.Palette2d;
import pong.commun.valeurs.Joueur;
import pong.commun.valeurs.RendezVous;
import pong.commun.valeurs.RendezVousComplet;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {

		registrar.registerMessage(MsgAjouterRendezVous.class);
		registrar.registerMessage(MsgActionAutreJoueur.class);
		registrar.registerMessage(MsgInitialiserFileAttente.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {

		registrar.registerModel(ModeleFileAttente.class);
		registrar.registerValue(RendezVous.class);
		registrar.registerValue(RendezVousComplet.class);

		registrar.registerValue(Joueur.class);
		
		registrar.registerValue(MondePong2d.class);
		registrar.registerValue(Balle2d.class);
		registrar.registerValue(Palette2d.class);
	}

	public static void declarerServeur(ServerRegistrar registrar) {

		registrar.registerName("localhost");

		registrar.registerPort(8002);
	}
}