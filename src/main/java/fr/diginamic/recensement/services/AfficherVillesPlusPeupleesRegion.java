package fr.diginamic.recensement.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.comparators.EnsemblePopComparateur;

/** Cas d'utilisation: affichage des 10 villes les plus peupl�es d'une r�gion donn�e
 * @author DIGINAMIC
 *
 */
public class AfficherVillesPlusPeupleesRegion extends MenuService {

	@Override
	public void traiter(Recensement recensement, Scanner scanner) {
		System.out.println("Quel est le code de la r�gion ? ");
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
			System.out.println("R�gion " + choix + " non trouv�e.");
		}

	}

}
