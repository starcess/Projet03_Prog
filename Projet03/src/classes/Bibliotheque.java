/* Fichier Bibliotheque.java
 * Auteur : rebec
 * Date de création : May 9, 2022
 */
package classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import util.Serialisation;

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
	 * @throws Exception 
	 */
	public void ajouter(Document document) throws Exception {
		if (Document.getNbDocument() <= MAX) {
			listeDocuments.add(document);
		}else {
			throw new Exception("Il ne reste plus de place dans la bibliothèque " + this.nomBibliotheque);
		}
	}
	
	/**
	 * Supprimer un document: 
	 * La suppression d'un document de la collection de documents.  
	 * @param code
	 * @throws Exception 
	 */
	public void suppression(String code) throws Exception{
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
	 * @throws Exception 
	 */
	public int rechercheCode(String code) throws Exception {
		int pos = -1;
		if(code.isBlank() == false ) {
			for(int i = 0; i < listeDocuments.size(); i++) {
				if ((listeDocuments.get(i)!= null) && listeDocuments.get(i).code.equalsIgnoreCase(code)) {
					pos = i;
				}
			}
		}else {
			throw new Exception("Ce code n'a pas été trouvé.");
		}
		return pos;
		
	}
	
	/**
	 * La recherche d'un document par titre
	 * @param titre
	 * @return
	 * @throws Exception 
	 */
	public int rechercheTitre(String titre) throws Exception {
		int pos = -1;
		if(titre.isBlank() == false ) {
			for(int i = 0; i < listeDocuments.size(); i++) {
				if ((listeDocuments.get(i)!= null) && listeDocuments.get(i).titre.equalsIgnoreCase(titre)) {
					pos = i;
				}
			}
		}else {
			throw new Exception("Ce titre n'a pas été trouvé.");
		}
		return pos;
	}
	
	/**
	 * 
	 * @param position
	 * @return
	 */
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
		if((listeDocuments.get(position) instanceof Livre) && (position > 0) && (position < this.listeDocuments.size())) {
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
		msg = "Ce n'étais pas un livre ou position plus petit que 0 et plus grande que la taille de la liste des documents ";
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
		if((listeDocuments.get(position) instanceof Livre) && (position > 0) && (position < this.listeDocuments.size())) {
			l = (Livre) listeDocuments.get(position);
			if(l.getNombreDisponible() < l.getNombreTotal()) {
				nbDispo = l.getNombreDisponible() + 1; 
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
	public ArrayList <Document> trier(ArrayList <Document> listeDocuments1) {
		int result = -1;
		Document temporaire;
		
		for (int i = 0; i < listeDocuments1.size() ; i++) {
			if(listeDocuments1.get(i) != null) {
				for(int j = i+1; j < listeDocuments1.size(); j++) {
					if(listeDocuments1.get(j) != null) {
						result =listeDocuments1.get(i).compareTo(listeDocuments.get(j));    
						if (result > 0) {
							temporaire = listeDocuments1.get(i);
							listeDocuments1.set(i, listeDocuments1.get(j));
							listeDocuments1.set(j, temporaire);
						}					
					}//fin if(listeDocuments.get(j) != null) {
				}//fin inside for j			
			}//fin if (listeDocuments.get(i) != null)
		}//fin outside for i	
		return listeDocuments1;
	}//fin méthode
	
	/**
	 * 
	 * @param listeDocuments1
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void sauvegardeBinaire(ArrayList<Document> listeDocuments1, String path) throws FileNotFoundException, IOException {
		Serialisation.objetToBinaire(listeDocuments1, path);
		System.out.println("Bibliothèque sérialisée en binaire avec succès");
	}
	
	
	/**
	 * 
	 * @param listeDocuments1
	 * @param path
	 * @throws IOException
	 */
	public void sauvegardeJson(ArrayList<Document> listeDocuments1, String path) throws IOException {
		Serialisation.objectToJson(listeDocuments1, path);
		System.out.println("Bibliothèque sérialisée en json avec succès");
	}
	
	
	/**
	 * 
	 * @param listeDocuments1
	 * @param path
	 * @throws IOException
	 */
	public void sauvegardeXml(ArrayList<Document> listeDocuments1, String path) throws IOException {
		Serialisation.objetToXML(listeDocuments1, path);
		System.out.println("Bibliothèque sérialisée en xml avec succès");
	}
	
	
	/**
	 * 
	 * @param path
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ArrayList<Document> chargementBinaire(String path) throws ClassNotFoundException, IOException {
		ArrayList<Document> listeDocuments1 = new ArrayList();
		listeDocuments1 = Serialisation.binaireToObjet(path);
		return listeDocuments1;
	}
	
	
	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public ArrayList<Document> chargementJson(String path) throws IOException {
		ArrayList<Document> listeDocuments1 = new ArrayList();
		listeDocuments1 = Serialisation.jsonToObject(path);
		return listeDocuments1;
		
	}	
	
	
	/**
	 * 
	 * @param path
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ArrayList<Document> chargementXml(String path) throws ClassNotFoundException, IOException {
		ArrayList<Document> listeDocuments1 = new ArrayList();
		listeDocuments1 = Serialisation.xmlToObjet(path);
		return listeDocuments1;
	}
	
	/**
	 * Afficher la liste triée des livres 
	 * @param listeDocuments1
	 * @return
	 */
	public String afficherListeLivres() {
		String msg = "Liste triés des livres: \n";
		this.trier(this.listeDocuments);
		for(int i = 0 ; i < this.listeDocuments.size(); i++ ){
			if(this.listeDocuments.get(i) instanceof Livre) {
				msg += this.listeDocuments.get(i) + "\n";
			}
		}
		return msg;
	}
	
	
	
	/**
	 * Afficher la liste triée des documents de la bibliothèque
	 */
	@Override
	public String toString() {
		this.trier(this.listeDocuments);
		String msg ="Liste triée des documents : \n";
		for(Document o : listeDocuments) {
			msg += o.toString() + "\n";
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
		//this.listeDocuments = listeDocuments;
		listeDocuments = new ArrayList();
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
		//this(String nom);
		setListeDocuments(listeDocuments);
	}
	
	
	/**
	 * 
	 * @param nom
	 */
	public Bibliotheque(String nom) {
		this();
		setNomBibliotheque(nom);	
	}

}
