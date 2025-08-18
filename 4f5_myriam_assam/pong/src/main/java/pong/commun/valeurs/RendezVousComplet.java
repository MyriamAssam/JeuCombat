package pong.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import pong.frontal.fragments.FragmentRendezVous;
import pong.frontal.fragments.FragmentRendezVousComplet;

public class RendezVousComplet extends RendezVous {
	private Joueur deuxiemeJoueur;

	public RendezVousComplet() {
		super();
	}

	@Override
	public FragmentRendezVous creerFragment(ViewLoader<FragmentRendezVous> viewLoaderRendezVous,
			ViewLoader<FragmentRendezVousComplet> viewLoaderRendezVousComplet) {

		return viewLoaderRendezVousComplet.createView();
	}

	@Override
	public void afficherSur(FragmentRendezVous fragmentRendezVous) {
		super.afficherSur(fragmentRendezVous);

		FragmentRendezVousComplet fragmentRendezVousComplet = (FragmentRendezVousComplet) fragmentRendezVous;
		fragmentRendezVousComplet.afficherNomDeuxiemeJoueur(deuxiemeJoueur.nomCourt());
	}

	@Override
	public String toString() {
		return premierJoueur().nomCourt() + " Vs " + deuxiemeJoueur.nomCourt();
	}
}