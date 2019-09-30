package fr.diginamic.recensement.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.comparators.EnsemblePopComparateur;

public class AfficherVillesPlusPeupleesDepartement extends MenuService{

	@Override
	public void traiter(Recensement recensement, Scanner scanner) {
		System.out.println("Quelle est le code du d�partement ? ");
		String choix = scanner.nextLine();
		
		List<Ville> villesDept = new ArrayList<Ville>();
		
		List<Ville> villes = recensement.getVilles();
		for (Ville ville: villes){
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)){
				villesDept.add(ville);
			}
		}
		
		Collections.sort(villesDept, new EnsemblePopComparateur(false));
		
		if (villesDept.size()>0){
			System.out.println("Les 10 villes les plus peupl�es du d�partement "+choix+" :");
			for (int i=0; i<10; i++){
				Ville ville = villesDept.get(i);
				System.out.println("Ville "+ville.getNom()+" : "+ville.getPopulation()+" habitants.");
			}
		}
		else {
			System.out.println("D�partement "+choix+" non trouv�.");
		}
	}

}
