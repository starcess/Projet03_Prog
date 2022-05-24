/* Fichier BD.java
 * Auteur : rebec
 * Date de création : May 9, 2022
 */
package classes;

import util.CodeGenerator;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class BD extends Volume  {

	protected int numEdition;
	
	@Override
	public String toString() {
		String msg = super.toString() + ",\t" +  "Edition : " + this.numEdition;
		return msg;
	}
	
	
	//Getters, setters and Constructor
	/**
	 * @return the numEdition
	 */
	public int getNumEdition() {
		return numEdition;
	}

	/**
	 * @param numEdition the numEdition to set
	 */
	public void setNumEdition(int numEdition) {
		this.numEdition = numEdition;
	}

	/**
	 * 
	 */
	public BD() {
		super();
	}
	
	public BD(String code1, String categorie1, String titre1, String autheur1) {
		super(code1, categorie1, titre1, autheur1);		
	}
	
	public BD(String code1, String categorie1, String titre1, String autheur1, int numEdition1) {
		this(code1, categorie1, titre1, autheur1);	
		super.code = CodeGenerator.generateBDCode(titre1, autheur1, numEdition1, 5, 2);
		super.categorie = Categorie.BD;
		setNumEdition(numEdition1);
	}

}
