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

import classes.Bibliotheque;
import classes.Document;

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
	private JComboBox cb_Code;
	private JRadioButton rdbtn_Livre;
	private JRadioButton rdbtn_Journal;
	private JRadioButton rdbtn_BD;
	private final ButtonGroup buttonGroupCategorie = new ButtonGroup();
	private JComboBox cb_Genre;
	private JTextField textField_Titre;
	private JTextField textField_Autheur;
	private JTextField textField_Annee;
	private JTextField textField_NbCopies;
	private JButton btn_Search;
	private JTextField textField_Date;
	private JTextField textField_Numero;
	private JPanel panel_Buttons;
	private JButton btn_Ajouter;
	private JButton btn_Supprimer;
	private JButton btn_Charger;
	private JButton btn_Effacer;
	private JButton btn_Lister;
	private JButton btn_Quitter;
	//My attributes
	private FeAu frameAu;
	private static Bibliotheque bibli;
	private static String pathBinaireToObject;
	private String pathOjectToBinaire;
	

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
		cb_Code.setFont(new Font("Tahoma", Font.BOLD, 14));
		cb_Code.setBounds(89, 42, 280, 21);
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
		cb_Genre.setBounds(235, 215, 114, 21);
		contentPane.add(cb_Genre);
		
		textField_Titre = new JTextField();
		textField_Titre.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Titre.setBounds(89, 79, 284, 19);
		contentPane.add(textField_Titre);
		textField_Titre.setColumns(10);
		
		textField_Autheur = new JTextField();
		textField_Autheur.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Autheur.setColumns(10);
		textField_Autheur.setBounds(85, 134, 284, 19);
		contentPane.add(textField_Autheur);
		
		textField_Annee = new JTextField();
		textField_Annee.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_Annee.setColumns(10);
		textField_Annee.setBounds(85, 175, 146, 19);
		contentPane.add(textField_Annee);
		
		textField_NbCopies = new JTextField();
		textField_NbCopies.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_NbCopies.setColumns(10);
		textField_NbCopies.setBounds(86, 216, 96, 19);
		contentPane.add(textField_NbCopies);
		
		btn_Search = new JButton("");
		btn_Search.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_1search.png")));
		btn_Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Search.setBounds(383, 73, 30, 30);
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
		panel_Buttons.setBounds(449, 10, 405, 94);
		contentPane.add(panel_Buttons);
		panel_Buttons.setLayout(null);
		
		btn_Ajouter = new JButton("");
		btn_Ajouter.addActionListener(new Btn_AjouterActionListener());
		btn_Ajouter.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_ajouter.png")));
		btn_Ajouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Ajouter.setBounds(32, 22, 50, 50);
		panel_Buttons.add(btn_Ajouter);
		
		btn_Supprimer = new JButton("");
		btn_Supprimer.addActionListener(new Btn_SupprimerActionListener());
		btn_Supprimer.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_delete.jpg")));
		btn_Supprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Supprimer.setBounds(92, 22, 50, 50);
		panel_Buttons.add(btn_Supprimer);
		
		btn_Charger = new JButton("");
		btn_Charger.addActionListener(new Btn_ChargerActionListener());
		btn_Charger.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_downlod.png")));
		btn_Charger.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Charger.setBounds(152, 22, 50, 50);
		panel_Buttons.add(btn_Charger);
		
		btn_Effacer = new JButton("");
		btn_Effacer.addActionListener(new Btn_EffacerActionListener());
		btn_Effacer.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_erase.png")));
		btn_Effacer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Effacer.setBounds(212, 22, 50, 50);
		panel_Buttons.add(btn_Effacer);
		
		btn_Lister = new JButton("");
		btn_Lister.addActionListener(new Btn_ListerActionListener());
		btn_Lister.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_lister.jpg")));
		btn_Lister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Lister.setBounds(272, 22, 50, 50);
		panel_Buttons.add(btn_Lister);
		btn_Quitter = new JButton("");
		btn_Quitter.addActionListener(new Btn_QuitterActionListener());
		btn_Quitter.setIcon(new ImageIcon(FeGestion.class.getResource("/images/rsz_quit_2.jpg")));
		btn_Quitter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Quitter.setBounds(329, 22, 50, 50);
		panel_Buttons.add(btn_Quitter);
	}
	
	//Charger fichier Document
	public static void chargerFichierBinaire() throws ClassNotFoundException, IOException {
		bibli = new Bibliotheque ();
		pathBinaireToObject = "./Ressources/objectToBinaire.bin";
		bibli.setListeDocuments(bibli.chargementBinaire(pathBinaireToObject)); 
	}
	
	
	private class Btn_AjouterActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	
	private class Btn_SupprimerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	
	private class Btn_ChargerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class Btn_EffacerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
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
		}
	}
	
	
}
