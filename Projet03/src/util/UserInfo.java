/* Fichier UserInfo.java
 * Auteur : rebec
 * Date de création : May 23, 2022
 */
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class UserInfo {

	private String[] username;
	private String[] pwd;
	
	
	//Methods
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String[] fichiertoPwd(String path)  {
		String ligne = "";
		String[] pwd = new String[10];
		String password;
		int i = 0;

		// utilisation de try-with
		try (FileReader fr = new FileReader(path); // ouvrir fichier en lecture
				BufferedReader br = new BufferedReader(fr);) {

			while (br.ready()  && (i < pwd.length)) { // tant que pas fin de fichier
				// Lire une ligne de texte
				ligne = br.readLine();

				if(ligne != null) {
					// Extraire les données de la ligne
					StringTokenizer str = new StringTokenizer(ligne, "[\t]");
						password = str.nextToken();
						pwd[i] = password;
						i++;	
				    }
				
			} // fin while

		} catch (NumberFormatException e) {
			System.out.println("Erreur d'année ou de nombre de copies totals disponible");
		} catch (FileNotFoundException e) {
			System.out.println("Erreur : fichier non trouvé");
		}
		catch (IOException e) {
			System.out.println("Erreur de lecture du fichier");
		} catch (NoSuchElementException e) {
			System.out.println("Données invalides");
		}
		return pwd;
	}//fin méthode
		
	
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String[] fichiertoUserName(String path) {
		String ligne = "";
		String[] username = new String[10];
		String utilisateur;
		int i = 0;

		// utilisation de try-with
		try (FileReader fr = new FileReader(path); // ouvrir fichier en lecture
				BufferedReader br = new BufferedReader(fr);) {

			while (br.ready()  && (i < username.length)) { // tant que pas fin de fichier
				// Lire une ligne de texte
				ligne = br.readLine();

				if(ligne != null) {
					// Extraire les données de la ligne
					StringTokenizer str = new StringTokenizer(ligne, "[\t]");
						utilisateur = str.nextToken();
						username[i] = utilisateur;
						i++;	
				    }
				
			} // fin while

		} catch (NumberFormatException e) {
			System.out.println("Erreur d'année ou de nombre de copies totals disponible");
		} catch (FileNotFoundException e) {
			System.out.println("Erreur : fichier non trouvé");
		}
		catch (IOException e) {
			System.out.println("Erreur de lecture du fichier");
		} catch (NoSuchElementException e) {
			System.out.println("Données invalides");
		}
		return username;
	}//fin méthode
	
	
	//Getters, setters and cosntructors
	/**
	 * @return the username
	 */
	public String[] getUsername() {
		return username;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(String[] username) {
		//this.username = username;
		String path = "./Ressources/users.txt";
		this.username = fichiertoUserName(path);
	}


	/**
	 * @return the pwd
	 */
	public String[] getPwd() {
		return pwd;
	}
	

	/**
	 * @param pwd the pwd to set
	 * 
	 */
	public void setPwd(String[] pwd)  {
		//this.pwd = pwd;
		String path = "./Ressources/pwds.txt";
		this.pwd = fichiertoPwd(path);
	}
	
	
	/**
	 * 
	 */
	public UserInfo() {
		}
	

}
