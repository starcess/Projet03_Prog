/* Fichier Bibliotheque.java
 * Auteur : rebec
 * Date de création : May 9, 2022
 */
package classes;

import java.util.ArrayList;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class Bibliotheque {

	protected String nomBibliotheque = "Bibliothèque Ahuntsic";
	protected final int MAX = 500;
	protected ArrayList <Document> documents;
	
	
	
	@Override
	public String toString() {
		String msg ="";
		return msg;
	}
	
	
	//Getters, setters and Constructors
	/**
	 * @return the nomBibliotheque
	 */
	public String getNomBibliotheque() {
		return nomBibliotheque;
	}


	/**
	 * @param nomBibliotheque the nomBibliotheque to set
	 */
	public void setNomBibliotheque(String nomBibliotheque) {
		this.nomBibliotheque = nomBibliotheque;
	}


	/**
	 * @return the documents
	 */
	public ArrayList<Document> getDocuments() {
		return documents;
	}


	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}


	/**
	 * @return the mAX
	 */
	public int getMAX() {
		return MAX;
	}


	/**
	 * 
	 */
	public Bibliotheque() {
		
	}
	
	public Bibliotheque(String nom) {
		setNomBibliotheque(nom);
	}

}
