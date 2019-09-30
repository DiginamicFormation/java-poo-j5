package fr.diginamic.recensement.services;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.comparators.EnsemblePopComparateur;

public class AfficherVillesPlusPeupleesFrance extends MenuService{

	@Override
	public void traiter(Recensement recensement, Scanner scanner) {
		
		List<Ville> villes = recensement.getVilles();

		Collections.sort(villes, new EnsemblePopComparateur(false));
		for (int i=0; i<10; i++){
			Ville ville = villes.get(i);
			System.out.println("Ville "+ville.getNom()+" : "+ville.getPopulation()+" habitants.");
		}
	}

}
