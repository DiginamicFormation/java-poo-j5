package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/** Recherche et affichage de la population d'une r�gion
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationRegion extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) {
		
		System.out.println("Quel est le code de la r�gion recherch�e ? ");
		String choix = scanner.nextLine();
		
		List<Ville> villes = rec.getVilles();
		int somme = 0;
		String nom = null;
		for (Ville ville: villes){
			if (ville.getCodeRegion().equalsIgnoreCase(choix)){
				somme+=ville.getPopulation();
				nom=ville.getNomRegion();
			}
		}
		if (somme>0){
			System.out.println("Population de la r�gion "+nom+" : "+ somme);
		}
		else {
			System.out.println("R�gion "+choix+" non trouv�e.");
		}
	}

}
