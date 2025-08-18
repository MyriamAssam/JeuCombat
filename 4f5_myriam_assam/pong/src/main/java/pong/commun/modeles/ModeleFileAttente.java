package pong.commun.modeles;

import java.util.ArrayList;
import java.util.List;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import pong.commun.enums.Region;
import pong.commun.valeurs.Joueur;
import pong.commun.valeurs.RendezVous;
import pong.frontal.vues.VueFileAttente;

public class ModeleFileAttente implements Model, WatchJson, WriteObjectGraph {
	private long prochainIdRendezVous = 1;

	public ModeleFileAttente() {
	}

	private Region region = null;
	private List<RendezVous> rendezVousDansOrdre = new ArrayList<>();

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int numeroRendezVous = 1;

		for (RendezVous rendezVous : rendezVousDansOrdre) {

			builder.append(numeroRendezVous);
			builder.append(". ");
			builder.append(rendezVous.toString());
			builder.append("\n");

			numeroRendezVous++;
		}

		return builder.toString();
	}

	public void initialiserRegion(Region region) {
		this.region = region;
	}

	public void afficherSur(VueFileAttente vueFileAttente) {

		vueFileAttente.viderListeRendezVous();

		for (RendezVous rendezVous : rendezVousDansOrdre) {

			vueFileAttente.ajouterRendezVous(rendezVous);
		}
	}

	public void ajouterRendezVous(Joueur premierJoueur) {

		String idRendezVous = genererIdRendezVous();

		RendezVous rendezVous = new RendezVous(idRendezVous, premierJoueur);

		rendezVousDansOrdre.add(rendezVous);
	}

	private String genererIdRendezVous() {
		String idRendezVous = String.valueOf(prochainIdRendezVous);
		prochainIdRendezVous++;

		if (region != null) {
			idRendezVous = region.name() + "¤" + idRendezVous;
		}

		return idRendezVous;
	}
}