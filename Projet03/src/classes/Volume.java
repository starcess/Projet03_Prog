/* Fichier Volume.java
 * Auteur : rebec
 * Date de création : May 9, 2022
 */
package classes;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class Volume extends Document {

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
	
	public Volume(String autheur1) {
		this();
		setAutheur(autheur1);
	}

}
