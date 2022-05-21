/* Fichier Document.java
 * Auteur : rebec
 * Date de création : May 13, 2022
 */
package classes;

import java.util.Objects;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class Document implements Comparable<Document>  {

	protected String code;
	protected Categorie categorie;
	protected String titre;
	protected static int nbDocument;
	
	//Methods
	@Override
	public String toString() {
		String msg = getClass().getSimpleName() + ",\t" + " : " + ",\t" + this.titre + ",\t" + this.code;
		return msg;
	}

	
	//Compare, equals and hashcode
	@Override
	public int compareTo(Document o) {
		//int test = this.getClass().compareTo(o.getClass());
		int result = (this.getClass().getSimpleName() + this.getCode()).compareTo(o.getClass().getSimpleName() + o.getCode());  
		return result;
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(categorie, code, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Document other = (Document) obj;
		return (categorie == other.categorie) && Objects.equals(code, other.code) && Objects.equals(titre, other.titre);
	}


	
	//Getters, setters and Constructors
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the nbDocument
	 */
	public static int getNbDocument() {
		return nbDocument;
	}
	
	/**
	 * 
	 */
	public Document() {
		nbDocument++;
	}
	
	/**
	 * 
	 * @param code1
	 * @param categorie1
	 * @param titre1
	 */
	public Document(String code1, String categorie1, String titre1) {
		this();
		setTitre(titre1);
		setCategorie(categorie);
		setCode(code1);
	}
	
	
	
	
}
