package fr.diginamic.recensement.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Region;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.comparators.EnsemblePopComparateur;
import fr.diginamic.recensement.services.comparators.RegionComparateur;

/** Affichage des régions les plus peuplées
 * @author DIGINAMIC
 *
 */
public class AfficherRegionsPlusPeuplees extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) {
		
		List<Ville> villes = rec.getVilles();
		Map<String, Region> mapRegions = new HashMap<>();
		
		for (Ville ville: villes){
			
			Region region = mapRegions.get(ville.getNomRegion());
			if (region==null){
				region = new Region(ville.getCodeRegion(), ville.getNomRegion());
				mapRegions.put(ville.getNomRegion(), region);
			}
			region.addVille(ville);
		}
		
		List<Region> regions = new ArrayList<Region>();
		regions.addAll(mapRegions.values());
		
		Collections.sort(regions, new EnsemblePopComparateur(false));
		
		for (int i=0; i<10; i++){
			Region region = regions.get(i);
			System.out.println("Region "+region.getNom()+" : "+region.getPopulation()+" habitants.");
		}
		
	}

}
