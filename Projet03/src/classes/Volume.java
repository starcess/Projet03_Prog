/* Fichier Volume.java
 * Auteur : rebec
 * Date de création : May 9, 2022
 */
package classes;

import java.io.Serializable;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class Volume extends Document implements Serializable  {

	protected String autheur;
	
	@Override
	public String toString() {
		String msg = super.toString() + ",\t" + this.autheur;
		return msg;
	}
	
	
	//Getters, setters and constructors
	/**
	 * @return the autheur
	 */
	public String getAutheur() {
		return autheur;
	}

	/**
	 * @param autheur the autheur to set
	 */
	public void setAutheur(String autheur) {
		this.autheur = autheur;
	}
	
	public Volume() {
		super();
	}
	
	public Volume(String code1, String categorie1, String titre1) {
		super(code1, categorie1, titre1);
	}
	
	public Volume(String code1, String categorie1, String titre1, String autheur1) {
		this(code1, categorie1, titre1);
		setAutheur(autheur1);
	}

}
