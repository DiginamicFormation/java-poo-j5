package fr.diginamic.recensement.diff.services.comparators;

import java.util.Comparator;

import fr.diginamic.recensement.diff.entites.Ville;

/** Comparateur de 2 villes
 * @author DIGINAMIC
 *
 */
public class VilleComparateur implements Comparator<Ville> {
	
	/**  Sens du tri: ascendant (true) ou descendant (false) */
	private boolean asc;
	
	/** Constructeur
	 * @param asc sens du tri
	 */
	public VilleComparateur(boolean asc){
		this.asc=asc;
	}

	@Override
	public int compare(Ville o1, Ville o2) {
		if (asc){
			if (o1.getPopulation()>o2.getPopulation()){
				return 1;
			}
			else if (o1.getPopulation()<o2.getPopulation()){
				return -1;
			}
			return 0;
		}
		else {
			if (o1.getPopulation()<o2.getPopulation()){
				return 1;
			}
			else if (o1.getPopulation()>o2.getPopulation()){
				return -1;
			}
			return 0;
		}
	}

}
