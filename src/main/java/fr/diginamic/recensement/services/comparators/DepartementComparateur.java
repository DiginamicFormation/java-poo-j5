package fr.diginamic.recensement.services.comparators;

import java.util.Comparator;

import fr.diginamic.recensement.entites.Departement;

/** Comparateur de 2 départements
 * @author DIGINAMIC
 *
 */
public class DepartementComparateur implements Comparator<Departement> {
	
	/**  Sens du tri: ascendant (true) ou descendant (false) */
	private boolean asc;
	
	/** Constructeur
	 * @param asc sens du tri
	 */
	public DepartementComparateur(boolean asc){
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
