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
			String pathSauvegardeXml = "./Ressources/objectToXml.xml";
			String pathSauvegardeBinaire = "./Ressources/objectToBinaire.bin";
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
			System.out.println("Prêt :\t" + bibli.listeDocuments.get(position).toString());
			position = bibli.rechercheCode("AC-4ABB6-47");
			System.out.println("Livre trouvé par code :\t"  + bibli.listeDocuments.get(position).toString());
			bibli.retourner(position);
			System.out.println("Retour :\t"  + bibli.listeDocuments.get(position).toString());
		
			System.out.println();
			bibli.sauvegardeXml(bibli.listeDocuments, pathSauvegardeXml);
			bibli.sauvegardeBinaire(bibli.listeDocuments, pathSauvegardeBinaire);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
}
