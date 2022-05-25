/* Fichier FeGestion.java
 * Auteur : rebec
 * Date de création : May 11, 2022
 */
package projet03_gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import classes.BD;
import classes.Bibliotheque;
import classes.Document;
import classes.Genre;
import classes.Journal;
import classes.Livre;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class FeGestion extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_Code;
	private JLabel lbl_Titre;
	private JLabel lbl_Autheur;
	private JLabel lbl_Annee;
	private JLabel lbl_Nb_Copie;
	private JLabel lbl_Date;
	private JLabel lbl_Numero;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private static JComboBox cb_Code;
	private JRadioButton rdbtn_Livre;
	private JRadioButton rdbtn_Journal;
	private JRadioButton rdbtn_BD;
	private static final ButtonGroup buttonGroupCategorie = new ButtonGroup();
	private static  JComboBox <Genre> cb_Genre;
	private static JTextField textField_Titre;
	private static JTextField textField_Autheur;
	private static JTextField textField_Annee;
	private static JTextField textField_NbCopies;
	private JButton btn_Search;
	private static JTextField textField_Date;
	private static JTextField textField_Numero;
	private JPanel panel_Buttons;
	private JButton btn_Ajouter;
	private JButton btn_Supprimer;
	private JButton btn_Sauvegarder;
	private JButton btn_Effacer;
	private JButton btn_Lister;
	private JButton btn_Quitter;
	//My attributes
	private FeAu frameAu;
	private static Bibliotheque bibli;
	private static String pathBinaire = "./Ressources/Liste_Binaire.bin";
	private static String pathXml = "./Ressources/Liste_Xml.xml";
	private JLabel lbl_Erreur;
	private JButton btn_Preter;
	private JButton btn_Retourner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FeGestion frame = new FeGestion();
					frame.setVisible(true);
					chargerFichierBinaire();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FeGestion() {
		initialize();
	}
	private void initialize() {
		setTitle("Bibliothèque Ahuntsic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 735);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_Code = new JLabel("Code ");
		lbl_Code.setForeground(Color.WHITE);
		lbl_Code.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Code.setBounds(10, 37, 88, 31);
		contentPane.add(lbl_Code);
		
		lbl_Titre = new JLabel("Titre");
		lbl_Titre.setForeground(Color.WHITE);
		lbl_Titre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Titre.setBounds(10, 73, 88, 31);
		contentPane.add(lbl_Titre);
		
		lbl_Autheur = new JLabel("Autheur");
		lbl_Autheur.setForeground(Color.WHITE);
		lbl_Autheur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Autheur.setBounds(10, 128, 88, 31);
		contentPane.add(lbl_Autheur);
		
		lbl_Annee = new JLabel("Année");
		lbl_Annee.setForeground(Color.WHITE);
		lbl_Annee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Annee.setBounds(10, 169, 88, 31);
		contentPane.add(lbl_Annee);
		
		lbl_Nb_Copie = new JLabel("Nb copies");
		lbl_Nb_Copie.setForeground(Color.WHITE);
		lbl_Nb_Copie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Nb_Copie.setBounds(10, 210, 88, 31);
		contentPane.add(lbl_Nb_Copie);
		
		lbl_Date = new JLabel("Date");
		lbl_Date.setForeground(Color.WHITE);
		lbl_Date.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Date.setBounds(583, 128, 88, 31);
		contentPane.add(lbl_Date);
		
		lbl_Numero = new JLabel("Numéro");
		lbl_Numero.setForeground(Color.WHITE);
		lbl_Numero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Numero.setBounds(583, 169, 88, 31);
		contentPane.add(lbl_Numero);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 297, 812, 377);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		cb_Code = new JComboBox();
		cb_Code.addActionListener(new Cb_CodeActionListener());
		cb_Code.setFont(new Font("Tahoma", Font.BOLD, 14));
		cb_Code.setBounds(74, 42, 259, 21);
		contentPane.add(cb_Code);
		
		rdbtn_Livre = new JRadioButton("Livre");
		buttonGroupCategorie.add(rdbtn_Livre);
		rdbtn_Livre.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtn_Livre.setBounds(449, 133, 103, 21);
		contentPane.add(rdbtn_Livre);
		
		rdbtn_Journal = new JRadioButton("Journal");
		buttonGroupCategorie.add(rdbtn_Journal);
		rdbtn_Journal.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtn_Journal.setBounds(449, 169, 103, 21);
		contentPane.add(rdbtn_Journal);
		
		rdbtn_BD = new JRadioButton("BD");
		buttonGroupCategorie.add(rdbtn_BD);
		rdbtn_BD.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtn_BD.setBounds(449, 209, 103, 21);
		contentPane.add(rdbtn_BD);
		
		cb_Genre = new JComboBox();
		cb_Genre.setFont(new Font("Tahoma", Font.BOLD, 14));
		cb_Genre.setBounds(210, 215, 178, 21);
		contentPane.add(cb_Genre);
		
		textField_Titre = new JTextField();
		textField_Titre.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Titre.setBounds(74, 78, 239, 19);
		contentPane.add(textField_Titre);
		textField_Titre.setColumns(10);
		
		textField_Autheur = new JTextField();
		textField_Autheur.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Autheur.setColumns(10);
		textField_Autheur.setBounds(74, 134, 239, 19);
		contentPane.add(textField_Autheur);
		
		textField_Annee = new JTextField();
		textField_Annee.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Annee.setColumns(10);
		textField_Annee.setBounds(74, 175, 146, 19);
		contentPane.add(textField_Annee);
		
		textField_NbCopies = new JTextField();
		textField_NbCopies.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_NbCopies.setColumns(10);
		textField_NbCopies.setBounds(86, 216, 96, 19);
		contentPane.add(textField_NbCopies);
		
		btn_Search = new JButton("");
		btn_Search.addActionListener(new Btn_SearchActionListener());
		btn_Search.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_1search.png")));
		btn_Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Search.setBounds(323, 74, 30, 30);
		contentPane.add(btn_Search);
		
		textField_Date = new JTextField();
		textField_Date.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Date.setColumns(10);
		textField_Date.setBounds(672, 134, 207, 19);
		contentPane.add(textField_Date);
		
		textField_Numero = new JTextField();
		textField_Numero.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Numero.setColumns(10);
		textField_Numero.setBounds(672, 175, 198, 19);
		contentPane.add(textField_Numero);
		
		panel_Buttons = new JPanel();
		panel_Buttons.setBackground(Color.BLACK);
		panel_Buttons.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.ORANGE, Color.ORANGE, Color.ORANGE));
		panel_Buttons.setBounds(398, 10, 488, 94);
		contentPane.add(panel_Buttons);
		panel_Buttons.setLayout(null);
		
		btn_Ajouter = new JButton("");
		btn_Ajouter.addActionListener(new Btn_AjouterActionListener());
		btn_Ajouter.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_ajouter.png")));
		btn_Ajouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Ajouter.setBounds(10, 22, 50, 50);
		panel_Buttons.add(btn_Ajouter);
		
		btn_Supprimer = new JButton("");
		btn_Supprimer.addActionListener(new Btn_SupprimerActionListener());
		btn_Supprimer.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_delete.jpg")));
		btn_Supprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Supprimer.setBounds(70, 22, 50, 50);
		panel_Buttons.add(btn_Supprimer);
		
		btn_Sauvegarder = new JButton("");
		btn_Sauvegarder.addActionListener(new Btn_SauvegarderActionListener());
		btn_Sauvegarder.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_downlod.png")));
		btn_Sauvegarder.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Sauvegarder.setBounds(130, 22, 50, 50);
		panel_Buttons.add(btn_Sauvegarder);
		
		btn_Effacer = new JButton("");
		btn_Effacer.addActionListener(new Btn_EffacerActionListener());
		btn_Effacer.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_erase.png")));
		btn_Effacer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Effacer.setBounds(308, 22, 50, 50);
		panel_Buttons.add(btn_Effacer);
		
		btn_Lister = new JButton("");
		btn_Lister.addActionListener(new Btn_ListerActionListener());
		btn_Lister.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_lister.jpg")));
		btn_Lister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Lister.setBounds(368, 22, 50, 50);
		panel_Buttons.add(btn_Lister);
		btn_Quitter = new JButton("");
		btn_Quitter.addActionListener(new Btn_QuitterActionListener());
		btn_Quitter.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_quit_2.jpg")));
		btn_Quitter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Quitter.setBounds(428, 22, 50, 50);
		panel_Buttons.add(btn_Quitter);
		
		btn_Preter = new JButton("");
		btn_Preter.addActionListener(new Btn_PreterActionListener());
		btn_Preter.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_borrow_second.png")));
		btn_Preter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Preter.setBounds(190, 22, 50, 50);
		panel_Buttons.add(btn_Preter);
		
		btn_Retourner = new JButton("");
		btn_Retourner.addActionListener(new Btn_RetournerActionListener());
		btn_Retourner.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_return.jpg")));
		btn_Retourner.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Retourner.setBounds(248, 22, 50, 50);
		panel_Buttons.add(btn_Retourner);
		
		lbl_Erreur = new JLabel("Erreur");
		lbl_Erreur.setForeground(Color.RED);
		lbl_Erreur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Erreur.setBounds(38, 249, 812, 31);
		contentPane.add(lbl_Erreur);
	}
	
	
	//Sélection du code d'un journal
	private class Cb_CodeActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String code = (String) cb_Code.getSelectedItem();
				int position = bibli.rechercheCode(code);
				Document docTemp = bibli.getListeDocuments().get(position);
				
				if(docTemp instanceof Livre) {
					//public Livre(String code1, String categorie1, String titre1, String autheur1, int annee1, Genre g, int nbTotal)
					effacerTout();
					Livre l = (Livre) docTemp;
					rdbtn_Livre.setSelected(true);
					textField_Titre.setText(l.getTitre());
					textField_Autheur.setText(l.getAutheur());
					textField_Annee.setText(String.valueOf(l.getAnnee()));
					cb_Genre.setSelectedItem(l.getGenre());
					textField_NbCopies.setText(String.valueOf(l.getNombreDisponible()));
				}else if(docTemp instanceof BD) {
					//public BD(String code1, String categorie1, String titre1, String autheur1, int numEdition1)
					effacerTout();
					BD bd = (BD) docTemp;
				    rdbtn_BD.setSelected(true);
					textField_Titre.setText(bd.getTitre());
					textField_Autheur.setText(bd.getAutheur());
					textField_Numero.setText(String.valueOf(bd.getNumEdition()));
					cb_Genre.setSelectedItem(Genre.NON_APPLICABLE);
				}else if(docTemp instanceof Journal) {
					//public Journal(String code1, String categorie1, String titre1, String dateParution1)
					effacerTout();
					Journal j = (Journal) docTemp;
					rdbtn_Journal.setSelected(true);
					textField_Titre.setText(j.getTitre());
					textField_Date.setText(j.getDateParution());
					cb_Genre.setSelectedItem(Genre.NON_APPLICABLE);
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	
	//Remplir ComboBox Code
	public static void remplirCbCode() {
		cb_Code.removeAllItems();
		String code;
		for(Document doc :  bibli.getListeDocuments()) {
			code = doc.getCode();
			cb_Code.addItem(code);
		}
	}
	
		
	//Remplir ComboBox Genre
	public static void remplirCbGenre() {
		cb_Genre.removeAllItems();
		for(Genre g : Genre.values()) {
			cb_Genre.addItem(g);
		}
	}
	
	
	//Charger fichier Document
		public static void chargerFichierBinaire() throws ClassNotFoundException, IOException {
			bibli = new Bibliotheque (); 
			bibli.setFromListeDocuments(bibli.chargementBinaire(pathBinaire));
			remplirCbCode();
			remplirCbGenre();
		}
		
	//Methode pour tout effacer
		public static void effacerTout() {
			textField_Annee.setText(null);
			textField_Autheur.setText(null);
			textField_Date.setText(null);
			textField_NbCopies.setText(null);
			textField_Numero.setText(null);
			textField_Titre.setText(null);
			buttonGroupCategorie.clearSelection();
			
		}
	
	private class Btn_AjouterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {		
			try {
				String numEdition = textField_Numero.getText();
				int numEdiInt = -1;
				String dateParution = textField_Date.getText();
				String nbCopieTotal = textField_NbCopies.getText();
				int nbCopieTotalInt = -1;
				String autheur = textField_Autheur.getText();
				String titre = textField_Titre.getText();
				String anneeString = textField_Annee.getText();
				int anneeInt = -1;
				Genre genre = (Genre) cb_Genre.getSelectedItem();
				if((numEdition != null) || (nbCopieTotal != null) || (anneeString != null)) {
					numEdiInt = Integer.parseInt(numEdition);
					nbCopieTotalInt = Integer.parseInt(nbCopieTotal);
					anneeInt = Integer.parseInt(anneeString);
					
					if(rdbtn_BD.isSelected()) {
						bibli.ajouter(new BD (null, null, titre , autheur, numEdiInt));
					}else if(rdbtn_Journal.isSelected()) {
						bibli.ajouter(new Journal (null, null, autheur, dateParution));
					}else if(rdbtn_Livre.isSelected()) {
					bibli.ajouter(new Livre (null, null, titre, autheur, anneeInt, genre, nbCopieTotalInt));
					}				
					remplirCbCode();
					remplirCbGenre();				
				}
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	
	private class Btn_SupprimerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String code = (String) cb_Code.getSelectedItem();
				bibli.suppression(code);
				remplirCbCode();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	

	
	private class Btn_EffacerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			effacerTout();
		}
	}
	
	
	private class Btn_ListerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			textArea.setText(bibli.getNomBibliotheque() + "\n");
			textArea.append(bibli.toString() + "\n");
			textArea.append("Capacité : " + Document.getNbDocument() + " documents");
		}
	}
	
	
	private class Btn_QuitterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				bibli.sauvegardeBinaire(bibli.getListeDocuments(), pathBinaire);
				bibli.sauvegardeXml(bibli.getListeDocuments(), pathXml);
				System.exit(0);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class Btn_SauvegarderActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				bibli.sauvegardeBinaire(bibli.getListeDocuments(), pathBinaire);
				bibli.sauvegardeXml(bibli.getListeDocuments(), pathXml);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class Btn_SearchActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class Btn_PreterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class Btn_RetournerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
}
