package fr.diginamic.recensement.diff.services;

import java.util.Scanner;

import fr.diginamic.recensement.diff.entites.Recensement;

/** Classe représentant un service
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/** Méthode abstraite de traitement que doivent posséder toutes les méthodes de services 
	 * @param lignes lignes du fichier
	 * @param scanner scanner
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) ;
}
