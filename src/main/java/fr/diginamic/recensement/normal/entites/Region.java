package fr.diginamic.recensement.normal.entites;

/** Représente une région
 * @author DIGINAMIC
 *
 */
public class Region {

	/** code : String*/
	private String code;
	/** nom : String*/
	private String nom;
	/** population : int*/
	private int population;
	
	/** Constructeur
	 * @param code code
	 * @param nom nom
	 */
	public Region(String code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Département "+nom + " avec une population de " + population + " hab.";
	}
	
	/** Getter
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/** Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/** Getter
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}
	/** Setter
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	
}
