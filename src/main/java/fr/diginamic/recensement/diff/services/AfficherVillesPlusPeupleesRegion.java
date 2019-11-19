package fr.diginamic.recensement.diff.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.diff.entites.Recensement;
import fr.diginamic.recensement.diff.entites.Ville;
import fr.diginamic.recensement.diff.services.comparators.EnsemblePopComparateur;

/** Cas d'utilisation: affichage des 10 villes les plus peuplées d'une région donnée
 * @author DIGINAMIC
 *
 */
public class AfficherVillesPlusPeupleesRegion extends MenuService {

	@Override
	public void traiter(Recensement recensement, Scanner scanner) {
		System.out.println("Quel est le code de la région ? ");
		String choix = scanner.nextLine();

		List<Ville> villesRegions = new ArrayList<Ville>();

		List<Ville> villes = recensement.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeRegion().equalsIgnoreCase(choix)) {
				villesRegions.add(ville);
			}
		}

		Collections.sort(villesRegions, new EnsemblePopComparateur(false));

		if (villesRegions.size() > 0) {
			for (int i = 0; i < 10; i++) {
				Ville ville = villesRegions.get(i);
				System.out.println("Ville " + ville.getNom() + " : " + ville.getPopulation() + " habitants.");
			}
		} else {
			System.out.println("Région " + choix + " non trouvée.");
		}

	}

}
