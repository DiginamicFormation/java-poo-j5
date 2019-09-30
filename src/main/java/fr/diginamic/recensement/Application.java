package fr.diginamic.recensement;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.utils.RecensementUtils;

/** Application de traitement des données de recensement de population
 * @param args
 */
public class Application {
	
	/** Point d'entrée
	 * @param args arguments (non utilisés ici)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Recensement recensement = RecensementUtils.lire("C:/temp/recensement population 2016.csv");

		if (recensement==null){
			System.out.println("L'application doit s'arrêtée en raison d'une erreur d'exécution.");
			System.exit(0);
		}
		
		// Menu
		int choix = 0;
		do {

			// Affichage du menu
			afficherMenu();

			// Poser une question à l'utilisateur
			String choixMenu = scanner.nextLine();
			
			// Conversion du choix utilisateur en int
			choix = Integer.parseInt(choixMenu);
			
			// On exécute l'option correspondant au choix de l'utilisateur
			switch (choix){
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			}
		} while (choix!=99);
		
		scanner.close();
		
	}
	
	/**
	 * Affichage du menu
	 */
	private static void afficherMenu() {
		System.out.println("***** Recensement population *****");
		System.out.println("1. Rechercher la population d'une ville");
		System.out.println("2. Rechercher la population d'un département");
		System.out.println("3. Rechercher la population d'une région");
		System.out.println("4. Afficher les 10 régions les plus peuplées.");
		System.out.println("5. Afficher les 10 départements les plus peuplés.");
		System.out.println("6. Afficher les 10 villes les plus peuplées d'un département.");
		System.out.println("7.  Afficher les 10 villes les plus peuplées d'une région.");
		System.out.println("8.  Afficher les 10 villes les plus peuplées de France.");
		System.out.println("99. Sortir");
	}
}
