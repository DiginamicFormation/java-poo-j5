package fr.diginamic.recensement.utils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/** Permet de constituer notre recensement progressivement à partir des lignes du fichier
 * @author DIGINAMIC
 *
 */
public class ParseurVille {
	
	/** Ajoute une ligne représentant une ville au recensement
	 * @param recensement recensement à compléter
	 * @param ligne ligne de laquelle on extrait une ville
	 */
	public static void ajoutLigne(Recensement recensement, String ligne){
		
		String[] morceaux = ligne.split(";");
		String codeRegion = morceaux[0];
		String nomRegion = morceaux[1];
		String codeDepartement = morceaux[2];
		String codeCommune = morceaux[5];
		String nomCommune = morceaux[6];
		int populationTotale = Integer.parseInt(morceaux[9].replace(" ", "").trim());
		
		// On cree maintenant la ville avec toutes ses données
		Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);
		
		// On ajoute la ville à la liste des villes du recensement
		recensement.getVilles().add(ville);
		
	}

}
