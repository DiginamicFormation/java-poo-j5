package fr.diginamic.recensement.normal.utils;

import java.util.Comparator;

import fr.diginamic.recensement.normal.entites.Ville;

public class VilleAlphabetiqueComparator implements Comparator<Ville> {

	@Override
	public int compare(Ville v1, Ville v2) {
		
		return v1.getNom().compareTo(v2.getNom());
	}

}
