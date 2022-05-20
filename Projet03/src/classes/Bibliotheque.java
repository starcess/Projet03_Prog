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
	protected ArrayList <Document> listeDocuments;
	
	
	//Methods
	
	/**
	 * L’ajout d'un nouveau document à la collection de documents.
	 * Au cas où il n’y a plus de place pour le document 
	 * (si on dépasse la capacité de la bibliothèque), on doit lever une exception.
	 * @param document
	 */
	public void ajouter(Document document) {
		if (Document.getNbDocument() <= MAX) {
			listeDocuments.add(document);
		}	
	}
	
	/**
	 * Supprimer un document: 
	 * La suppression d'un document de la collection de documents.  
	 * @param code
	 */
	
	public void suppression(String code){
		int index;
		for(Document o : listeDocuments) {
			if(o.code.equalsIgnoreCase(code) && (o != null)) {
				index = rechercheCode(code);
				listeDocuments.remove(index);
			}
		}
	}
	
	/**
	 * La recherche d'un document par code
	 * @param code
	 * @return
	 */
	public int rechercheCode(String code) {
		int pos = -1;
		if(code.isBlank() == false ) {
			for(int i = 0; i <= MAX; i++) {
				if ((listeDocuments.get(i)!= null) && listeDocuments.get(i).code.equalsIgnoreCase(code)) {
					pos = i;
				}
			}
		}
		return pos;
	}
	
	/**
	 * La recherche d'un document par titre
	 * @param titre
	 * @return
	 */
	public int rechercheTitre(String titre) {
		int pos = -1;
		if(titre.isBlank() == false ) {
			for(int i = 0; i <= MAX; i++) {
				if ((listeDocuments.get(i)!= null) && listeDocuments.get(i).titre.equalsIgnoreCase(titre)) {
					pos = i;
				}
			}
		}
		return pos;
	}
	
	
	public Document obtention(int position) {
		Document memoire = listeDocuments.get(position);
		return memoire;
	}
	
	
	
	
	
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
