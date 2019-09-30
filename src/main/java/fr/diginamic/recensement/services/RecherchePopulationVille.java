package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/** Recherche et affichage de la population d'une ville
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVille extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) {
		
		System.out.println("Quelle est le nom de la ville ");
		String choix = scanner.nextLine();
		
		List<Ville> villes = rec.getVilles();
		for (Ville ville: villes){
			if (ville.getNom().equalsIgnoreCase(choix) || ville.getNom().toLowerCase().startsWith(choix.toLowerCase()+" ")){
				System.out.println(ville.getNom()+" : "+ville.getPopulation());
			}
		}
	}

}
