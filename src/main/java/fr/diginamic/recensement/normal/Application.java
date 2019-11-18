package fr.diginamic.recensement.normal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

import fr.diginamic.recensement.normal.entites.Ville;
import fr.diginamic.recensement.normal.utils.PlusGrandeVilleComparator;
import fr.diginamic.recensement.normal.utils.PlusPetiteVilleComparator;

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
		System.out.println("---------------------------------------------------");
		for (int i=0; i<villes.size(); i++){
			if (villes.get(i).getNom().equals("Montpellier")){
				System.out.println(villes.get(i));
				break;
			}
			
		}
		
		// Recherche et affichage de la population de l'Hérault
		System.out.println("---------------------------------------------------");
		int popDept = 0;
		for (int i=0; i<villes.size(); i++){
			Ville v = villes.get(i);
			if (v.getCodeDepartement().equals("34")){
				popDept += v.getPopulation();
			}
		}
		System.out.println("Population de l'Hérault :"+popDept);
		
		// Recherche et affichage de la plus petite ville de l'Hérault
		System.out.println("---------------------------------------------------");
		int popMin = Integer.MAX_VALUE;
		Ville villeMin = null;
		for (int i=0; i<villes.size(); i++){
			Ville v = villes.get(i);
			if (v.getCodeDepartement().equals("34") && v.getPopulation() < popMin){
				popMin = v.getPopulation();
				villeMin = v;
			}
		}
		System.out.println("Plus petite ville du département :"+villeMin);
		
		// Alimentation d'une liste ne contenant que les villes du département 34
		List<Ville> villesDept = new ArrayList<>();
		for (int i=0; i<villes.size(); i++){
			Ville v = villes.get(i);
			if (v.getCodeDepartement().equals("34")){
				villesDept.add(v);
			}
		}
		
		// Afficher les 10 plus grandes villes du département
		System.out.println("---------------------------------------------------");
		System.out.println("Affichage des 10 plus grandes villes du département");
		Collections.sort(villesDept, new PlusGrandeVilleComparator());
		for (int i=0; i<10; i++){
			System.out.println(villesDept.get(i));
		}
		
		// Afficher les 10 plus petites villes du département
		System.out.println("----------------------------------------------------");
		System.out.println("Affichage des 10 plus grandes petites du département");
		Collections.sort(villesDept, new PlusPetiteVilleComparator());
		for (int i=0; i<10; i++){
			System.out.println(villesDept.get(i));
		}
	}
}
