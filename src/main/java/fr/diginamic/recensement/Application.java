package fr.diginamic.recensement;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.services.AfficherDepartementsPlusPeuplees;
import fr.diginamic.recensement.services.AfficherRegionsPlusPeuplees;
import fr.diginamic.recensement.services.AfficherVillesPlusPeupleesDepartement;
import fr.diginamic.recensement.services.AfficherVillesPlusPeupleesFrance;
import fr.diginamic.recensement.services.AfficherVillesPlusPeupleesRegion;
import fr.diginamic.recensement.services.RecherchePopulationDepartement;
import fr.diginamic.recensement.services.RecherchePopulationRegion;
import fr.diginamic.recensement.services.RecherchePopulationVille;
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
				RecherchePopulationVille rechercheVille = new RecherchePopulationVille();
				rechercheVille.traiter(recensement, scanner);
				break;
			case 2:
				RecherchePopulationDepartement rechercheDept = new RecherchePopulationDepartement();
				rechercheDept.traiter(recensement, scanner);
				break;
			case 3:
				RecherchePopulationRegion rechercheRegion = new RecherchePopulationRegion();
				rechercheRegion.traiter(recensement, scanner);
				break;
			case 4:
				AfficherRegionsPlusPeuplees regionsPlusPeuplees = new AfficherRegionsPlusPeuplees();
				regionsPlusPeuplees.traiter(recensement, scanner);
				break;
			case 5:
				AfficherDepartementsPlusPeuplees deptsPlusPeuplees = new AfficherDepartementsPlusPeuplees();
				deptsPlusPeuplees.traiter(recensement, scanner);
				break;
			case 6:
				AfficherVillesPlusPeupleesDepartement villesPlusPeupleesDept = new AfficherVillesPlusPeupleesDepartement();
				villesPlusPeupleesDept.traiter(recensement, scanner);
				break;
			case 7:
				AfficherVillesPlusPeupleesRegion villesPlusPeupleesRegion = new AfficherVillesPlusPeupleesRegion();
				villesPlusPeupleesRegion.traiter(recensement, scanner);
				break;
			case 8:
				AfficherVillesPlusPeupleesFrance villesPlusPeupleesFrance = new AfficherVillesPlusPeupleesFrance();
				villesPlusPeupleesFrance.traiter(recensement, scanner);
				break;
			case 9:
				System.out.println("Au revoir.");
				break;
			}
		} while (choix!=9);
		
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
		System.out.println("7. Afficher les 10 villes les plus peupl�es d'une r�gion.");
		System.out.println("8. Afficher les 10 villes les plus peupl�es de France.");
		System.out.println("9. Sortir");
	}
}
