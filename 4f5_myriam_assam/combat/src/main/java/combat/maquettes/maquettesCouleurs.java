package combat.maquettes;

import java.util.List;
import java.util.Random;

import ca.ntro.app.Ntro;
import combat.commun.valeurs.Couleur;

public class maquettesCouleurs {

	private static final List<String> choixDeNoms = List.of("Las Palmas", "Razzmatazz", "Heliotrope", "Copper",
			"Bright Sun", "Torch Red", "Perano");

	private static final List<String> choixDeCodes = List.of("#C9DF45", "#D0074D", "#E284F2", "#DC8759", "#EFBB3A",
			"#F0032F", "#CDB6F2");

	public static String getHexCodeForColorName(String colorName) {
		for (int i = 0; i < choixDeNoms.size(); i++) {
			if (choixDeNoms.get(i).equalsIgnoreCase(colorName)) {
				return choixDeCodes.get(i);
			}
		}
		return null;
	}

	public static Couleur creerCouleur(String id) {
		Couleur couleur = new Couleur();

		switch (id) {

		case "1":
			couleur = creerCouleur(id, "Las Palmas", "#C9DF45", true, 100, false, false, "");
			break;
		case "2":
			couleur = creerCouleur(id, "Razzmatazz", "#D0074D", true, 200, false, false, "");
			break;
		case "3":
			couleur = creerCouleur(id, "Heliotrope", "#E284F2", true, 300, false, false, "");
			break;

		case "4":
			couleur = creerCouleur(id, "Copper", "#DC8759", true, 400, false, false, "");
			break;
		case "5":
			couleur = creerCouleur(id, "Bright Sun", "#EFBB3A", false, 500, false, false, "");
			break;

		case "6":
			couleur = creerCouleur(id, "Torch Red", "#F0032F", false, 600, false, false, "");
			break;

		case "7":
			couleur = creerCouleur(id, "Perano", "#CDB6F2", false, 600, false, false, "");
			break;
		default:
			couleur = couleurAleatoire(id);
			break;
		}
		return couleur;
	}

	public static Couleur creerCouleur(String id, String nom, String codeHex, boolean debloque, long prix,
			boolean tankCache, boolean balleCache, String couleurSelection) {
		Couleur couleur = new Couleur();
		couleur.setId(id);
		couleur.setNom(nom);
		couleur.setCodeHex(codeHex);
		couleur.setDebloque(debloque);
		couleur.setPrix(prix);
		couleur.setTankCache(tankCache);
		couleur.setBalleCache(balleCache);
		couleur.setCouleurSelection(couleurSelection);
		return couleur;
	}

	public static Couleur couleurAleatoire(String id) {
		Random rnd = new Random();
		int index = rnd.nextInt(choixDeNoms.size());
		return creerCouleur(id, choixDeNoms.get(index), choixDeCodes.get(index), true, 100 * (index + 1), false, false, "");
	}
}