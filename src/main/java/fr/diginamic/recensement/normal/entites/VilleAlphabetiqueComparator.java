package fr.diginamic.recensement.normal.entites;

import java.util.Comparator;

public class VilleAlphabetiqueComparator implements Comparator<Ville> {

	@Override
	public int compare(Ville v1, Ville v2) {
		
		return v1.getNom().compareTo(v2.getNom());
	}

}
