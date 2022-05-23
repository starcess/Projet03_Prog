/* Fichier Serialisation.java
 * Auteur : rebec
 * Date de création : May 19, 2022
 */
package util;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.google.gson.Gson;

import classes.Document;
import classes.Genre;
import classes.Livre;


/**
 *  TODO
 * Author : Prénom, nom
 */
public class Serialisation {
	
									//Sérialisation json		
	/**
	 * 
	 * @param documents
	 * @param pathSauvegarde
	 * @throws IOException
	 */
	public static void objectToJson(ArrayList <Document> documents, String pathSauvegarde) throws IOException {
		// Créer une instance Gson
		Gson js = new Gson();
		try (Writer out = new FileWriter(pathSauvegarde)) {
		
		js.toJson(documents, out);
		}
	}//fin méthode
	
	/**
	* @param path
	* @return
	* @throws IOException
	*/	 
	
	public static ArrayList <Document> jsonToObject(String path) throws IOException {
		ArrayList<Document> documents;
		
		// Créer une instance Gson
		Gson js = new Gson();
		//JsonReader jsonReader ;
		try (Reader in = new FileReader(path)) {
			documents = js.fromJson(in, ArrayList.class);
		}
		return documents; 
	}//fin méthode
	
	
	
									//Sérialisation Binaire
	/**
	 * 
	 * @param documents
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void objetToBinaire(ArrayList <Document> documents, String path) throws FileNotFoundException, IOException {
			try ( // Ouvre le fichier en ecriture
				FileOutputStream fos = 
				new FileOutputStream(path);
				ObjectOutputStream serialiseur = 
				new ObjectOutputStream(fos); )
			{
					// sérialiser l’objet
					serialiseur.writeObject(documents);
			}
	}//fin méthode
	
	
	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList <Document> binaireToObjet (String path) throws IOException, ClassNotFoundException{
		try ( // Ouvre le fichier en lecture
			FileInputStream fis = 
			new FileInputStream(path);
			ObjectInputStream deserialiseur = 
			new ObjectInputStream(fis) )
			{
				// Désérialiser le flux en objet
				ArrayList <Document> docs = (ArrayList <Document>) deserialiseur.readObject();
				return docs;
			}
	}//fin deSerialise //fin methode	


	
									//Sérialisation XML
	/**
	 * 
	 * @param listesDocuments
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void objetToXML(ArrayList <Document> listesDocuments, String path) throws FileNotFoundException, IOException{
		try (
				//Ouvre le fichier en ecriture
				FileOutputStream fos = new FileOutputStream(path);
				XMLEncoder encodeur = new XMLEncoder(fos);   )
		{
			//serialiser l'objet(s)
			encodeur.writeObject(listesDocuments);

		}
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static  ArrayList <Document> xmlToObjet(String path) throws FileNotFoundException, IOException {	
		try (XMLDecoder decodeur = new XMLDecoder(new FileInputStream(path)))

		{
			ArrayList <Document> listesDocuments = new ArrayList();
			//déserialiser tab
			listesDocuments = (ArrayList <Document>) decodeur.readObject();
			return listesDocuments;
		}

	}
	
									//Sérialisation TXT
	public static ArrayList<Document> fichiertoObject(String path) {
		String ligne = "";
		ArrayList<Document> listeDocuments1 = new ArrayList();
		//int i = Document.getNbDocument();

		// utilisation de try-with
		try (FileReader fr = new FileReader(path); // ouvrir fichier en lecture
				BufferedReader br = new BufferedReader(fr);) {

			while (br.ready()  /*&& (i < l.length )*/ ) { // tant que pas fin de fichier
				// Lire une ligne de texte
				ligne = br.readLine();

				if(ligne != null) {
					// Extraire les données de la ligne
					StringTokenizer str = new StringTokenizer(ligne, "[\t]");
						String titre = str.nextToken();
						String autheur = str.nextToken();
						int annee = Integer.parseInt(str.nextToken());
						String genreString = str.nextToken().toUpperCase();
						Genre g = Genre.valueOf(genreString);
						int nbCopieTotal = Integer.parseInt(str.nextToken());
												
						Document l = new Livre (null, "Livre", titre, autheur, annee, g, nbCopieTotal);
						listeDocuments1.add(l); 
						//i = Document.getNbDocument();	
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
		return listeDocuments1;
	}//fin méthode


}
