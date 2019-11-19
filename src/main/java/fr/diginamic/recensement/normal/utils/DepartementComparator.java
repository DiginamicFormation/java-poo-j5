package fr.diginamic.recensement.normal.utils;

import java.util.Comparator;

import fr.diginamic.recensement.normal.entites.Departement;

/** Comparateur de 2 départements
 * @author DIGINAMIC
 *
 */
public class DepartementComparator implements Comparator<Departement> {
	
	/**  Sens du tri: ascendant (true) ou descendant (false) */
	private boolean asc;
	
	/** Constructeur
	 * @param asc sens du tri
	 */
	public DepartementComparator(boolean asc){
		this.asc=asc;
	}

	@Override
	public int compare(Departement o1, Departement o2) {
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
