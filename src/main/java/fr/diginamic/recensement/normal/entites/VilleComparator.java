package fr.diginamic.recensement.normal.entites;

import java.util.Comparator;

public class VilleComparator implements Comparator<Ville> {

	@Override
	public int compare(Ville v1, Ville v2) {
		
		if (v1.getPopulation()> v2.getPopulation()){
			return 1;
		}
		else if (v1.getPopulation() < v2.getPopulation()){
			return -1;
		}
		return 0;
	}

}
