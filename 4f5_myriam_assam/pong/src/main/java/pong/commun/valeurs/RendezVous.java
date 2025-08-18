package pong.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;
import pong.frontal.fragments.FragmentRendezVous;
import pong.frontal.fragments.FragmentRendezVousComplet;

public class RendezVous implements ModelValue {
	private String idRendezVous;
	private Joueur premierJoueur;

	public FragmentRendezVous creerFragment(ViewLoader<FragmentRendezVous> viewLoaderRendezVous,
			ViewLoader<FragmentRendezVousComplet> viewLoaderRendezVousComplet) {

		return viewLoaderRendezVous.createView();
	}

	public RendezVous() {
	}

	public RendezVous(String idRendezVous, Joueur premierJoueur) {
		this.idRendezVous = idRendezVous;
		this.premierJoueur = premierJoueur;
	}

	protected Joueur premierJoueur() {
		return premierJoueur;
	}

	public void afficherSur(FragmentRendezVous fragmentRendezVous) {
		fragmentRendezVous.afficherNomPremierJoueur(premierJoueur.nomCourt());
	}

	@Override
	public String toString() {
		return premierJoueur().nomComplet();
	}
}