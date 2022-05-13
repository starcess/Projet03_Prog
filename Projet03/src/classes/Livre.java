/* Fichier Livre.java
 * Auteur : rebec
 * Date de création : May 9, 2022
 */
package classes;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class Livre extends Volume{
	private int annee;
	private Genre genre;
	private int nombreTotal;
	private int nombreDisponible;
	
	
	@Override
	public String toString() {
		String msg = getClass().getSimpleName() + "\t" + "super.getCode"  ;
		
		return msg;
	}
	
	
	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * @return the nombreTotal
	 */
	public int getNombreTotal() {
		return nombreTotal;
	}

	/**
	 * @param nombreTotal the nombreTotal to set
	 */
	public void setNombreTotal(int nombreTotal) {
		this.nombreTotal = nombreTotal;
	}

	/**
	 * @return the nombreDisponible
	 */
	public int getNombreDisponible() {
		return nombreDisponible;
	}

	/**
	 * @param nombreDisponible the nombreDisponible to set
	 */
	public void setNombreDisponible(int nombreDisponible) {
		this.nombreDisponible = nombreDisponible;
	}

	
	public Livre() {
		// TODO Auto-generated constructor stub
	}
	
	public Livre(int annee1, Genre g, int nbTotal, int nbDispo) {
		super();
		setAnnee(annee1);
		setGenre(g);
		setNombreTotal(nbTotal);
		setNombreDisponible(nbDispo);
	}

}
