package fr.diginamic.recensement;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Application de traitement des donn�es de recensement de population
 * 
 * @param args
 */
public class Application {

	/**
	 * Point d'entr�e
	 * 
	 * @param args
	 *            arguments (non utilis�s ici)
	 */
	public static void main(String[] args) {

		List<String> lignes = null;
		try {
			File file = new File("C:/temp/recensement population 2016.csv");
			lignes = FileUtils.readLines(file, "UTF-8");

			// On supprime la ligne d'ent�te avec les noms des colonnes
			lignes.remove(0);

			for (String ligne : lignes) {
				System.out.println(ligne);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
