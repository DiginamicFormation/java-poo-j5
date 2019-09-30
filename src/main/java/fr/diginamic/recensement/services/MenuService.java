package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;

/** Classe repr�sentant un service
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/** M�thode abstraite de traitement que doivent poss�der toutes les m�thodes de services 
	 * @param lignes lignes du fichier
	 * @param scanner scanner
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) ;
}
