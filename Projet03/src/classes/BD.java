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
public class BD extends Volume{

	protected int numEdition;
	
	@Override
	public String toString() {
		String msg = super.toString() + ",\t" + this.numEdition;
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
	
	public BD(int numEdition1) {
		this();
		setNumEdition(numEdition1);
		super.code = CodeGenerator.generateBDCode(titre, autheur, numEdition1, 5, 2);
	}

}
