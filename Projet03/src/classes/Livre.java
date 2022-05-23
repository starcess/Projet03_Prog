/* Fichier Livre.java
 * Auteur : rebec
 * Date de création : May 9, 2022
 */
package classes;

import util.CodeGenerator;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class Livre extends Volume{
	protected int annee;
	protected Genre genre;
	protected int nombreTotal;
	protected int nombreDisponible;
	
	
	@Override
	public String toString() {
		String msg = super.toString() + ",\t" + this.annee + ",\t" +
					  this.genre + ",\t" + this.nombreDisponible + "/" + this.nombreTotal;
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

	//Constructor
	public Livre() {
		super();
	}
	
	
	public Livre(String code1, String categorie1, String titre1, String autheur1) {
		super(code1, categorie1, titre1, autheur1);
	}
	
	
	public Livre(String code1, String categorie1, String titre1, String autheur1, int annee1, Genre g, int nbTotal) {		
		this(code1, categorie1, titre1, autheur1);
		super.code = CodeGenerator.generateLivreCode(titre, autheur, annee1, 5, 2);
		super.categorie = Categorie.LIVRE;
		setAnnee(annee1);
		setGenre(g);
		setNombreTotal(nbTotal);
		setNombreDisponible(nbTotal);
	}

}
