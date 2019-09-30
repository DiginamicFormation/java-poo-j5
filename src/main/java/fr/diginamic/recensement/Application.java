package fr.diginamic.recensement;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.utils.RecensementUtils;

/** Application de traitement des donn�es de recensement de population
 * @param args
 */
public class Application {
	
	/** Point d'entr�e
	 * @param args arguments (non utilis�s ici)
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Recensement recensement = RecensementUtils.lire("C:/temp/recensement population 2016.csv");

		if (recensement==null){
			System.out.println("L'application doit s'arr�t�e en raison d'une erreur d'ex�cution.");
			System.exit(0);
		}
		
		// Menu
		int choix = 0;
		do {

			// Affichage du menu
			afficherMenu();

			// Poser une question � l'utilisateur
			String choixMenu = scanner.nextLine();
			
			// Conversion du choix utilisateur en int
			choix = Integer.parseInt(choixMenu);
			
			// On ex�cute l'option correspondant au choix de l'utilisateur
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
		System.out.println("2. Rechercher la population d'un d�partement");
		System.out.println("3. Rechercher la population d'une r�gion");
		System.out.println("4. Afficher les 10 r�gions les plus peupl�es.");
		System.out.println("5. Afficher les 10 d�partements les plus peupl�s.");
		System.out.println("6. Afficher les 10 villes les plus peupl�es d'un d�partement.");
		System.out.println("7.  Afficher les 10 villes les plus peupl�es d'une r�gion.");
		System.out.println("8.  Afficher les 10 villes les plus peupl�es de France.");
		System.out.println("99. Sortir");
	}
}
