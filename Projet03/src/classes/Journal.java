/* Fichier Journal.java
 * Auteur : rebec
 * Date de création : May 9, 2022
 */
package classes;

import java.util.Date;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class Journal extends Document {

	protected Date dateParution;
	
	@Override
	public String toString() {
		String msg = super.toString() + ",\t" + this.dateParution.toString();
		return msg;
	}
	
	
	//Getters, Setters and Constructors
	/**
	 * @return the dateParution
	 */
	public Date getDateParution() {
		return dateParution;
	}

	/**
	 * @param dateParution the dateParution to set
	 */
	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	/**
	 * Journal: est un document 
	 * qui a en plus une date de parution:
	 */
	public Journal() {
		super();
	}
	
	public Journal(Date dateParution1) {
		this();	
		setDateParution(dateParution1);
	}

}
