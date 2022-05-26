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

	protected String nomBibliotheque = "bibliothèque Ahuntsic";
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
			throw new Exception("Il ne reste plus de place dans la " + this.nomBibliotheque);
		}
	}
	
	
	/**
	 * Supprimer un document: 
	 * La suppression d'un document de la collection de documents.  
	 * @param code
	 * @throws Exception 
	 */
	public void suppression(String code) throws Exception{
		String msg;
		int index = rechercheCode(code); 
		if(index > -1) {
			msg = "Supprimer : " + this.listeDocuments.get(index).toString();
			System.out.println(msg);
			this.listeDocuments.remove(index);
			
		}else {
			msg = "Livre non trouvé.";
			System.out.println(msg);
		}
		
		
	}
	
	/**
	 * La recherche d'un document par code
	 * @param code
	 * @return
	 * @throws Exception 
	 */
	public int rechercheCode(String code1) throws Exception {
		int pos = -1;
		String msg;
		//System.out.println("Code : " + code1);
		if(code1.isBlank() == false ) {
			for(int i = 0; i < listeDocuments.size(); i++) {
				if ((listeDocuments.get(i)!= null) && listeDocuments.get(i).getCode().equalsIgnoreCase(code1)) {
					pos = i;
				}
			}
		} else {
			msg = "Code : [" + code1 + "], non trouvé.";
			throw new Exception(msg);
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
		String msg;
		if(titre.isBlank() == false ) {
			for(int i = 0; i < listeDocuments.size(); i++) {
				if ((listeDocuments.get(i)!= null) && listeDocuments.get(i).titre.equalsIgnoreCase(titre)) {
					pos = i;
				}
			}
		} else {
			msg = "Titre : [" + titre + "], non trouvé.";
			throw new Exception(msg);
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
				nbDispo = l.getNombreDisponible() - 1; 
				l.setNombreDisponible(nbDispo);
				this.listeDocuments.set(position, l);
				msg = "Prêt :\t" + this.listeDocuments.get(position).toString();
				System.out.println(msg);
			}else {
				msg = "Il ne reste plus de livre à prêter.";
				System.out.println(msg);
			}	
		}else {
		msg = this.listeDocuments.get(position).getClass().getSimpleName() + " : Emprunt non permis.";
		System.out.println(msg);
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
				listeDocuments.set(position, l);
				msg = "Retour :\t" + this.listeDocuments.get(position).toString() ;
				System.out.println(msg);
			}else {
				msg = "Aucun livre avait été emprunté \n" + this.listeDocuments.get(position).toString();
				System.out.println(msg);
				throw new Exception(msg);	
			}	
		}else {
			msg = this.listeDocuments.get(position).getClass().getSimpleName() + " : Retour non permis.";
			System.out.println(msg);
			throw new Exception(msg);
		}
	}
	
	
	/**
	 * Le tri des documents par catégorie puis par code
	 * pour comparer deux objets :
	 * a.compareTo(b) == 0 si a.equals(b)
	 * a.compareTo(b) < 0 pour a strictement inférieur à b
	 * a.compareTo(b) > 0 pour a strictement supérieur à b 
	 * @throws Exception 
	 */
	public ArrayList <Document> trier(ArrayList <Document> listeDocuments1) throws Exception {
		int result = -1;
		Document temporaire;
		
		if(listeDocuments1.size() > 0) {
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
		}else {
			throw new Exception("La liste de document est vide.");
		}
			
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
	 * @throws Exception 
	 */
	public String afficherListeLivres() throws Exception {
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
		String msg ="Liste triée des documents : \n";
		try {
			this.trier(this.listeDocuments);
			for(Document o : listeDocuments) {
				msg += o.toString() + "\n";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		this.listeDocuments = new ArrayList();
	}
	
	
	public void setFromListeDocuments(ArrayList<Document> listeDocuments1) {
		//this.listeDocuments = listeDocuments;
		this.listeDocuments = listeDocuments1;
	}
	
	
	public void setListeDocuments() {
		//this.listeDocuments = listeDocuments;
		this.listeDocuments = new ArrayList();
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
		setListeDocuments();
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
