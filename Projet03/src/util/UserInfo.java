/* Fichier UserInfo.java
 * Auteur : rebec
 * Date de création : May 23, 2022
 */
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class UserInfo {

	private ArrayList <String> listeUsername;
	private ArrayList <String> listePwd;
	
	
	//Methods
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public  ArrayList<String> fichiertoPwd(String path)  {
		String ligne = "";
		ArrayList<String> pwd = new ArrayList();
		String password;

		// utilisation de try-with
		try (FileReader fr = new FileReader(path); // ouvrir fichier en lecture
				BufferedReader br = new BufferedReader(fr);) {

			while (br.ready()) { // tant que pas fin de fichier
				// Lire une ligne de texte
				ligne = br.readLine();

				if(ligne != null) {
					// Extraire les données de la ligne
					StringTokenizer str = new StringTokenizer(ligne, "[\n]");
						password = str.nextToken();
						pwd.add(password);	
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
	public ArrayList<String> fichiertoUserName(String path) {
		String ligne = "";
		ArrayList<String> username = new ArrayList();
		String utilisateur;

		// utilisation de try-with
		try (FileReader fr = new FileReader(path); // ouvrir fichier en lecture
				BufferedReader br = new BufferedReader(fr);) {

			while (br.ready()) { // tant que pas fin de fichier
				// Lire une ligne de texte
				ligne = br.readLine();

				if(ligne != null) {
					// Extraire les données de la ligne
					StringTokenizer str = new StringTokenizer(ligne, "[\n]");
						utilisateur = str.nextToken();
						username.add(utilisateur);
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
	

	public void addUserName(String username1) {
		this.listeUsername.add(username1);		
	}
	
	
	public void addPwd(String pwd1) {
		this.listePwd.add(pwd1);		
	}
	
	
	//Getters, setters and cosntructors
	/**
	 * @return the username
	 */
	public ArrayList<String> getUsername() {
		return listeUsername;
	}


	/**
	 * @param username the username to set
	 */
	public void setUsername(ArrayList<String> username) {
		//this.username = username;
		String path = "./Ressources/users.txt";
		this.listeUsername = fichiertoUserName(path);
	}
	
	
	public void setUsername() {
		//this.username = username;
		String path = "./Ressources/users.txt";
		this.listeUsername = fichiertoUserName(path);
	}


	/**
	 * @return the pwd
	 */
	public ArrayList<String> getPwd() {
		return listePwd;
	}
	

	/**
	 * @param pwd the pwd to set
	 * 
	 */
	public void setPwd(ArrayList<String> pwd)  {
		//this.pwd = pwd;
		String path = "./Ressources/pwds.txt";
		this.listePwd = fichiertoPwd(path);
	}
	
	
	public void setPwd()  {
		//this.pwd = pwd;
		String path = "./Ressources/pwds.txt";
		this.listePwd = fichiertoPwd(path);
	}
	
	
	/**
	 * 
	 */
	public UserInfo() {
		setPwd();
		setUsername();
	}
	

}
