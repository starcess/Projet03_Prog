/* Fichier Serialisation.java
 * Auteur : rebec
 * Date de création : May 19, 2022
 */
package util;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
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

import com.google.gson.Gson;

import classes.Document;


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


	
									//Sérialisation Binaire
	/**
	 * 
	 * @param listesDocuments
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void objetToXML(ArrayList <Document> listesDocuments, String path) throws FileNotFoundException, IOException{
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
	private static  ArrayList <Document> xmlToObjet(String path) throws FileNotFoundException, IOException {	
		try (XMLDecoder decodeur = new XMLDecoder(new FileInputStream(path)))

		{
			ArrayList <Document> listesDocuments = new ArrayList();
			//déserialiser tab
			listesDocuments = (ArrayList <Document>) decodeur.readObject();
			return listesDocuments;
		}

	}


}
