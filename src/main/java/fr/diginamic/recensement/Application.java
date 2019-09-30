package fr.diginamic.recensement;

import java.util.List;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.utils.RecensementUtils;

/** Application de traitement des données de recensement de population
 * @param args
 */
public class Application {
	
	/** Point d'entrée
	 * @param args arguments (non utilisés ici)
	 */
	public static void main(String[] args) {
		Recensement recensement = RecensementUtils.lire("C:/temp/recensement population 2016.csv");
		
		List<Ville> villes = recensement.getVilles();
		for (int i=0; i<villes.size(); i++){
			System.out.println(villes.get(i).getNom());
		}
	}
}
