/* Fichier Test_Bibliothèque.java
 * Auteur : rebec
 * Date de création : May 19, 2022
 */
package classes;

import util.Serialisation;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class Test_Bibliothèque {

	public static void main(String[] args) {
		
		/*
		Liste triée des documents :
			BD : JC-8F600-5F, Pif Edition: 109
			Journal : 21-C65B6-25, Le monde, 2021-03-27
			Journal : 22-44B63-27, Devoir, 2022-02-13
			Livre : AC-4AFB6-63, L'étranger 1959 Roman 4/4
			Livre : VH-99D96-47, Les Misérables 1942 Roman 3/3
			Livre trouvé par titre :Livre : AC-4AFB6-63, L'étranger 1959 Roman 4/4
			Pret: Livre : AC-4AFB6-63, L'étranger 1959 Roman 3/4
			Pret: Journal: Emprunt non permis
			Liste triée des livres :
			Livre : AC-4AFB6-63, L'étranger 1959 Roman 3/4
			Livre : VH-99D96-47, Les Misérables 1942 Roman 3/3
		*/
		
		
		try {
			String pathChargementLivre = "./Ressources/Liste_Livre.txt";
			String pathXml = "./Ressources/Liste_Xml.xml";
			String pathBinaire = "./Ressources/Liste_Binaire.bin";
			int position;
			
			Bibliotheque bibli = new Bibliotheque();
			bibli.listeDocuments = Serialisation.fichiertoObject(pathChargementLivre);
			bibli.ajouter(new BD (null, null, "Pif","Edison", 109));
			bibli.ajouter(new Journal (null, null, "Le monde", "2021-03-27"));
			System.out.println(bibli.toString());
			
			System.out.println();
			System.out.println(bibli.afficherListeLivres());
			System.out.println();
			
			position = bibli.rechercheTitre("L'Etranger");
			System.out.println("Livre trouvé par titre :\t"  + bibli.listeDocuments.get(position).toString());
			bibli.emprunter(position);
			bibli.retourner(position);
			position = bibli.rechercheCode("21-C65B6-25");
			System.out.println(bibli.getListeDocuments().get(position).getClass().getSimpleName() + " trouvé par code :\t"  + bibli.listeDocuments.get(position).toString());
			bibli.emprunter(position);
		
			System.out.println();
			bibli.sauvegardeXml(bibli.listeDocuments, pathXml);
			bibli.sauvegardeBinaire(bibli.listeDocuments, pathBinaire);
			
			System.out.println();
 
			
			Bibliotheque bibli2 = new Bibliotheque("Deuxième bibliothèque");
			bibli2.setFromListeDocuments(bibli2.chargementBinaire(pathBinaire)); 
			System.out.println(bibli2.getNomBibliotheque() + "\n" + bibli2.toString());
			
			
			//Bibliotheque bibli3 = new Bibliotheque("Troisième bibliothèque");
			//bibli2.setFromListeDocuments(bibli3.chargementXml(pathBinaire)); 
			//System.out.println(bibli3.getNomBibliotheque() + "\n" + bibli3.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
}
