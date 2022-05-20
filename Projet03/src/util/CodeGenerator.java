package util;

import java.util.Date;

/** Classe utilitaire pour generer le code d'un document
 *	a partir de ses informations
 */
public class CodeGenerator {
					//Génération de code d'un document selon sa catégorie:
	
	/**
	 * Journal:
	 * Son code est généré à partir: son titre, 
	 * sa date de parution("aaaa-mm-jj"), l'année(aaaa)
	 * , longueur code(5), longueur du préfixe(2)
	 * @param titre
	 * @param dateParution
	 * @param annee
	 * @param longueurCode
	 * @param longueurPrefixe
	 * @return
	 */
	public static String generateJournalCode(String titre, Date dateParution, int annee,  int longueurCode, int longueurPrefixe) {	
		/*
		 returnCode += generateCodeLetter(auteur) + "-";
		 returnCode += CustomHash(titre, longueurTitre) + "-";
		 returnCode += CustomHash(Integer.toString(annee), longueurAnnee);
		 */
		
		String returnCode = ""; // String qui contiendra le code final
		returnCode = generateCodeLetter(titre) + "-";
		returnCode += customHash(titre, longueurCode) + "-";
		returnCode += customHash(Integer.toString(annee), longueurPrefixe);
		return returnCode;
	}
	
	/**
	 * Bd: 
	 * titre, auteur,  numéro édition, longueur code(5), 
	 * longueur du préfixe(2)
	 * @param titre
	 * @param autheur
	 * @param numEdition
	 * @param longueurCode
	 * @param longueurPrefixe
	 * @return
	 */
	public static String generateBDCode(String titre, String autheur, int numEdition, int longueurCode, int longueurPrefixe) {
		/*
		 returnCode += generateCodeLetter(auteur) + "-";
		 returnCode += CustomHash(titre, longueurTitre) + "-";
		 returnCode += CustomHash(Integer.toString(annee), longueurAnnee);
		 */
		
		String returnCode = "";
		returnCode = generateCodeLetter(autheur) + "-";
		returnCode = customHash(titre, longueurCode);
		returnCode = customHash(Integer.toString(numEdition), longueurPrefixe);
		return returnCode;
	}

	/**
	 * Livre:
	 * titre, auteur,  année édition, longueur code(5),
	 *  longueur du préfixe(2)
	 * @param titre
	 * @param autheur
	 * @param anneeEdition
	 * @param longueurCode
	 * @param longueurPrefixe
	 * @return
	 */
	public static String generateLivreCode(String titre, String autheur, int anneeEdition, int longueurCode, int longueurPrefixe) {
		/*
		 returnCode += generateCodeLetter(auteur) + "-";
		 returnCode += CustomHash(titre, longueurTitre) + "-";
		 returnCode += CustomHash(Integer.toString(annee), longueurAnnee);
		 */
		
		String returnCode = "";
		returnCode = generateCodeLetter(autheur) + "-";
		returnCode += customHash(titre, longueurCode);
		returnCode += customHash(Integer.toString(longueurCode), longueurPrefixe);
		return returnCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//WAS IN THE ORIGINAL FILE
	public static char[] HEXADECIMAL = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
	'F' };

	public static String generateCode(String titre, String auteur, int annee, int longueurTitre, int longueurAnnee) {
		if (longueurTitre <= 0) {
			longueurTitre = 1;
		}
		if (longueurTitre <= 4) {
			longueurTitre = 4;
		}
		if (longueurAnnee <= 0) {
			longueurAnnee = 1;
		}
		String returnCode = ""; // String qui contiendra le code final

		returnCode += generateCodeLetter(auteur) + "-";

		returnCode += customHash(titre, longueurTitre) + "-";

		returnCode += customHash(Integer.toString(annee), longueurAnnee);

		return returnCode;
	}

	public static String generateCodeLetter(String chaine) {
		String returnCode = "";
		String items[] = chaine.split("[ ]");
		if(chaine != null) {
			if (items.length >= 2 )
			{ // Premiere Partie du Code = Premiere lettre Nom Prenom Auteur
				returnCode = items[0].substring(0, 1).toUpperCase(); // IE : Patrick Senecal = PS-*****-**
				returnCode += items[1].substring(0, 1).toUpperCase();
			} else if ((chaine.length() >= 2) && !Character.isDigit(chaine.charAt(0)))
			{ // Si 1 item Code = 2 premieres lettres du nom
				returnCode = chaine.substring(0, 2).toUpperCase(); // IE : Corneille = CO-*****-**
			} else  { //
				// Si 1 item commencant par un chiffre : les 2 caracteres à partir de la position 1
				return chaine.substring(2,4);
			}

		} else {
			returnCode += "XX"; // Sinon Code = XX-*****-**
		}

		return returnCode;
	}

	public static String customHash(String titre, int longCode) {
		String returnCode = "";
		char[] nomTrans = titre.toCharArray(); // nom converti en Char[]
		int[] nbReduce = new int[longCode]; // Bucket pour le "Hashage"
		String retourAdd = ""; // String temporaire pour transformer le titre en chiffre

		if (titre.length() >= longCode) { // Si longueur titre est >= a la longeur du code

			for (int i = 0; i < nomTrans.length; i++) {
				nbReduce[i % nbReduce.length] += nomTrans[i]; // du titre a leur "Bucket" respectif
			}

			for (int i = nomTrans.length - 1; i >= 0; i--) {
				nbReduce[i % nbReduce.length] += nomTrans[i]; // les "Buckets"
			}

			for (int i = 0; i < nbReduce.length; i++) {
				retourAdd += HEXADECIMAL[reduceInt(nbReduce[i])]; // Ajoute la valeur "hashe" au code en HEX ( base 16 )
			}

			returnCode += retourAdd;
		} else { // Si la longueur titre est < la longueur du code

			for (int i = 0; i < (longCode - 1); i++) {
				nbReduce[i % nomTrans.length] += nomTrans[i % nomTrans.length];
			}

			for (int i = longCode - 1; i >= 0; i--) {
				nbReduce[nomTrans[i % nomTrans.length] % nbReduce.length] += nomTrans[i % nomTrans.length]; // les
				// "Buckets"
			}

			for (int i = 0; i < nbReduce.length; i++) {
				retourAdd += HEXADECIMAL[reduceInt(nbReduce[i])];
			}

			returnCode += retourAdd;
		}

		return returnCode;
	}

	public static int reduceInt(int value) {
		int temp = value;

		if (value < HEXADECIMAL.length) {
			return value;
		} else {
			while (temp >= HEXADECIMAL.length) {
				temp = (temp / 10) + (temp % 10);
			}
		}

		return temp;
	}

	public static String reverse(String string) {
		char tempString[] = string.toCharArray();
		String finalString = "";

		for (int i = 0, j = tempString.length - 1; i < string.length(); i++, j--) {
			tempString[j] = string.charAt(i);
		}

		for (int i = 0; i < tempString.length; i++) {
			finalString += tempString[i];
		}

		return finalString;
	}
	
}
