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
			for(int i = 0; i <=  listeDocuments.size(); i++) {
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
			for(int i = 0; i <= listeDocuments.size(); i++) {
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
	
	
	
	/**
	 * Seuls les livres peuvent être empruntés.
	 * Un ajustement du nombre de copies disponibles doit être effectué selon les prêts et les retours.
	 * Le prêt d’un livre donné revient à vérifier s’il a une copie disponible. 
	 * Le retour d’un livre revient à rendre disponible une copie de ce livre.
	 * Au cas où l'on essaye d'emprunter un document qui n'est pas un livre, une exception doit être levée(signalée).
	 * @param position
	 * @throws Exception
	 */
	public void emprunter(int position) throws Exception {
		String msg;
		Livre l;
		int nbDispo;
		if(listeDocuments.get(position) instanceof Livre) {
			l = (Livre) listeDocuments.get(position);
			if(l.getNombreDisponible() > 0) {
				nbDispo = l.getNombreTotal() - 1; 
				l.setNombreDisponible(nbDispo);
				listeDocuments.set(nbDispo, l);
			}else {
				msg = "Il ne reste plus de livre à prêter.";
				throw new Exception(msg);
			}	
		}else {
			msg = "Ce n'étais pas un livre.";
			throw new Exception(msg);
		}
	}
	
	
	
	/**
	 * Seuls les livres peuvent être empruntés.
	 * Un ajustement du nombre de copies disponibles doit être effectué selon les prêts et les retours.
	 * Le prêt d’un livre donné revient à vérifier s’il a une copie disponible. 
	 * Le retour d’un livre revient à rendre disponible une copie de ce livre. 
	 * @param position
	 * @throws Exception
	 */
	public void retourner(int position) throws Exception {
		String msg;
		Livre l;
		int nbDispo;
		if(listeDocuments.get(position) instanceof Livre) {
			l = (Livre) listeDocuments.get(position);
			if(l.getNombreDisponible() < l.getNombreTotal()) {
				nbDispo = l.getNombreTotal() + 1; 
				l.setNombreDisponible(nbDispo);
				listeDocuments.set(nbDispo, l);
			}else {
				msg = "Aucun livre avait été emprunté";
				throw new Exception(msg);
			}	
		}else {
			msg = "Ce n'étais pas un livre.";
			throw new Exception(msg);
		}
	}
	
	
	/**
	 * Le tri des documents par catégorie puis par code
	 * pour comparer deux objets :
	 * a.compareTo(b) == 0 si a.equals(b)
	 * a.compareTo(b) < 0 pour a strictement inférieur à b
	 * a.compareTo(b) > 0 pour a strictement supérieur à b 
	 */
	public void trier() {
		int result = -1;
		Document temporaire;
		
		for (int i = 0; i < listeDocuments.size() ; i++) {
			if(listeDocuments.get(i) != null) {
				for(int j = i+1; j < listeDocuments.size(); j++) {
					if(listeDocuments.get(j) != null) {
						result =listeDocuments.get(i).compareTo(listeDocuments.get(j));    
						if (result > 0) {
							temporaire = listeDocuments.get(i);
							listeDocuments.set(i, listeDocuments.get(j));
							listeDocuments.set(j, temporaire);
							//listeDocuments.get(i) = listeDocuments.get(j);
							//listeDocuments.get(j) = memory;
						}					
					}//fin if(listeDocuments.get(j) != null) {
				}//fin inside for j			
			}//fin if (listeDocuments.get(i) != null)
		}//fin outside for i		
	}//fin méthode
	
	
	@Override
	public String toString() {
		this.trier();
		String msg ="";
		for(Document o : listeDocuments) {
			msg += o.toString();
		}
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
	 * @return the listeDocuments
	 */
	public ArrayList<Document> getListeDocuments() {
		return listeDocuments;
	}

	/**
	 * @param listeDocuments the listeDocuments to set
	 */
	public void setListeDocuments(ArrayList<Document> listeDocuments) {
		this.listeDocuments = listeDocuments;
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
