package fr.diginamic.recensement.normal.entites;

import java.util.Comparator;

import fr.diginamic.recensement.normal.entites.Departement;

/** Comparateur de 2 départements
 * @author DIGINAMIC
 *
 */
public class RegionComparateur implements Comparator<Region> {
	
	/**  Sens du tri: ascendant (true) ou descendant (false) */
	private boolean asc;
	
	/** Constructeur
	 * @param asc sens du tri
	 */
	public RegionComparateur(boolean asc){
		this.asc=asc;
	}

	@Override
	public int compare(Region o1, Region o2) {
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
