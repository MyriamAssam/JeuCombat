package combat.commun.modeles;

import java.util.ArrayList;
import java.util.List;
import static ca.ntro.app.tasks.backend.BackendTasks.*;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import combat.commun.valeurs.Joueur;
import combat.commun.valeurs.Achat;
import combat.commun.valeurs.Couleur;
import combat.frontal.vues.VueAcceuil;
import combat.frontal.vues.VueAchat;

public class ModeleAchat implements Model, WatchJson, WriteObjectGraph {
	private long prochainIdAchat = 1;

	public ModeleAchat() {
	}

	private int indiceAchatParId(String idAchat) {
		int indice = -1;

		for (int i = 0; i < couleurachat.size(); i++) {
			if (couleurachat.get(i).siIdEst(idAchat)) {
				indice = i;
				break;
			}
		}

		return indice;
	}

	public void retirerAchat(String idAchat) {
		int indiceRendezVous = indiceAchatParId(idAchat);

		if (indiceRendezVous >= 0) {
			couleurachat.remove(indiceRendezVous);
		}
	}

	private List<Achat> couleurachat = new ArrayList<>();

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int numeroAchat = 1;

		for (Achat achat : couleurachat) {

			builder.append(numeroAchat);
			builder.append(". ");
			builder.append(achat.toString());
			builder.append("\n");

			numeroAchat++;
		}

		return builder.toString();
	}

	public void afficherSur(VueAchat vueAchat) {

		vueAchat.viderListeAchat();

		for (Achat achat : couleurachat) {

			vueAchat.ajouterAchat(achat);
		}
	}

	public void ajouterAchat(Couleur premiereCouleur) {

		String idAchat = genererAchat();

		Achat achat = new Achat(idAchat, premiereCouleur);

		couleurachat.add(achat);
	}

	private String genererAchat() {
		String idAchat = String.valueOf(prochainIdAchat);
		prochainIdAchat++;

		return idAchat;
	}
}
