package fr.diginamic.recensement.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Departement;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.comparators.DepartementComparateur;

/** Affichage des 10 départements les plus peuplés
 * @author DIGINAMIC
 *
 */
public class AfficherDepartementsPlusPeuplees extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) {
		
		List<Ville> villes = rec.getVilles();
		Map<String, Departement> mapDepts = new HashMap<>();
		
		for (Ville ville: villes){
			
			Departement departement = mapDepts.get(ville.getCodeDepartement());
			if (departement==null){
				departement = new Departement(ville.getCodeDepartement());
				mapDepts.put(ville.getCodeDepartement(), departement);
			}
			departement.addVille(ville);
		}
		
		List<Departement> departements = new ArrayList<Departement>();
		departements.addAll(mapDepts.values());
		
		Collections.sort(departements, new DepartementComparateur(false));
		
		for (int i=0; i<10; i++){
			Departement departement = departements.get(i);
			System.out.println("Département "+departement.getCode()+" : "+departement.getPopulation()+" habitants.");
		}
		
	}

}
