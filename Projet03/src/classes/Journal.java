/* Fichier Journal.java
 * Auteur : rebec
 * Date de création : May 9, 2022
 */
package classes;

import java.io.Serializable;
import java.time.LocalDate;

import util.CodeGenerator;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class Journal extends Document  implements Serializable {

	protected String dateParution;
	protected int annee;
	
	@Override
	public String toString() {
		String msg = super.toString() + ",\t" + this.dateParution.toString();
		return msg;
	}
	
	
	//Getters, Setters and Constructors
	/**
	 * @return the dateParution
	 */
	public String getDateParution() {
		return dateParution;
	}

	/**
	 * @param dateParution the dateParution to set
	 */
	public void setDateParution(String dateParution) {
		this.dateParution = dateParution;
	}

	/**
	 * Journal: est un document 
	 * qui a en plus une date de parution:
	 */
	public Journal() {
		super();
	}
	
	
	public Journal(String code1, String categorie1, String titre1) {
		super(code1, categorie1, titre1);
	}
	
	
	public Journal(String code1, String categorie1, String titre1, String dateParution1) {
		this(code1, categorie1, titre1);	
		setDateParution(dateParution1);
		//this.annee = String.valueOf(dateParution1.getYear());
		LocalDate date = LocalDate.parse(this.dateParution);
		this.annee = date.getYear();
		super.code = CodeGenerator.generateJournalCode(titre, dateParution1, annee, 5,2);	
		super.categorie = Categorie.JOURNAL;
	}

}
