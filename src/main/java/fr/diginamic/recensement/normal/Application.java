package fr.diginamic.recensement.normal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import fr.diginamic.recensement.normal.entites.Ville;

/** Application de traitement des données de recensement de population
 * @param args
 */
public class Application {
	
	/** Point d'entrée
	 * @param args arguments (non utilisés ici)
	 */
	public static void main(String[] args) {
		
		// On créé la liste des villes
		List<Ville> villes = new ArrayList<Ville>();
		
		List<String> lignes = null;
		try {
			File file = new File("C:/temp/recensement population 2016.csv");
			lignes = FileUtils.readLines(file, "UTF-8");
			
			// On supprime la ligne d'entéte avec les noms des colonnes
			lignes.remove(0);
			
			for (String ligne: lignes){
				String[] morceaux = ligne.split(";");
				String codeRegion = morceaux[0];
				String nomRegion = morceaux[1];
				String codeDepartement = morceaux[2];
				String codeCommune = morceaux[5];
				String nomCommune = morceaux[6];
				int populationTotale = Integer.parseInt(morceaux[7].replace(" ", "").trim());
				
				// On cree maintenant la ville avec toutes ses données
				Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);
				
				// On ajoute la ville à la liste des villes
				villes.add(ville);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		// Recherche et affichage de Montpellier
		for (int i=0; i<villes.size(); i++){
			if (villes.get(i).getNom().equals("Montpellier")){
				System.out.println(villes.get(i));
				break;
			}
			
		}
		
		// Recherche et affichage de la population de l'Hérault
		int popDept = 0;
		for (int i=0; i<villes.size(); i++){
			Ville v = villes.get(i);
			if (v.getCodeDepartement().equals("34")){
				popDept += v.getPopulation();
			}
		}
		System.out.println("Population de l'Hérault :"+popDept);
	}
}
