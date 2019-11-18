package fr.diginamic.recensement.diff;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Application de traitement des données de recensement de population
 * 
 * @param args
 */
public class Application {

	/**
	 * Point d'entrée
	 * 
	 * @param args
	 *            arguments (non utilisés ici)
	 */
	public static void main(String[] args) {

		List<String> lignes = null;
		try {
			File file = new File("C:/temp/recensement population 2016.csv");
			lignes = FileUtils.readLines(file, "UTF-8");

			// On supprime la ligne d'entéte avec les noms des colonnes
			lignes.remove(0);

			for (String ligne : lignes) {
				System.out.println(ligne);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
